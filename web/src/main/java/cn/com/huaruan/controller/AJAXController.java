package cn.com.huaruan.controller;

import cn.com.huaruan.model.ResultVo;
import cn.com.huaruan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax")
public class AJAXController {
    @Autowired
    private UserService userService;

    @PostMapping("/account")
    public ResultVo checkAccount(String account){
        Boolean isExist = userService.checkAccount(account);

        if (isExist){
            return new ResultVo(false, "该账户已存在！");
        }else {
            return new ResultVo(true, "该账户可被注册");
        }
    }

    @PostMapping("/idCard")
    public ResultVo checkIdCard(String idCard){
        Boolean isExist = userService.checkIdCard(idCard);

        if (isExist){
            return new ResultVo(false, "该身份证已存在！");
        }else {
            return new ResultVo(true, "该身份证可用于注册");
        }
    }

    @PostMapping("/phone")
    public ResultVo checkPhone(String phone){
        Boolean isExist = userService.checkPhone(phone);

        if (isExist){
            return new ResultVo(false, "该手机号已存在！");
        }else {
            return new ResultVo(true, "该手机号可用于注册");
        }
    }

    @PostMapping("/email")
    public ResultVo checkEmail(String email){
        Boolean isExist = userService.checkEmail(email);

        if (isExist){
            return new ResultVo(false, "该邮箱已存在！");
        }else {
            return new ResultVo(true, "该邮箱可用于注册");
        }
    }
}
