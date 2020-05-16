package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.ProductRatioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin()
@Api(value = "产品合格率")
public class ProductRatioController {
    @Autowired
    private ProductRatioService productRatioService;

    @GetMapping(value = "/productRatio/getProductRatio")
    @ApiOperation("获取全部产品合格率列表")
    public CommonResult getProductRatio(@RequestParam String date_begin, String date_end,String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(productRatioService.getRatio(date_begin, date_end,robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/productRatio/getProductRatioByRobot")
    @ApiOperation("根据机器人获取全部列表")

    public CommonResult getProductRatioByRobot(String robot_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(productRatioService.findAllByRobot(robot_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/productRatio/getProductRatioById")
    @ApiOperation("根据id获取全部产品合格率列表")
    public CommonResult getProductRatioById(@RequestParam String time) {
        CommonResult result = new CommonResult();
        try {
            result.setData(productRatioService.getRatioById(time));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


}
