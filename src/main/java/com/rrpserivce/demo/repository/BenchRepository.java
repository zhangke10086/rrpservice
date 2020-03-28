package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Bench;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchRepository extends JpaRepository<Bench, Integer> {
}
