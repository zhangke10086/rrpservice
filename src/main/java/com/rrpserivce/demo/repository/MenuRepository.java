package com.rrpserivce.demo.repository;


import com.rrpserivce.demo.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
//    @Query(value = "select * from menu where id in (select menu_id from role_menu_ass where role_id in (select role_id from user where id = ?))",nativeQuery=true)
//    List<Menu> getDynamicMenu(Integer user_id);
//    @Query(value = "",nativeQuery=true)
//    Set<Menu> getAllByMenu_Id(Integer menu_id);

//    Set<Menu> getAllByMenu_id(Integer menu_id);
}
