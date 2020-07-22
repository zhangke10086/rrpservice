package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.repository.BenchCountRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BenchCountService {
    @Autowired
    private BenchCountRepository benchCountRepository;

    //动态查询
    public Set<BenchCount> query(Map<String, Object> jsonData) {
        Set<BenchCount> allCount;
        System.out.println(jsonData.toString());
        if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
            allCount = benchCountRepository.getCountWithRobot(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("robotid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
            allCount = benchCountRepository.getCountWithCompany(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("companyid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("city"))) {
            allCount = benchCountRepository.getCountWithCity(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("city").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("province"))) {
            allCount = benchCountRepository.getCountWithProvince(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("province").toString());
        }else {
            allCount = benchCountRepository.getAllCount(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString());
        }
//        List<BenchCount> result = new ArrayList<BenchCount>();
////        for (BenchCount benchCount: mpsPage)
////            if ((benchCount.getTime().toString()).compareTo(jsonData.get("enddate").toString()))
////                mpsPage.add(benchCount);
//        System.out.println("=========================");
//        System.out.println(jsonData.toString());
//        System.out.println(jsonData.get("enddate").toString());
//        System.out.println(jsonData.get("enddate").getClass());
//        return result;

        Set<BenchCount> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
        set.addAll(allCount);
        for (BenchCount singleBenchCount: set){
            List<BenchCount> repeats =
                    allCount.stream().filter(s->DateUtils.isSameDay(s.getTime(), singleBenchCount.getTime())).collect(Collectors.toList());
            if (repeats.size()>1){
                int sum = 0;
                for (BenchCount singleBenchCount2: repeats) sum+=singleBenchCount2.getCount();
                singleBenchCount.setCount(sum);
            }
        }
        return set;
    }
    //根据机器人id寻找最新的一个租赁
    public BenchCount findNewestByRobot(String id){return benchCountRepository.findNewestByRobot_Id(id);}

    public List<BenchCount> findAllByRobot(String robot_id) {
        return benchCountRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BenchCount> getCountById(String time) {
        return benchCountRepository.getCountById(time);
    }

}
