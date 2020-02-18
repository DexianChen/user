package com.exc.service;

import com.exc.model.Menu;
import com.exc.model.RequestParamVo;

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

    void updateMenu(RequestParamVo requestParamVo);

    void deleteMenu(Integer[] taskIds);

    /**
     * 插入菜谱
     * @param requestParamVo 菜谱实体
     */
    void insertMenu(RequestParamVo requestParamVo);

    Menu findOne(Integer userId);

    void deleteOne(Integer userId);

    Boolean checkAccount(String account);

    Boolean checkIdCard(String idCard);

    Boolean checkPhone(String phone);

    Boolean checkEmail(String email);

    Integer countSize(String searchParam);
}
