package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BenchCountRepository extends JpaRepository<BenchCount, Integer> {
    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    List<BenchCount> getCount(String begin, String end);

    @Query(value = "select * from bench_count WHERE time = ?", nativeQuery = true)
    List<BenchCount> getCountById(String time);
}
