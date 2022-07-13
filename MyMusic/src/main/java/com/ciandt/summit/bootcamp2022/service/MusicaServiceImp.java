package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.Artista;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.exception.FiltroInvalidoException;
import com.ciandt.summit.bootcamp2022.repository.ArtistaRepository;
import com.ciandt.summit.bootcamp2022.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Collection;
import java.util.stream.Collectors;

public class MusicaServiceImp implements MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Musica> buscarMusicas(String filtro) {
        if(filtro.length() < 3 )
            throw new FiltroInvalidoException("Filtro invalido.");

        List<Musica> musicasEncontradas = musicaRepository.findByNomeContaining(filtro);
        List<Artista> artistasEncontrados = artistaRepository.findByNomeContaining(filtro);
        Set<Musica> musicas = new HashSet<Musica>(musicasEncontradas);

        artistasEncontrados.forEach(artista -> musicas.addAll(musicaRepository.findByArtista(artista)));

        return ordernarMusicas(musicas);
    }

    public List<Musica> ordernarMusicas(Set<Musica> musicas){
        TreeMap<Artista, TreeSet<Musica>> musicasOrdenadas = musicas.stream()
                .collect(Collectors.groupingBy(
                        Musica::getArtista,
                        TreeMap::new,
                        Collectors.toCollection(TreeSet::new)
                ));

        return musicasOrdenadas.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
