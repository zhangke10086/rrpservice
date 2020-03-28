package com.rrpserivce.demo.controller;

import com.rrpserivce.demo.entity.Command;
import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.CommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "指令")
public class CommandController {
    @Autowired
    private CommandService commandService;

    @GetMapping(value = "/command/getCommand")
    @ApiOperation("获取全部指令列表")

    public CommonResult getCommand() {
        CommonResult result = new CommonResult();
        try {
            result.setData(commandService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/command/getCommandById")
    @ApiOperation("根据id查找指令")
    public CommonResult getCommandById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(commandService.findById(id));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/command/updateCommand")
    @ApiOperation("修改指令")
    public CommonResult updateCommand(@RequestBody Command command) {
        CommonResult result = new CommonResult();
        try {
            commandService.update(command);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @PostMapping(value = "/command/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody int id) {
        CommonResult result = new CommonResult();
        try {
            commandService.deleteById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/command/addCommand")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody Command command) {
        CommonResult result = new CommonResult();
        try {
            commandService.add(command);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
