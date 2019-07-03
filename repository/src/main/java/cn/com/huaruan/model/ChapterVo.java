package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChapterVo implements Serializable {
    private String chapterId;
    private String chapterTitle;
}
