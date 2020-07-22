package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.ConcreteCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin()
@Api(value = "混凝土方量")
public class ConcreteCountController {
    @Autowired
    private ConcreteCountService concreteCountService;

    @PostMapping(value = "/concreteCount/query")
    @ApiOperation(value = "动态查询用户")
    public CommonResult query(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            result.setData(concreteCountService.query(jsonData));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
    @GetMapping(value = "/concreteCount/findNewestByRobot")
    @ApiOperation(value = "根据机器人查找最新的混凝土方量")
    public CommonResult findNewestByRobot(@RequestParam(value = "id")String id){
        CommonResult result = new CommonResult();
        try {
            result.setData(concreteCountService.findNewestByRobot(id));
            return result;
        } catch (Exception e){
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
