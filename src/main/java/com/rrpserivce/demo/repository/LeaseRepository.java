package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.Lease;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Query(value = "update  lease set remind = '1' where robot_id=?1",nativeQuery = true)
    public void setRemind(String id);

    @Modifying
    @Query(value = "update  lease set remind = '0' where robot_id =?1",nativeQuery = true)
    public void cancleRemind(String id);
    public List<Lease> findAll(Specification<Lease> spec);
}
