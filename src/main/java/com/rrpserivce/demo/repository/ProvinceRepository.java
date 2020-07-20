package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Company;
import com.rrpserivce.demo.entity.Diagnose;
import com.rrpserivce.demo.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    @Modifying
    @Query(value = "UPDATE province SET value=value+1 WHERE name =:proName",nativeQuery = true)
    void addProValue(@Param("proName") String pro_name);

    @Modifying
    @Query(value = "UPDATE province SET value=value-1 WHERE name =:proName",nativeQuery = true)
    void deleteProValue(@Param("proName") String pro_name);
}
