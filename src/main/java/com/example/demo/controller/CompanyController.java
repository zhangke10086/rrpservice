package com.example.demo.controller;
import com.common.resformat.CommonResult;
import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@Api(value = "企业")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping(value = "/company/addCompany")
    @ApiOperation(value = "增加企业")
    public CommonResult add(@RequestBody Company company){
        CommonResult result = new CommonResult();
        try {
            companyService.add(company);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }


    @DeleteMapping(value = "/company/deleteCompany")
    @ApiOperation(value = "删除企业")
    public CommonResult deleteById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            companyService.deleteById(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }


    @PutMapping(value = "/company/updateCompany")
    @ApiOperation("修改企业")
    public CommonResult updateDepartment(@RequestBody Company company){
        CommonResult result = new CommonResult();
        try {
            companyService.update(company);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @GetMapping(value = "/company/findAllCompany")
    @ApiOperation(value = "查找所有企业")
    public CommonResult findAll(){
        CommonResult result = new CommonResult();
        try {
            result.setData(companyService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/company/findById")
    @ApiOperation(value = "按id查找企业")
    public CommonResult findById(@RequestParam(value = "id")int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(companyService.find(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/company/findByKey")
    @ApiOperation(value = "按关键字(模糊)查询")
    public CommonResult findById(@RequestParam(value = "key")String key){
        CommonResult result = new CommonResult();
        try {
            result.setData(companyService.findAllByNameLike(key));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

}
