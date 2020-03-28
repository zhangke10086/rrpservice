package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.Bench;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BenchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "模台参数")
public class BenchController {
    @Autowired
    private BenchService benchService;

    @GetMapping(value = "/bench/getBench")
    @ApiOperation("获取全部模台参数列表")

    public CommonResult getBench() {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/bench/getBenchById")
    @ApiOperation("根据id查找模台参数")
    public CommonResult getBenchById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/bench/updateBench")
    @ApiOperation("修改模台参数")
    public CommonResult updateBench(@RequestBody Bench bench) {
        CommonResult result = new CommonResult();
        try {
            benchService.update(bench);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/bench/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            benchService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/bench/addBench")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody Bench bench) {
        CommonResult result = new CommonResult();
        try {
            benchService.add(bench);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
