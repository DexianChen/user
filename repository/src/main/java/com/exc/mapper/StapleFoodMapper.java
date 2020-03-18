package com.exc.mapper;

import com.exc.model.StapleFood;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface StapleFoodMapper {
    /**
     * 获取美味主食列表
     * @return 美味主食列表
     */
    List<StapleFood> list();
}
