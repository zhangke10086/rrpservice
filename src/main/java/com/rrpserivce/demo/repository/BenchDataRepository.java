package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BenchDataRepository extends JpaRepository<BenchData, Integer> {
    @Transactional
    @Modifying
    @Query(value = "delete from bench_data where bench_id = ?",nativeQuery = true)
    void deleteByBench(int bench_id);
}
