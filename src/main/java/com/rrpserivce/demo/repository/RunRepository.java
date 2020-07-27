package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Run;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RunRepository extends JpaRepository<Run, Integer> {
    @Query(value = "select * from run WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Run> getRatio(String begin, String end);

    @Query(value = "select * from run WHERE company_id = ?1 and time BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Run> getRatioByCompany(int company_id, String begin, String end);

    @Query(value = "select * from run WHERE time = ?", nativeQuery = true)
    List<Run> getRatioById(String time);

    @Query(value = "SELECT * from run where company_id = ? ORDER BY time desc LIMIT 10", nativeQuery = true)
    List<Run> getRatioLate(int company_id);
}


