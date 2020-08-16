package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Integer> {
}
