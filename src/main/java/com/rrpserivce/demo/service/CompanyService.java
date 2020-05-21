package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Company;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.entity.User;
import com.rrpserivce.demo.repository.CompanyRepository;
import com.rrpserivce.demo.repository.RobotRepository;
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
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    private RobotRepository robotRepository;
    //增加
    public void add(Company company){companyRepository.save(company);}
    //根据id删除
    public void deleteById(int id){companyRepository.deleteById(id);}
    //修改
    public void update(Company company){companyRepository.save(company);}
    //查找全部
    public List<Company> findAll(){return companyRepository.findAll();}
    //按id查找
    public Company find(int id){return companyRepository.findById(id).get();}
    //按关键字查询
    public List<Company> findAllByNameLike(String key){
        String[] ag = key.split("");
        String sql = "";
        for (String para:ag) {
            sql = sql + para + "%";
        }
        return companyRepository.findAllByNameLike("%" + sql);
    }

    public List<Company> findAllBy2Keys(String key1,String key2){
        return companyRepository.findAllBy2Keys(key1,key2);
    }


    public List<Company> findByRobot(int id){
        return companyRepository.findByRobot(id);
    }


    //动态查询
    public List<Company> query(Map<String, Object> jsonData) {

        Specification<Company> mpsQuery = new Specification<Company>() {
            @Override
            public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (!StringUtils.isEmpty(jsonData.get("province"))) {
                    //equal为相等  root.get("") 即为 bench.get()                          jsonData.get()即为前端传参 jsondata
                    predicates.add(criteriaBuilder.equal(root.get("province"), jsonData.get("province").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("city"))) {
                    predicates.add(criteriaBuilder.equal(root.get("city"), jsonData.get("city").toString()));
                }
                if (!StringUtils.isEmpty(jsonData.get("companytypeid"))) {
                    //出租和制造企业
                    if (Integer.parseInt(jsonData.get("companytypeid").toString()) == 1 ||Integer.parseInt(jsonData.get("companytypeid").toString()) == 2){
                        //非骊久只能看自己所拥有的机器人
//                        if(!jsonData.get("owncompanyid").toString().equals("1")){
//                            predicates.add(criteriaBuilder.equal(root.get("robot").get("belongingCompany").get("id"), jsonData.get("owncompanyid").toString()));
//                        }
                        if (!StringUtils.isEmpty(jsonData.get("companyid"))) {
                            predicates.add(criteriaBuilder.equal(root.get("id"),jsonData.get("companyid").toString()));
                        }
                    }
                    //租用企业 只能看自己数据
                    if (Integer.parseInt(jsonData.get("companytypeid").toString()) == 4){
                        if (!StringUtils.isEmpty(jsonData.get("owncompanyid"))) {
                            predicates.add(criteriaBuilder.equal(root.get("id"),jsonData.get("owncompanyid").toString()));
                        }
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        List<Company> mpsPage = companyRepository.findAll(mpsQuery);
        return mpsPage;
    }
}
