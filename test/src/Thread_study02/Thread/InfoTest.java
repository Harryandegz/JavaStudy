package Thread_study02.Thread;
/*
其他方法
isAlive:表示线程是否还活着
Thread.currentThread():当前线程
setName、getName：代理名称

 */
public class InfoTest {
    public static void main(String[] args) throws InterruptedException{
        System.out.println(Thread.currentThread().isAlive());

        //设置名称：真实角色
        Myinfo info=new Myinfo("战斗机");
        Thread t=new Thread(info);
        t.setName("公鸡");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}
class Myinfo implements Runnable{
    private String name;
    public Myinfo(String name){
        this.name=name;

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+name);
    }
}