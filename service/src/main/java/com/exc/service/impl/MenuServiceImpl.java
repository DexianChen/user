package com.exc.service.impl;

import com.exc.model.RequestParamVo;
import com.exc.service.MenuService;
import com.exc.mapper.MenuMapper;
import com.exc.model.Menu;
import com.exc.utils.MD5Util;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Menu> listMenu(String searchParam, String currentPage, String itemsPerPage) {
        Integer perPage = Integer.valueOf(itemsPerPage);
        Integer fistIndex = (Integer.valueOf(currentPage) - 1 ) * perPage;
        return menuMapper.listMenu(searchParam, fistIndex, perPage);
    }

    @Override
    public void updateMenu(RequestParamVo requestParamVo) {
        String md5Pwd= new MD5Util().getkeyBeanofStr(requestParamVo.getPwd());
        requestParamVo.setPwd(md5Pwd);
        menuMapper.updateMenu(requestParamVo);
    }

    @Override
    public void deleteMenu(Integer[] userIds) {
        menuMapper.deleteMenu(userIds);
    }

    @Override
    public void insertMenu(RequestParamVo requestParamVo) {
        String md5Pwd= new MD5Util().getkeyBeanofStr(requestParamVo.getPwd());
        requestParamVo.setPwd(md5Pwd);
        menuMapper.insertMenu(requestParamVo);
    }

    @Override
    public Menu findOne(Integer userId) {
        return menuMapper.findOne(userId);
    }

    @Override
    public void deleteOne(Integer userId) {
        menuMapper.deleteOne(userId);
    }

    @Override
    public Boolean checkAccount(String account) {
        Integer number = menuMapper.checkAccount(account);

        return number > 0;
    }

    @Override
    public Boolean checkIdCard(String idCard) {
        Integer number = menuMapper.checkIdCard(idCard);

        return number > 0;
    }

    @Override
    public Boolean checkPhone(String phone) {
        Integer number = menuMapper.checkPhone(phone);

        return number > 0;
    }

    @Override
    public Boolean checkEmail(String email) {
        Integer number = menuMapper.checkEmail(email);

        return number > 0;
    }

    @Override
    public Integer countSize(String searchParam) {
        return menuMapper.countSize(searchParam);
    }
}
