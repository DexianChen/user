package cn.com.huaruan.service;


import cn.com.huaruan.model.ExpressQueryRequestVo;
import cn.com.huaruan.model.ExpressSubscribeQueryRequestVo;
import cn.com.huaruan.model.ExpressSubscribeRequestVo;
import cn.com.huaruan.model.ResultVo;

/**
 * 快递鸟service
 */
public interface KdniaoService {
    /**
     * 查询接口
     * 物流查询API提供实时查询物流轨迹的服务，用户提供运单号和快递公司，即可查询当前时刻的最新物流轨迹。
     * @param requestVo 请求内容,包括以下字段
     * OrderCode	String	订单编号	O
     * ShipperCode	String	快递公司编码	R
     * LogisticCode	String	物流单号    R
     * @return
     */
    ResultVo expressQuery(ExpressQueryRequestVo requestVo);

    /**
     * 订阅接口
     * 物流追踪API提供物流订单监控服务，用户将订单内容订阅到快递鸟后，快递鸟对订单进行实时监控。
     * 当物流轨迹有更新时，实时获取数据，对数据进行格式化，计算运单预计到达时间、全流程的物流状态、当前所在城市等数据后，
     * 推送给用户。监控直到订单签收后结束。
     * @param requestVo
     * @return
     */
    ResultVo expressSubscribe(ExpressSubscribeRequestVo requestVo);

    /**
     * 推送接口
     * 订阅查询结果（RequestType：101）
     * 通过轨迹查询（订阅查询）接口订阅到快递鸟的数据，快递鸟推送时，会将推送的RequestType的值置为101，同时返回下列数据
     * @param requestVo
     * @return
     */
    ResultVo subscribeQuery(ExpressSubscribeQueryRequestVo requestVo);
}
