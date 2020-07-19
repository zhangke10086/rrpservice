package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Bench;
import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.ProductRatio;
import com.rrpserivce.demo.repository.BenchCountRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class BenchCountService {
    @Autowired
    private BenchCountRepository benchCountRepository;

    //查询
    public Set<BenchCount> getCount(String begin, String end,String robot_id) {
        if (robot_id.equals("null")) {
            Set<BenchCount> ratios = benchCountRepository.getAllCount(begin, end);
            Set<BenchCount> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
            set.addAll(ratios);
            for (BenchCount singleBenchCount: set){
                List<BenchCount> repeats =
                        ratios.stream().filter(s->DateUtils.isSameDay(s.getTime(), singleBenchCount.getTime())).collect(Collectors.toList());
                if (repeats.size()>1){
                    int sum = 0;
                    for (BenchCount singleBenchCount2: repeats) sum+=singleBenchCount2.getCount();
                    singleBenchCount.setCount(sum);
                }
            }
            return set;
        } else{
            return benchCountRepository.getCount(begin, end,robot_id);
        }

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
