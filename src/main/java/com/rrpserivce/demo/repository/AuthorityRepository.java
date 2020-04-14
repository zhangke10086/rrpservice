package com.rrpserivce.demo.repository;


import com.rrpserivce.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
//    @Query(value = "select id from role_menu_ass where role_id = ? and menu_id = ?",nativeQuery=true)
//    Integer findIdByRoleAndMenu(int role_id, int menu_id);
//    Integer findBy
    @Query(value = "select * from authority where role_menu_ass_id in (select id from role_menu_ass where role_id = ?)", nativeQuery=true)
    List<Authority> findByRoleId(int role_id);

    @Transactional
    @Modifying
    @Query(value = "delete from authority where role_menu_ass_id in (select id from role_menu_ass where role_id = ?)", nativeQuery=true)
    void deleteAuthority(int role_id);
//    void deleteAllByRoleMenuIn
}
