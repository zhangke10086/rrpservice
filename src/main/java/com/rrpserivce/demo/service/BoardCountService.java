package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.BoardCount;
import com.rrpserivce.demo.repository.BoardCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCountService {
    @Autowired
    private BoardCountRepository boardCountRepository;

    //查询
    public List<BoardCount> getCount(String begin, String end,String robot_id) {
        return boardCountRepository.getCount(begin, end,robot_id);
    }

    public List<BoardCount> findAllByRobot(String robot_id) {
        return boardCountRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BoardCount> getCountById(String time) {
        return boardCountRepository.getCountById(time);
    }

}
