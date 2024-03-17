package com.itzbh.service.impl;

import com.itzbh.domain.User;
import com.itzbh.mapper.Usermapper2;
import com.itzbh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    Usermapper2 usermapper;
    @Override
    public User login(String username, String password)
    {
        return usermapper.get_user(username, password);
    }

    @Override
    public boolean Register(String username, String password) {
        User user=usermapper.select_by_username(username);
        if(user==null){
            usermapper.insert_new_user(username,password);
            return true;
        }
        else{
            return false;
        }

    }
}
