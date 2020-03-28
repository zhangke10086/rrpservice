package com.example.demo.controller;

import com.common.resformat.CommonResult;
import com.example.demo.entity.CompanyType;
import com.example.demo.service.CompanyTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@RestController
@CrossOrigin
@Api(value = "公司种类")
public class CompanyTypeController extends HttpServlet {
    @Autowired
    private CompanyTypeService companyTypeService;
    @PostMapping(value = "/companyType/addCompanyType")
    @ApiOperation(value = "增加公司种类")
    public CommonResult add(@RequestBody CompanyType companyType){
        CommonResult result = new CommonResult();
        try {
            companyTypeService.add(companyType);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }


    @DeleteMapping(value = "/companyType/deleteCompanyType")
    @ApiOperation(value = "删除公司种类")
    public CommonResult deleteById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            companyTypeService.deleteById(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }


    @PutMapping(value = "/companyType/updateCompanyType")
    @ApiOperation("修改公司种类")
    public CommonResult updateDepartment(@RequestBody CompanyType companyType){
        CommonResult result = new CommonResult();
        try {
            companyTypeService.update(companyType);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @GetMapping(value = "/companyType/findAllCompanyType")
    @ApiOperation(value = "查找所有企业类型")
    public CommonResult findAll(){
        CommonResult result = new CommonResult();
        try {
            result.setData(companyTypeService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/companyType/findById")
    @ApiOperation(value = "根据id查找企业类型")
    public CommonResult findById(@RequestBody String id){
        CommonResult result = new CommonResult();
        try {
            System.out.println(id);
            String[] ag = id.split(":");
            result.setData(companyTypeService.findById(Integer.parseInt(ag[1])));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
