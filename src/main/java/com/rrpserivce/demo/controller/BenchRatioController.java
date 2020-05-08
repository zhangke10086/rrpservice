package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BenchRatioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin()
@Api(value = "模台利用率")
public class BenchRatioController {
    @Autowired
    private BenchRatioService benchRatioService;

    @GetMapping(value = "/benchRatio/getBenchRatio")
    @ApiOperation("获取全部模台利用率列表")
    public CommonResult getBenchRatio(@RequestParam String date_begin, String date_end) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchRatioService.getRatio(date_begin, date_end));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/benchRatio/getBenchRatioById")
    @ApiOperation("根据id获取全部模台利用率列表")
    public CommonResult getBenchRatioById(@RequestParam String time) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchRatioService.getRatioById(time));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
