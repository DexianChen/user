package cn.com.huaruan;

import cn.com.huaruan.mapper.UserMapper;
import cn.com.huaruan.mapper.UserRepository;
import cn.com.huaruan.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * es测试类
 * @author cdx
 * date 2019-08-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    /**
     * 创建索引，会根据User类的@Document注解信息来创建
     */
    @Test
    public void testCreateIndex() {
        elasticsearchTemplate.createIndex(User.class);
    }

    /**
     * 删除索引
     */
    @Test
    public void testDeleteIndex() {
        elasticsearchTemplate.deleteIndex(User.class);
//        elasticsearchTemplate.deleteIndex("index");
    }

    /**
     * 新增
     */
    @Test
    public void insert() {
        User user = new User();
        user.setAccount("jack");
        user.setIdCard("450000000000000000");
        userRepository.save(user);
    }

    /**
     * 批量新增
     */
    @Test
    public void insertList() {
        List<User> userList = userMapper.selectUserList("", 0, 10);
        // 接收对象集合，实现批量新增
        userRepository.saveAll(userList);
    }
}
