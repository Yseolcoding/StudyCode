package main.com.ch6.StartupBust.code;

import java.util.ArrayList;

public class StartupBust {

    // 사용할 변수를 선언하고 초기화합니다.
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // 우선 스타트업 객체 몇개를 만들고 위치를 지정합니다.
        // Startup 객체 세 개를 만들고 각각 이름을 부여한 후에 ArrayList에 저장합니다.
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        one.setName("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        // 사용자에게 간단한 게임 방법을 설명합니다.
        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        // 목록에 있는 각 Startup에 대해 반복합니다.
        for (Startup startup : startups) {
            //Startup의 위치를 지정하기 위한 보조 메서드를 호출합니다.
            ArrayList<String> newLocation = helper.placeStartup(3);
            //이 Startup 객체의 세터 메서드를 호출해서 방금 보조 메서드에서 받아온 위치를 지정합니다.
            startup.setLocationCells(newLocation);
        } // for 반복문 끝
    } // setUpGame 메서드 끝

    private void startPlaying() {
        // Startup 목록이 비어 있지 않으면
        while (!startups.isEmpty()){
            // 사용자의 입력을 받습니다.
            String userGuess = helper.getUserInput("Enter a guess");
            //checkUserGuess 메서드를 호출합니다.
            checkUserGuess(userGuess);
        }// while문 끝
        // finishGame 메서드를 호출합니다.
        finishGame();
    } // startPlaying 메서드 끝

    private void checkUserGuess(String userGuess){
        // 사용자가 추측한 횟수를 증가시킵니다.
        numOfGuesses++;
        // 따로 바꾸지 않으면 miss라고 가정합니다.
        String result = "miss";

        // 목록에 들어 있는 모든 Startup 객체에 대해 반복합니다.
        for(Startup startupToTest : startups){
            // Startup 객체에 사용자가 입력한 위치가 맞는지 또는 그 객체가 침몰했는지 물어봅니다.
            result = startupToTest.checkYourself(userGuess);

            if(result.equals("hit")) {
                //반복문에서 일찍 빠져 나옵니다. 나머지는 더이상 확인하지 않아도 되니까요.
                break;
            }
            if (result.equals("kill")) {
                // 이건 침몰했으므로 Startup 목록에서 빼고 반복문을 빠져나갑니다.
                startups.remove(startupToTest);
                break;
            }
        } // for 반복문 끝
        // 게임 결과를 알려주는 메시지를 출력합니다.
        System.out.println(result);
    } // checkUserGuess 메서드 끝

    private void finishGame() {
        // 게임 결과를 알려주는 메시지를 출력합니다.
        System.out.println("All Startups are dead! Your stock is now worthless");
        if(numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    } // 메서드 끝

    public static void main(String[] args) {
        // 게임 객체를 만듭니다.
        StartupBust game = new StartupBust();
        // 게임 객체에 게임을 설정하라는 명령을 내립니다.
        game.setUpGame();
        // 게임 객체에 주 게임 진행 반복문을 돌리라는 명령을 내립니다.
        // (사용자에게 계속해서 위치를 물어보고, 그 추측을 확인합니다.)
        game.startPlaying();
    } // 메서드 끝
}
