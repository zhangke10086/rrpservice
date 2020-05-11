package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BoardArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BoardAreaRepository extends JpaRepository<BoardArea, Integer> {
    @Query(value = "select * from board_area WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    List<BoardArea> getArea(String begin, String end);

    @Query(value = "select * from board_area WHERE time = ?", nativeQuery = true)
    List<BoardArea> getAreaById(String time);
}
