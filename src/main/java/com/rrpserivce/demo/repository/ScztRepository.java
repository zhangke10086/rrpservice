package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.entity.SCZT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScztRepository extends JpaRepository<SCZT, String> {
    public List<SCZT> findAllByRobot_Id(int RobotId);
    public SCZT findByRobot_Id(String RobotId);
    public SCZT findById(int id);
    public SCZT deleteById(int id);
}
