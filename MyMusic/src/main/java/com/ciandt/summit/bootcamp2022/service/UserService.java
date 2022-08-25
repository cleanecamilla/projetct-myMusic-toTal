package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
