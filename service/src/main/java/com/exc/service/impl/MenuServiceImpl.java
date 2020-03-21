package com.exc.service.impl;

import com.exc.mapper.*;
import com.exc.model.*;
import com.exc.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cdx
 * date 2020-02-18
 */
@Service
@MapperScan(basePackages = {"com/exc/mapper"})
public class MenuServiceImpl implements MenuService {
    private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private CarouselDesignsMapper carouselDesignsMapper;
    @Autowired
    private TasteMapper tasteMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Map<String, List<?>> listMenu(String searchParam) {
        HashMap<String, List<?>> resultMap = new HashMap<>(8);

        // 获取轮播图
        List<CarouselDesigns> carouselDesignsList = carouselDesignsMapper.list();
        resultMap.put("carouselDesignsList", carouselDesignsList);

        // 获取美味主食
        List<Menu> stapleFoodList = menuMapper.listStapleFood();
        resultMap.put("stapleFoodList", stapleFoodList);

        // 获取休闲小吃
        List<Menu> snackList = menuMapper.listSnack();
        resultMap.put("snackList", snackList);

        // 获取浓郁靓汤
        List<Menu> soupList = menuMapper.listSoup();
        resultMap.put("soupList", soupList);

        // 获取精致甜品
        List<Menu> sweetMeatsList = menuMapper.listSweetMeats();
        resultMap.put("sweetMeatsList", sweetMeatsList);

        // 获取健康调味
        List<Menu> dressingList = menuMapper.listDressing();
        resultMap.put("dressingList", dressingList);

        return resultMap;
    }

    @Override
    public void updateMenu(RequestParamVo requestParamVo) {
        menuMapper.updateMenu(requestParamVo);
    }

    @Override
    public void deleteMenu(Integer[] menuIds) {
        menuMapper.deleteMenu(menuIds);
    }

    @Override
    public void insertMenu(RequestParamVo requestParamVo) {
        Menu menu = new Menu();
        menu.setName(requestParamVo.getName());
        menu.setTaste(StringUtils.join(requestParamVo.getTaste(), ","));
        menu.setCategory(requestParamVo.getCategory());
        menu.setStep(requestParamVo.getStep());
        menu.setScore(requestParamVo.getScore());
        menu.setEvaluateContent(requestParamVo.getEvaluateContent());
        menu.setPictureUrl(requestParamVo.getPictureUrl());

        menuMapper.insertMenu(menu);
    }

    @Override
    public Menu findOne(Integer menuId) {
        return menuMapper.findOne(menuId);
    }

    @Override
    public void deleteOne(Integer menuId) {
        menuMapper.deleteOne(menuId);
    }

    @Override
    public Boolean checkName(String name) {
        Integer number = menuMapper.checkName(name);

        return number > 0;
    }

    @Override
    public Integer countSize(String searchParam) {
        return menuMapper.countSize(searchParam);
    }

    @Override
    public Map<String, List<?>> initEdit() {
        HashMap<String, List<?>> resultMap = new HashMap<>(8);

        // 获取味道列表
        List<Taste> tasteList = tasteMapper.list();
        resultMap.put("tasteList", tasteList);

        // 获取分类列表
        List<Category> categoryList = categoryMapper.list();
        resultMap.put("categoryList", categoryList);

        return resultMap;
    }
}
