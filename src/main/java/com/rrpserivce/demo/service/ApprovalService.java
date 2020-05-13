package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Approval;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.Pay;
import com.rrpserivce.demo.repository.ApprovalRepository;
import com.rrpserivce.demo.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class ApprovalService {
    @Autowired
    private ApprovalRepository approvalRepository;
    @Autowired
    private PayService payService;
    @Autowired
    private LeaseService leaseService;
    //增加
    public void add(Approval approval){approvalRepository.save(approval);}
    //删除
//    public void delete(int id){approvalRepository.deleteById(id);};
    //修改
    public void update(Approval approval){approvalRepository.save(approval);}
    //动态查询
    public List<Approval> query(Map<String,Object> jsonData){

        Specification<Approval> mpsQuery = new Specification<Approval>() {
            @Override
            public Predicate toPredicate(Root<Approval> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(jsonData.get("province"))) {
                    predicates.add(criteriaBuilder.equal(root.get("lease").get("companyId").get("province"), jsonData.get("province").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("city"))) {
                    predicates.add(criteriaBuilder.equal(root.get("lease").get("companyId").get("city"), jsonData.get("city").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
                    predicates.add(criteriaBuilder.equal(root.get("robot").get("id"), jsonData.get("robotid").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
                    predicates.add(criteriaBuilder.equal(root.get("lease").get("companyId").get("id"), jsonData.get("companyid").toString()));
                }
                predicates.add(criteriaBuilder.equal(root.get("state"), '0'));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<Approval> mpsPage = approvalRepository.findAll(mpsQuery);
        return mpsPage;
    }
    //按id查找
    public Approval findById(int id){return approvalRepository.findById(id).get();}
    //状态改为1
    public void changeState(int id){
        approvalRepository.changeState(id);
    }
    public void confirm(Map<String, Object> jsonData){
        String request = jsonData.get("request").toString();
        int lease_id = Integer.parseInt(jsonData.get("leaseid").toString());
        int approval_id = Integer.parseInt(jsonData.get("id").toString());
        switch (request){
            case "续费审核":
                payService.ChangeExamineSituation(lease_id);
                leaseService.ChangePaymentSituation(lease_id);
                this.changeState(approval_id);
                break;
            case "启用":
                leaseService.ChangeState("已启用",lease_id);
                this.changeState(approval_id);
                break;
            case "停用":
                leaseService.ChangeState("已停用",lease_id);
                this.changeState(approval_id);
                break;
        }
    }
    public void reject(Map<String, Object> jsonData){
        String request = jsonData.get("request").toString();
        int lease_id = Integer.parseInt(jsonData.get("leaseid").toString());
        int approval_id = Integer.parseInt(jsonData.get("id").toString());
        this.changeState(approval_id);
    }
}
