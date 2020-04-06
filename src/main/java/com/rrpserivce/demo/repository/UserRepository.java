package com.rrpserivce.demo.repository;


import com.rrpserivce.demo.entity.Menu;
import com.rrpserivce.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
