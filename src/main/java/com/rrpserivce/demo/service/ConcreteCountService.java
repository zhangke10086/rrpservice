package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.ConcreteCount;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.ProductRatio;
import com.rrpserivce.demo.repository.ConcreteCountRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class ConcreteCountService {
    @Autowired
    private ConcreteCountRepository concreteCountRepository;
    //根据机器人id寻找最新的一个租赁
    public ConcreteCount findNewestByRobot(String id){return concreteCountRepository.findNewestByRobot_Id(id);}
    //查询
    public Set<ConcreteCount> getCount(String begin, String end, String robot_id) {
        if (robot_id.equals("null")) {
            Set<ConcreteCount> ratios = concreteCountRepository.getAllCount(begin, end);
            Set<ConcreteCount> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
            set.addAll(ratios);
            for (ConcreteCount single: set){
                List<ConcreteCount> repeats =
                        ratios.stream().filter(s-> DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
                if (repeats.size()>1){
                    double mean = 0;
                    for (ConcreteCount count: repeats) mean+=count.getCount();
                    single.setCount(mean);
                }
            }
            return set;
        } else{
            return concreteCountRepository.getCount(begin, end, robot_id);
        }
    }

    public List<ConcreteCount> findAllByRobot(String robot_id) {
        return concreteCountRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<ConcreteCount> getCountById(String time) {
        return concreteCountRepository.getCountById(time);
    }

}
