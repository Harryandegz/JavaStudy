package cn.postman.collection;

import java.util.*;

public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer=new Timer();
        //执行安排
       // timer.schedule(new MyTask(),1000);//执行任务一次
        //timer.schedule(new MyTask(),10000,1000);//执行任务多次
        Calendar cal=new GregorianCalendar(2019,7,28,15,22,59);
        timer.schedule(new MyTask(),cal.getTime(),200);//指定时间

    }


}
//任务类
class MyTask extends TimerTask{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("放空大脑休息一会");
        }
        System.out.println("---end---");
    }
}
