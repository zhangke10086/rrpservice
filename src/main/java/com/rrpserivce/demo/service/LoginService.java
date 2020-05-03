package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.User;
import com.rrpserivce.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public User findUserByUsernameAndPassword(String username, String password) {
        User user = loginRepository.findUserByUsernameAndPassword(username,password);
        user.setLogin_time(new Date());
        loginRepository.save(user);
        user.setPassword(null);
        return user;
    }
}
