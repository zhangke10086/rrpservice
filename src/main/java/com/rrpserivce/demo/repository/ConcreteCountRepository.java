package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.ConcreteCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcreteCountRepository extends JpaRepository<ConcreteCount, Integer> {
    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    List<ConcreteCount> getCount(String begin, String end);

    @Query(value = "select * from concrete_count WHERE time = ?", nativeQuery = true)
    List<ConcreteCount> getCountById(String time);
}
