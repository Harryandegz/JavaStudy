package Thread_study02.Thread;
/*
守护线程：守护线程是为用户线程服务的；JVM停止不用等待守护线程执行完毕
默认情况下线程都是用户线程，JVM等待所有的用户线程执行完毕才会停止
 */

public class DaemonTest {
    public static void main(String[] args) {
        God god=new God();//角色
        You you=new You();//代理
     Thread t=new Thread(god);
     t.setDaemon(true);//将用户线程调整为守护
     t.start();
     new Thread(you).start();
    }
}
class You implements Runnable{
    @Override
    public void run() {
        for (int i=1;i<=365*100;i++){
            System.out.println("happy life ...");
        }
        System.out.println("......");
    }
}
class God implements Runnable{
    @Override
    public void run() {
        for(;true;){
            System.out.println("bless you...");
        }
    }
}
