package com.exc.mapper;

import com.exc.model.Soup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface SoupMapper {
    /**
     * 获取浓郁靓汤列表
     * @return 浓郁靓汤列表
     */
    List<Soup> list();
}
