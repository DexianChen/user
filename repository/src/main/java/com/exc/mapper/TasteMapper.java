package com.exc.mapper;

import com.exc.model.Taste;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface TasteMapper {
    /**
     * 获取味道列表
     * @return 味道列表
     */
    List<Taste> list();
}
