package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.SoftwareUpgrade;
import com.rrpserivce.demo.repository.SoftwareUpgradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareUpgradeService {
    @Autowired
    private SoftwareUpgradeRepository softwareUpgradeRepository;

    //查询全部
    public List<SoftwareUpgrade> findAll() {
        return softwareUpgradeRepository.findAll();
    }

    //根据id查找
    public SoftwareUpgrade findById(int id) {
        return softwareUpgradeRepository.findById(id).get();
    }

    //增加
    public void add(SoftwareUpgrade softwareUpgrade) {
        softwareUpgradeRepository.save(softwareUpgrade);
    }

    //修改
    public void update(SoftwareUpgrade softwareUpgrade) {
        softwareUpgradeRepository.save(softwareUpgrade);
    }

    //根据id删除
    public void deleteById(int id) {
        softwareUpgradeRepository.deleteById(id);
    }

}
