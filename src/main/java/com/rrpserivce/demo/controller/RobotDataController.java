package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.RobotData;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.RobotDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "模台参数")
public class RobotDataController {
    @Autowired
    private RobotDataService robotDataService;

    @GetMapping(value = "/robotData/getRobotData")
    @ApiOperation("获取全部模台参数列表")

    public CommonResult getRobotData() {
        CommonResult result = new CommonResult();
        try {
            result.setData(robotDataService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/robotData/getRobotDataByRobot")
    @ApiOperation("根据机器人获取全部列表")

    public CommonResult getRobotDataByRobot(String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(robotDataService.findAllByRobot(robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/robotData/getRobotDataById")
    @ApiOperation("根据id查找模台参数")
    public CommonResult getRobotDataById(int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(robotDataService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/robotData/updateRobotData")
    @ApiOperation("修改模台参数")
    public CommonResult updateRobotData(@RequestBody RobotData robotData) {
        CommonResult result = new CommonResult();
        try {
            robotDataService.update(robotData);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/robotData/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            robotDataService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/robotData/addRobotData")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody RobotData robotData) {
        CommonResult result = new CommonResult();
        try {
            robotDataService.add(robotData);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
