

package com.example.demo.service;


import com.example.demo.entity.School;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    //查询全部
    public List<Teacher> findAll(){
        return  teacherRepository.findAll();
    }
    //根据id查找
    public Teacher findById(String id) {
         return teacherRepository.findById(id).get();
    }
    //增加
    public void add(Teacher teacher) {
         teacherRepository.save(teacher);
    }
    //修改
    public void update(Teacher teacher) {
        teacherRepository.save(teacher);
    }
    //根据id删除
    public void deleteById(String id) {
        teacherRepository.deleteById(id);
    }

}
