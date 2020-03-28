package com.example.demo.controller;
import com.common.resformat.CommonResult;
import com.example.demo.entity.Robot;
import com.example.demo.service.RobotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@Api(value = "机器人")
public class RobotController {
    @Autowired
    private RobotService robotService;
    @PostMapping(value = "/robot/addRobot")
    @ApiOperation(value = "增加机器人")
    public CommonResult add(@RequestBody Robot robot){
        CommonResult result = new CommonResult();
        try {
            robotService.add(robot);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }


    @DeleteMapping(value = "/robot/deleteRobot")
    @ApiOperation(value = "删除机器人")
    public CommonResult deleteById(@RequestParam(value = "id") String id){
        CommonResult result = new CommonResult();
        try {
            robotService.delete(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }


    @PutMapping(value = "/robot/updateRobot")
    @ApiOperation("修改机器人")
    public CommonResult updateDepartment(@RequestBody Robot robot){
        CommonResult result = new CommonResult();
        try {
            robotService.update(robot);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @GetMapping(value = "/robot/findAllRobot")
    @ApiOperation(value = "查找所有机器人")
    public CommonResult findAll(){
        CommonResult result = new CommonResult();
        try {
            result.setData(robotService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/robot/findById")
    @ApiOperation(value = "查找一个机器人")
    public CommonResult findById(@RequestParam(value = "id")String id){
        CommonResult result = new CommonResult();
        try {
            result.setData(robotService.find(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/robot/findAllByCompany")
    @ApiOperation(value = "按企业id查找机器人")
    public CommonResult findAllByCompany(@RequestParam(value = "id")int id){
        CommonResult result = new CommonResult();
        try {
            result.setData(robotService.findAllByBelongingCompany(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
