package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.ProcessData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ProcessDataRepository extends JpaRepository<ProcessData, Integer> {
    @Transactional
    @Query(value = "select * from process_data where bench_id = ?",nativeQuery = true)
    ProcessData getByBench(int bench_id);

    @Transactional
    @Modifying
    @Query(value = "delete from process_data where bench_id = ?",nativeQuery = true)
    void deleteByBench(int bench_id);
}
