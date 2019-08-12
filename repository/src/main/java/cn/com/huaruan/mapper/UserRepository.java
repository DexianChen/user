package cn.com.huaruan.mapper;

import cn.com.huaruan.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承ElasticsearchRepository的User类接口
 * @author cdx
 * date 2019-08-12
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {
}
