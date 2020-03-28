package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchManage;
import com.rrpserivce.demo.repository.BenchManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchManageService {
    @Autowired
    private BenchManageRepository benchManageRepository;

    //查询全部
    public List<BenchManage> findAll() {
        return benchManageRepository.findAll();
    }

    //根据id查找
    public BenchManage findById(int id) {
        return benchManageRepository.findById(id).get();
    }

    //增加
    public void add(BenchManage benchManage) {
        benchManageRepository.save(benchManage);
    }

    //修改
    public void update(BenchManage benchManage) {
        benchManageRepository.save(benchManage);
    }

    //根据id删除
    public void deleteById(int id) {
        benchManageRepository.deleteById(id);
    }

}
