package com.ciandt.summit.bootcamp2022.service;

public interface TokenProviderService {

    String getToken(String username);

    boolean isTokenValid(String username, String token);
}
