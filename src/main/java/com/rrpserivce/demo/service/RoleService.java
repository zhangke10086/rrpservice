package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Role;
import com.rrpserivce.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Integer id){
        return roleRepository.findById(id).get();
    }

    public void add(Role role){
        roleRepository.save(role);
    }

    public void update(Role role){
        roleRepository.save(role);
    }

    public void deleteById(Integer id){
        roleRepository.deleteById(id);
    }

}
