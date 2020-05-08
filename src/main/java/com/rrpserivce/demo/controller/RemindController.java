package com.rrpserivce.demo.controller;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.entity.Lease;
import com.rrpserivce.demo.entity.Robot;
import com.rrpserivce.demo.service.LeaseService;
import com.rrpserivce.demo.service.RemindService;
import com.rrpserivce.demo.service.RobotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;


@RestController
@CrossOrigin
@Api(value = "提醒")
public class RemindController {
    @Autowired
    private RemindService remindService;
    @Autowired
    private LeaseService leaseService;
    @PostMapping(value = "/remind/addRemind")
    @ApiOperation(value = "增加提醒信息")
    @Transactional
    public CommonResult add(@RequestBody Map<String,Object> json){
        CommonResult result = new CommonResult();
        try {
            remindService.add(json);
            leaseService.setRemind(json);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

    @PostMapping(value = "/remind/findByCompanyid")
    @ApiOperation(value = "根据企业id查找提醒信息")
    public CommonResult findByCompanyId(@RequestBody String companyid){
        CommonResult result = new CommonResult();
        try {
            result.setData(remindService.findByCompanyId(companyid));
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }
    @PostMapping(value = "/remind/findByRobotId")
    @ApiOperation(value = "根据机器人id查找提醒信息")
    public CommonResult findByRobotId(@RequestBody String robotid){
        CommonResult result = new CommonResult();
        try {
            result.setData(remindService.findByRobotid(robotid));
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }
}
