package cn.com.huaruan.service;

import cn.com.huaruan.model.ChapterVo;
import cn.com.huaruan.model.ItemDescriptionVo;
import cn.com.huaruan.model.ItemVo;
import cn.com.huaruan.model.NodeVo;

import java.util.List;

public interface BookService {

    void saveChapter(List<ChapterVo> chapterList);

    void saveNode(List<NodeVo> nodeList);

    void saveItem(List<ItemVo> itemList, List<ItemDescriptionVo> itemDescriptionList);
}
