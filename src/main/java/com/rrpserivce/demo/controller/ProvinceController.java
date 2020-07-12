package com.rrpserivce.demo.controller;


import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "省")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @GetMapping(value = "/province/getprovince")
    @ApiOperation("获取全部省")
    public CommonResult getProvince() {
        CommonResult result = new CommonResult();
        try {
            result.setData(provinceService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
