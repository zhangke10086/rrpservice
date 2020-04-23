package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;

import com.rrpserivce.demo.entity.CompletedAuthority;
import com.rrpserivce.demo.service.AuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 最后清理死代码
@RestController
@CrossOrigin
@Api(value = "权限")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @GetMapping(value = "/authority/findAll")
    @ApiOperation(value = "查找")
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
    public CommonResult add(@RequestBody CompletedAuthority completedAuthority){
        CommonResult result = new CommonResult();
        try {
            authorityService.add(completedAuthority);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

    @PutMapping(value = "/authority/updateAuthority")
    @ApiOperation("修改企业")
    public CommonResult updateDepartment(@RequestBody CompletedAuthority completedAuthority){
        CommonResult result = new CommonResult();
        try {
            authorityService.update(completedAuthority);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @GetMapping(value = "/authority/findByRoleId")
    @ApiOperation(value = "按role_id查找")
    public CommonResult findById(@RequestParam(value = "role_id")int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(authorityService.findByRoleId(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
