package main.com.ch10.ex1;

public class TestBox {
    private Integer i;
    private int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }

    public void go(){
        j=i;
        System.out.println(j);
        System.out.println(i);
    }
}
