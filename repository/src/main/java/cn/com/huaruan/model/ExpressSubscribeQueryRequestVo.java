package cn.com.huaruan.model;

import lombok.Data;

@Data
public class ExpressSubscribeQueryRequestVo {
    private String eBusinessId;
    private String updateTime;
    /**
     * 推送物流单号轨迹个数
     */
    private String count;
    /**
     * 推送物流单号轨迹集合
     */
    private String data;
}
