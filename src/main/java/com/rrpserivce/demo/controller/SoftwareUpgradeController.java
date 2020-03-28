package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.SoftwareUpgrade;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.SoftwareUpgradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "软件")
public class SoftwareUpgradeController {
    @Autowired
    private SoftwareUpgradeService softwareUpgradeService;

    @GetMapping(value = "/softwareUpgrade/getSoftwareUpgrade")
    @ApiOperation("获取全部软件列表")

    public CommonResult getSoftwareUpgrade() {
        CommonResult result = new CommonResult();
        try {
            result.setData(softwareUpgradeService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/softwareUpgrade/getSoftwareUpgradeById")
    @ApiOperation("根据id查找软件")
    public CommonResult getSoftwareUpgradeById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(softwareUpgradeService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/softwareUpgrade/updateSoftwareUpgrade")
    @ApiOperation("修改软件")
    public CommonResult updateSoftwareUpgrade(@RequestBody SoftwareUpgrade softwareUpgrade) {
        CommonResult result = new CommonResult();
        try {
            softwareUpgradeService.update(softwareUpgrade);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/softwareUpgrade/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            softwareUpgradeService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/softwareUpgrade/addSoftwareUpgrade")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody SoftwareUpgrade softwareUpgrade) {
        CommonResult result = new CommonResult();
        try {
            softwareUpgradeService.add(softwareUpgrade);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
