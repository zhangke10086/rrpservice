package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;
    //增加
    public void add(Lease lease){leaseRepository.save(lease);}
    //删除
    public void delete(int id){leaseRepository.deleteById(id);}
    //修改
    public void update(Lease lease){leaseRepository.save(lease);}
    //查找全部
    public List<Lease> findAll(){return leaseRepository.findAll();}
    //按id查找
    public Lease find(int id){return leaseRepository.findById(id).get();}
    //根据机器人id寻找
    public List<Lease> findByRobot(int id){return leaseRepository.findAllByRobot_Id(id);}
    //根据租用企业寻找
    public List<Lease> findByCompany(int id){return leaseRepository.findAllByCompanyId_Id(id);}
}
