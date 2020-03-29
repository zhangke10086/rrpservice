package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.entity.User;
import com.rrpserivce.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "用户")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/user/getUsers")
    @ApiOperation("获取全部用户列表")
    public CommonResult getUser() {
        CommonResult result = new CommonResult();
        try {
            result.setData(userService.findAll());
            System.out.println(result.toString());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg(userService.findAll().toString());
            return result;
        }
    }

    @GetMapping(value = "/user/getUserById")
    @ApiOperation("根据id查找用户")
    public CommonResult getUserById(@RequestParam(value = "id") int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(userService.findById(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/user/updateUser")
    @ApiOperation("修改系")
    public CommonResult updateUser(@RequestBody User user){
        CommonResult result = new CommonResult();
        try {
            userService.update(user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @DeleteMapping(value = "/user/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            userService.deleteById(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/user/addUser")
    @ApiOperation("增加")
    public CommonResult add(@RequestParam(value = "id") User user){
        CommonResult result = new CommonResult();
        try {
            userService.add(user);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
