package com.rrpserivce.demo.repository;


import com.rrpserivce.demo.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface DynamicMenuRepository extends JpaRepository<Menu, Integer> {
    @Query(value = "select * from menu where id in (select menu_id from role_menu_ass where role_id in (select role_id from user where id = ?))",nativeQuery=true)
    Set<Menu> getDynamicMenu(Integer user_id);

    @Query(value = "select * from menu where id in (select menu_id from role_menu_ass where role_id in (select role_id from user where id = ?)) and menu_id = ?",nativeQuery=true)
    Set<Menu> getDynamicMenuByMenu_id(Integer user_id, Integer menu_id);

    @Query(value = "select * from menu where id in (select menu_id from role_menu_ass where role_id in (select role_id from user where username = ?))",nativeQuery=true)
    Set<Menu> getDynamicMenuByUsername(String username);

    @Query(value = "select id from user where username=?",nativeQuery=true)
    int getIdByUsername(String username);

    // 废掉不用
    @Query(value = "select * from menu where id in (select menu_id from role_menu_ass where role_id in (select role_id from user)) and menu_id = ?",nativeQuery=true)
    Set<Menu> getAllDynamicMenu2(Integer menu_id);

    /**
     * 更应该放在MenuRepository中
     * 也不该用@Query
     * 但是先不改了，先这样
     * @param menu_id
     * @return
     */
    @Query(value = "select * from menu where menu_id = ?",nativeQuery=true)
    Set<Menu> getAllChildrenMenu(Integer menu_id);

    @Query(value = "select * from menu where menu_id <> NULL", nativeQuery = true)
    Set<Menu> getAllNotNullMenus();
}
