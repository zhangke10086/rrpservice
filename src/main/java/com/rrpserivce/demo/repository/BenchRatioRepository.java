package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchRatio;
import com.rrpserivce.demo.entity.BenchRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface BenchRatioRepository extends JpaRepository<BenchRatio, Integer> {


    @Query(value = "select * from bench_ratio WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<BenchRatio> getRatioWithRobot(String begin, String end, String robot_id);

    @Query(value = "select * from bench_ratio WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<BenchRatio> getAllRatio(String begin, String end);

    @Query(value = "select * from bench_ratio WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company = ?3)", nativeQuery = true)
    Set<BenchRatio> getRatioWithCompany(String begin, String end, String company_id);

    @Query(value = "select * from bench_ratio WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where city=?3))", nativeQuery = true)
    Set<BenchRatio> getRatioWithCity(String begin, String end, String city_name);

    @Query(value = "select * from bench_ratio WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where province=?3))", nativeQuery = true)
    Set<BenchRatio> getRatioWithProvince(String begin, String end, String province_name);




    @Query(value = "select * from bench_ratio WHERE time = ?", nativeQuery = true)
    List<BenchRatio> getRatioById(String time);

    @Transactional
    @Query(value = "select * from bench_ratio where robot_id = ?",nativeQuery = true)
    List<BenchRatio> getByRobot(String robot_id);
}
