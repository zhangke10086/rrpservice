package com.rrpserivce.demo.repository;


import com.rrpserivce.demo.entity.BenchData;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BenchDataRepository extends JpaRepository<BenchData, Integer> {
    @Transactional
    @Modifying
    @Query(value = "delete from bench_data where bench_id = ?",nativeQuery = true)
    void deleteByBench(int bench_id);
    @Transactional
    @Query(value = "select * from bench_data where bench_id = ?",nativeQuery = true)
    List<BenchData> getByRobot(String robot_id);
    public List<BenchData> findAll(Specification<BenchData> spec);
}
