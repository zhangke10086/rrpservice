package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Integer> {
    public List<Lease> findAllByRobot_Id(int id);
    public List<Lease> findAllByCompanyId_Id(int id);
}
