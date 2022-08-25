package com.ciandt.summit.bootcamp2022.infra.configs;

import com.ciandt.summit.bootcamp2022.domains.songs.adapters.services.SongServiceImp;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.interfaces.SongServicePort;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.repositories.SongRepositoryPort;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class BeansConfig {
    @Bean
    public SongServicePort songService(SongRepositoryPort songRepositoryPort) {
        return new SongServiceImp(songRepositoryPort);
    }
}
