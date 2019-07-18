package cn.com.huaruan.model;

import lombok.Data;

@Data
public class ExpressQueryRequestVo {
    /**
     * 订单编号, 非必须
     */
    private String orderCode;
    /**
     * 快递公司编码
     */
     private String shipperCode;
    /**
     * 物流单号
     */
     private String logisticCode;
}
