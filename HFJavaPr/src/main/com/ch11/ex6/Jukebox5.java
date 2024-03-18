package main.com.ch11.ex6;


import java.util.Collections;
import java.util.List;

/*
    p. 378 Comparator만 가지고 정렬하기
 */
public class Jukebox5 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

    public void go() {
        // List의 타입을 String이 아닌 SongV2로 변경합니다.
        // 가짜 클래스(MockSongs)를 호출해서 곡 데이터를 곡명 리스트에 채워 줍니다.
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);

        TitleCompare titleCompare = new TitleCompare();
        songList.sort(titleCompare);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();         // Comparator 클래스의 인스턴스 생성
        songList.sort(artistCompare);                              // 리스트에 대해서 sort()를 호출하면서 새로 만든 Comparator 객체에 대한 레퍼런스를 넘겨줍니다.
        System.out.println("아티스트명 순서로 정렬 : " + songList);
    }
}
