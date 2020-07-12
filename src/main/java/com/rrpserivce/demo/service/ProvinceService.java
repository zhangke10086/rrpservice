package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Province;
import com.rrpserivce.demo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    //查询全部省
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

}
