package cn.com.huaruan.model;

import lombok.Data;

@Data
public class ExpressSubscribeQueryResponseVo {
    private String eBusinessId;
    private String updateTime;
    /**
     * 成功与否：true，false
     */
    private Boolean succeed;
    /**
     * 失败原因
     */
    private String reason;
}
