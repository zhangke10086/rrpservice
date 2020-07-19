package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.BenchRatio;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.ProductRatio;
import com.rrpserivce.demo.repository.BenchRatioRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class BenchRatioService {
    @Autowired
    private BenchRatioRepository benchRatioRepository;
    //根据机器人id寻找最新的一个模台转换率
    public BenchRatio findNewestByRobot(String id){return benchRatioRepository.findNewestByRobot_Id(id);}
    //查询
    public Set<BenchRatio> getRatio(String begin, String end, String robot_id) {
        if (robot_id.equals("null")) {
            Set<BenchRatio> ratios = benchRatioRepository.getAllRatio(begin, end);
            Set<BenchRatio> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
            set.addAll(ratios);
            for (BenchRatio single: set){
                List<BenchRatio> repeats =
                        ratios.stream().filter(s-> DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
                if (repeats.size()>1){
                    double mean = 0;
                    for (BenchRatio ratio1: repeats) mean+=ratio1.getRatio();
                    mean/=repeats.size();
                    single.setRatio(mean);
                }
            }
            return set;
        } else{
            return benchRatioRepository.getRatio(begin, end,robot_id);
        }

    }

    public List<BenchRatio> findAllByRobot(String robot_id) {
        return benchRatioRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BenchRatio> getRatioById(String time) {
        return benchRatioRepository.getRatioById(time);
    }

}
