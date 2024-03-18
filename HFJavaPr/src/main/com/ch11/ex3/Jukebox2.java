package main.com.ch11.ex3;


import java.util.Collections;
import java.util.List;

/*
    p. 359 예시
 */
public class Jukebox2 {
    public static void main(String[] args) {
        new Jukebox2().go();
    }

    public void go() {
        // List의 타입을 String이 아닌 SongV2로 변경합니다.
        // 가짜 클래스(MockSongs)를 호출해서 곡 데이터를 곡명 리스트에 채워 줍니다.
        List<SongV2> songList = MockSongs.getSongsV2();
        System.out.println(songList);

        // 다시 한번 sort 메서드를 호출해서 곡 정렬하기.
        Collections.sort(songList);
        System.out.println(songList);
    }
}

/*
에러이유 :
    객체를 무엇에 대해서 정렬해야하는지, 컴파일러가 알지 못함.

에러 메세지 :
    /Users/seollucia/Practice/SpringPractice/HFJavaPr/src/main/com/ch11/ex3/Jukebox2.java:22:20
    java: no suitable method found for sort(java.util.List<main.com.ch11.ex3.SongV2>)
        method java.util.Collections.<T>sort(java.util.List<T>) is not applicable
        (inference variable T has incompatible bounds
            equality constraints: main.com.ch11.ex3.SongV2
            lower bounds: java.lang.Comparable<? super T>)
        method java.util.Collections.<T>sort(java.util.List<T>,java.util.Comparator<? super T>) is not applicable
        (cannot infer type-variable(s) T
            (actual and formal argument lists differ in length))
 */