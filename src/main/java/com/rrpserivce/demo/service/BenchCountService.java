package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.repository.BenchCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchCountService {
    @Autowired
    private BenchCountRepository benchCountRepository;

    //查询
    public List<BenchCount> getCount(String begin, String end) {
        return benchCountRepository.getCount(begin, end);
    }

    //根据id查询
    public List<BenchCount> getCountById(String time) {
        return benchCountRepository.getCountById(time);
    }

}
