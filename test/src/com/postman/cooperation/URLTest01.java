package com.postman.cooperation;

import java.net.MalformedURLException;
import java.net.URL;

/*
*URL:统一资源定位器，互联网的三大基石之一（HTML HTTP），区分资源
* 1.协议
* 2.域名、计算机
* 3.端口：默认80
* 4.请求资源
*https://read.qidian.com/chapter/nXGK6zq3QBDhI-Ha6N4TBg2/q-Q9jRNkrdtp4rPq4Fd4KQ2
*
*
*@author
 */
public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("https://www.iqiyi.com/v_19rs0ayp6w.html?vfrm=pcw_home&vfrmblk=B&vfrmrst=fcs_0_p15");
        //获取四个值
        System.out.println("协议"+url.getProtocol());
        System.out.println("域名|IP|主机名"+url.getHost());
        System.out.println("端口"+url.getPort());
        System.out.println("请求资源"+url.getFile());
        System.out.println("请求资源"+url.getPath());
        //参数
        System.out.println("参数"+url.getQuery());
        //锚点
        System.out.println("锚点"+url.getRef());


    }

}
