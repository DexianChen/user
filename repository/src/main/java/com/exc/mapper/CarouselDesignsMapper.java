package com.exc.mapper;

import com.exc.model.CarouselDesigns;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cdx
 * date: 2020/03/18
 */
@Repository
public interface CarouselDesignsMapper {
    /**
     * 获取轮播图列表
     * @return 轮播图列表
     */
    List<CarouselDesigns> list();
}
