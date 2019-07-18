package cn.com.huaruan.controller;

import cn.com.huaruan.model.ExpressQueryRequestVo;
import cn.com.huaruan.model.ExpressSubscribeRequestVo;
import cn.com.huaruan.model.ResultVo;
import cn.com.huaruan.model.ExpressSubscribeQueryRequestVo;
import cn.com.huaruan.service.KdniaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OmsPortalOrderExpressController {
    @Autowired
    private KdniaoService kdniaoService;

    @ApiOperation("快递鸟即时查询接口")
    @RequestMapping(value = "/expressQuery", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo expressQuery(@RequestBody ExpressQueryRequestVo requestVo) {
        return kdniaoService.expressQuery(requestVo);
    }

    @ApiOperation("快递鸟物流追踪接口")
    @RequestMapping(value = "/expressSubscribe", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo expressSubscribe(@RequestBody ExpressSubscribeRequestVo requestVo) {
        return kdniaoService.expressSubscribe(requestVo);
    }

    @ApiOperation("快递鸟物流推送接口")
    @RequestMapping(value = "/subscribeQuery", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo subscribeQuery(@RequestBody ExpressSubscribeQueryRequestVo requestVo) {
        return kdniaoService.subscribeQuery(requestVo);
    }
}
