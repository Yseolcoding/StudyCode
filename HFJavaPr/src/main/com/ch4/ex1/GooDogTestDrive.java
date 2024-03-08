package main.com.ch4.ex1;

/*
    p.124 예제 실습
 */
public class GooDogTestDrive {
    public static void main(String[] args) {

        GoodDog one = new GoodDog();
        GoodDog two = new GoodDog();
        System.out.println("Dog one : " + one.getSize());
        System.out.println("Dog two : " + two.getSize());
        one.bark();
        two.bark();
        System.out.println(one.equals(two));
    }
}
