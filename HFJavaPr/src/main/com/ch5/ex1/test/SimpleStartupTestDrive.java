package main.com.ch5.ex1.test;

/*
    테스트 해야할 것

    1. SimpleStartup 객체의 인스턴스를 만듭니다.
    2. 객체에 위치를 대입합니다({2,3,4})와 같은 int 값 세 개가 들어 있는 배열).
    3. 사용자가 추측한 위치를 나타내는 int를 만듭니다.
    4. 앞의 3단계에서 만들어낸 int를 전달하면서 checkYourself() 메서드를 호출합니다.
    5. 결과를 출력해서 올바른 결과가 나왔는지 확인합니다(결과가 맞으면 "passed", 틀리면 "failed"를 출력).
 */
public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        //SimpleStartup 클래스의 객체를 만듭니다.
        SimpleStartup dot = new SimpleStartup();

        //스타트업의 위치를 나타내기 위한 int 배열을 만듭니다. (일곱 개의 연속된 정수 가운데 세 개)
        int[] locations = {2, 3, 4};
        // 스타트업에 대해 세터 메서드를 호출합니다.
        dot.setLocationCells(locations);


        //사용자가 추측한 위치 역할을 할 가짜 값을 만듭니다.
        int userGuess = 2;
        //스타트업 객체에 대해 checkYourself() 메서드를 호출하고 그 메서드에 가짜 값을 전달합니다.
        String result = dot.checkYourself(userGuess);

        String testResult = "failed";
        if (result.equals("hit")){
            //가짜 값(2)이 맞으면 ("hit"가 리턴되면) 제대로 작동한다는 것을 알 수 있습니다.
            testResult = "passed";
        }

        // 테스트 결과 출력
        System.out.println(testResult);


    }
}
