/*
join 合并线程，插队线程
 */

package Thread_study02.Thread;

public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{for(int i=0;i<100;i++){
            System.out.println("lambda..."+i);
        }
        });
        t.start();
        for(int i=0;i<100;i++){
            if(i==20){
               t.join();//插队 main被阻塞了
            }
            System.out.println("main..."+i);
        }
    }
}
