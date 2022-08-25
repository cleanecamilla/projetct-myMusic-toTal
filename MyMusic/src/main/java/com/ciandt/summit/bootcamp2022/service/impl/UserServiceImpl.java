package com.ciandt.summit.bootcamp2022.service.impl;

import com.ciandt.summit.bootcamp2022.entity.User;
import com.ciandt.summit.bootcamp2022.repository.UserRepository;
import com.ciandt.summit.bootcamp2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
