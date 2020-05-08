package com.rrpserivce.demo.repository;
import com.rrpserivce.demo.entity.ProductRatio;
import com.rrpserivce.demo.entity.Remind;
import com.rrpserivce.demo.entity.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemindRepository extends JpaRepository<Remind, String> {
    @Query(value = "select * from remind where company_id = ?1", nativeQuery = true)
    Remind findByCompanyId(String id);

    @Query(value = "select * from remind where robot_id = ?1", nativeQuery = true)
    Remind findByRobotid(String id);

    @Modifying
    @Query(value = "delete  from remind where robot_id = ?1", nativeQuery = true)
    void deleteByRobotid(String id);
}
