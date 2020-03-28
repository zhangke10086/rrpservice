package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Diagnose;
import com.rrpserivce.demo.repository.DiagnoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnoseService {
    @Autowired
    private DiagnoseRepository diagnoseRepository;

    //查询全部
    public List<Diagnose> findAll() {
        return diagnoseRepository.findAll();
    }

    //根据id查找
    public Diagnose findById(int id) {
        return diagnoseRepository.findById(id).get();
    }

    //增加
    public void add(Diagnose diagnose) {
        diagnoseRepository.save(diagnose);
    }

    //修改
    public void update(Diagnose diagnose) {
        diagnoseRepository.save(diagnose);
    }

    //根据id删除
    public void deleteById(int id) {
        diagnoseRepository.deleteById(id);
    }

}
