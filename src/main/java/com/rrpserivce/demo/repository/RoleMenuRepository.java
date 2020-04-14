package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleMenuRepository extends JpaRepository<RoleMenu, Integer> {

//    @Query(value = "select * from role_menu_ass where role_id = ? and menu_id = ?;",nativeQuery=true)
    RoleMenu findByRoleAndMenu(int role, int menu);
}
