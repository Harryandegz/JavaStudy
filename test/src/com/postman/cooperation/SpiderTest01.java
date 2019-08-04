package com.postman.cooperation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
*
* 网络爬虫的原理
*
 */
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
        //获取URL
        //URL url=new URL("https://www.jd.com/2019");
        URL url=new URL("https://www.dianping.com");
        //下载资源
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        //模拟浏览器的get请求(骗过服务器)
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134");
        InputStream is=url.openStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String msg=null;
        while(null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理

    }
}
