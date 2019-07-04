package cn.com.huaruan.service.impl;

import cn.com.huaruan.model.*;
import cn.com.huaruan.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void saveChapter(List<ChapterVo> chapterList) {

    }

    @Override
    public void saveNode(List<NodeVo> nodeList) {

    }

    @Override
    public void saveItem(List<ItemVo> itemList, List<ItemDescriptionVo> itemDescriptionList) {
        List<ItemVo> completeItemList = buildItem(itemList, itemDescriptionList);
        for (ItemVo itemVo : completeItemList) {
            System.out.println(itemVo.toString());
        }
    }

    @Override
    public void saveOther(List<OtherVo> otherList) {
//        for (OtherVo otherVo : otherList) {
//            System.out.println(otherVo.toString());
//        }
    }

    /**
     * 将条文说明列表信息插入到条文列表信息中，构建完整的条文列表信息
     * @param itemList
     * @param itemDescriptionList
     * @return
     */
    private List<ItemVo> buildItem(List<ItemVo> itemList, List<ItemDescriptionVo> itemDescriptionList) {
        for (ItemDescriptionVo itemDescriptionVo : itemDescriptionList) {
            for (ItemVo itemVo : itemList) {
                boolean matching = itemDescriptionVo.getId().contains(itemVo.getItemId()) || itemVo.getItemId().contains(itemDescriptionVo.getId());
                if (matching) {
                    itemVo.setItemDescription(itemDescriptionVo.getDescription());
                    //匹配则跳出本循环
                    break;
                }
            }
        }
        return itemList;
    }
}
