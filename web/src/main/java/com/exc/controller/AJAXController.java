package com.exc.controller;

import com.exc.model.ResultVo;
import com.exc.service.MenuService;
import com.exc.service.impl.MenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cdx
 * date 2020-02-18
 * 表单校验
 */
@RestController
@RequestMapping("/ajax")
public class AJAXController {
    private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuService menuService;

    @PostMapping("/name")
    public ResultVo checkName(String name) {
        Boolean isExist = menuService.checkName(name);

        if (isExist) {
            return new ResultVo(false, "该菜式已存在！");
        } else {
            return new ResultVo(true, "该菜式可被添加");
        }
    }
}
