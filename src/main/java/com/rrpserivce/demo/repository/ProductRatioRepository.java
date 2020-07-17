package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.ProductRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface ProductRatioRepository extends JpaRepository<ProductRatio, Integer> {
    @Query(value = "select * from product_ratio WHERE time BETWEEN ?1 AND ?2 and robot_id = ?3", nativeQuery = true)
    Set<ProductRatio> getRatio(String begin, String end, String robot_id);

    @Query(value = "select * from product_ratio WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    Set<ProductRatio> getAllRatio(String begin, String end);

    @Query(value = "select id from product_ratio", nativeQuery = true)
    List<Integer> getId();

    @Query(value = "select * from product_ratio WHERE time = ?", nativeQuery = true)
    List<ProductRatio> getRatioById(String time);

    @Transactional
    @Query(value = "select * from product_ratio where robot_id = ?",nativeQuery = true)
    List<ProductRatio> getByRobot(String robot_id);
}
