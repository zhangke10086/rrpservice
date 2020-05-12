package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Pay;
import com.rrpserivce.demo.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService {
    @Autowired
    private PayRepository payRepository;
    //增加
    public void add(Pay pay){payRepository.save(pay);}
    //删除
    public void delete(int id){payRepository.deleteById(id);};
    //修改
    public void update(Pay pay){payRepository.save(pay);}
    //查找全部
    public List<Pay> findAll(){return payRepository.findAll();}
    //按id查找
    public Pay findById(int id){return payRepository.findById(id).get();}
    public Pay findByLeaseId(int id){
        return payRepository.findByLeaseId(id);
    }

}
