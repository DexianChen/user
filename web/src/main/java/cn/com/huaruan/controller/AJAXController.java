package cn.com.huaruan.controller;

import cn.com.huaruan.model.*;
import cn.com.huaruan.service.BookService;
import cn.com.huaruan.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ajax")
public class AJAXController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @PostMapping("/account")
    public ResultVo checkAccount(String account) {
        Boolean isExist = userService.checkAccount(account);

        if (isExist) {
            return new ResultVo(false, "该账户已存在！");
        } else {
            return new ResultVo(true, "该账户可被注册");
        }
    }

    @PostMapping("/idCard")
    public ResultVo checkIdCard(String idCard) {
        Boolean isExist = userService.checkIdCard(idCard);

        if (isExist) {
            return new ResultVo(false, "该身份证已存在！");
        } else {
            return new ResultVo(true, "该身份证可用于注册");
        }
    }

    @PostMapping("/phone")
    public ResultVo checkPhone(String phone) {
        Boolean isExist = userService.checkPhone(phone);

        if (isExist) {
            return new ResultVo(false, "该手机号已存在！");
        } else {
            return new ResultVo(true, "该手机号可用于注册");
        }
    }

    @PostMapping("/email")
    public ResultVo checkEmail(String email) {
        Boolean isExist = userService.checkEmail(email);

        if (isExist) {
            return new ResultVo(false, "该邮箱已存在！");
        } else {
            return new ResultVo(true, "该邮箱可用于注册");
        }
    }

    /**
     * 用于保存书籍的章列表信息
     * @param chapterListStr 章的列表信息
     * @return ResultVo
     */
    @PostMapping("/book/chapter")
    public ResultVo saveChapter(@RequestParam("chapterList")String chapterListStr) {
        List<ChapterVo> chapterList = JSON.parseArray(chapterListStr, ChapterVo.class);

        try {
            bookService.saveChapter(chapterList);
            return new ResultVo(true, "保存章列表信息成功");
        } catch (Exception e) {
            return new ResultVo(false, "保存章列表信息失败");
        }
    }

    /**
     * 用于保存书籍的节列表信息
     * @param nodeListStr 节的列表信息
     * @return
     */
    @PostMapping("/book/node")
    public ResultVo saveNode(@RequestParam("nodeList")String nodeListStr) {
        List<NodeVo> nodeList = JSON.parseArray(nodeListStr, NodeVo.class);

        try {
            bookService.saveNode(nodeList);
            return new ResultVo(true, "保存节列表信息成功");
        } catch (Exception e) {
            return new ResultVo(false, "保存节列表信息失败");
        }
    }

    /**
     * 用于保存书籍的条文列表信息
     * @param itemListStr 条文的列表信息
     * @param itemDescriptionListStr 条文说明列表信息
     * @return
     */
    @PostMapping("/book/item")
    public ResultVo saveItem(@RequestParam("itemList")String itemListStr,
                             @RequestParam("itemDescriptionList")String itemDescriptionListStr) {
        List<ItemVo> itemList = JSON.parseArray(itemListStr, ItemVo.class);
        List<ItemDescriptionVo> itemDescriptionList = JSON.parseArray(itemDescriptionListStr, ItemDescriptionVo.class);

        try {
            bookService.saveItem(itemList, itemDescriptionList);
            return new ResultVo(true, "保存节列表信息成功");
        } catch (Exception e) {
            return new ResultVo(false, "保存节列表信息失败");
        }
    }
}
