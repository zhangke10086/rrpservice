/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.helper.CommonResult;
import com.example.demo.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin()
@Api(value = "系")
public class DepartmentController {

    @Autowired
   private DepartmentService departmentService;

    @GetMapping(value = "/department/getdepartment")
    @ApiOperation("获取全部系列表")

    public CommonResult getdepartment() {
        CommonResult result = new CommonResult();
        try {
            result.setData(departmentService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/department/getdepartmentById")
    @ApiOperation("根据id查找系")
    public CommonResult getdepartmentById(@RequestBody String id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(departmentService.findById(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/department/updateDepartment")
    @ApiOperation("修改系")
    public CommonResult updateDepartment(@RequestBody Department department){
        CommonResult result = new CommonResult();
        try {
            departmentService.update(department);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    
    @PostMapping(value = "/department/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody String id){
        CommonResult result = new CommonResult();
        try {
            departmentService.deleteById(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/department/addDepartment")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody Department department){
        CommonResult result = new CommonResult();
        try {
            departmentService.add(department);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }



}


