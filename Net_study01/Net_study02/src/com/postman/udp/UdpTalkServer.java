package com.postman.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中。。。");
        //1.使用DatagramSocket 制定端口 创建接收端
        DatagramSocket server=new DatagramSocket(9999);
        //2.准备容器 封装成DatagramPacket包裹
        byte[] container=new byte[1024*60];
        DatagramPacket packet=new DatagramPacket(container,0,container.length);
        //3.阻塞式接受包裹receive（datagrampacket p）
        server.receive(packet);//阻塞式
        //4.分析数据
        //byte[] getData();
        //getLength()
        byte[] datas=packet.getData();
        int len=packet.getLength();
        System.out.println(new String(datas,0,len));
        //5.释放资源
        server.close();
    }
}
