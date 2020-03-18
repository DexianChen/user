package com.exc.service.impl;

import com.exc.mapper.*;
import com.exc.model.*;
import com.exc.service.MenuService;
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
    private StapleFoodMapper stapleFoodMapper;
    @Autowired
    private SnackMapper snackMapper;
    @Autowired
    private SoupMapper soupMapper;
    @Autowired
    private SweetMeatsMapper sweetMeatsMapper;
    @Autowired
    private DressingMapper dressingMapper;

    @Override
    public Map<String, List<?>> listMenu(String searchParam) {
        HashMap<String, List<?>> resultMap = new HashMap<>(8);

        // 获取轮播图
        List<CarouselDesigns> carouselDesignsList = carouselDesignsMapper.list();
        resultMap.put("carouselDesignsList", carouselDesignsList);

        // 获取美味主食
        List<StapleFood> stapleFoodList = stapleFoodMapper.list();
        resultMap.put("stapleFoodList", stapleFoodList);

        // 获取休闲小吃
        List<Snack> snackList = snackMapper.list();
        resultMap.put("snackList", snackList);

        // 获取浓郁靓汤
        List<Soup> soupList = soupMapper.list();
        resultMap.put("soupList", soupList);

        // 获取精致甜品
        List<SweetMeats> sweetMeatsList = sweetMeatsMapper.list();
        resultMap.put("sweetMeatsList", sweetMeatsList);

        // 获取健康调味
        List<Dressing> dressingList = dressingMapper.list();
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
        menuMapper.insertMenu(requestParamVo);
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
}
