package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.Pay;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRepository extends JpaRepository<Pay, Integer> {
    @Query(value = "select * from  pay where lease_id =?1",nativeQuery = true)
    Pay findByLeaseId(int id);
    @Query(value = "select * from  pay where lease_id =?1 and examine_situation ='待审核'",nativeQuery = true)
    Pay findByLeaseIdAndState(int id);
    @Modifying
    @Query(value = "update  pay set examine_situation = '通过' where lease_id =?1",nativeQuery = true)
    public void changeExamineSituation(int id);

    public List<Pay> findAll(Specification<Pay> spec);
}
