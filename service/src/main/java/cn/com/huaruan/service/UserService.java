package cn.com.huaruan.service;

import cn.com.huaruan.model.RequestParamDao;
import cn.com.huaruan.model.User;

import java.util.List;

public interface UserService {
    List<User> selectUserList(String searchParam);

    void updateUser(RequestParamDao requestParamDao);

    void deleteUser(Integer[] taskIds);

    void insertUser(RequestParamDao requestParamDao);

    User findOne(Integer userId);

    void deleteOne(Integer userId);

    Boolean checkAccount(String account);

    Boolean checkIdCard(String idCard);

    Boolean checkPhone(String phone);

    Boolean checkEmail(String email);
}
