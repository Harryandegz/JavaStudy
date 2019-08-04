package cn.postman.collection;

import java.util.ArrayList;

/*
测试collection接口中的方法
 */
public class TestList {
    public static void main(String[] args) {
        ArrayList<String> c=new ArrayList<String>();
        c.add("sss");
        c.add("omg");
        System.out.println(c.contains("AG"));
        System.out.println(c.size());
        c.remove("sss");
        System.out.println(c.size());
        Object[] objs=c.toArray();
        System.out.println(c);

    }

}
