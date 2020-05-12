package com.rrpserivce.demo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.repository.LeaseRepository;
import com.rrpserivce.demo.repository.RemindRepository;
import com.rrpserivce.demo.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;
    @Autowired
    private RemindRepository remindRepository;
    @Autowired
    private RobotRepository robotRepository;



    public List<Lease> query(Map<String, Object> jsonData) {

        Specification<Lease> mpsQuery = new Specification<Lease>() {
            @Override
            public Predicate toPredicate(Root<Lease> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
                    predicates.add(criteriaBuilder.equal(root.get("robot").get("id"), jsonData.get("robotid").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
                    predicates.add(criteriaBuilder.equal(root.get("companyId").get("id"), jsonData.get("companyid").toString()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<Lease> mpsPage = leaseRepository.findAll(mpsQuery);
        return mpsPage;
    }
    //增加
    public void add(Lease lease){leaseRepository.save(lease);}
    //删除
    public void delete(int id){leaseRepository.deleteById(id);}
    //修改
    public void update(Lease lease){leaseRepository.save(lease);}
    //查找全部
    public List<Lease> findAll(){return leaseRepository.findAll();}
    //按id查找
    public Lease find(int id){return leaseRepository.findById(id).get();}
    //根据机器人id寻找
    public List<Lease> findByRobot(int id){return leaseRepository.findAllByRobot_Id(id);}
    //根据租用企业寻找
    public List<Lease> findByCompany(int id){
        return leaseRepository.findAllByCompanyId_Id(id);
    }

    public void setRemind(Map<String,Object> json){
        String id = null == json.get("robotid")? null: json.get("robotid").toString();
        leaseRepository.setRemind(id);
    }
    @Transactional
    public void cancleRemind(String id){
        leaseRepository.cancleRemind(id);
        remindRepository.deleteByRobotid(id);
    }

    @Transactional
    public void start(Lease lease){
        Robot robot = lease.getRobot();
        robot.setUse_situation("启用");
        robotRepository.save(robot);
        lease.setStartTime(new Date());
        leaseRepository.save(lease);
    }

    @Transactional
    public void stop(Lease lease){
        Robot robot = lease.getRobot();
        robot.setUse_situation("未启用");
        robotRepository.save(robot);
        lease.setStartTime(new Date());
        leaseRepository.save(lease);
    }
}
