package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.BenchManage;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.BenchManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "模台")
public class BenchManageController {
    @Autowired
    private BenchManageService benchManageService;

    @GetMapping(value = "/benchManage/getBenchManage")
    @ApiOperation("获取全部模台列表")

    public CommonResult getBenchManage() {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchManageService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/benchManage/getBenchManageById")
    @ApiOperation("根据id查找模台")
    public CommonResult getBenchManageById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(benchManageService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/benchManage/updateBenchManage")
    @ApiOperation("修改模台")
    public CommonResult updateBenchManage(@RequestBody BenchManage benchManage) {
        CommonResult result = new CommonResult();
        try {
            benchManageService.update(benchManage);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/benchManage/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            benchManageService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/benchManage/addBenchManage")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody BenchManage benchManage) {
        CommonResult result = new CommonResult();
        try {
            benchManageService.add(benchManage);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
