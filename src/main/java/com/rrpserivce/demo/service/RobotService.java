package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class RobotService {
    @Autowired
    private RobotRepository robotRepository;
    //增加
    public void add(Robot robot){robotRepository.save(robot);}
    //删除
    public void delete(String id){robotRepository.deleteById(id);}
    //修改
    public void update(Robot robot){robotRepository.save(robot);}
    //查全部
    public List<Robot> findAll(){return robotRepository.findAll();}
    //按id查找
    public Robot find(String id){return robotRepository.findById(id).get();}
    //根据企业id号查找
    public List<Robot> findAllByBelongingCompany(int id){
        return robotRepository.findAllByBelongingCompany_Id(id);
    }

    //出租企业查找 租用企业下的全部机器人
    public List<Robot> findByComapny(Map<String,Object> jsondata){
        String companyid = null == jsondata.get("companyid")? null:jsondata.get("companyid").toString();
        String owncompanyid = null == jsondata.get("owncompanyid")? null:jsondata.get("owncompanyid").toString();
        if(companyid!=null && owncompanyid!=null){
            return robotRepository.findByComapny(Integer.parseInt(companyid),Integer.parseInt(owncompanyid));
        } else {
            return null;
        }
    }

    public List<Robot> findByCompanyId(int id){
        return robotRepository.findByComapnyid(id);
    }
}
