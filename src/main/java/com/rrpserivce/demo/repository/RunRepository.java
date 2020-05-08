package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Run;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RunRepository extends JpaRepository<Run, Integer> {
    @Query(value = "select * from run WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Run> getRatio(String begin, String end);

    @Query(value = "select * from run WHERE time = ?", nativeQuery = true)
    List<Run> getRatioById(String time);
}
