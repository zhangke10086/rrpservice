package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Company;
import com.rrpserivce.demo.entity.Remind;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.repository.RemindRepository;
import com.rrpserivce.demo.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RemindService {
    @Autowired
    private RemindRepository remindRepository;

    public void add(Map<String,Object> json){
        String robotid = null == json.get("robotid")? null: json.get("robotid").toString();
        int companyid = null == json.get("companyid")? null: Integer.parseInt(json.get("companyid").toString());
        Remind remind = new Remind();
        Robot robot =new Robot();
        robot.setId(robotid);
        Company company = new Company();
        company.setId(companyid);
        remind.setRobot(robot);
        remind.setCompany(company);
        remindRepository.save(remind);
    }
    public Remind findByCompanyId(String id){
        return remindRepository.findByCompanyId(id);
    }
    public Remind findByRobotid(String id){
        return remindRepository.findByRobotid(id);
    }
}
