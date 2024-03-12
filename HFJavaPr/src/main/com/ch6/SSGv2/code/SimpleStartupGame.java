package main.com.ch6.SSGv2.code;

public class SimpleStartupGame {
    public static void main(String[] args) {
        //사용자가 추측한 횟수를 추적하기 위한 변수를 만듭니다.
        int numOfGuesses = 0;
        //일단 사용자로부터 입력을 받기 위한 메서드가 들어있는 특별한 클래스가 있다고 생각합시다.
        GameHelper helper = new GameHelper();

        //스타트업 객체를 만듭니다.
        SimpleStartup theStartup = new SimpleStartup();
        //첫번째 셀 위치를 정하기 위한 난수를 만듭니다.
        int randomNum = (int) (Math.random() * 5);

        //그 값을 써서 셀 위치 배열을 만듭니다.
        int[] locations = {randomNum, randomNum+1, randomNum+2};
        //스타트업의 위치를 지정합니다(배열 사용).
        theStartup.setLocationCells(locations);
        //스타트업이 살아 있는지 추적하기 위한 불리업 변수를 만들고,
        boolean isAlive = true;

        //아직 살아 있으면 계속 반복합니다.
        while(isAlive){
            //사용자가 추측한 값을 가져옵니다.
            int guess = helper.getUserInput("enter a number ");
            //스타트업 객체를 통해 추측한 값이 맞는지 확인합니다. 리턴 결과는 String에 저장합니다.
            String result = theStartup.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")){
                isAlive = false;
                System.out.println("You took" + numOfGuesses + " guesses");
            } //if문 끝
        } // while문 끝
    } // main문 끝
}
