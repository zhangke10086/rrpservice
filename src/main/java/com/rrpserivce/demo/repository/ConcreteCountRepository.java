package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.BenchRatio;
import com.rrpserivce.demo.entity.ConcreteCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface ConcreteCountRepository extends JpaRepository<ConcreteCount, Integer> {
    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<ConcreteCount> getCountWithRobot(String begin, String end, String robot_id);

    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<ConcreteCount> getAllCount(String begin, String end);

    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company = ?3)", nativeQuery = true)
    Set<ConcreteCount> getCountWithCompany(String begin, String end, String company_id);

    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where city=?3))", nativeQuery = true)
    Set<ConcreteCount> getCountWithCity(String begin, String end, String city_name);

    @Query(value = "select * from concrete_count WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where province=?3))", nativeQuery = true)
    Set<ConcreteCount> getCountWithProvince(String begin, String end, String province_name);


    @Query(value = "select * from concrete_count WHERE time = ?", nativeQuery = true)
    List<ConcreteCount> getCountById(String time);

    @Query(value = "select * from concrete_count where robot_id = ?1 and id=(select max(id) from concrete_count where robot_id = ?1);",nativeQuery = true)
    public ConcreteCount findNewestByRobot_Id(String id);

    @Transactional
    @Query(value = "select * from concrete_count where robot_id = ?",nativeQuery = true)
    List<ConcreteCount> getByRobot(String robot_id);
}
