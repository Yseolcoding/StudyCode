package main.com.ch6.StartupBust.code;

import java.util.ArrayList;

public class Startup {
    // Startup 클래스의 인스턴스 변수
    private ArrayList<String> locationCells;
    private String name;

    // Startup의 위치를 갱신하는 세터 메서드(GameHelper의 placeStartup() 메서드에서 제공하는 무작위로 만든 위치)
    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    // 기본 세터 메서드
    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        // ArrayList의 indexOf() 메서드를 쓰고 있습니다.
        // 사용자가 추측한 위치가 ArrayList에 들어 있으면 indexOf()에서 그 항목의 인덱스를 리턴합니다.
        // 그렇지 않으면 -1을 리턴합니다.
        int index = locationCells.indexOf(userInput);
        if(index >= 0){
            // ArrayList의 remove() 메서드를 써서 그 항목을 삭제합니다.
            locationCells.remove(index);

            // isEmpty() 메서드를 써서 모든 위치를 맞혔는지 확인합니다.
            if(locationCells.isEmpty()){
                result = "kill";
                // Startup이 침몰했음을 알려 줍니다.
                System.out.println("Ouch! You sunk " + name + " : ( ");
            } else {
                result = "hit";
            } // if문 끝
        } // 바깥쪽 if문 끝
        // "miss", "hit" 또는 "kill"을 리턴합니다.
        return result;
    } // 메서드 끝
} // 클래스 끝
