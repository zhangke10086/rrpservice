package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BenchCount;
import com.rrpserivce.demo.entity.BoardCount;
import com.rrpserivce.demo.entity.ConcreteCount;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.repository.BoardCountRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class BoardCountService {
    @Autowired
    private BoardCountRepository boardCountRepository;
    //根据机器人id寻找最新的一个租赁
    public BoardCount findNewestByRobot(String id){return boardCountRepository.findNewestByRobot_Id(id);}
    //查询
    public Set<BoardCount> getCount(String begin, String end, String robot_id) {
        if (robot_id.equals("null")) {
            Set<BoardCount> ratios = boardCountRepository.getAllCount(begin, end);
            Set<BoardCount> set = new TreeSet<>((ratio1, ratio2) -> DateUtils.isSameDay(ratio1.getTime(), ratio2.getTime())?0:(ratio1.getTime().compareTo(ratio2.getTime())));
            set.addAll(ratios);
            for (BoardCount single: set){
                List<BoardCount> repeats =
                        ratios.stream().filter(s->DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
                if (repeats.size()>1){
                    double mean = 0;
                    for (BoardCount count: repeats) mean+=count.getCount();
                    single.setCount(mean);
                }
            }
            return set;
        } else{
            return boardCountRepository.getCount(begin, end, robot_id);
        }
    }

    public List<BoardCount> findAllByRobot(String robot_id) {
        return boardCountRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BoardCount> getCountById(String time) {
        return boardCountRepository.getCountById(time);
    }

}
