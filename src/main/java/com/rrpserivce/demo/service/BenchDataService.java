package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchData;
import com.rrpserivce.demo.repository.BenchDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchDataService {
    @Autowired
    private BenchDataRepository benchManageRepository;

    //查询全部
    public List<BenchData> findAll() {
        return benchManageRepository.findAll();
    }

    //根据id查找
    public BenchData findById(int id) {
        return benchManageRepository.findById(id).get();
    }

    //增加
    public void add(BenchData benchManage) {
        benchManageRepository.save(benchManage);
    }

    //修改
    public void update(BenchData benchManage) {
        benchManageRepository.save(benchManage);
    }

    //根据id删除
    public void deleteById(int id) {
        benchManageRepository.deleteById(id);
    }

}
