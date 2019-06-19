package cn.com.huaruan.service.impl;

import cn.com.huaruan.model.RequestParamDao;
import cn.com.huaruan.service.UserService;
import cn.com.huaruan.mapper.UserMapper;
import cn.com.huaruan.model.User;
import cn.com.huaruan.utils.MD5Util;
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
    public List<User> selectUserList(String searchParam) {
        List<User> userList = userMapper.selectUserList(searchParam);

        /**
         * 身份证以及手机的脱敏处理
         */
        for (User user : userList) {
            StringBuilder idCard = new StringBuilder(user.getIdCard());
            idCard.replace(6, 14, "********");
            user.setIdCard(idCard.toString());

            StringBuilder phone = new StringBuilder(user.getPhone());
            phone.replace(4,8, "****");
            user.setPhone(phone.toString());
        }

        return userList;
    }

    @Override
    public void updateUser(RequestParamDao requestParamDao) {
        String md5Pwd= new MD5Util().getkeyBeanofStr(requestParamDao.getPwd());
        requestParamDao.setPwd(md5Pwd);
        userMapper.updateUser(requestParamDao);
    }

    @Override
    public void deleteUser(Integer[] userIds) {
        userMapper.deleteUser(userIds);
    }

    @Override
    public void insertUser(RequestParamDao requestParamDao) {
        String md5Pwd= new MD5Util().getkeyBeanofStr(requestParamDao.getPwd());
        requestParamDao.setPwd(md5Pwd);
        userMapper.insertUser(requestParamDao);
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
