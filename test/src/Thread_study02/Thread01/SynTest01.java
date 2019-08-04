package Thread_study02.Thread01;

/*
线程安全：在并发时保证数据的正确性、效率尽可能高
synchronized
1、同步方法
2、同步块
 */
public class SynTest01 {
    public static void main(String[] args) {
        //一份资源
       SynWeb12306 web=new SynWeb12306();
        //多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"码磺").start();
    }
}

class SynWeb12306 implements Runnable {
    private int ticketNums = 10;
    private boolean flag=true;
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test5();
        }
    }
    //线程安全：尽可能锁定合理的范围（不是指代码 指的是数据的完整性）
    //double checking
    public void test5(){
        if (ticketNums <= 0) {//考虑的是没有票的情况
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNums <= 0) {//考虑最后的一张票
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->>" + ticketNums--);
        }
    }
    //线程不安全 范围太小锁不住
    public void test4(){
        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->>" + ticketNums--);

    }
    //线程不安全锁定失败 ticketNums对象在变 下面test锁定this的地址是没有变化的
    public void test3(){
        synchronized ((Integer)ticketNums) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->>" + ticketNums--);
        }
    }
    //线程安全 范围太大-->效率低下
    public void test2(){
        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->>" + ticketNums--);
        }
    }
}
