package com.example.demo.repository;
import com.example.demo.entity.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobotRepository extends JpaRepository<Robot, String> {
    public List<Robot> findAllByBelongingCompany_Id(int BelongingCompanyId);
}
