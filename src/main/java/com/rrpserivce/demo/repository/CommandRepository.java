package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Integer> {
}
