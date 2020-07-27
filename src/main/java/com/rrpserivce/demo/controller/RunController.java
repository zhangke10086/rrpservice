package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.RunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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

    @GetMapping(value = "/run/getRunByCompany")
    @ApiOperation("获取全部运行数据列表")
    public CommonResult getRatioByCompany(@RequestParam int company_id, String date_begin, String date_end) {
        CommonResult result = new CommonResult();
        try {
            result.setData(runService.getRatioByCompany(company_id, date_begin, date_end));
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

    @GetMapping(value = "/run/getRatioLate")
    @ApiOperation("根据获取全部最新运行数据列表")
    public CommonResult getRatioLate(@RequestParam int company_id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(runService.getRatioLate(company_id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PostMapping(value = "/run/QueryRun")
    @ApiOperation(value = "动态查询模台")
    public CommonResult QueryLease(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            result.setData(runService.query(jsonData));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

}
