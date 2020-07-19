package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchRatio;
import com.rrpserivce.demo.entity.BoardArea;
import com.rrpserivce.demo.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface BoardAreaRepository extends JpaRepository<BoardArea, Integer> {
    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<BoardArea> getArea(String begin, String end, String robot_id);

    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<BoardArea> getAllArea(String begin, String end);

    @Query(value = "select * from board_area WHERE time = ?", nativeQuery = true)
    List<BoardArea> getAreaById(String time);

    @Transactional
    @Query(value = "select * from board_area where robot_id = ?",nativeQuery = true)
    List<BoardArea> getByRobot(String robot_id);

    @Query(value = "select * from board_area where robot_id = ?1 and id=(select max(id) from board_area where robot_id = ?1);",nativeQuery = true)
    public BoardArea findNewestByRobot_Id(String id);
}
