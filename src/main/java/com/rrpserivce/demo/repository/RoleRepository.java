package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * 用不到了，改为前台实现
     * @return
     */
    @Query(value = "select MAX(id) from role",nativeQuery=true)
    Integer getMaxId();
}
