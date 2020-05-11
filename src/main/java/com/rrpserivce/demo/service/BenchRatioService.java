package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
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
    public List<BenchRatio> getRatio(String begin, String end,String robot_id) {
        return benchRatioRepository.getRatio(begin, end,robot_id);
    }

    public List<BenchRatio> findAllByRobot(String robot_id) {
        return benchRatioRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BenchRatio> getRatioById(String time) {
        return benchRatioRepository.getRatioById(time);
    }

}
