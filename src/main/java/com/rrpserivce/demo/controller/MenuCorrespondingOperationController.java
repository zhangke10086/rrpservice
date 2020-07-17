package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.MenuCorrespondingOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@Api(value = "菜单(应该/可以)有的操作")
public class MenuCorrespondingOperationController {
    @Autowired
    private MenuCorrespondingOperationService menuCorrespondingOperationService;

    @GetMapping(value = "/menuCorrespondingOperation/getMenuCorrespondingOperation")
    @ApiOperation("获取")
    public CommonResult getMenuCorrespondingOperation() {
        CommonResult result = new CommonResult();
        try {
            result.setData(menuCorrespondingOperationService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
