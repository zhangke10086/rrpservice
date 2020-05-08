package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.ProductRatio;
import com.rrpserivce.demo.repository.ProductRatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRatioService {
    @Autowired
    private ProductRatioRepository productRatioRepository;

    //查询
    public List<ProductRatio> getRatio(String begin, String end) {
        return productRatioRepository.getRatio(begin, end);
    }

    //根据id查询
    public List<ProductRatio> getRatioById(String time) {
        return productRatioRepository.getRatioById(time);
    }

}
