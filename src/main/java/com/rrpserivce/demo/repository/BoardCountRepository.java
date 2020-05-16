package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.BoardCount;
import com.rrpserivce.demo.entity.BoardCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardCountRepository extends JpaRepository<BoardCount, Integer> {
    @Query(value = "select * from board_count WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    List<BoardCount> getCount(String begin, String end, String robot_id);

    @Query(value = "select * from board_count WHERE time = ?", nativeQuery = true)
    List<BoardCount> getCountById(String time);

    @Transactional
    @Query(value = "select * from board_count where robot_id = ?",nativeQuery = true)
    List<BoardCount> getByRobot(String robot_id);
}
