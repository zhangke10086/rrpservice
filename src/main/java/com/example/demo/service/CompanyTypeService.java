package com.example.demo.service;

import com.example.demo.entity.CompanyType;
import com.example.demo.repository.CompanyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyTypeService {
    @Autowired
    private CompanyTypeRepository companyTypeRepository;
    //增
    public void add(CompanyType companyType){companyTypeRepository.save(companyType);}
    //删
    public void deleteById(Integer id){companyTypeRepository.deleteById(id);}
    //修改
    public void update(CompanyType companyType){companyTypeRepository.save(companyType);}
    //按id查找
    public CompanyType findById(Integer id){return companyTypeRepository.findById(id).get();}
    //查找全部
    public List<CompanyType> findAll(){
        return companyTypeRepository.findAll();
    }
}
