package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Approval;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.Pay;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.repository.LeaseRepository;
import com.rrpserivce.demo.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;
    @Autowired
    private RobotRepository robotRepository;
    @Autowired
    private PayService payService;
    @Autowired
    private ApprovalService approvalService;

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

    public void setRemind(int id){
        leaseRepository.setRemind(id);
    }
    public void cancleRemind(int id){
        leaseRepository.cancleRemind(id);
    }
    public Map<String,Object> findRemind(int companyid) throws ParseException {
        List<Lease> leases = leaseRepository.findRemind(companyid);
        Map map =new HashMap();
        if (leases.size()>0){
            for (Lease lease: leases){
                //0缴费 1欠费
                if (lease.getPaymentSituation()=='1'){
                    map.put("msg",lease.getRobot().getName()+"已欠费，请及时缴费！");
                } else {
                    Pay pay = payService.findByLeaseId(lease.getId());
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
                    String date2 = pay.getPaymentDeadline();
                    long daysBetween = (sdf.parse(date2).getTime()-new Date().getTime())/(60*60*24*1000);
                    map.put("msg",lease.getRobot().getName()+"还有"+daysBetween+"天到期，请及时缴费！");
                }
            }
            return map;
        } else {
            return null;
        }
    }
    public void start(Lease lease){
        Robot robot = lease.getRobot();
        robot.setUse_situation("启用");
        robotRepository.save(robot);
        lease.setStartTime(new Date());
        leaseRepository.save(lease);
    }

    public void stop(Lease lease){
        Robot robot = lease.getRobot();
        robot.setUse_situation("未启用");
        robotRepository.save(robot);
        lease.setStartTime(new Date());
        leaseRepository.save(lease);
    }
    public void pay(Pay pay) throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        pay.setPaymentDeadline(sdf.format(sdf.parse(pay.getPaymentDeadline())));
        Approval approval =new Approval();
        approval.setLease(pay.getLease());
        approval.setRobot(pay.getRobot());
        approval.setState('0');
        approval.setRequest("续费审核");
        payService.add(pay);
        approvalService.add(approval);
    }
}
