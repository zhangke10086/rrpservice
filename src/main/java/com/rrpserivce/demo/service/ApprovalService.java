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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApprovalService {
    @Autowired
    private ApprovalRepository approvalRepository;
    //增加
    public void add(Approval approval){approvalRepository.save(approval);}
    //删除
//    public void delete(int id){approvalRepository.deleteById(id);};
    //修改
    public void update(Approval approval){approvalRepository.save(approval);}
    //查找全部
    public List<Approval> query(Map<String,Object> jsonData){

        Specification<Approval> mpsQuery = new Specification<Approval>() {
            @Override
            public Predicate toPredicate(Root<Approval> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(jsonData.get("robotid"))) {
                    predicates.add(criteriaBuilder.equal(root.get("robot").get("id"), jsonData.get("robotid").toString()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<Approval> mpsPage = approvalRepository.findAll(mpsQuery);
        return mpsPage;
    }
    //按id查找
    public Approval findById(int id){return approvalRepository.findById(id).get();}


}
