package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Bench;
import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.BenchData;
import com.rrpserivce.demo.entity.Lease;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface BenchCountRepository extends JpaRepository<BenchCount, Integer> {
    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<BenchCount> getCount(String begin, String end, String robot_id);

    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<BenchCount> getAllCount(String begin, String end);

    @Query(value = "select * from bench_count WHERE time = ?", nativeQuery = true)
    List<BenchCount> getCountById(String time);

    @Transactional
    @Query(value = "select * from bench_count where robot_id = ?",nativeQuery = true)
    List<BenchCount> getByRobot(String robot_id);

    @Query(value = "select * from bench_count where robot_id = ?1 and id=(select max(id) from bench_count where robot_id = ?1);",nativeQuery = true)
    public BenchCount findNewestByRobot_Id(String id);

    public List<BenchCount> findAll(Specification<BenchCount> spec);
}
