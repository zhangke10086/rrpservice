package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Trouble;
import com.rrpserivce.demo.entity.Trouble;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TroubleRepository extends JpaRepository<Trouble, Integer> {
    @Transactional
    @Query(value = "select * from trouble where robot_id = ?",nativeQuery = true)
    List<Trouble> getByRobot(String robot_id);
    public List<Trouble> findAll(Specification<Trouble> spec);
}
