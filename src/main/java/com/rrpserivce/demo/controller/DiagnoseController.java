package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.Diagnose;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.DiagnoseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "诊断")
public class DiagnoseController {
    @Autowired
    private DiagnoseService diagnoseService;

    @GetMapping(value = "/diagnose/getDiagnose")
    @ApiOperation("获取全部诊断列表")

    public CommonResult getDiagnose() {
        CommonResult result = new CommonResult();
        try {
            result.setData(diagnoseService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/diagnose/getDiagnoseById")
    @ApiOperation("根据id查找诊断")
    public CommonResult getDiagnoseById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(diagnoseService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/diagnose/updateDiagnose")
    @ApiOperation("修改诊断")
    public CommonResult updateDiagnose(@RequestBody Diagnose diagnose) {
        CommonResult result = new CommonResult();
        try {
            diagnoseService.update(diagnose);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/diagnose/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            diagnoseService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/diagnose/addDiagnose")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody Diagnose diagnose) {
        CommonResult result = new CommonResult();
        try {
            diagnoseService.add(diagnose);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
