package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByProvinceid(String provinceid);
}
