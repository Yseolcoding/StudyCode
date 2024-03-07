package main.com.ch2.ex1;

/*
    p. 78 객체 관련 예제
 */
public class DogTestDrive {
    public static void main(String[] args) {

        // Dog 객체 생성
        Dog d = new Dog();
        // 점 연산자(.)를 써서 Dog의 크기를 설정합니다.
        d.size = 40;
        // bark() 메서드 호출
        d.bark();
    }
}
