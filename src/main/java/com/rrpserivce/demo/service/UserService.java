package com.rrpserivce.demo.service;

import com.alibaba.fastjson.JSON;
import com.rrpserivce.demo.entity.User;
import com.rrpserivce.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id){
//        Option<User> option = userRepository.findById(id);
        User user = userRepository.findById(id).get();
//        user.setPassword(null);
        return user;
    }

    public void add(User user){userRepository.save(user);}

    public void update(User user){
        userRepository.save(user);
    }

    public void resetPassword(Integer id) {
        User user = userRepository.findById(id).get();
        user.setPassword("123456");
        userRepository.save(user);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

}
