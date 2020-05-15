package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Warning;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface WarningRepository extends JpaRepository<Warning, Integer> {
    @Transactional
    @Query(value = "select * from warning where robot_id = ?",nativeQuery = true)
    List<Warning> getByRobot(String robot_id);
    public List<Warning> findAll(Specification<Warning> spec);
}
