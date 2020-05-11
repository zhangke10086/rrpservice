package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Bench;
import com.rrpserivce.demo.entity.BenchCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BenchCountRepository extends JpaRepository<BenchCount, Integer> {
    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    List<BenchCount> getCount(String begin, String end, String robot_id);

    @Query(value = "select * from bench_count WHERE time = ?", nativeQuery = true)
    List<BenchCount> getCountById(String time);

    @Transactional
    @Query(value = "select * from bench_count where robot_id = ?",nativeQuery = true)
    List<BenchCount> getByRobot(String robot_id);
}
