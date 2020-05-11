package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BenchRatioRepository extends JpaRepository<BenchRatio, Integer> {
    @Query(value = "select * from bench_ratio WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    List<BenchRatio> getRatio(String begin, String end, String robot_id);

    @Query(value = "select * from bench_ratio WHERE time = ?", nativeQuery = true)
    List<BenchRatio> getRatioById(String time);

    @Transactional
    @Query(value = "select * from bench_ratio where robot_id = ?",nativeQuery = true)
    List<BenchRatio> getByRobot(String robot_id);
}
