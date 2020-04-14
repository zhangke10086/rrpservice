package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;

import com.rrpserivce.demo.entity.RoleMenuOperation;
import com.rrpserivce.demo.service.AuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(value = "权限")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @GetMapping(value = "/authority/findAll")
    @ApiOperation(value = "查找所有企业")
    public CommonResult findAll(){
        CommonResult result = new CommonResult();
        try {
            result.setData(authorityService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PostMapping(value = "/authority/addAuthority")
    @ApiOperation(value = "增加")
    public CommonResult add(@RequestBody List<RoleMenuOperation> roleMenuOperations){
        CommonResult result = new CommonResult();
        try {
            authorityService.add(roleMenuOperations);
//            return JSON.toJSONString(authorities);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

    @GetMapping(value = "/authority/findById")
    @ApiOperation(value = "按id查找企业")
    public CommonResult findById(@RequestParam(value = "id")int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(authorityService.find(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
