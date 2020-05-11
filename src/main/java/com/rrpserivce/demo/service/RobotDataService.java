package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.RobotData;
import com.rrpserivce.demo.repository.RobotDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotDataService {
    @Autowired
    private RobotDataRepository robotDataRepository;

    //查询全部
    public List<RobotData> findAll() {
        return robotDataRepository.findAll();
    }

    //根据id查找
    public RobotData findById(int id) {
        return robotDataRepository.findById(id).get();
    }

    //增加
    public void add(RobotData robotData) {
        robotDataRepository.save(robotData);
    }

    //修改
    public void update(RobotData robotData) {
        robotDataRepository.save(robotData);
    }

    //根据id删除
    public void deleteById(int id) {
        robotDataRepository.deleteById(id);
    }

    public List<RobotData> findAllByRobot(String robot_id) {
        return robotDataRepository.getByRobot(robot_id);
    }

}
