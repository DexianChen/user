package cn.com.huaruan.service.controller;

import cn.com.huaruan.service.UserService;
import cn.com.huaruan.service.impl.UserServiceImpl;
import cn.com.huaruan.service.model.RequestParamVo;
import cn.com.huaruan.service.model.ResultVo;
import cn.com.huaruan.service.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8088", maxAge = 3600)
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
            return new ResultVo("SUCCESS", "更新用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo("FAIL", "更新用户失败");
    }

    @GetMapping("/delete")
    public ResultVo deleteJob(Integer[] taskIds){
        try {
            userService.deleteUser(taskIds);
            return new ResultVo("SUCCESS", "删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultVo("FAIL", "删除用户失败");
    }

    @GetMapping("/list")
    public List<User> getTaskList(){
        return userService.selectUserList();
    }

    @PostMapping("/insert")
    public ResultVo insertTask(@RequestBody RequestParamVo paramVo){
        try {
            userService.insertUser(paramVo);
            return new ResultVo("SUCCESS", "插入用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo("FAIL", "插入用户失败");
    }
}
