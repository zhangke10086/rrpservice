package com.rrpserivce.demo.controller;


import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.CityService;
import com.rrpserivce.demo.service.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@Api(value = "市")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping(value = "/city/getcity")
    @ApiOperation("获取全部市")
    public CommonResult getProvince() {
        CommonResult result = new CommonResult();
        try {
            result.setData(cityService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
