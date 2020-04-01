package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.ProcessData;
import com.rrpserivce.demo.repository.ProcessDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessDataService {
    @Autowired
    private ProcessDataRepository processDataRepository;

    //查询全部
    public List<ProcessData> findAll() {
        return processDataRepository.findAll();
    }

    //根据id查找
    public ProcessData findById(int id) {
        return processDataRepository.findById(id).get();
    }

    //增加
    public void add(ProcessData processData) {
        processDataRepository.save(processData);
    }

    //修改
    public void update(ProcessData processData) {
        processDataRepository.save(processData);
    }

    //根据id删除
    public void deleteById(int id) {
        processDataRepository.deleteById(id);
    }

    //根据bench_id查找
    public ProcessData getByBench(int bench_id) {
        return processDataRepository.getByBench(bench_id);
    }

    //根据bench_id删除
    public void deleteByBench(int bench_id) {
        processDataRepository.deleteByBench(bench_id);
    }

}
