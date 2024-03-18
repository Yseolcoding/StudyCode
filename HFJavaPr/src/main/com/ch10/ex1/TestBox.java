package main.com.ch10.ex1;

/*
    p.335 쓰면서 제대로 공부하기 예시
 */
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

/*
    결과 : Integer 값이 null일 경우 int에 대입되지 않고 에러가 발생한다.
 */