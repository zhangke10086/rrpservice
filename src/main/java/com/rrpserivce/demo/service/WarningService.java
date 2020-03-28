package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Warning;
import com.rrpserivce.demo.repository.WarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarningService {
    @Autowired
    private WarningRepository warningRepository;

    //查询全部
    public List<Warning> findAll() {
        return warningRepository.findAll();
    }

    //根据id查找
    public Warning findById(int id) {
        return warningRepository.findById(id).get();
    }

    //增加
    public void add(Warning warning) {
        warningRepository.save(warning);
    }

    //修改
    public void update(Warning warning) {
        warningRepository.save(warning);
    }

    //根据id删除
    public void deleteById(int id) {
        warningRepository.deleteById(id);
    }

}
