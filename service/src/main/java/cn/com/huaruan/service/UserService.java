package cn.com.huaruan.service;

import cn.com.huaruan.model.RequestParamVo;
import cn.com.huaruan.model.User;

import java.util.List;

public interface UserService {
    List<User> selectUserList();

    void updateUser(RequestParamVo paramVo);

    void deleteUser(Integer[] taskIds);

    void insertUser(RequestParamVo paramVo);

    User getUserByAccount(String account);

    User findOne(Integer userId);

    void deleteOne(Integer userId);

    Boolean checkAccount(String account);

    Boolean checkIdCard(String idCard);

    Boolean checkPhone(String phone);

    Boolean checkEmail(String email);
}
