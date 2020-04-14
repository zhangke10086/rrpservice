package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.DynamicMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api(value = "动态菜单")
public class DynamicMenuController {
    @Autowired
    private DynamicMenuService dynamicMenuService;
    @GetMapping(value = "/dynamicMenuService/getDynamicMenu")
    @ApiOperation("根据用户id查找动态菜单")
    public CommonResult getDynamicMenu(@RequestParam(value = "id")int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(dynamicMenuService.getDynamicMenu(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/dynamicMenuService/getAllDynamicMenus")
    @ApiOperation("获取全部菜单列表")
    public CommonResult getAllDynamicMenus() {
        CommonResult result = new CommonResult();
        try {
            result.setData(dynamicMenuService.getAllMenus());
            System.out.println(result.toString());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/dynamicMenuService/getDynamicMenuByUsername")
    @ApiOperation("根据用户名查找动态菜单")
    public CommonResult getDynamicMenuByUsername(@RequestParam(value = "username") String username) {
        CommonResult result = new CommonResult();
        try {
            result.setData(dynamicMenuService.getDynamicMenuByUsername(username));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/dynamicMenuService/getAllNotNullMenus")
    @ApiOperation("获取全部菜单列表")
    public CommonResult getAllNotNullMenus() {
        CommonResult result = new CommonResult();
        try {
            result.setData(dynamicMenuService.getAllNotNullMenus());
            System.out.println(result.toString());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
