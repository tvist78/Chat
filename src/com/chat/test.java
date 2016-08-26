package com.chat;

/**
 * Created by tvist on 14.05.2016.
 */
public class test {
    private int id;
    private static  int nextid = 1;

    public void set(){
    id = nextid;
        nextid++;
    }

    public  int getId(){
        return id;
    }

    public static int getNextid(){
        return nextid;
    }

    public static void main(String[] args){
    test one = new test();
        test two = new test();
        test three = new test();
        one.set();
        two.set();
        three.set();
        System.out.println(one.getId() + "   " + test.getNextid());
        System.out.println(two.getId() + "   " + test.getNextid());
        System.out.println(three.getId() + "   " + test.getNextid());
    }

}
