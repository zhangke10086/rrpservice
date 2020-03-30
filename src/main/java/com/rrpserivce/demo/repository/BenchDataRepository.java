package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchDataRepository extends JpaRepository<BenchData, Integer> {
}
