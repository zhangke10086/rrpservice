package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Diagnose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnoseRepository extends JpaRepository<Diagnose, Integer> {
}
