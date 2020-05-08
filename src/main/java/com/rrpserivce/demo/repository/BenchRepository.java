package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Bench;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BenchRepository extends JpaRepository<Bench, Integer> {
    @Transactional
    @Query(value = "select * from bench where robot_id = ?",nativeQuery = true)
    List<Bench> getByRobot(String robot_id);
}
