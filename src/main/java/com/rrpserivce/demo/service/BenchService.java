package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Bench;
import com.rrpserivce.demo.repository.BenchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchService {
    @Autowired
    private BenchRepository benchRepository;

    //查询全部
    public List<Bench> findAll() {
        return benchRepository.findAll();
    }

    //根据id查找
    public Bench findById(int id) {
        return benchRepository.findById(id).get();
    }

    //增加
    public void add(Bench bench) {
        benchRepository.save(bench);
    }

    //修改
    public void update(Bench bench) {
        benchRepository.save(bench);
    }

    //根据id删除
    public void deleteById(int id) {
        benchRepository.deleteById(id);
    }

}
