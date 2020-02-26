/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo.controller;

import com.common.resformat.CommonResult;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin()
@Api(value = "教师")
public class TeacherController {

    @Autowired
   private TeacherService teacherService;

    @GetMapping(value = "/teacher/getTeacher")
    @ApiOperation("获取全部教师")

    public CommonResult getdepartment() {
        CommonResult result = new CommonResult();
        try {
            result.setData(teacherService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/teacher/getTeacherById")
    @ApiOperation("根据id查找教师")
    public CommonResult getdepartmentById(@RequestBody String id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(teacherService.findById(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/teacher/updateTeacher")
    @ApiOperation("修改系")
    public CommonResult updateDepartment(@RequestBody Teacher teacher){
        CommonResult result = new CommonResult();
        try {
            teacherService.update(teacher);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    
    @PostMapping(value = "/teacher/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestBody String id){
        CommonResult result = new CommonResult();
        try {
            teacherService.deleteById(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/teacher/addTeacher")
    @ApiOperation("增加")
    public CommonResult add(@RequestBody Teacher teacher){
        CommonResult result = new CommonResult();
        try {
            teacherService.add(teacher);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }



}


