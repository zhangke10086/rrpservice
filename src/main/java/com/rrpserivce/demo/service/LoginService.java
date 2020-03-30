package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.User;
import com.rrpserivce.demo.repository.LoginRepository;
import com.rrpserivce.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public User findUserByUserNameAndPassword(String username, String password) {
        User user = loginRepository.findUserByUserNameAndPassword(username,password);
        user.setPassword(null);
        return user;
    }
}
