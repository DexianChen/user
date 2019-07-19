package cn.com.huaruan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExpressSubscribeQueryRequestVo {
    @JsonProperty("EBusinessID")
    private String eBusinessId;
    @JsonProperty("PushTime")
    private String pushTime;
    /**
     * 推送物流单号轨迹个数
     */
    @JsonProperty("Count")
    private String count;
    /**
     * 推送物流单号轨迹集合
     */
    @JsonProperty("Data")
    private ExpressSubscribeQueryData[] data;
}

/**
 * 推送物流单号轨迹集合
 */
@Data
class ExpressSubscribeQueryData {
    @JsonProperty("EBusinessID")
    private String eBusinessId;
    @JsonProperty("ShipperCode")
    private String shipperCode;
    @JsonProperty("LogisticCode")
    private String logisticCode;
    @JsonProperty("Success")
    private Boolean success;
    @JsonProperty("Reason")
    private String reason;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("CallBack")
    private String callBack;
    @JsonProperty("Traces")
    private ExpressTrace[] traces;
    @JsonProperty("EstimatedDeliveryTime")
    private String estimatedDeliveryTime;
}

/**
 * 快递轨迹
 */
@Data
class ExpressTrace {
    @JsonProperty("AcceptTime")
    private String acceptTime;
    @JsonProperty("AcceptStation")
    private String acceptStation;
    @JsonProperty("Remark")
    private String remark;
}