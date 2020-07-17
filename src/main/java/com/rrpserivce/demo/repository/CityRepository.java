package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.City;
import com.rrpserivce.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByProvinceid(String provinceid);
    //增加省和市的value
    @Modifying
    @Query(value = "UPDATE city SET value=value+1 WHERE name=:cityName",nativeQuery = true)
    void addCityValue(@Param("cityName") String city_name);

    @Modifying
    @Query(value = "UPDATE city SET value=value-1 WHERE name=:cityName",nativeQuery = true)
    void deleteCityValue(@Param("cityName") String city_name);
}
