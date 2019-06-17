package cn.com.huaruan.service.impl;

import cn.com.huaruan.service.UserService;
import cn.com.huaruan.service.mapper.UserMapper;
import cn.com.huaruan.service.model.RequestParamVo;
import cn.com.huaruan.service.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@MapperScan(basePackages = {"cn.com.huaruan.repository.mapper"})
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return null;
    }

    @Override
    public void updateUser(RequestParamVo paramVo) {

    }

    @Override
    public void deleteUser(Integer[] taskIds) {

    }

    @Override
    public void insertUser(RequestParamVo paramVo) {

    }
}
