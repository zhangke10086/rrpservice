

package com.example.demo.service;


import com.example.demo.entity.Department;
import com.example.demo.entity.School;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    //查询全部
    public List<School> findAll(){
        return  schoolRepository.findAll();
    }
    //根据id查找
    public School findById(String id) {
         return schoolRepository.findById(id).get();
    }
    //增加
    public void add(School school) {
         schoolRepository.save(school);
    }
    //修改
    public void update(School school) {
        schoolRepository.save(school);
    }
    //根据id删除
    public void deleteById(String id) {
        schoolRepository.deleteById(id);
    }

}
