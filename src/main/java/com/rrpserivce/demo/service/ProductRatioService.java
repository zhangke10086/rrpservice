package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.ProductRatio;
import com.rrpserivce.demo.repository.ProductRatioRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductRatioService {
    @Autowired
    private ProductRatioRepository productRatioRepository;

    public Set<ProductRatio> query(Map<String, Object> jsonData) {
        Set<ProductRatio> allCount;
        System.out.println(jsonData.toString());
        if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
            allCount = productRatioRepository.getRatioWithRobot(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("robotid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
            allCount = productRatioRepository.getRatioWithCompany(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("companyid").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("city"))) {
            allCount = productRatioRepository.getRatioWithCity(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("city").toString());
        }else if (!StringUtils.isEmpty(jsonData.get("province"))) {
            allCount = productRatioRepository.getRatioWithProvince(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString(),
                    jsonData.get("province").toString());
        }else {
            allCount = productRatioRepository.getAllRatio(
                    jsonData.get("startdate").toString(),
                    jsonData.get("enddate").toString());
        }

        Set<ProductRatio> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
        set.addAll(allCount);
        for (ProductRatio single: set){
            List<ProductRatio> repeats =
                    allCount.stream().filter(s-> DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
            if (repeats.size()>1){
                double mean = 0;
                for (ProductRatio ratio1: repeats) mean+=ratio1.getRatio();
                mean/=repeats.size();
                single.setRatio(mean);
            }
        }

        return set;
    }


    public List<ProductRatio> findAllByRobot(String robot_id) {
        return productRatioRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<ProductRatio> getRatioById(String time) {
        return productRatioRepository.getRatioById(time);
    }

}
