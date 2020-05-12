package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRepository extends JpaRepository<Pay, Integer> {
    @Query(value = "select * from  pay where lease_id =?1",nativeQuery = true)
    Pay findByLeaseId(int id);
}
