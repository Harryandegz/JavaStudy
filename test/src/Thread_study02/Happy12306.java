package Thread_study02;
/*
快乐火车票
 */


public class Happy12306 {
    public static void main(String[] args) {
        Web12306 c=new Web12306(20,"happy");
        new Passenger(c,"lg",2).start();
        new Passenger(c,"lp",1).start();

    }
}
//乘客
class Passenger extends Thread{//做成代理
    int seats;
    public Passenger(Runnable target,String name,int seats){
        super(target,name);//延续父类的构造器，同时加入属性
        this.seats = seats;
    }

}
//火车票网
class Web12306 implements Runnable{
    int available;//可用的位置
    String name;//名称
    public Web12306(int available,String name){
        this.available=available;
        this.name=name;
    }
    public void run() {
            Passenger p=(Passenger)Thread.currentThread();//强制类型转换，知道哪个乘客在使用
            boolean flag=this.bookTickets(p.seats);
            if(flag){
                System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置为"+p.seats);}
            else {
                System.out.println("出票失败"+Thread.currentThread().getName()+"-<位置不够");
            }
        }

    //购票
    public synchronized boolean bookTickets(int seats){
        System.out.println("可用位置为："+available);
        if(seats>available){
            return false;
        }
        available-=seats;
        return true;
    }
}
