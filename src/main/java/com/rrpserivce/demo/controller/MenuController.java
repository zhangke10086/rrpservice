package com.rrpserivce.demo.controller;


import com.common.resformat.CommonResult;
import com.rrpserivce.demo.entity.Menu;
import com.rrpserivce.demo.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@Api(value = "菜单")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping(value = "/menu/getMenusByMenuNotNull")
    @ApiOperation("获取全部菜单列表")
    public CommonResult getMenusByMenuNotNull() {
        CommonResult result = new CommonResult();
        try {
            result.setData(menuService.getMenusByMenuNotNull());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @GetMapping(value = "/menu/getMenus")
    @ApiOperation("获取全部菜单列表")
    public CommonResult getMenus() {
        CommonResult result = new CommonResult();
        try {
            result.setData(menuService.findAll());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }


    @GetMapping(value = "/menu/getMenuById")
    @ApiOperation("根据id查找菜单")
    public CommonResult getMenuById(@RequestParam(value = "id") int id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(menuService.findById(id));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.setState(500);
            result.setMsg("获取失败");
            return result;
        }
    }

    @PutMapping(value = "/menu/updateMenu")
    @ApiOperation("修改")
    public CommonResult updateUser(@RequestBody Menu menu){
        CommonResult result = new CommonResult();
        try {
            menuService.update(menu);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @DeleteMapping(value = "/menu/deleteById")
    @ApiOperation("删除")
    public CommonResult deleteById(@RequestParam(value = "id") int id){
        CommonResult result = new CommonResult();
        try {
            menuService.deleteById(id);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("删除失败");
            return result;
        }
    }

    @PostMapping(value = "/menu/addMenu")
    @ApiOperation("增加")
    public CommonResult add(@RequestParam(value = "id") Menu menu){
        CommonResult result = new CommonResult();
        try {
            menuService.add(menu);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("新增失败");
            return result;
        }
    }

}
