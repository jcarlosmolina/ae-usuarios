package com.keralty.usuarios.security;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

import com.keralty.usuarios.viewmodel.LoginRequest;
import com.keralty.usuarios.viewmodel.UserInfoViewModel;

@ApplicationScoped
public interface UserAuthenticationService {

    Optional<String> login(String username, String password);
    
    Optional<String> login(LoginRequest loginRequest);

    UserInfoViewModel loginAzure(LoginRequest loginRequest);

    void logout(User user);
}
