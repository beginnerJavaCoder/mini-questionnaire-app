package com.example.service.impl;

import com.example.entity.Answer;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    /*
    passwordEncoder used for hashing passwords those will be saved in the DB.
    It means that passwords in their raw form will not be saved in the database.
     */
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Answer> getStatistics(Integer id) {
        return findById(id).getAnswers();
    }

    @Override
    public boolean isUsernameAlreadyExists(String username) {
        return findByUsername(username) != null;
    }

    @Override
    public User register(User candidate) {
        if(isUsernameAlreadyExists(candidate.getUsername())) {
            return null;
        }

        candidate.setPassword(passwordEncoder.encode(candidate.getPassword()));

        return userRepository.saveAndFlush(candidate);
    }

    @Override
    public void saveAnswers(String username, List<Answer> answers) {
        User user = findByUsername(username);
        List<Answer> userAnswers = user.getAnswers();
        for (Answer answer : answers) {
            userAnswers.add(answer);
        }
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }

        return user;
    }
}
