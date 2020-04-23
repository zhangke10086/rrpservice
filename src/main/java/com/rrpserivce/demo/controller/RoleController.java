package com.rrpserivce.demo.controller;

import com.common.resformat.CommonResult;
import com.rrpserivce.demo.entity.Role;
import com.rrpserivce.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "身份")
public class RoleController {
    @Autowired
    private RoleService roleService;

    // 先不用了,集成到Authority
    @PostMapping(value = "/role/addRole")
    @ApiOperation(value = "增加身份")
    public CommonResult addRole(@RequestBody Role role){
        CommonResult result = new CommonResult();
        try {
            roleService.add(role);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }


    @DeleteMapping(value = "/role/deleteRole")
    @ApiOperation(value = "删除身份")
    public CommonResult deleteRoleById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            roleService.deleteById(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }


    @PutMapping(value = "/role/updateRole")
    @ApiOperation("修改身份")
    public CommonResult updateRole(@RequestBody Role role){
        CommonResult result = new CommonResult();
        try {
            roleService.update(role);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    @GetMapping(value = "/role/getRoles")
    @ApiOperation(value = "查找所有身份")
    public CommonResult findAll(){
        CommonResult result = new CommonResult();
        try {
            result.setData(roleService.findAll());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/role/getRoleById")
    @ApiOperation("根据id查找用户")
    public CommonResult getRoleById(@RequestParam(value = "id") int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(roleService.findById(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    /**
     * 用不到了，改为前台实现
     * @return
     */
    @GetMapping(value = "/role/getRolesMaxId")
    @ApiOperation(value = "查找所有身份")
    public CommonResult getMaxId(){
        CommonResult result = new CommonResult();
        try {
            result.setData(roleService.getMaxId());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }
}
