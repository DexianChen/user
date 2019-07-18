package cn.com.huaruan.service.impl;


import cn.com.huaruan.model.*;
import cn.com.huaruan.service.KdniaoService;
import cn.com.huaruan.utils.HttpClient;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class KdniaoServiceImpl implements KdniaoService {
    @Value("${kdniao.eBusinessId}")
    private String eBusinessId;
    @Value("${kdniao.appKey}")
    private String appKey;
    @Value("${kdniao.expressQueryReqUrl}")
    private String expressQueryReqUrl;
    @Value("${kdniao.expressSubscribeReqUrl}")
    private String expressSubscribeReqUrl;
    @Value("${kdniao.subscribeQueryReqUrl}")
    private String subscribeQueryReqUrl;

    @Override
    public ResultVo expressQuery(ExpressQueryRequestVo requestVo) {
        try {
            String requestData = JSONObject.toJSONString(requestVo);

            Map<String, String> params = buildRequestParams(requestData, "1002", "2");

            String content = invokeKdniaoAPI(expressQueryReqUrl, params);

//            Map<String, String> resultMap = JSONObject.parseObject(content, Map.class);
//            String logisticCode = resultMap.get("LogisticCode");
//            String shipperCode = resultMap.get("ShipperCode");
//            String traces = resultMap.get("Traces");
//            JSONArray jsonArray = JSONArray.parseArray(traces);
//            System.out.println("快递单号：" + logisticCode);
//            System.out.println("快递公司编码：" + shipperCode);
//            System.out.println("物流信息：");
//            for (Object o : jsonArray) {
//
//            }
            System.out.println(content);

            return new ResultVo(true, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo(true, null);
    }

    @Override
    public ResultVo expressSubscribe(ExpressSubscribeRequestVo requestVo) {
        try {
            String requestData = JSONObject.toJSONString(requestVo);

            Map<String, String> params = buildRequestParams(requestData, "1008", "2");

            String content = invokeKdniaoAPI(expressSubscribeReqUrl, params);

            System.out.println(content);

            return new ResultVo(true, content);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo(true, null);
    }

    @Override
    public ResultVo subscribeQuery(ExpressSubscribeQueryRequestVo requestVo) {
        System.out.println(requestVo.toString());

        ExpressSubscribeQueryResponseVo responseVo = new ExpressSubscribeQueryResponseVo();
        responseVo.setEBusinessId(eBusinessId);
        responseVo.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return null;
    }

    /**
     * 调用快递鸟API
     * @param requestUrl 请求地址
     * @param params 请求参数
     * @return 相应内容
     */
    private String invokeKdniaoAPI(String requestUrl, Map<String, String> params) throws IOException {
        HttpClient httpClient = new HttpClient(requestUrl);
        httpClient.setParams(params);
        httpClient.setHttps(false);
        httpClient.post();
        return httpClient.getContent();
    }

    /**
     * 构建请求参数
     * @param requestData 请求内容
     * @param requestType 请求指令类型：1002-即时查询，1008-追踪订阅
     * @param dataType 请求、返回数据类型：2-json
     * @return 含有参数的map集合
     */
    private Map<String, String> buildRequestParams(String requestData, String requestType, String dataType)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        HashMap<String, String> params = new HashMap<>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", eBusinessId);
        params.put("RequestType", requestType);
        String dataSign=encrypt(requestData, appKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", dataType);

        return params;
    }

    /**
     * MD5加密
     * @param str 内容
     * @param charset 编码方式
     * @throws Exception
     */
    @SuppressWarnings("unused")
    private String MD5(String str, String charset) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (byte b : result) {
            int val = b & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * base64编码
     * @param str 内容
     * @param charset 编码方式
     * @throws UnsupportedEncodingException
     */
    private String base64(String str, String charset) throws UnsupportedEncodingException{
        String encoded = base64Encode(str.getBytes(charset));
        return encoded;
    }

    @SuppressWarnings("unused")
    private String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
        String result = URLEncoder.encode(str, charset);
        return result;
    }

    /**
     * 电商Sign签名生成
     * @param content 内容
     * @param keyValue Appkey
     * @param charset 编码方式
     * @throws UnsupportedEncodingException ,Exception
     * @return DataSign签名
     */
    @SuppressWarnings("unused")
    private String encrypt (String content, String keyValue, String charset)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (keyValue != null)
        {
            return base64(MD5(content + keyValue, charset), charset);
        }
        return base64(MD5(content, charset), charset);
    }

    private static char[] base64EncodeChars = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/' };

    private static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }
}
