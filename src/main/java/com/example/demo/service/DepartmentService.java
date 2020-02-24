/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo.service;


import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //查询全部
    public List<Department> findAll(){
        return  departmentRepository.findAll();
    }
    //根据id查找
    public Department findById(String id) {
         return departmentRepository.findById(id).get();
    }
    //增加
    public void add(Department Department) {
         departmentRepository.save(Department);
    }
    //修改
    public void update(Department Department) {
        departmentRepository.save(Department);
    }
    //根据id删除
    public void deleteById(String id) {
        departmentRepository.deleteById(id);
    }

}
