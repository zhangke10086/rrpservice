package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.BoardArea;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.repository.BoardAreaRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class BoardAreaService {
    @Autowired
    private BoardAreaRepository boardAreaRepository;

    //根据机器人id寻找最新的一个租赁
    public BoardArea findNewestByRobot(String id){return boardAreaRepository.findNewestByRobot_Id(id);}

    //查询
    public Set<BoardArea> getArea(String begin, String end,String robot_id) {
        if (robot_id.equals("null")) {
            Set<BoardArea> areas = boardAreaRepository.getAllArea(begin, end);

            Set<BoardArea> set = new TreeSet<>((area, area1) -> DateUtils.isSameDay(area.getTime(), area1.getTime())?0:(area.getTime().compareTo(area1.getTime())));
            set.addAll(areas);
            for (BoardArea single: set){
                List<BoardArea> repeats =
                        areas.stream().filter(s-> DateUtils.isSameDay(s.getTime(), single.getTime())).collect(Collectors.toList());
                if (repeats.size()>1){
                    double mean = 0;
                    for (BoardArea area: repeats) mean+=area.getArea();
                    single.setArea(mean);
                }
            }
            return set;
        } else{
            return boardAreaRepository.getArea(begin, end, robot_id);
        }
    }

    public List<BoardArea> findAllByRobot(String robot_id) {
        return boardAreaRepository.getByRobot(robot_id);
    }

    //根据id查询
    public List<BoardArea> getAreaById(String time) {
        return boardAreaRepository.getAreaById(time);
    }

}
