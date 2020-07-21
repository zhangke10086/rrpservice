package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BoardCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin()
@Api(value = "叠合板数量")
public class BoardCountController {
    @Autowired
    private BoardCountService boardCountService;
    @PostMapping(value = "/boardCount/query")
    @ApiOperation(value = "动态查询用户")
    public CommonResult query(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            result.setData(boardCountService.query(jsonData));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/boardCount/getBoardCountByRobot")
    @ApiOperation("根据机器人获取全部列表")

    public CommonResult getBoardCountByRobot(String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(boardCountService.findAllByRobot(robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/boardCount/getBoardCountById")
    @ApiOperation("根据id获取全部叠合板数量列表")
    public CommonResult getBoardCountById(@RequestParam String time) {
        CommonResult result = new CommonResult();
        try {
            result.setData(boardCountService.getCountById(time));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
