package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Approval;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.Pay;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.repository.ApprovalRepository;
import com.rrpserivce.demo.repository.LeaseRepository;
import com.rrpserivce.demo.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
    private ApprovalRepository approvalRepository;
    @Autowired
    private PayService payService;
    @Autowired
    private ApprovalService approvalService;

    public List<Lease> query(Map<String, Object> jsonData) {

        Specification<Lease> mpsQuery = new Specification<Lease>() {
            @Override
            public Predicate toPredicate(Root<Lease> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(jsonData.get("province"))) {
                    predicates.add(criteriaBuilder.equal(root.get("companyId").get("province"), jsonData.get("province").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("city"))) {
                    predicates.add(criteriaBuilder.equal(root.get("companyId").get("city"), jsonData.get("city").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
                    predicates.add(criteriaBuilder.equal(root.get("robot").get("id"), jsonData.get("robotid").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("companytypeid"))) {
                    //出租和制造企业
                    if (Integer.parseInt(jsonData.get("companytypeid").toString()) == 1 ||Integer.parseInt(jsonData.get("companytypeid").toString()) == 2){
                        //非骊久只能看自己所拥有的机器人
                        if(!jsonData.get("owncompanyid").toString().equals("1")){
                            predicates.add(criteriaBuilder.equal(root.get("robot").get("belongingCompany").get("id"), jsonData.get("owncompanyid").toString()));
                        }
                        if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
                            predicates.add(criteriaBuilder.equal(root.get("companyId").get("id"),jsonData.get("companyid").toString()));
                        }
                    }
                    //租用企业 只能看自己数据
                    if (Integer.parseInt(jsonData.get("companytypeid").toString()) == 4){
                        if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
                            predicates.add(criteriaBuilder.equal(root.get("companyId").get("id"),jsonData.get("owncompanyid").toString()));
                        }
                    }
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

    //登陆时查询是否被提醒
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
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
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
    public Map start(Lease lease){
        Map map =new HashMap();
        List<Approval> approvals = approvalRepository.isApproval(lease.getId());
        if (approvals.size()!=0){
            String request = approvals.get(0).getRequest();
            String id = approvals.get(0).getRobot().getId();
            map.put("msg",id+"正在"+request+" 请求中，请耐心等待客服经理审批！");
            return map;
        } else {
            Approval approval =new Approval();
            approval.setRobot(lease.getRobot());
            approval.setLease(lease);
            approval.setState('0');
            approval.setRequest("启用");
            approvalService.add(approval);
            map.put("msg","已发起启用审核，等待客服经理审批！");
            return map;
        }
    }

    public Map stop(Lease lease){
        Map map =new HashMap();
        List<Approval> approvals = approvalRepository.isApproval(lease.getId());
        if (approvals.size()!=0){
            String request = approvals.get(0).getRequest();
            String id = approvals.get(0).getRobot().getId();
            map.put("msg",id+"正在"+request+" 请求中，请耐心等待客服经理审批！");
            return map;
        } else {
            Approval approval =new Approval();
            approval.setRobot(lease.getRobot());
            approval.setLease(lease);
            approval.setState('0');
            approval.setRequest("停用");
            approvalService.add(approval);
            map.put("msg","已发起停用审核，等待客服经理审批！");
            return map;
        }
    }
    //续费
    public void pay(Pay pay) throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        pay.setPaymentDeadline(sdf.format(sdf.parse(pay.getPaymentDeadline())));
        Approval approval =new Approval();
        approval.setLease(pay.getLease());
        approval.setRobot(pay.getRobot());
        approval.setState('0');
        approval.setRequest("续费审核");
        leaseRepository.changePaymentSituation('2',pay.getLease().getId());
        payService.add(pay);
        approvalService.add(approval);
    }
    //缴费审核通过
    public void ChangePaymentSituation(int id){
        leaseRepository.changePaymentSituation('0',id);
    }
    //启用,停用 审核通过
    public void ChangeState(String state,int id){
        leaseRepository.changeState(state,id);
    }

    //上传合同 并返回url
    public String upload(MultipartFile file) throws IOException {
        //获取文件字节数组
        byte [] bytes = file.getBytes();
        String fileName =file.getOriginalFilename();
        //文件存储路径(/fileupload/ 这样会在根目录下创建问价夹)
        File pfile = new File("/fileupload/");
        if(!pfile.exists()){
            //不存在时,创建文件夹
            pfile.mkdirs();
        }
        //创建文件
        File file1 = new File(pfile, fileName);
        //写入指定文件夹
        OutputStream out = new FileOutputStream(file1);
        out.write(bytes);
        return file1.getAbsolutePath();
    }
}
