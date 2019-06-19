package cn.com.huaruan.service.impl;

import cn.com.huaruan.model.RequestParamVo;
import cn.com.huaruan.service.UserService;
import cn.com.huaruan.mapper.UserMapper;
import cn.com.huaruan.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@MapperScan(basePackages = {"cn.com.huaruan.mapper"})
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public void updateUser(RequestParamVo paramVo) {
        userMapper.updateUser(paramVo);
    }

    @Override
    public void deleteUser(Integer[] userIds) {
        userMapper.deleteUser(userIds);
    }

    @Override
    public void insertUser(RequestParamVo paramVo) {
        userMapper.insertUser(paramVo);
    }

    @Override
    public User getUserByAccount(String account) {
        userMapper.getUserByAccount(account);
        return null;
    }

    @Override
    public User findOne(Integer userId) {
        return userMapper.findOne(userId);
    }

    @Override
    public void deleteOne(Integer userId) {
        userMapper.deleteOne(userId);
    }

    @Override
    public Boolean checkAccount(String account) {
        Integer number = userMapper.checkAccount(account);

        return number > 0;
    }

    @Override
    public Boolean checkIdCard(String idCard) {
        Integer number = userMapper.checkIdCard(idCard);

        return number > 0;
    }

    @Override
    public Boolean checkPhone(String phone) {
        Integer number = userMapper.checkPhone(phone);

        return number > 0;
    }

    @Override
    public Boolean checkEmail(String email) {
        Integer number = userMapper.checkEmail(email);

        return number > 0;
    }
}
