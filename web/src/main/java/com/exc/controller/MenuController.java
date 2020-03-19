package com.exc.controller;

import com.exc.model.Menu;
import com.exc.model.RequestParamVo;
import com.exc.model.ResultVo;
import com.exc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author cdx
 * date 2020-02-18
 * 菜谱controller
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/update")
    public ResultVo updateMenu(@RequestBody RequestParamVo paramVo){
        try {
            menuService.updateMenu(paramVo);
            return new ResultVo(true, "更新菜谱成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "更新菜谱失败");
    }

    @GetMapping("/delete")
    public ResultVo deleteMenu(@RequestParam("menuIds") Integer[] menuIds){
        try {
            menuService.deleteMenu(menuIds);
            return new ResultVo(true, "批量删除菜谱成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "批量删除菜谱失败");
    }

    @GetMapping("/list")
    public Map<String, List<?>> listMenu(@RequestParam("searchParam") String searchParam){
        return menuService.listMenu(searchParam);
    }

    private Integer countSize(String searchParam){
        return menuService.countSize(searchParam);
    }

    @PostMapping("/insert")
    public ResultVo insertMenu(@RequestBody RequestParamVo paramVo){
        try {
            menuService.insertMenu(paramVo);
            return new ResultVo(true, "插入菜谱成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo(false, "插入菜谱失败");
    }

    @GetMapping("/findOne")
    public Menu findOne(Integer menuId){
        return menuService.findOne(menuId);
    }

    @GetMapping("/deleteOne")
    public ResultVo deleteOne(Integer menuId){
        try {
            menuService.deleteOne(menuId);
            return new ResultVo(true, "删除菜谱成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "删除菜谱失败");
    }

    @GetMapping("/initEdit")
    public Map<String, List<?>> initEdit(){
        return menuService.initEdit();
    }
}
