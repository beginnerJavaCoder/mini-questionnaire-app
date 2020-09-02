package com.example.form;

import com.example.entity.User;

public class UserForm {

    private String username;
    private String password;

    public UserForm() { }

    /*
    This method parses "UserForm" object to entity "User".
     */
    public User composeUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
