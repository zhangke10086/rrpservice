package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository  extends JpaRepository<User, Integer> {
    User findUserByUsernameAndPassword(String username, String password);
}
