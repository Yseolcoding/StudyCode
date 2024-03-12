package main.com.ch5.ex1_SSGv1.code;

public class SimpleStartupV1 {
    private int[] locationCells;
    private int numOfHits = 0;

    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    public String checkYourself(int guess){
        String result = "miss";
        for (int cell : locationCells){
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            } //if문 끝
        } //for문 끝
        if(numOfHits == locationCells.length){
            result = "kill";
        } //if문 끝
        System.out.println(result);
        return result;
    }
}
