package main.com.ch11.ex2;

import java.util.Collections;
import java.util.List;

/*
    p.357 예시
    sort() 사용해서 정렬하기
 */
public class Jukebox1 {
    public static void main(String[] args) {

        new Jukebox1().go();
    }

    public void go() {
        List<String> songList = MockSongs.getSongStrings();
        Collections.sort(songList);
        System.out.println(songList);
    }
}