package Thread_study02.Thread;
    /*
    线程的优先级1-10
static int
MAX_PRIORITY 10  线程可以具有的最高优先级。
static int
MIN_PRIORITY 1  线程可以具有的最低优先级。
static int
NORM_PRIORITY 5 分配给线程的默认优先级。
     */

public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyPriority mp=new MyPriority();
        Thread t1=new Thread(mp);
        t1.start();

    }

}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}