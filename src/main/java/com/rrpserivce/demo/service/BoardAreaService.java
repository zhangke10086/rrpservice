package com.rrpserivce.demo.service;


import com.rrpserivce.demo.entity.BoardArea;
import com.rrpserivce.demo.repository.BoardAreaRepository;
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
public class BoardAreaService {
    @Autowired
    private BoardAreaRepository boardAreaRepository;

    public Set<BoardArea> query(Map<String, Object> jsonData) {
        Set<BoardArea> allArea;
        System.out.println(jsonData.toString());
        if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
            allArea = boardAreaRepository.getAreaWithRobot(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("robotid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
            allArea = boardAreaRepository.getAreaWithCompany(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("companyid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("city"))) {
            allArea = boardAreaRepository.getAreaWithCity(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("city").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("province"))) {
            allArea = boardAreaRepository.getAreaWithProvince(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("province").toString());
        }else {
            allArea = boardAreaRepository.getAllArea(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString());
        }

        Set<BoardArea> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
        set.addAll(allArea);
        for (BoardArea single: set){
            List<BoardArea> repeats =
                    allArea.stream().filter(s-> DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
            if (repeats.size()>1){
                double mean = 0;
                for (BoardArea a: repeats) mean+=a.getArea();
                single.setArea(mean);
            }
        }
        return set;
    }


    public List<BoardArea> findAllByRobot(String robot_id) {
        return boardAreaRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BoardArea> getAreaById(String time) {
        return boardAreaRepository.getAreaById(time);
    }

}
