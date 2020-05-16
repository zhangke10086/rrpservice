package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.ConcreteCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin()
@Api(value = "混凝土方量")
public class ConcreteCountController {
    @Autowired
    private ConcreteCountService concreteCountService;

    @GetMapping(value = "/concreteCount/getConcreteCount")
    @ApiOperation("获取全部混凝土方量列表")
    public CommonResult getConcreteCount(@RequestParam String date_begin, String date_end, String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(concreteCountService.getCount(date_begin, date_end,robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/concreteCount/getConcreteCountByRobot")
    @ApiOperation("根据机器人获取全部列表")

    public CommonResult getConcreteCountByRobot(String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(concreteCountService.findAllByRobot(robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/concreteCount/getConcreteCountById")
    @ApiOperation("根据id获取全部混凝土方量列表")
    public CommonResult getConcreteCountById(@RequestParam String time) {
        CommonResult result = new CommonResult();
        try {
            result.setData(concreteCountService.getCountById(time));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
