package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.ProductRatio;
import com.rrpserivce.demo.repository.ProductRatioRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductRatioService {
    @Autowired
    private ProductRatioRepository productRatioRepository;

    //查询
    public Set<ProductRatio> getRatio(String begin, String end,String robot_id) {
        if (robot_id.equals("null")) {
            Set<ProductRatio> ratios = productRatioRepository.getAllRatio(begin, end);

            Set<ProductRatio> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
            set.addAll(ratios);
            for (ProductRatio singleRatio: set){
                List<ProductRatio> repeats =
                        ratios.stream().filter(s->
                                DateUtils.isSameDay(s.getTime(), singleRatio.getTime())
                        ).collect(Collectors.toList());
                if (repeats.size()>1){
                    double mean = 0;
                    for (ProductRatio ratio1: repeats) mean+=ratio1.getRatio();
                    mean/=repeats.size();
                    singleRatio.setRatio(mean);
                }
            }
            return set;
        } else{
            return productRatioRepository.getRatio(begin, end, robot_id);
        }
    }

    public List<ProductRatio> findAllByRobot(String robot_id) {
        return productRatioRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<ProductRatio> getRatioById(String time) {
        return productRatioRepository.getRatioById(time);
    }

}
