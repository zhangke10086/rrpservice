package com.rrpserivce.demo.repository;


import com.rrpserivce.demo.entity.BoardArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface BoardAreaRepository extends JpaRepository<BoardArea, Integer> {
    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<BoardArea> getAreaWithRobot(String begin, String end, String robot_id);

    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<BoardArea> getAllArea(String begin, String end);

    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company = ?3)", nativeQuery = true)
    Set<BoardArea> getAreaWithCompany(String begin, String end, String company_id);

    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where city=?3))", nativeQuery = true)
    Set<BoardArea> getAreaWithCity(String begin, String end, String city_name);

    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2 and robot_id in (select id from robot where belonging_company in (select id from company where province=?3))", nativeQuery = true)
    Set<BoardArea> getAreaWithProvince(String begin, String end, String province_name);

    @Query(value = "select * from board_area WHERE time = ?", nativeQuery = true)
    List<BoardArea> getAreaById(String time);

    @Query(value = "select * from board_area where robot_id = ?1 and id=(select max(id) from board_area where robot_id = ?1);",nativeQuery = true)
    public BoardArea findNewestByRobot_Id(String id);

    @Transactional
    @Query(value = "select * from board_area where robot_id = ?",nativeQuery = true)
    List<BoardArea> getByRobot(String robot_id);
}
