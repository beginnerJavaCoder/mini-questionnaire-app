package com.example.controller;

import com.example.entity.User;
import com.example.form.UserForm;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
public class RegistrationRestController {

    private final UserService userService;

    @Autowired
    public RegistrationRestController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserForm userForm) {
        User saved = userService.register(userForm.composeUser());

        //It may happens if user's username already exists in DB
        if(saved == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
