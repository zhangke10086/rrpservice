package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.RunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin()
@Api(value = "运行数据")
public class RunController {
    @Autowired
    private RunService runService;

    @GetMapping(value = "/run/getRun")
    @ApiOperation("获取全部运行数据列表")
    public CommonResult getRun(@RequestParam String date_begin, String date_end) {
        CommonResult result = new CommonResult();
        try {
            result.setData(runService.getRatio(date_begin, date_end));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/run/getRunById")
    @ApiOperation("根据id获取全部运行数据列表")
    public CommonResult getRunById(@RequestParam String time) {
        CommonResult result = new CommonResult();
        try {
            result.setData(runService.getRatioById(time));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
