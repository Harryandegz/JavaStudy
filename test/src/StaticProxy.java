/*
静态代理
公共接口：
1.真实角色
2.代理角色
 */


public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();

       //new Thread(线程对象).start();
    }
}
interface Marry{
    void happyMarry();
}
//真实角色
class You implements Marry{
    public void happyMarry(){
        System.out.println("you and 嫦娥终于奔月了 这是角色重写接口中的方法");
    }
}
//代理角色
class WeddingCompany implements Marry{
    //真实角色
    private Marry target;//不是很搞得懂这个marry是个什么类型
    public WeddingCompany(Marry target){
        this.target=target;
    }
    public void happyMarry(){
        ready();
    this.target.happyMarry();
        after();
    }
    private void ready(){
        System.out.println("布置猪窝。。。");
    }
    private void after(){
        System.out.println("闹玉兔。。。");

    }
}