package com.postman.cooperation;
/*
协作模型：生产者消费者实现方式一：管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for(int i=0;i<100;i++){
        container.push(new Streambun(i));
        }
    }
}
//消费者
class Consumer  extends Thread{
    SynContainer container;
    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for(int i=0;i<100;i++){
            System.out.println("消费-->第"+container.pop().id+"个馒头");
        }
    }
}
//缓冲区
class SynContainer{
    Streambun[] buns=new Streambun[10];
    int count=0;//计数器
    //存储 生产
    public synchronized void push(Streambun bun){
        //何时能生产 容器存在空间
        //不能生产 只有等待
        if(count==buns.length){

            try {
                this.wait();//线程阻塞，消费者通知生产解除
            } catch (InterruptedException e) {

            }
        }
        //存在空间 可以生产
        buns[count]=bun;
        count++;
        //存在数据了，可以通知消费了
        this.notifyAll();
    }
    //获取 消费
    public synchronized Streambun pop(){
        //何时消费 容器中是否存在数据
        //没有数据 只有等待
        if(count==0){
            try {
                this.wait();//线程阻塞 生产者通知消费解除阻塞
            } catch (InterruptedException e) {

            }
        }
        //存在数据可以消费
      count--;
      Streambun bun=buns[count];
      this.notifyAll();//存在空间了，可以唤醒对方生产了
      return bun;
    }
}
//馒头
class Streambun{
    int id;

    public Streambun(int id) {
        this.id = id;
    }
}
