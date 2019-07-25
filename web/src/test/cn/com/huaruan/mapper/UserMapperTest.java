package cn.com.huaruan.mapper;

import cn.com.huaruan.model.RequestParamVo;
import cn.com.huaruan.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Mock
    private UserMapper userMapper;

    @Test
    public void testSelectUserList() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAccount("jack");
        list.add(user);

        when(userMapper.selectUserList("", 1, 1)).thenReturn(list);
        assertEquals(list.get(0).getAccount(), "jack");
    }

    @Test
    public void testInsertUser() {
        RequestParamVo paramVo = new RequestParamVo();
        paramVo.setAccount("jack");
        paramVo.setPwd("jack");
        paramVo.setSex(0);
        // 参数为空, 会抛出BadSqlGrammarException异常
        doThrow(new RuntimeException()).when(userMapper).insertUser(paramVo);
    }
}
