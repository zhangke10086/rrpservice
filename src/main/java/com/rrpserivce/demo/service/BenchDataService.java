package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchData;
import com.rrpserivce.demo.repository.BenchDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchDataService {
    @Autowired
    private BenchDataRepository benchDataRepository;

    //查询全部
    public List<BenchData> findAll() {
        return benchDataRepository.findAll();
    }

    //根据id查找
    public BenchData findById(int id) {
        return benchDataRepository.findById(id).get();
    }

    //增加
    public void add(BenchData benchManage) {
        benchDataRepository.save(benchManage);
    }

    //修改
    public void update(BenchData benchManage) {
        benchDataRepository.save(benchManage);
    }

    //根据id删除
    public void deleteById(int id) {
        benchDataRepository.deleteById(id);
    }

    //根据bench_id删除
    public void deleteByBench(int bench_id) {
        benchDataRepository.deleteByBench(bench_id);
    }

}
