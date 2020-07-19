package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Company;
import com.rrpserivce.demo.entity.SCZT;
import com.rrpserivce.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ScztService {
    @Autowired
    private ScztRepository scztRepository;
    @Autowired
    private RobotRepository robotRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    //增加
    @Transactional
    public void add(SCZT sczt){
        scztRepository.save(sczt);
    }
    //根据id删除
    @Transactional
    public void deleteById(int id){
        scztRepository.deleteById(id);
    }
    //查找全部
    public List<SCZT> findAll(){return scztRepository.findAll();}
    //按id查找
    public SCZT find(int id){return scztRepository.findById(id);}
    //按Robotid查找
    public SCZT findByRobot(String id){return scztRepository.findByRobot_Id(id);}
}
