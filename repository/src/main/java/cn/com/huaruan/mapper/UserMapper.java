package cn.com.huaruan.mapper;

import cn.com.huaruan.model.RequestParamDao;
import cn.com.huaruan.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectUserList(@Param("searchParam") String searchParam, @Param("fistIndex") Integer fistIndex,
                              @Param("perPage") Integer perPage);

    void insertUser(RequestParamDao requestParamDto);

    void updateUser(RequestParamDao requestParamDto);

    void deleteUser(@Param("userIds") Integer[] userIds);

    User findOne(@Param("userId") Integer userId);

    void deleteOne(Integer userId);

    Integer checkAccount(String account);

    Integer checkIdCard(String idCard);

    Integer checkPhone(String phone);

    Integer checkEmail(String email);

    Integer countSize(@Param("searchParam") String searchParam);
}
