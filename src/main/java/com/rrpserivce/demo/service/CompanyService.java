package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Company;
import com.rrpserivce.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    //增加
    public void add(Company company){companyRepository.save(company);}
    //根据id删除
    public void deleteById(int id){companyRepository.deleteById(id);}
    //修改
    public void update(Company company){companyRepository.save(company);}
    //查找全部
    public List<Company> findAll(){return companyRepository.findAll();}
    //按id查找
    public Company find(int id){return companyRepository.findById(id).get();}
    //按关键字查询
    public List<Company> findAllByNameLike(String key){
        String[] ag = key.split("");
        String sql = "";
        for (String para:ag) {
            sql = sql + para + "%";
        }
        return companyRepository.findAllByNameLike("%" + sql);
    }
}
