package main.com.ch6.ex2;

public class Boat {
    private int length;
    public void setLength(int len) {
        length = len;
    }

    public int getLength(){
        return length;
    }

    public void move() {
        System.out.print("drift ");
    }
}
