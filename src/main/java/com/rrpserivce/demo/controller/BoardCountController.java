package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BoardCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin()
@Api(value = "叠合板数量")
public class BoardCountController {
    @Autowired
    private BoardCountService boardCountService;

    @GetMapping(value = "/boardCount/getBoardCount")
    @ApiOperation("获取全部叠合板数量列表")
    public CommonResult getBoardCount(@RequestParam String date_begin, String date_end) {
        CommonResult result = new CommonResult();
        try {
            result.setData(boardCountService.getCount(date_begin, date_end));
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
