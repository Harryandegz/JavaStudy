package Thread_study02.Thread;
/*
线程不安全：数据有负数、相同
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        //一份资源
        UnsafeWeb12306 web=new UnsafeWeb12306();
        //多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"码磺").start();
    }
}

class UnsafeWeb12306 implements Runnable {
    private int ticketNums = 10;
    private boolean flag=true;
    public void run() {
        while (flag) {
            test();
        }
    }
    public void test(){
        if (ticketNums < 0) {
            flag=false;
            return;
        }
        //因为run方法不能对外抛出异常
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->>" + ticketNums--);
    }
}