package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class NodeVo implements Serializable {
    private String chapterId;
    private String nodeId;
    private String nodeTitle;
}
