package com.example.controller;


import com.example.entity.User;
import com.example.form.UserForm;
import com.example.security.JwtTokenUtil;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager,
                                        JwtTokenUtil jwtTokenUtil,
                                        UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody UserForm userForm) {
        try {
            String username = userForm.getUsername();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, userForm.getPassword()));

            User user = (User) userService.loadUserByUsername(username);
            String token = jwtTokenUtil.generateToken(user);

            Map<String, Object> response = new HashMap<>();

            response.put("token", token);
            response.put("username", user.getUsername());
            response.put("userId", user.getId());
            response.put("roles", user.getRoles());

            return ResponseEntity.ok(response);

        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
