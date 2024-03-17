package com.itzbh.service;

import com.itzbh.domain.User;

public interface UserService {
    public User login(String username, String password);
    public boolean Register(String username,String password);
}
