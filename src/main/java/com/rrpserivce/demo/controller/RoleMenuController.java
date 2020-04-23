package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.RoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@Api(value = "身份菜单")
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenuService;

    // 已经改了
    @GetMapping(value = "/roleMenu/getRoleMenus")
    @ApiOperation("获取全部role-menu列表")
    public CommonResult getUser() {
        CommonResult result = new CommonResult();
        try {
            result.setData(roleMenuService.findAll());
            System.out.println(result.toString());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg(roleMenuService.findAll().toString());
            return result;
        }
    }
}
