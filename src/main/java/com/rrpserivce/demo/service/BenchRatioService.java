package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchRatio;
import com.rrpserivce.demo.repository.BenchRatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchRatioService {
    @Autowired
    private BenchRatioRepository benchRatioRepository;

    //查询
    public List<BenchRatio> getRatio(String begin, String end) {
        return benchRatioRepository.getRatio(begin, end);
    }

    //根据id查询
    public List<BenchRatio> getRatioById(String time) {
        return benchRatioRepository.getRatioById(time);
    }

}
