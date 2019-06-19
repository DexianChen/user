package cn.com.huaruan.controller;

import cn.com.huaruan.model.RequestParamDao;
import cn.com.huaruan.model.RequestParamVo;
import cn.com.huaruan.service.UserService;
import cn.com.huaruan.service.impl.UserServiceImpl;
import cn.com.huaruan.model.ResultVo;
import cn.com.huaruan.model.User;
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
            RequestParamDao requestParamDao = new RequestParamDao(paramVo);
            userService.updateUser(requestParamDao);
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
    public List<User> selectUserList(@RequestParam("searchParam") String searchParam){
        return userService.selectUserList(searchParam);
    }

    @PostMapping("/insert")
    public ResultVo insertUser(@RequestBody RequestParamVo paramVo){
        try {
            RequestParamDao requestParamDao = new RequestParamDao(paramVo);
            userService.insertUser(requestParamDao);
            return new ResultVo(true, "插入用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo(false, "插入用户失败");
    }

    @GetMapping("/search")
    public User getUserByAccount(String account) {
        return userService.getUserByAccount(account);
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
