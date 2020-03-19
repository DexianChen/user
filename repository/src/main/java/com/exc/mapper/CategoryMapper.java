package com.exc.mapper;

import com.exc.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface CategoryMapper {
    /**
     * 获取分类列表
     * @return 分类列表
     */
    List<Category> list();
}
