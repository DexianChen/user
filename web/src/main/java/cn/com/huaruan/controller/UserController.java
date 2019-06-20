package cn.com.huaruan.controller;

import cn.com.huaruan.model.*;
import cn.com.huaruan.service.UserService;
import cn.com.huaruan.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserService userService;

    @PostMapping("/update")
    public ResultVo updateUser(@RequestBody RequestParamVo paramVo){
        try {
            userService.updateUser(paramVo);
            return new ResultVo(true, "更新用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "更新用户失败");
    }

    @GetMapping("/delete")
    public ResultVo deleteUser(@RequestParam("userIds") Integer[] userIds){
        try {
            userService.deleteUser(userIds);
            return new ResultVo(true, "批量删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "批量删除用户失败");
    }

    @GetMapping("/list")
    public PageVo selectUserList(@RequestParam("searchParam") String searchParam,
                                 @RequestParam("currentPage") String currentPage,
                                 @RequestParam("itemsPerPage") String itemsPerPage){
        List<User> userList = userService.selectUserList(searchParam, currentPage, itemsPerPage);

        Integer countSize = countSize(searchParam);
        return new PageVo(countSize, userList);
    }

    /**
     * 统计符合条件的用户数量
     * @param searchParam
     * @return
     */
    private Integer countSize(String searchParam){
        return userService.countSize(searchParam);
    }

    @PostMapping("/insert")
    public ResultVo insertUser(@RequestBody RequestParamVo paramVo){
        try {
            userService.insertUser(paramVo);
            return new ResultVo(true, "插入用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo(false, "插入用户失败");
    }

    @GetMapping("/findOne")
    public User findOne(Integer userId){
        return userService.findOne(userId);
    }

    @GetMapping("/deleteOne")
    public ResultVo deleteOne(Integer userId){
        try {
            userService.deleteOne(userId);
            return new ResultVo(true, "删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo(false, "删除用户失败");
    }
}
