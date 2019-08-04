package com.postman.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
*飞机游戏的主窗口
* @author postman
* @date 2019.07.25
 */
public class MyGameFrame extends JFrame {
    /*
    *初始化窗口
     */
    Image plane=GameUtil.getImage("images/plane.jpg");
    Image bg=GameUtil.getImage("images/bg.jpg");
    int planeX=250,planeY=250;
    @Override
    public void paint(Graphics g) {//自动被调用  g相当于一支画笔
      g.drawImage(bg,0,0,null);
      g.drawImage(plane,planeX,planeY,null);
      planeX++;planeY++;
    }
   //因为要使用该类内部的方法这里使用一个内部类,
    //帮助我们反复重画窗口！
    class PaintThread extends Thread{
       @Override
       public void run() {
        while(true){
            System.out.println("窗口画一次");
            repaint();//重画
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       }
   }
    public void launchFrame(){
        this.setTitle("飞机游戏作品");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(300,300);
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }
        });
        new PaintThread().start();//启动重画窗口的线程
    }

    public static void main(String[] args) {
        MyGameFrame f=new MyGameFrame();
        f.launchFrame();
    }
}
