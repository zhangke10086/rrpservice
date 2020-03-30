package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "登陆")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    @ApiOperation("根据id查找用户")
    public CommonResult getUserById(@RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password) {
        CommonResult result = new CommonResult();
        try {
            result.setData(loginService.findUserByUserNameAndPassword(username, password));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

}
