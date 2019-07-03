package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemVo implements Serializable {
    private String chapterId;
    private String nodeId;
    private String itemId;
    private String itemContent;
    private String itemDescription;
}
