package com.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TFR
 * @date 2018/2/2
 */
public class HttpClientTest {


    public static void main(String[] args) throws Exception {
        HttpClientTest test = new HttpClientTest();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", "123"));
        params.add(new BasicNameValuePair("password", "123"));
        test.postTest(params, "http:loclhost:8081/httpClientPost");
        /*Map<String, String> params = new HashMap();
        params.put("name","haha");
        params.put("password","123");
        String response = HttpClientUtil.doPost("http:loclhost:8081/httpClientPost",params);
        System.out.println(response);*/

    }

    public void postTest(List<NameValuePair> t, String url) throws Exception {
        //添加参数
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(t, "utf-8");

        // 一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
        // 二、读取数据超时：SocketTimeout-->指的是连接上一个url，获取response的返回等待时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        post.setConfig(requestConfig);
        HttpResponse response = client.execute(post);


        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = response.getEntity();
            String message = EntityUtils.toString(resEntity, "utf-8");
            System.out.println(message);
        } else {
            System.out.println("请求失败");
        }

    }
}
