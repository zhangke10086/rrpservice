package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.*;
import com.rrpserivce.demo.repository.AuthorityRepository;
import com.rrpserivce.demo.repository.RoleMenuRepository;
import com.rrpserivce.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RoleMenuRepository roleMenuRepository;
    @Autowired
    private RoleRepository roleRepository;
    //增加
    public void add(Authority authority){
        authorityRepository.save(authority);
    }


    /**
     * 用事物先添加role表和role_menu_ass
     * 再添加authority
     * @param completedAuthority
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(CompletedAuthority completedAuthority){
        roleRepository.save(completedAuthority.getToAddRole());

        List<RoleMenuOperation> roleMenuOperations = completedAuthority.getAuthorityArray();
        for (RoleMenuOperation roleMenuOperation: roleMenuOperations)
            this.add(new Authority(
                    roleMenuOperation.getOperation(),
                    roleMenuRepository.findByRoleAndMenu(
                            roleMenuOperation.getRole(), roleMenuOperation.getMenu())
                            .getId()));
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(CompletedAuthority completedAuthority){
        // 也可以求交集差集然后对应不变-增加或删除
        authorityRepository.deleteAuthority(completedAuthority.getToAddRole().getId());
        roleRepository.save(completedAuthority.getToAddRole());

        List<RoleMenuOperation> roleMenuOperations = completedAuthority.getAuthorityArray();
        for (RoleMenuOperation roleMenuOperation: roleMenuOperations)
            this.add(new Authority(
                    roleMenuOperation.getOperation(),
                    roleMenuRepository.findByRoleAndMenu(
                            roleMenuOperation.getRole(), roleMenuOperation.getMenu())
                            .getId()));
    }
    //根据id删除
    public void deleteById(int id){authorityRepository.deleteById(id);}
    //修改
    public void update(Authority authority){authorityRepository.save(authority);}
    //查找全部
    public List<Authority> findAll(){
        return authorityRepository.findAll();
    }
    //按id查找
    public Authority find(int id){return authorityRepository.findById(id).get();}



    public Set<RoleMenuOperation> findByRoleId(int role_id) {
        List<Authority> authorities =  authorityRepository.findByRoleId(role_id);
        Set<RoleMenuOperation> roleMenuOperations = new HashSet<>();
        for (Authority authority: authorities) {
            roleMenuOperations.add(new RoleMenuOperation(
                    roleMenuRepository.findById(authority.getRoleMenu()).get().getRole(),
                    roleMenuRepository.findById(authority.getRoleMenu()).get().getMenu(),
                    authority.getOperation()
            ));
        }
        return roleMenuOperations;
    }



    public Set<MenuOperations> findByRoleIdWhenLogin(int role_id) {
        List<Authority> authorities =  authorityRepository.findByRoleId(role_id);
        Set<RoleMenuOperation> roleMenuOperations = new HashSet<>();

        // 结果的集合
        Set<MenuOperations> menuOperationsSet = new HashSet<>();

        for (Authority authority: authorities) {
            roleMenuOperations.add(new RoleMenuOperation(
                    roleMenuRepository.findById(authority.getRoleMenu()).get().getRole(),
                    roleMenuRepository.findById(authority.getRoleMenu()).get().getMenu(),
                    authority.getOperation()
            ));
        }

        //复杂度
        // 先单个抽出来放到menuOperationsSet
        for (RoleMenuOperation roleMenuOperation: roleMenuOperations)
            menuOperationsSet.add(new MenuOperations(roleMenuOperation.getMenu()));

        // 然后对menuOperationsSet的operations修改(先roleMenuOperations，重复只会出现一次，避免多余检查)
        for (RoleMenuOperation roleMenuOperation: roleMenuOperations) for (MenuOperations menuOperations: menuOperationsSet)
                if (menuOperations.getMenu() == roleMenuOperation.getMenu()) { menuOperations.addOperation(roleMenuOperation.getOperation());break;}

        return menuOperationsSet;
    }

}
