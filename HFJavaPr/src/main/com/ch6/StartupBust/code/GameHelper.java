package main.com.ch6.StartupBust.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {
    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private static final int MAX_ATTEMPTS = 200;
    static final int HORIZONTAL_INCREMENT = 1;              // 이 둘은 enum으로 처리하면 더 좋습니다.
    static final int VERTICAL_INCREMENT = GRID_LENGTH ;     // (부록 B 참조)

    private final int[] grid = new int[GRID_SIZE];
    private final Random random = new Random();
    private int startupCount = 0;

    public String getUserInput(String prompt){
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    } // getUserInput 끝

    public ArrayList<String> placeStartup(int startupSize) {
        // 그리드에 대한 인덱스(0-48) 저장
        int[] startupCoords = new int[startupSize];         // 현재 후보 좌표
        int attempts = 0;                                   // 현재 시도 횟수
        boolean success = false;                            // 적절한 위치를 찾았는지 기록

        startupCount++;                                     // n번째 Startup 배치
        int increment = getIncrement();                     // 수평, 수직 방향 번갈아 배치

        while (!success && attempts ++ < MAX_ATTEMPTS) {    // 메인 검색 반복문
            int location = random.nextInt(GRID_SIZE);       // 임의의 시작점 선정

            for (int i = 0; i < startupCoords.length; i++) {  // 제안된 좌표의 배열 생성
                startupCoords[i] = location;                // 배열에 현재 위치를 집어넣음
                location += increment;                      // 다음 위치 계산
            }
            //System.out.println("Trying: " + Arrays.toString(startupCoords));

            if (startupFits(startupCoords, increment)) {     // 스타트업 객체가 그리드 안에 들어오는지 확인
                success = coordsAvailable(startupCoords);   // 이미 선점된 위치가 아닌지도 확인
            }                                               // 반복문 끝
        }                                                   // while문 끝
        savePositionToGrid(startupCoords);                  // 확인이 끝난 좌표 저장
        ArrayList<String> alphaCells = convertCoordsToAlphaFormnat(startupCoords);
        //그 Startup이 정확하게 어디 있는지 알려주는 코드
        System.out.println("Placed at: " + alphaCells);
        return alphaCells;
    } // palceStartup 끝

    private boolean startupFits(int[] startupCoords, int increment){
        int finalLocation = startupCoords[startupCoords.length -1];
        if(increment == HORIZONTAL_INCREMENT) {
            // 끝점이 시작점과 같은 행에 있는지 확인
            return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
        } else {
            return finalLocation < GRID_SIZE;               // 끝점이 밖으로 나가지 않는지 확인
        }
    } // startupFits 끝

    private boolean coordsAvailable(int[] startupCoords) {
        for (int coord : startupCoords) {                  // 가능한 모든 위치 확인
            if (grid[coord] != 0) {                        // 이미 차 있는 위치
                System.out.println("position: " + coord + " already taken.");
                return false;                              // 쓸 수 없는 자리
            }
        }
        return true;                                       // 충돌 없음. 만세!
    } // coordsAvailable 끝

    private void savePositionToGrid(int[] startupCoords) {
        for (int index : startupCoords) {
            grid[index] = 1;                               // 그리드 위치를 '사용 중'으로 표시
        }
    } // savePositionToGrid 끝

    private ArrayList<String> convertCoordsToAlphaFormnat(int[] startupCoords) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        for (int index : startupCoords) {                           // 각 그리드 좌표에 대해
            String alphaCoords = getAlphaCoordsFromIndex(index);    // "a0" 스타일로 바꿈
            alphaCells.add(alphaCoords);                            // 목록에 추가
        }
        return alphaCells;                                 // "a0" 스타일 좌표 리턴
    }

    private String getAlphaCoordsFromIndex(int index){
        int row = calcRowFromIndex(index);                          // 행 값 가져옴
        int column = index % GRID_LENGTH;                           // 숫자로 된 열 값 계산
        String letter = ALPHABET.substring(column, column+1);       // 글자로 변환
        return letter + row;
    } // getAlphaCoordsFromIndex 끝

    private int calcRowFromIndex(int index) {
        return index / GRID_LENGTH;
    } // calcRowFromIndex 끝

    private int getIncrement() {
        if (startupCount % 2 == 0) {                               // 짝수 번쨰 Startup 객체는
            return HORIZONTAL_INCREMENT;                           // 수평 방향으로 배치
        } else {                                                   // 홀수 번째 Startup 객체는
            return VERTICAL_INCREMENT;                             // 수직 방향으로 배치
        }
    } // getIncrement 끝
} // 클래스 끝
