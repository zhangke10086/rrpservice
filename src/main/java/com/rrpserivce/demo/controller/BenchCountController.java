package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BenchCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin()
@Api(value = "模台个数")
public class BenchCountController {
    @Autowired
    private BenchCountService benchCountService;



    @GetMapping(value = "/benchCount/getBenchCountByRobot")
    @ApiOperation("根据机器人获取全部列表")

    public CommonResult getBenchCountByRobot(String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchCountService.findAllByRobot(robot_id));
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


    @PostMapping(value = "/benchCount/query")
    @ApiOperation(value = "动态查询用户")
    public CommonResult QueryLease(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            result.setData(benchCountService.query(jsonData));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

}
