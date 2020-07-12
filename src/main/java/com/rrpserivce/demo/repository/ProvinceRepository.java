package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Diagnose;
import com.rrpserivce.demo.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
}
