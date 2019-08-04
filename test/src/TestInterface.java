
/*
测试接口和实现类
 */

public class TestInterface {
    public static void main(String[] args) {

    }
}
//飞行接口
interface Volant{
    int FLY_HEIGHT=1000;
    void fly();
}
//善良接口
interface Honest{
    void helpOther();
}
class Angel implements Volant,Honest{//实现类可以实现多个父接口


    @Override
    public void helpOther() {
        System.out.println("angel.helpother()");
    }

    @Override
    public void fly() {
        System.out.println("angel.fly()");
    }
}