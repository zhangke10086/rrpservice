package com.rrpserivce.demo.controller;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.entity.Pay;
import com.rrpserivce.demo.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
@Api(value = "支付")
public class PayController {
    @Autowired
    private PayService payService;

    @PostMapping(value = "/lease/QueryPay")
    @ApiOperation(value = "动态查询缴费")
    public CommonResult QueryLease(@RequestBody Map<String, Object> jsonData){
        CommonResult result = new CommonResult();
        try {
            result.setData(payService.query(jsonData));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PostMapping(value = "/pay/addPay")
    @ApiOperation(value = "增加支付")
    public CommonResult add(@RequestBody Pay pay){
        CommonResult result = new CommonResult();
        try {
            payService.add(pay);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }


    @DeleteMapping(value = "/pay/deletePay")
    @ApiOperation(value = "删除支付")
    public CommonResult deleteById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            payService.delete(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }


    @PutMapping(value = "/pay/updatePay")
    @ApiOperation("修改缴费")
    public CommonResult updateDepartment(@RequestBody Pay pay){
        CommonResult result = new CommonResult();
        try {
            payService.update(pay);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @GetMapping(value = "/pay/findAllPay")
    @ApiOperation(value = "查找所有缴费")
    public CommonResult findAll(){
        CommonResult result = new CommonResult();
        try {
            result.setData(payService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/pay/findById")
    @ApiOperation(value = "查找一个缴费")
    public CommonResult findById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(payService.findById(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
