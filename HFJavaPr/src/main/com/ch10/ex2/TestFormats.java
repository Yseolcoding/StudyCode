package main.com.ch10.ex2;

/*
    p.338 숫자 포매팅 예시
 */
public class TestFormats {
    public static void main(String[] args) {
        long myBillion = 1_000_000_000L;
        String s = String.format("%,d", myBillion);
        System.out.println(s);
    }
}

/*
    예시 오류 코멘트 :
    예시에는
    long myBillion = 1_000_0000_000;
    값이 주어졌는데, 이대로 컴파일 할 경우, 컴파일 오류가 발생했다.
    "java: integer number too large"
    확인해보니 Java에서 리터럴 숫자 값은 기본적으로 "int"로 처리되기 때문이다.

    해결방법 :
    long myBillion = 1_000_0000_000L;
    숫자 뒤에 L 또는 l을 붙여 이 숫자의 타입이 long 타입을 명시해줘야한다.
 */
