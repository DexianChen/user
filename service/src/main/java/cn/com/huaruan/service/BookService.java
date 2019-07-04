package cn.com.huaruan.service;

import cn.com.huaruan.model.*;

import java.util.List;

/**
 * 用于保存文章信息
 */
public interface BookService {

    /**
     * 保存章列表信息
     * @param chapterList
     */
    void saveChapter(List<ChapterVo> chapterList);

    /**
     * 保存节列表信息
     * @param nodeList
     */
    void saveNode(List<NodeVo> nodeList);

    /**
     * 保存条文列表信息
     * @param itemList
     * @param itemDescriptionList
     */
    void saveItem(List<ItemVo> itemList, List<ItemDescriptionVo> itemDescriptionList);

    /**
     * 保存其他列表信息(包括前言和附录等)
     * @param otherList
     */
    void saveOther(List<OtherVo> otherList);
}
