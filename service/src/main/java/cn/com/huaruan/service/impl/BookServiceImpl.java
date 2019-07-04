package cn.com.huaruan.service.impl;

import cn.com.huaruan.mapper.BookMapper;
import cn.com.huaruan.model.*;
import cn.com.huaruan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void saveChapter(List<ChapterVo> chapterList) {
//        bookMapper.saveChapter(chapterList);
    }

    @Override
    public void saveNode(List<NodeVo> nodeList) {
        bookMapper.saveNode(nodeList);
    }

    @Override
    public void saveItem(List<ItemVo> itemList, List<ItemDescriptionVo> itemDescriptionList) {
        List<ItemVo> completeItemList = buildItem(itemList, itemDescriptionList);
//        bookMapper.saveItem(completeItemList);
    }

    @Override
    public void saveOther(List<OtherVo> otherList) {
//        bookMapper.saveOther(otherList);
    }

    /**
     * 将条文说明列表信息插入到条文列表信息中，构建完整的条文列表信息
     *
     * @param itemList
     * @param itemDescriptionList
     * @return
     */
    private List<ItemVo> buildItem(List<ItemVo> itemList, List<ItemDescriptionVo> itemDescriptionList) {
        for (ItemDescriptionVo itemDescriptionVo : itemDescriptionList) {
            for (ItemVo itemVo : itemList) {
                boolean matching = itemDescriptionVo.getId().trim().equals(itemVo.getItemId().trim());
                if (matching) {
                    itemVo.setItemDescription(itemDescriptionVo.getDescription());
                    //匹配则跳出本循环
                    break;
                } else {
                    // 特殊处理
                    switch (itemDescriptionVo.getId().trim()) {
                        case "3．0．1、3．0．2":
                            if (itemVo.getItemId().trim().equals("3．0．1")) {
                                itemVo.setItemDescription(itemDescriptionVo.getDescription());
                                break;
                            }
                        case "5．0．10、5．0．11":
                            if (itemVo.getItemId().trim().equals("5．0．10")) {
                                itemVo.setItemDescription(itemDescriptionVo.getDescription());
                                break;
                            }
                        case "7．1．6、7．1．7":
                            if (itemVo.getItemId().trim().equals("7．1．6")) {
                                itemVo.setItemDescription(itemDescriptionVo.getDescription());
                                break;
                            }
                        case "7．2．6、7．2．7":
                            if (itemVo.getItemId().trim().equals("7．2．6")) {
                                itemVo.setItemDescription(itemDescriptionVo.getDescription());
                                break;
                            }
                        case "8．0．8、8．0．9":
                            if (itemVo.getItemId().trim().equals("8．0．8")) {
                                itemVo.setItemDescription(itemDescriptionVo.getDescription());
                                break;
                            }
                        case "11．0．1～11．0．3":
                            if (itemVo.getItemId().trim().equals("11．0．1")) {
                                itemVo.setItemDescription(itemDescriptionVo.getDescription());
                                break;
                            }
                    }
                }
            }

        }
        return itemList;
    }
}
