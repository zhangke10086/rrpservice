package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.ProcessData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessDataRepository extends JpaRepository<ProcessData, Integer> {
}
