package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.City;
import com.rrpserivce.demo.entity.Province;
import com.rrpserivce.demo.repository.CityRepository;
import com.rrpserivce.demo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;


    public List<City> findAll() {
        return cityRepository.findAll();
    }

    //查询当前省下的市
    public List<City> findByProvinceId(String provinceid) {
        return cityRepository.findByProvinceid(provinceid);
    }
}
