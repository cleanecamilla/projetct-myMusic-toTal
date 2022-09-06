package com.ciandt.summit.bootcamp2022.infra.config;

import com.ciandt.summit.bootcamp2022.domain.adapters.services.MusicServiceImpl;
import com.ciandt.summit.bootcamp2022.domain.adapters.services.PlaylistServiceImpl;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.PlaylistServicePort;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.MusicRepositoryPort;
import com.ciandt.summit.bootcamp2022.domain.ports.repositories.PlaylistRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    MusicServicePort musicServicePort(MusicRepositoryPort musicRepositoryPort) {
        return new MusicServiceImpl(musicRepositoryPort);
    }

    @Bean
    PlaylistServicePort playlistServicePort(PlaylistRepositoryPort playlistRepositoryPort) {
        return new PlaylistServiceImpl(playlistRepositoryPort);
    }
}
