package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.repository.LeaseRepository;
import com.rrpserivce.demo.repository.RemindRepository;
import com.rrpserivce.demo.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;
    @Autowired
    private RemindRepository remindRepository;
    @Autowired
    private RobotRepository robotRepository;
    //增加
    public void add(Lease lease){leaseRepository.save(lease);}
    //删除
    public void delete(int id){leaseRepository.deleteById(id);}
    //修改
    public void update(Lease lease){leaseRepository.save(lease);}
    //查找全部
    public List<Lease> findAll(){return leaseRepository.findAll();}
    //按id查找
    public Lease find(int id){return leaseRepository.findById(id).get();}
    //根据机器人id寻找
    public List<Lease> findByRobot(int id){return leaseRepository.findAllByRobot_Id(id);}
    //根据租用企业寻找
    public List<Lease> findByCompany(int id){return leaseRepository.findAllByCompanyId_Id(id);}

    public void setRemind(Map<String,Object> json){
        String id = null == json.get("robotid")? null: json.get("robotid").toString();
        leaseRepository.setRemind(id);
    }
    @Transactional
    public void cancleRemind(String id){
        leaseRepository.cancleRemind(id);
        remindRepository.deleteByRobotid(id);
    }

    @Transactional
    public void start(Lease lease){
        Robot robot = lease.getRobot();
        robot.setUse_situation("启用");
        robotRepository.save(robot);
        lease.setStartTime(new Date());
        leaseRepository.save(lease);
    }

    @Transactional
    public void stop(Lease lease){
        Robot robot = lease.getRobot();
        robot.setUse_situation("未启用");
        robotRepository.save(robot);
        lease.setStartTime(new Date());
        leaseRepository.save(lease);
    }
}
