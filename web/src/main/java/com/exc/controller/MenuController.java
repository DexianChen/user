package com.exc.controller;

import com.exc.model.ResultVo;
import com.exc.service.MenuService;
import com.exc.service.impl.MenuServiceImpl;
import com.exc.model.Menu;
import com.exc.model.PageVo;
import com.exc.model.RequestParamVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cdx
 * date 2020-02-18
 * 菜谱controller
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

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
    public ResultVo deleteMenu(@RequestParam("userIds") Integer[] userIds){
        try {
            menuService.deleteMenu(userIds);
            return new ResultVo(true, "批量删除菜谱成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "批量删除菜谱失败");
    }

    @GetMapping("/list")
    public PageVo listMenu(@RequestParam("searchParam") String searchParam,
                                 @RequestParam("currentPage") String currentPage,
                                 @RequestParam("itemsPerPage") String itemsPerPage){
        List<Menu> menuList = menuService.listMenu(searchParam, currentPage, itemsPerPage);

        Integer countSize = countSize(searchParam);
        return new PageVo(countSize, menuList);
    }

    /**
     * 统计符合条件的菜谱数量
     * @param searchParam
     * @return
     */
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
    public Menu findOne(Integer userId){
        return menuService.findOne(userId);
    }

    @GetMapping("/deleteOne")
    public ResultVo deleteOne(Integer userId){
        try {
            menuService.deleteOne(userId);
            return new ResultVo(true, "删除菜谱成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "删除菜谱失败");
    }
}