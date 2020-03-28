package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.ProcessData;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.ProcessDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "生产参数")
public class ProcessDataController {
    @Autowired
    private ProcessDataService processDataService;

    @GetMapping(value = "/processData/getProcessData")
    @ApiOperation("获取全部生产参数列表")

    public CommonResult getProcessData() {
        CommonResult result = new CommonResult();
        try {
            result.setData(processDataService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/processData/getProcessDataById")
    @ApiOperation("根据id查找生产参数")
    public CommonResult getProcessDataById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(processDataService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/processData/updateProcessData")
    @ApiOperation("修改生产参数")
    public CommonResult updateProcessData(@RequestBody ProcessData processData) {
        CommonResult result = new CommonResult();
        try {
            processDataService.update(processData);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/processData/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            processDataService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/processData/addProcessData")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody ProcessData processData) {
        CommonResult result = new CommonResult();
        try {
            processDataService.add(processData);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
