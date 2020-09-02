package com.example.service;

import com.example.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    boolean isUsernameAlreadyExists(String username);

    User register(User candidate);
}
