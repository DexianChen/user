package cn.com.huaruan.service;

import cn.com.huaruan.model.ChapterVo;
import cn.com.huaruan.model.ItemDescriptionVo;
import cn.com.huaruan.model.ItemVo;
import cn.com.huaruan.model.NodeVo;

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
}
