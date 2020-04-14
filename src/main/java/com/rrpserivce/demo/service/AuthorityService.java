package com.rrpserivce.demo.service;

import com.alibaba.fastjson.JSON;
import com.rrpserivce.demo.entity.Authority;
import com.rrpserivce.demo.entity.Company;
import com.rrpserivce.demo.entity.RoleMenu;
import com.rrpserivce.demo.entity.RoleMenuOperation;
import com.rrpserivce.demo.repository.AuthorityRepository;
import com.rrpserivce.demo.repository.CompanyRepository;
import com.rrpserivce.demo.repository.RoleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Cache;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RoleMenuRepository roleMenuRepository;
    //增加
    public void add(Authority authority){
        authorityRepository.save(authority);
//        authority = null;
//        this.getHibernateTemplate().evict(authority);
    }


    //    public void add(List<Authority> authorities){authorityRepository.save(authorities);}
    //增加
    @Transactional(rollbackFor = Exception.class)
    public void add(List<RoleMenuOperation> roleMenuOperations){
        try {
            Thread.sleep(10000); // 休眠10秒
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
        System.out.println(JSON.toJSONString(roleMenuOperations));
//        Set<Authority> authorities = new HashSet<>();
        Authority authority;
        for (RoleMenuOperation roleMenuOperation: roleMenuOperations) {
//            int operationId = roleMenuOperation.getOperation();
//            int roleId = roleMenuOperation.getRole();
//            int menuId = roleMenuOperation.getMenu();
//            RoleMenu roleMenu = roleMenuRepository.findByRoleAndMenu(roleId, menuId);
//            if (roleMenu!=null) {
//                int roleMenuId = roleMenu.getId();
//            int roleMenuId = 0;
//            for (RoleMenu roleMenu1: roleMenuRepository.findAll()) {
//                if (roleMenu1.getRole() == roleId && roleMenu1.getMenu() == menuId) {
//                    roleMenuId = roleMenu1.getId();
//                    System.out.println("嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎  " + roleMenuId);
//                }
//            }
//                Authority authority = new Authority(operationId,
//                        roleMenuRepository.findByRoleAndMenu(roleId, menuId).getId());
            authority = new Authority(
                    roleMenuOperation.getOperation(),
                    roleMenuRepository.findByRoleAndMenu(
                            roleMenuOperation.getRole(), roleMenuOperation.getMenu())
                            .getId());
            this.add(authority);


//                authorities.add(new Authority(
//                        roleMenuOperation.getOperation(),
//                        roleMenuRepository.findByRoleAndMenu(
//                                roleMenuOperation.getRole(), roleMenuOperation.getMenu())
//                                .getId()));
//            }else return roleId + " " + menuId;
        }
    }
    //根据id删除
    public void deleteById(int id){authorityRepository.deleteById(id);}
    //修改
    public void update(Authority authority){authorityRepository.save(authority);}
    //查找全部
    public List<Authority> findAll(){return authorityRepository.findAll();}
    //按id查找
    public Authority find(int id){return authorityRepository.findById(id).get();}

    public int getRoleMenuId(int role_id, int menu_id) {
//        return authorityRepository.getRoleMenuId(role_id, menu_id);
        List<RoleMenu> roleMenus = roleMenuRepository.findAll();
        for (RoleMenu roleMenu: roleMenus) {
            if (roleMenu.getRole() == role_id && roleMenu.getMenu() == menu_id) {
                return roleMenu.getId();
            }
        }
        return 0;
    }
//package com.rrpserivce.demo.service;
//
//import com.alibaba.fastjson.JSON;
//import com.rrpserivce.demo.entity.Authority;
//import com.rrpserivce.demo.entity.Company;
//import com.rrpserivce.demo.entity.RoleMenu;
//import com.rrpserivce.demo.entity.RoleMenuOperation;
//import com.rrpserivce.demo.repository.AuthorityRepository;
//import com.rrpserivce.demo.repository.CompanyRepository;
//import com.rrpserivce.demo.repository.RoleMenuRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//    @Service
//    public class AuthorityService {
//        @Autowired
//        private AuthorityRepository authorityRepository;
//        @Autowired
//        private RoleMenuRepository roleMenuRepository;
//        //增加
//        public void add(Authority authority){authorityRepository.save(authority);}
//        //增加
////    @Transactional(rollbackFor = Exception.class)
//        public String add(List<RoleMenuOperation> roleMenuOperations){
//            try {
//                Thread.sleep(10000); // 休眠10秒
//            } catch (Exception e) {
//                System.out.println("Got an exception!");
//            }
//            System.out.println(JSON.toJSONString(roleMenuOperations));
//            Set<Authority> authorities = new HashSet<>();
//            for (RoleMenuOperation roleMenuOperation: roleMenuOperations) {
//                int operationId = roleMenuOperation.getOperation();
//                int roleId = roleMenuOperation.getRole();
//                int menuId = roleMenuOperation.getMenu();
//                RoleMenu roleMenu = roleMenuRepository.findByRoleAndMenu(roleId, menuId);
//                if (roleMenu!=null) {
//                    int roleMenuId = roleMenu.getId();
////            int roleMenuId = 0;
////            for (RoleMenu roleMenu1: roleMenuRepository.findAll()) {
////                if (roleMenu1.getRole() == roleId && roleMenu1.getMenu() == menuId) {
////                    roleMenuId = roleMenu1.getId();
////                    System.out.println("嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎  " + roleMenuId);
////                }
////            }
//                    Authority authority = new Authority(operationId, roleMenuId);
//                    this.add(authority);
//                    authorities.add(authority);
//                }else return roleId + " " + menuId;
//            }
//            return JSON.toJSONString(authorities);
//        }
//        //根据id删除
//        public void deleteById(int id){authorityRepository.deleteById(id);}
//        //修改
//        public void update(Authority authority){authorityRepository.save(authority);}
//        //查找全部
//        public List<Authority> findAll(){return authorityRepository.findAll();}
//        //按id查找
//        public Authority find(int id){return authorityRepository.findById(id).get();}
//
//        public int getRoleMenuId(int role_id, int menu_id) {
////        return authorityRepository.getRoleMenuId(role_id, menu_id);
//            List<RoleMenu> roleMenus = roleMenuRepository.findAll();
//            for (RoleMenu roleMenu: roleMenus) {
//                if (roleMenu.getRole() == role_id && roleMenu.getMenu() == menu_id) {
//                    System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊       " + roleMenu.getId());
//                    return roleMenu.getId();
//                }
//            }
//            System.out.println("没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有没有");
//            return 0;
//        }
//
//    }
}
