package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.BenchData;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BenchDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin()
@Api(value = "模台参数")
public class BenchDataController {
    @Autowired
    private BenchDataService benchDataService;

    @PostMapping(value = "/benchData/QueryBenchData")
    @ApiOperation(value = "动态查询模台参数")
    public CommonResult QueryLease(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            result.setData(benchDataService.query(jsonData));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/benchData/getBenchData")
    @ApiOperation("获取全部模台参数列表")
    public CommonResult getBenchData() {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchDataService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/benchData/getBenchDataById")
    @ApiOperation("根据id查找模台参数")
    public CommonResult getBenchDataById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchDataService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/benchData/updateBenchData")
    @ApiOperation("修改模台参数")
    public CommonResult updateBenchData(@RequestBody BenchData benchData) {
        CommonResult result = new CommonResult();
        try {
            benchDataService.update(benchData);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/benchData/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            benchDataService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/benchData/addBenchData")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody BenchData benchData) {
        CommonResult result = new CommonResult();
        try {
            benchDataService.add(benchData);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
