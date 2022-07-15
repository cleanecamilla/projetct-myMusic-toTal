package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.exception.FiltroInvalidoException;
import com.ciandt.summit.bootcamp2022.repository.ArtistaRepository;
import com.ciandt.summit.bootcamp2022.repository.MusicaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MusicaServiceImp implements MusicaService {

    private static final Logger logger = LoggerFactory.getLogger(MusicaServiceImp.class);

    @Autowired
    private MusicaRepository musicaRepository;
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Musica> buscarMusicas(String filtro) {
        logger.info("Buscando musicas com o filtro: " + filtro);

        if(filtro.length() < 3 ) {
            logger.error("O filtro informado para busca de musicas eh invalido");
            throw new FiltroInvalidoException(filtro);
        }

        List<Musica> musicasEncontradas = musicaRepository.findByNomeContaining(filtro);
        List<Artista> artistasEncontrados = artistaRepository.findByNomeContaining(filtro);
        Set<Musica> musicas = new HashSet<Musica>(musicasEncontradas);

        artistasEncontrados.forEach(artista -> musicas.addAll(musicaRepository.findByArtista(artista)));

        return ordernarMusicas(musicas);
    }

    public List<Musica> ordernarMusicas(Set<Musica> musicas){
        logger.info("Ordenando as musicas encontradas");
        TreeMap<Artista, TreeSet<Musica>> musicasOrdenadas = musicas.stream()
                .collect(Collectors.groupingBy(
                        Musica::getArtista,
                        TreeMap::new,
                        Collectors.toCollection(TreeSet::new)
                ));

        return musicasOrdenadas.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
