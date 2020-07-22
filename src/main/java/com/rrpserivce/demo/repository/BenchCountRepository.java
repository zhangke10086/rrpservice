package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchCount;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface BenchCountRepository extends JpaRepository<BenchCount, Integer> {
    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<BenchCount> getCountWithRobot(String begin, String end, String robot_id);

    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<BenchCount> getAllCount(String begin, String end);

    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company = ?3)", nativeQuery = true)
    Set<BenchCount> getCountWithCompany(String begin, String end, String company_id);

    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where city=?3))", nativeQuery = true)
    Set<BenchCount> getCountWithCity(String begin, String end, String city_name);

    @Query(value = "select * from bench_count WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where province=?3))", nativeQuery = true)
    Set<BenchCount> getCountWithProvince(String begin, String end, String province_name);

    @Query(value = "select * from bench_count WHERE time = ?", nativeQuery = true)
    List<BenchCount> getCountById(String time);

    @Transactional
    @Query(value = "select * from bench_count where robot_id = ?",nativeQuery = true)
    List<BenchCount> getByRobot(String robot_id);

    @Query(value = "select * from bench_count where robot_id = ?1 and id=(select max(id) from bench_count where robot_id = ?1);",nativeQuery = true)
    public BenchCount findNewestByRobot_Id(String id);

    public List<BenchCount> findAll(Specification<BenchCount> spec);
}
