package cn.com.huaruan.utils;

import lombok.Data;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * http请求客户端
 */
@Data
public class HttpClient {
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求参数
     */
    private Map<String, String> params;
    private String xmlParam;
    /**
     * 返回的状态码
     */
    private int statusCode;
    /**
     * 响应内容
     */
    private String content;
    /**
     * 是否为https协议类型
     */
    private boolean isHttps;

    public HttpClient(String url, Map<String, String> param) {
        this.url = url;
        this.params = param;
    }

    public HttpClient(String url) {
        this.url = url;
    }

    public void addParameter(String key, String value) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put(key, value);
    }

    public void post() throws IOException {
        HttpPost http = new HttpPost(url);
        setEntity(http);
        execute(http);
    }

    public void put() throws IOException {
        HttpPut http = new HttpPut(url);
        setEntity(http);
        execute(http);
    }

    public void get() throws IOException {
        if (params != null) {
            StringBuilder requestUrl = new StringBuilder(this.url);
            boolean isFirst = true;
            for (Map.Entry<String, String> param : params.entrySet()) {
                if (isFirst){
                    requestUrl.append("?");
                    isFirst = false;
                }else {
                    requestUrl.append("&");
                }
                requestUrl.append(param.getKey()).append("=").append(param.getValue());
                this.url = requestUrl.toString();
            }
        }
        HttpGet http = new HttpGet(url);
        execute(http);
    }

    /**
     * set http post,put param
     */
    private void setEntity(HttpEntityEnclosingRequestBase http) {
        if (params != null) {
            List<NameValuePair> nvps = new LinkedList<>();
            for (Map.Entry<String, String> param : params.entrySet()) {
                // 添加参数
                nvps.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }
            // 设置参数
            http.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        }
        if (xmlParam != null) {
            http.setEntity(new StringEntity(xmlParam, Consts.UTF_8));
        }
    }

    private void execute(HttpUriRequest http) {
        CloseableHttpClient httpClient = null;
        try {
            if (isHttps) {
                // 信任所有
                SSLContext sslContext = new SSLContextBuilder()
                        .loadTrustMaterial(null, (TrustStrategy) (chain, authType) -> true).build();
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
                httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            } else {
                httpClient = HttpClients.createDefault();
            }
            CloseableHttpResponse response = httpClient.execute(http);
            try {
                if (response != null) {
                    if (response.getStatusLine() != null) {
                        statusCode = response.getStatusLine().getStatusCode();
                    }
                    HttpEntity entity = response.getEntity();
                    // 响应内容
                    content = EntityUtils.toString(entity, Consts.UTF_8);
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
