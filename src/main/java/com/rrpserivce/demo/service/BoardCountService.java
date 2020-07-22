package com.rrpserivce.demo.service;


import com.rrpserivce.demo.entity.BoardCount;
import com.rrpserivce.demo.repository.BoardCountRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class BoardCountService {
    @Autowired
    private BoardCountRepository boardCountRepository;

    public Set<BoardCount> query(Map<String, Object> jsonData) {
        Set<BoardCount> allCount;
        System.out.println(jsonData.toString());
        if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
            allCount = boardCountRepository.getCountWithRobot(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("robotid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
            allCount = boardCountRepository.getCountWithCompany(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("companyid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("city"))) {
            allCount = boardCountRepository.getCountWithCity(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("city").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("province"))) {
            allCount = boardCountRepository.getCountWithProvince(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("province").toString());
        }else {
            allCount = boardCountRepository.getAllCount(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString());
        }

        Set<BoardCount> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
        set.addAll(allCount);
        for (BoardCount single: set){
            List<BoardCount> repeats =
                    allCount.stream().filter(s-> DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
            if (repeats.size()>1){
                int mean = 0;
                for (BoardCount c: repeats) mean+=c.getCount();
                single.setCount(mean);
            }
        }
        return set;
    }

    //根据机器人id寻找最新的一个租赁
    public BoardCount findNewestByRobot(String id){return boardCountRepository.findNewestByRobot_Id(id);}

    public List<BoardCount> findAllByRobot(String robot_id) {
        return boardCountRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BoardCount> getCountById(String time) {
        return boardCountRepository.getCountById(time);
    }

}
