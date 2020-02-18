package com.exc.service;

import com.exc.model.Menu;
import com.exc.model.RequestParamVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cdx
 * date 2020-02-18
 * 菜谱业务接口
 */
public interface MenuService {
    /**
     * 查询菜谱列表
     * @param searchParam 搜索参数
     * @param currentPage 当前页码
     * @param itemsPerPage 每页大小
     * @return 菜谱列表
     */
    List<Menu> listMenu(String searchParam, String currentPage, String itemsPerPage);

    /**
     * 更新菜谱
     * @param requestParamVo 菜谱实体
     */
    void updateMenu(RequestParamVo requestParamVo);

    void deleteMenu(Integer[] taskIds);

    /**
     * 插入菜谱
     * @param requestParamVo 菜谱实体
     */
    @Transactional(rollbackFor = Exception.class)
    void insertMenu(RequestParamVo requestParamVo);

    /**
     * 根据id获取菜谱
     * @param menuId 菜谱id
     * @return 菜谱
     */
    Menu findOne(@Param("menuId") Integer menuId);

    void deleteOne(Integer userId);

    /**
     * 校验菜式名称是否重复
     * @param name 菜式名称
     * @return 是否重复
     */
    Boolean checkName(String name);

    Integer countSize(String searchParam);
}
