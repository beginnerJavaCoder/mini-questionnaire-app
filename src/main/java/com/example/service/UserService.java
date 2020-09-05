package com.example.service;

import com.example.entity.Answer;
import com.example.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User findById(Integer id);

    User findByUsername(String username);

    List<Answer> getStatistics(Integer id);

    boolean isUsernameAlreadyExists(String username);

    User register(User candidate);

    void saveAnswers(String username, List<Answer> answers);
}
