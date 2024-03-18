package main.com.ch11.ex1;

import java.util.List;

/*
    p.352 예시
    (아직은 알파벳 순으로 정렬되어있지 않음)
 */
public class Jukebox1 {
    public static void main(String[] args) {

        new Jukebox1().go();
    }

    public void go() {
        List<String> songList = MockSongs.getSongStrings();
        System.out.println(songList);
    }
}