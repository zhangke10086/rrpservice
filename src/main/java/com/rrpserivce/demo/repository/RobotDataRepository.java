package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.RobotData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotDataRepository extends JpaRepository<RobotData, Integer> {
}
