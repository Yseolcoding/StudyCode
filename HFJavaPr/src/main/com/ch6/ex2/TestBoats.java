package main.com.ch6.ex2;
/*
    p.238 수영장 퍼즐
 */
public class TestBoats {
    public static void main(String[] args) {

        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();

        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }
}

