package main.com.ch11.ex10;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    p. 392 hashcode()와 equals()를 오버라이드한 Song 클래스 추가
 */
public class Jukebox9 {
    public static void main(String[] args) {
        new Jukebox9().go();
    }


    public void go() {
        // SongListMore.txt의 내용과 똑같은 값을 가지는 SongV4 객체의 List를 리턴하는 MockMoreSongs 클래스 생성
        List<SongV4> songList = MockMoreSongs.getSongsV4();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        // HashSet에는 Collection을 받아들이는 생성자가 있는데, 그 생성자에서는 그 컬렉션의 모든 항목이 담긴 집합을 리턴해 줍니다.
        Set<SongV4> songSet = new HashSet<>(songList);
        // Set에 SongV4 객체들을 저장하고자 합니다. HashSet은 Set이기 때문에 HashSet도 이 Set 변수에 저장할 수 있습니다.
        System.out.println(songSet);
    }
}