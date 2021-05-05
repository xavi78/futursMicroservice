package com.geekshubs.auth.app.services;

import com.geekshubs.auth.domain.entities.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    public User save(User user);
    public String login(String username, String password, HttpServletRequest request);
}
