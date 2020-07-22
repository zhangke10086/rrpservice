package com.rrpserivce.demo.service;


import com.rrpserivce.demo.entity.ConcreteCount;
import com.rrpserivce.demo.repository.ConcreteCountRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class ConcreteCountService {
    @Autowired
    private ConcreteCountRepository concreteCountRepository;

    public Set<ConcreteCount> query(Map<String, Object> jsonData) {
        Set<ConcreteCount> allCount;
        System.out.println(jsonData.toString());
        if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
            allCount = concreteCountRepository.getCountWithRobot(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("robotid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
            allCount = concreteCountRepository.getCountWithCompany(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("companyid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("city"))) {
            allCount = concreteCountRepository.getCountWithCity(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("city").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("province"))) {
            allCount = concreteCountRepository.getCountWithProvince(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("province").toString());
        }else {
            allCount = concreteCountRepository.getAllCount(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString());
        }

        Set<ConcreteCount> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
        set.addAll(allCount);
        for (ConcreteCount single: set){
            List<ConcreteCount> repeats =
                    allCount.stream().filter(s-> DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
            if (repeats.size()>1){
                int mean = 0;
                for (ConcreteCount ratio1: repeats) mean+=ratio1.getCount();
//                mean/=repeats.size();
                single.setCount(mean);
            }
        }
        return set;
    }

    //根据机器人id寻找最新的一个租赁
    public ConcreteCount findNewestByRobot(String id){return concreteCountRepository.findNewestByRobot_Id(id);}


    public List<ConcreteCount> findAllByRobot(String robot_id) {
        return concreteCountRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<ConcreteCount> getCountById(String time) {
        return concreteCountRepository.getCountById(time);
    }

}
