package com.example.demo.controller;
import com.common.resformat.CommonResult;
import com.example.demo.entity.Lease;
import com.example.demo.service.LeaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@Api(value = "租赁")
public class LeaseController {
    @Autowired
    private LeaseService leaseService;
    @PostMapping(value = "/lease/addLease")
    @ApiOperation(value = "增加租赁")
    public CommonResult add(@RequestBody Lease lease){
        CommonResult result = new CommonResult();
        try {
            leaseService.add(lease);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }


    @DeleteMapping(value = "/lease/deleteLease")
    @ApiOperation(value = "删除租赁")
    public CommonResult deleteById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            leaseService.delete(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }


    @PutMapping(value = "/lease/updateLease")
    @ApiOperation("修改租赁")
    public CommonResult updateDepartment(@RequestBody Lease lease){
        CommonResult result = new CommonResult();
        try {
            leaseService.update(lease);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @GetMapping(value = "/lease/findAllLease")
    @ApiOperation(value = "查找所有租赁")
    public CommonResult findAll(){
        CommonResult result = new CommonResult();
        try {
            result.setData(leaseService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/lease/findAllByRobot")
    @ApiOperation(value = "根据机器人查找所有租赁")
    public CommonResult findAllByRobot(@RequestParam(value = "id")int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(leaseService.findByRobot(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/lease/findAllByCompany")
    @ApiOperation(value = "根据企业查找所有租赁")
    public CommonResult findAllByCompany(@RequestParam(value = "id")int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(leaseService.findByCompany(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/lease/findById")
    @ApiOperation(value = "查找一个租赁")
    public CommonResult findById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(leaseService.find(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
