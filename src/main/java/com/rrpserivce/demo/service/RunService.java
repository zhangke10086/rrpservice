package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Run;
import com.rrpserivce.demo.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunService {
    @Autowired
    private RunRepository runRepository;

    //查询
    public List<Run> getRatio(String begin, String end) {
        return runRepository.getRatio(begin, end);
    }

    //根据id查询
    public List<Run> getRatioById(String time) {
        return runRepository.getRatioById(time);
    }

}
