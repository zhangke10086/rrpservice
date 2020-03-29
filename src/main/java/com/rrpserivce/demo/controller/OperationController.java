package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.OperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@Api(value = "权限")
public class OperationController {
    @Autowired
    private OperationService operationService;

    // 未完成，数据不对
    @GetMapping(value = "/operation/getAuthority")
    @ApiOperation("获取权限列表")
    public CommonResult getUser() {
        CommonResult result = new CommonResult();
        try {
            result.setData(operationService.findAll());
            System.out.println(result.toString());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg(operationService.findAll().toString());
            return result;
        }
    }
}
