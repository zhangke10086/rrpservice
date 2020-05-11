package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.BoardCount;
import com.rrpserivce.demo.entity.BoardCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BoardCountRepository extends JpaRepository<BoardCount, Integer> {
    @Query(value = "select * from board_count WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    List<BoardCount> getCount(String begin, String end);

    @Query(value = "select * from board_count WHERE time = ?", nativeQuery = true)
    List<BoardCount> getCountById(String time);
}
