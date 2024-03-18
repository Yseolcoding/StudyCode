package main.com.ch11.ex9;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    p. 389 ArrayList 대신 HashSet 사용해보기
 */
public class Jukebox8 {
    public static void main(String[] args) {
        new Jukebox8().go();
    }

    public void go() {
        // SongListMore.txt의 내용과 똑같은 값을 가지는 SongV3 객체의 List를 리턴하는 MockMoreSongs 클래스 생성
        List<SongV3> songList = MockMoreSongs.getSongsV3();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        // HashSet에는 Collection을 받아들이는 생성자가 있는데, 그 생성자에서는 그 컬렉션의 모든 항목이 담긴 집합을 리턴해 줍니다.
        Set<SongV3> songSet = new HashSet<>(songList);
        // Set에 SongV3 객체들을 저장하고자 합니다. HashSet은 Set이기 때문에 HashSet도 이 Set 변수에 저장할 수 있습니다.
        System.out.println(songSet);
    }
}

/*
    실행 결과 :
    [somersault, cassidy, $10, havana, $10, Cassidy, 50 ways]
    [$10, $10, 50 ways, Cassidy, cassidy, havana, somersault]
    [somersault, cassidy, 50 ways, $10, Cassidy, havana, $10]

    * 여전히 중복된 항목들이 남아있고, HashSet에 집어넣고 나니 정렬된 순서가 다 뒤섞이게 됨.
 */