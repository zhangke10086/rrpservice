package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.Lease;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Integer> {
    public List<Lease> findAllByRobot_Id(int id);
    public List<Lease> findAllByCompanyId_Id(int id);
    @Modifying
    @Query(value = "update  lease set remind = '1' where id=?1",nativeQuery = true)
    public void setRemind(int id);

    @Modifying
    @Query(value = "update  lease set remind = '0' where id =?1",nativeQuery = true)
    public void cancleRemind(int id);
    public List<Lease> findAll(Specification<Lease> spec);

    @Query(value = "select * from  lease where company_id =?1 and remind = '1'",nativeQuery = true)
    public List<Lease> findRemind(int id);

    @Modifying
    @Query(value = "update  lease set payment_situation = ?1 where id =?2",nativeQuery = true)
    public void changePaymentSituation(Character c,int id);

    @Modifying
    @Query(value = "update  lease set state = ?1 where id = ?2",nativeQuery = true)
    public void changeState(String state,int id);


}
