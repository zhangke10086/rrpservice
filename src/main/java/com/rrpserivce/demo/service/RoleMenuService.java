package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.RoleMenu;
import com.rrpserivce.demo.repository.RoleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuService {
    @Autowired
    private RoleMenuRepository roleMenuRepository;
    public List<RoleMenu> findAll() {
        return roleMenuRepository.findAll();
    }

}
