package cn.com.huaruan.service.impl;

import cn.com.huaruan.model.ChapterVo;
import cn.com.huaruan.model.ItemDescriptionVo;
import cn.com.huaruan.model.ItemVo;
import cn.com.huaruan.model.NodeVo;
import cn.com.huaruan.service.BookService;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void saveChapter(List<ChapterVo> chapterList) {
        // 用去去重，但这么写不太好 TODO
        HashSet<ChapterVo> chapterVoSet = new HashSet<>();
        // 去重后的新集合
        ArrayList<ChapterVo> chapterVos = new ArrayList<>();

        for (ChapterVo chapterVo : chapterList) {
            boolean duplicate = chapterVoSet.add(chapterVo);

            if (duplicate){
                chapterVos.add(chapterVo);
            }
        }

//        for (ChapterVo chapterVo : chapterVos) {
//            System.out.println(chapterVo);
//        }
    }

    @Override
    public void saveNode(List<NodeVo> nodeList) {
        // 用去去重，但这么写不太好 TODO
        HashSet<NodeVo> nodeVoSet = new HashSet<>();
        // 去重后的新集合
        ArrayList<NodeVo> nodeVos = new ArrayList<>();

        for (NodeVo nodeVo : nodeList) {
            boolean duplicate = nodeVoSet.add(nodeVo);

            if (duplicate){
                nodeVos.add(nodeVo);
            }
        }

        for (NodeVo nodeVo : nodeVos) {
            System.out.println(nodeVo);
        }
    }

    @Override
    public void saveItem(List<ItemVo> itemList, List<ItemDescriptionVo> itemDescriptionList) {
        // 用去去重，但这么写不太好 TODO
        HashSet<ItemVo> itemVoSet = new HashSet<>();
        // 去重后的新集合
        ArrayList<ItemVo> itemVos = new ArrayList<>();

        for (ItemVo itemVo : itemList) {
            boolean duplicate = itemVoSet.add(itemVo);

            if (duplicate){
                ItemVo completeItemVo = buildItem(itemVo, itemDescriptionList);
                itemVos.add(completeItemVo);
//                System.out.println(itemVo.getItemId() + "-->" +itemVo.getItemDescription() + "-->" + completeItemVo.getItemDescription());
            }
        }

        for (ItemVo itemVo : itemVos) {
//            System.out.println(itemVo);
        }
    }

    private ItemVo buildItem(ItemVo itemVo, List<ItemDescriptionVo> itemDescriptionList) {
        for (ItemDescriptionVo itemDescriptionVo : itemDescriptionList) {
            boolean matching = itemDescriptionVo.getId().contains(itemVo.getItemId());
            if (matching){
                itemVo.setItemDescription(itemDescriptionVo.getDescription());
                return itemVo;
            }
        }
        return itemVo;
    }
}
