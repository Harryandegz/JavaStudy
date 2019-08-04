public class LambdaThread {
    static class Test implements Runnable{
        public void run(){
            for (int i=0;i<=20;i++) {
                System.out.println("一边听歌");
            }
        }
    }

}
