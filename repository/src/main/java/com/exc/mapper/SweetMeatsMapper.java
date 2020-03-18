package com.exc.mapper;

import com.exc.model.SweetMeats;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface SweetMeatsMapper {
    /**
     * 获取精致甜品列表
     * @return 精致甜品列表
     */
    List<SweetMeats> list();
}
