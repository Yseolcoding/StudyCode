package main.com.ch6.SSGv2.code;

import java.util.ArrayList;

public class Startup {

    private ArrayList<String> locationCells;
    //private int numOfHits = 0;
    // (지금은 추적하지 않아도 됩니다.)

    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public String checkYourself(String userInput){
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if(index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            } // if문 끝
        } // 바깥쪽 if문 끝
        return result;
    }//메서드 끝
} //클래스 끝
