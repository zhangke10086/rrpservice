package com.rrpserivce.demo.controller;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.entity.Approval;
import com.rrpserivce.demo.entity.Pay;
import com.rrpserivce.demo.service.ApprovalService;
import com.rrpserivce.demo.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
@Api(value = "审批")
public class ApprovalController {
    @Autowired
    private ApprovalService approvalService;



    @PostMapping(value = "/approval/QueryApproval")
    @ApiOperation(value = "动态查询审批信息")
    public CommonResult Query(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            result.setData(approvalService.query(jsonData));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PostMapping(value = "/approval/confirm")
    @ApiOperation(value = "审核确认")
    public CommonResult Confirm(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            approvalService.confirm(jsonData);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
    @PostMapping(value = "/approval/reject")
    @ApiOperation(value = "审核驳回")
    public CommonResult Reject(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            approvalService.reject(jsonData);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/approval/findById")
    @ApiOperation(value = "根据id查找")
    public CommonResult findById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(approvalService.findById(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
