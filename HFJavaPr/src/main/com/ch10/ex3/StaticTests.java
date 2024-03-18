package main.com.ch10.ex3;

/*
    p.348 연습문제
 */

class StaticSuper {
    static {
        System.out.println("super static block");
    }

    StaticSuper() {
        System.out.println("super constructor");
    }
}
public class StaticTests extends StaticSuper{
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static block  " + rand);
    }

    StaticTests() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("in main");
        StaticTests st = new StaticTests();
    }
}

/*
    실행순서 이유 (by GPT)
    1. super static block: 프로그램 실행 시 가장 먼저, 부모 클래스 StaticSuper의 정적 블록이 실행됩니다.
        정적 블록은 클래스가 JVM에 의해 로드될 때 단 한 번 실행되는데, 이 경우 StaticTests 클래스가 StaticSuper를 상속하므로,
        StaticTests 클래스가 로드될 때 StaticSuper 클래스도 함께 로드되며, 그 결과 StaticSuper의 정적 블록이 실행됩니다.
    2. static block 5: 다음으로, StaticTests 클래스의 정적 블록이 실행됩니다.
        이 블록 내에서 rand 변수에 0과 5 사이의 임의의 정수가 할당되고, 그 값이 출력됩니다.
        이 단계도 클래스가 로드될 때 발생합니다. 정확한 rand 값은 실행할 때마다 달라질 수 있지만, 이 예제에서는 5로 출력되었습니다.
    3. in main: main 메서드가 실행되기 시작하면, "in main" 문자열이 출력됩니다.
        main 메서드는 프로그램의 시작점으로, 정적 블록이 실행된 후에 호출됩니다.
    4. super constructor: StaticTests 객체가 생성될 때, 먼저 부모 클래스인 StaticSuper의 생성자가 호출됩니다.
        객체의 생성 과정에서는 먼저 부모 클래스의 생성자가 실행되고, 이 때문에 "super constructor"가 출력됩니다.

constructor: 마지막으로, StaticTests 클래스의 생성자가 실행되어 "constructor"가 출력됩니다. 이는 객체가 완전히 초기화되고 나서 발생하는 단계입니다.
 */