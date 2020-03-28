package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Warning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarningRepository extends JpaRepository<Warning, Integer> {
}
