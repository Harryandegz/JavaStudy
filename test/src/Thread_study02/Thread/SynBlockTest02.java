package Thread_study02.Thread;

import java.util.ArrayList;
import java.util.List;

public class SynBlockTest02 {
    public static void main(String[] args)throws InterruptedException {
        List<String> list=new ArrayList<String>();
        for(int i=0;i<1000;i++){
            new Thread(()->{
                //同步块
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(list.size());

    }

}
//账户
class Account{
    int money;//金额
    String name;//名称
    public Account(int money,String name){
        this.money=money;
        this.name=name;
    }
}
//模拟取款
class Drawing extends Thread {
    Account account;//取钱的账户
    int drawingMoney;//取的钱数
    int packetTotal;//口袋的总数

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money - drawingMoney < 0) {
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName() + "-->账户余额为" + account.money);
        System.out.println(this.getName() + "-->口袋的钱为" + packetTotal);
    }

}
