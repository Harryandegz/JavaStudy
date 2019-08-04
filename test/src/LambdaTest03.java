/*
lambda推导+带返回值
 */



public class LambdaTest03 {
    public static void main(String[] args) {
        IInterest interest=(int a,int c )-> {
            System.out.println("i like lambda-->"+ (a+c));
            return a+c;
        };
        interest.lambda(100,200);
        //简化
         interest=( a, c )-> {
            System.out.println("i like lambda-->"+ (a+c));
            return a+c;
        };
        interest.lambda(200,200);

    }
    interface IInterest{
        int lambda(int a,int b);
    }
    //外部类
    class Interest  implements IInterest {
        public int lambda(int a,int c ) {
            System.out.println("i like lambda-->"+ (a+c));
            return a+c;
        }

    }
}
