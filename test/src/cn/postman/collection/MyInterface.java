package cn.postman.collection;

public interface MyInterface {
        int MAX_AGE=100;
        public abstract void test();
}
class MyClass implements MyInterface{
    @Override
    public void test() {
        System.out.println(MAX_AGE);
        System.out.println("MyClass.test");
    }
}