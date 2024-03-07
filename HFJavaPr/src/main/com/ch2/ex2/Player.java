package main.com.ch2.ex2;

public class Player {

    // Player가 추측한 숫자를 저장할 변수
    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("추측한 숫자 : " + number);
    }
}
