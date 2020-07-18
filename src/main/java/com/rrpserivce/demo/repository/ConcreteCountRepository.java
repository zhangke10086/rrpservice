package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.ConcreteCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface ConcreteCountRepository extends JpaRepository<ConcreteCount, Integer> {
    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<ConcreteCount> getCount(String begin, String end, String robot_id);

    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<ConcreteCount> getAllCount(String begin, String end);

    @Query(value = "select * from concrete_count WHERE time = ?", nativeQuery = true)
    List<ConcreteCount> getCountById(String time);

    @Transactional
    @Query(value = "select * from concrete_count where robot_id = ?",nativeQuery = true)
    List<ConcreteCount> getByRobot(String robot_id);
}
