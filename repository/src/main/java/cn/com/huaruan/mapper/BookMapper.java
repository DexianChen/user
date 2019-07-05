package cn.com.huaruan.mapper;

import cn.com.huaruan.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    /**
     * 保存章列表信息
     * @param chapterList
     */
    void saveChapter(@Param("chapterList") List<ChapterVo> chapterList);

    /**
     * 保存节列表信息
     * @param nodeList
     */
    void saveNode(@Param("nodeList") List<NodeVo> nodeList);

    /**
     * 保存条文列表信息
     * @param itemList
     */
    void saveItem(@Param("itemList") List<ItemVo> itemList);

    /**
     * 保存其他列表信息(包括前言和附录等)
     * @param otherList
     */
    void saveOther(@Param("otherList") List<OtherVo> otherList);
}
