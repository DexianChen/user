package com.exc.model;


import java.io.Serializable;

/**
 * @author cdx
 * date 2020-02-18
 * 请求实体类
 */
public class RequestParamVo implements Serializable {
    private static final long serialVersionUID = -2844671755624013656L;

    /**
     * 菜式名称
     */
    private String name;

    /**
     * 味道, 1-酸,2-甜,3-苦,4-辣,5-咸
     */
    private Integer[] taste;

    /**
     * 分类, 1-美味主食,2-休闲小吃,3-浓郁靓汤,4-精致甜品,5-健康调味
     */
    private String category;

    /**
     * 菜谱图片
     */
    private String pictureUrl;

    /**
     * 做法步骤
     */
    private String step;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 评价内容
     */
    private String evaluateContent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getTaste() {
        return taste;
    }

    public void setTaste(Integer[] taste) {
        this.taste = taste;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }
}
