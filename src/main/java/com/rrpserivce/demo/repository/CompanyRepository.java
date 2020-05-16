package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.BenchData;
import com.rrpserivce.demo.entity.Company;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    public List<Company> findAllByNameLike(String key);
    @Modifying
    @Query("select c from Company c where c.companyType.type in (?1,?2)")
    List<Company> findAllBy2Keys(String key1, String key2);
    public List<Company> findAll(Specification<Company> spec);
}
