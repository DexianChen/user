package com.exc.mapper;

import com.exc.model.Dressing;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface DressingMapper {
    /**
     * 获取健康调味列表
     * @return 健康调味列表
     */
    List<Dressing> list();
}
