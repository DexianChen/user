package cn.com.huaruan.service.mapper;

import cn.com.huaruan.service.model.RequestParamVo;
import cn.com.huaruan.service.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectUserList();

    User getUserById(String account);

    void insertUser(RequestParamVo paramVo);

    void updateUser(RequestParamVo paramVo);

    void deleteByIds(String[] userId);
}
