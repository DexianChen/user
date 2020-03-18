package com.exc.mapper;

import com.exc.model.Snack;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface SnackMapper {
    /**
     * 获取休闲小吃列表
     * @return 休闲小吃列表
     */
    List<Snack> list();
}
