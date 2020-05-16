package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Bench;
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
    public List<BenchCount> getCount(String begin, String end,String robot_id) {
        return benchCountRepository.getCount(begin, end,robot_id);
    }

    public List<BenchCount> findAllByRobot(String robot_id) {
        return benchCountRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BenchCount> getCountById(String time) {
        return benchCountRepository.getCountById(time);
    }

}
