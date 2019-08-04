/*
lambda推导
 */


public class LambdaTest01 {
    //内部类
   static class Like2 implements ILike{
        public void lambda(){
            System.out.println("i like lambda2");
        }

    }

    public static void main(String[] args) {
        ILike like=new Like();
        like.lambda();
        like=new Like2();
        like.lambda();
        //方法内部类
        class Like3 implements ILike{
            public void lambda(){
                System.out.println("i like lambda3");
            }

        }
        like=new Like3();
        like.lambda();
        //匿名内部类
        like=new ILike() {
            @Override
            public void lambda() {

                System.out.println("i like lambda4");
            }
        };
        like.lambda();
        //lambda
        like=()->{
                System.out.println("i like lambda5");
        };
        like.lambda();
        /*
        lambda推导必须存在类型

         */
    }
}
interface ILike{
    void lambda();

}
//外部类
class Like implements ILike{
    public void lambda(){
        System.out.println("i like lambda");
    }

}
