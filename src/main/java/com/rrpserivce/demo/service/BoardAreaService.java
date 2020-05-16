package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.BoardArea;
import com.rrpserivce.demo.repository.BoardAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardAreaService {
    @Autowired
    private BoardAreaRepository boardAreaRepository;

    //查询
    public List<BoardArea> getArea(String begin, String end,String robot_id) {
        return boardAreaRepository.getArea(begin, end,robot_id);
    }

    public List<BoardArea> findAllByRobot(String robot_id) {
        return boardAreaRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BoardArea> getAreaById(String time) {
        return boardAreaRepository.getAreaById(time);
    }

}
