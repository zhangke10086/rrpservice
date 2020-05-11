package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BenchCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin()
@Api(value = "模台个数")
public class BenchCountController {
    @Autowired
    private BenchCountService benchCountService;

    @GetMapping(value = "/benchCount/getBenchCount")
    @ApiOperation("获取全部模台个数列表")
    public CommonResult getBenchCount(@RequestParam String date_begin, String date_end) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchCountService.getCount(date_begin, date_end));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/benchCount/getBenchCountById")
    @ApiOperation("根据id获取全部模台个数列表")
    public CommonResult getBenchCountById(@RequestParam String time) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchCountService.getCountById(time));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
