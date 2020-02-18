package com.exc.mapper;

import com.exc.model.RequestParamVo;
import com.exc.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date 2020-02-18
 * 菜谱mapper
 */
@Repository
public interface MenuMapper {
    /**
     * 查询菜谱列表
     * @param searchParam 搜索参数
     * @param fistIndex 页码
     * @param perPage 每页大小
     * @return 菜谱列表
     */
    List<Menu> listMenu(@Param("searchParam") String searchParam, @Param("fistIndex") Integer fistIndex,
                              @Param("perPage") Integer perPage);

    /**
     * 插入菜谱
     * @param requestParamVo 菜谱实体
     */
    void insertMenu(RequestParamVo requestParamVo);

    /**
     * 更新菜谱
     * @param requestParamVo 菜谱实体
     */
    void updateMenu(RequestParamVo requestParamVo);

    /**
     * 批量删除菜谱
     * @param menuIds 菜谱id列表
     */
    void deleteMenu(@Param("MenuIds") Integer[] menuIds);

    /**
     * 根据id获取菜谱
     * @param menuId 菜谱id
     * @return 菜谱
     */
    Menu findOne(@Param("MenuId") Integer menuId);

    /**
     * 根据id删除菜谱
     * @param menuId 菜谱id
     */
    void deleteOne(Integer menuId);

    Integer checkAccount(String account);

    Integer checkIdCard(String idCard);

    Integer checkPhone(String phone);

    Integer checkEmail(String email);

    Integer countSize(@Param("searchParam") String searchParam);
}
