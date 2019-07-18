package cn.com.huaruan.model;

import lombok.Data;

import java.util.List;

@Data
public class ExpressSubscribeRequestVo {
//    private String orderCode;
    private String shipperCode;
    private String logisticCode;
//    private Integer payType;
//    private Integer expType;
//    private String customerName;
//    private String customerPwd;
//    private String monthCode;
//    private Integer isNotice;
//    private Double cost;
//    private Double otherCost;
    private ExpressSubscribeSender sender;
    private ExpressSubscribeReceiver receiver;
//    private ExpressSubscribeCommodity[] commodity;
//    private Double weight;
//    private Integer quantity;
//    private Double volume;
//    private String remark;
}
