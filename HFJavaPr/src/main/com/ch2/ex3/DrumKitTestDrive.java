package main.com.ch2.ex3;
/*
    p. 85 코드 자석 문제
 */
public class DrumKitTestDrive {
    public static void main(String[] args) {

    DrumKit d = new DrumKit();
    d.playSnare();
    d.snare=false;
    d.playTopHat();

    if(d.snare == true){
        d.playSnare();
    }

    }
}
