

package com.example.demo.service;


import com.example.demo.entity.Degree;
import com.example.demo.entity.School;
import com.example.demo.repository.DegreeRepository;
import com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeService {
    @Autowired
    private DegreeRepository degreeRepository;

    //查询全部
    public List<Degree> findAll(){
        return  degreeRepository.findAll();
    }
    //根据id查找
    public Degree findById(String id) {
         return degreeRepository.findById(id).get();
    }
    //增加
    public void add(Degree degree) {
         degreeRepository.save(degree);
    }
    //修改
    public void update(Degree degree) {
        degreeRepository.save(degree);
    }
    //根据id删除
    public void deleteById(String id) {
        degreeRepository.deleteById(id);
    }

}
