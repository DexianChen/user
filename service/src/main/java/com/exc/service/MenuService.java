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
    List<Menu> listMenu(String searchParam, String currentPage, String itemsPerPage);

    void updateMenu(RequestParamVo requestParamVo);

    void deleteMenu(Integer[] taskIds);

    void insertMenu(RequestParamVo requestParamVo);

    Menu findOne(Integer userId);

    void deleteOne(Integer userId);

    Boolean checkAccount(String account);

    Boolean checkIdCard(String idCard);

    Boolean checkPhone(String phone);

    Boolean checkEmail(String email);

    Integer countSize(String searchParam);
}
