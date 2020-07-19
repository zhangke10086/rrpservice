package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BoardAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin()
@Api(value = "叠合板面积")
public class BoardAreaController {
    @Autowired
    private BoardAreaService boardAreaService;

    @GetMapping(value = "/boardArea/findNewestByRobot")
    @ApiOperation(value = "根据机器人查找最新的叠合板面积")
    public CommonResult findNewestByRobot(@RequestParam(value = "id")String id){
        CommonResult result = new CommonResult();
        try {
            result.setData(boardAreaService.findNewestByRobot(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/boardArea/getBoardArea")
    @ApiOperation("获取全部叠合板面积列表")
    public CommonResult getBoardArea(@RequestParam String date_begin, String date_end,String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(boardAreaService.getArea(date_begin, date_end,robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/boardArea/getBoardAreaByRobot")
    @ApiOperation("根据机器人获取全部列表")

    public CommonResult getBoardAreaByRobot(String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(boardAreaService.findAllByRobot(robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/boardArea/getBoardAreaById")
    @ApiOperation("根据id获取全部叠合板面积列表")
    public CommonResult getBoardAreaById(@RequestParam String time) {
        CommonResult result = new CommonResult();
        try {
            result.setData(boardAreaService.getAreaById(time));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
