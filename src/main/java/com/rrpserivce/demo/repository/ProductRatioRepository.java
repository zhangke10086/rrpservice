package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.ProductRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRatioRepository extends JpaRepository<ProductRatio, Integer> {
    @Query(value = "select * from product_ratio WHERE time BETWEEN ?1 AND ?2", nativeQuery = true)
    List<ProductRatio> getRatio(String begin, String end);

    @Query(value = "select * from product_ratio WHERE time = ?", nativeQuery = true)
    List<ProductRatio> getRatioById(String time);
}
