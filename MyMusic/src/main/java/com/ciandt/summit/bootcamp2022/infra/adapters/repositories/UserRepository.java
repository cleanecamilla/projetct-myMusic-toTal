package com.ciandt.summit.bootcamp2022.infra.adapters.repositories;

import com.ciandt.summit.bootcamp2022.domain.ports.repositories.UserRepositoryPort;

public class UserRepository implements UserRepositoryPort {

    private final SpringUserRepository springUserRepository;

    public UserRepository(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

}
