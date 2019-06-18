package cn.com.huaruan.mapper;

import cn.com.huaruan.model.RequestParamVo;
import cn.com.huaruan.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectUserList();

    void insertUser(RequestParamVo paramVo);

    void updateUser(RequestParamVo paramVo);

    void deleteUser(Integer[] userId);

    User getUserByAccount(String account);

    User findOne(@Param("userId") Integer userId);
}
