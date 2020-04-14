package com.rrpserivce.demo.repository;


import com.rrpserivce.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
//    @Query(value = "select id from role_menu_ass where role_id = ? and menu_id = ?",nativeQuery=true)
//    Integer findIdByRoleAndMenu(int role_id, int menu_id);
//    Integer findBy
}
