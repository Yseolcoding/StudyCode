package main.com.ch11.ex11;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
    p. 394 TreeSet
 */
public class Jukebox10 {
    public static void main(String[] args) {
        new Jukebox10().go();
    }


    public void go() {
        List<SongV4> songList = MockMoreSongs.getSongsV3();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        /*
        // HashSet 대신 TreeSet을 생성합니다. TreeSet에서는 SongV4의 compareTo() 메서드를 써서 songList에 있는 항목들을 정렬합니다.
        Set<SongV4> songSet = new TreeSet<>(songList);
        */

        // 람다로 정렬하기, Bpm으로 정렬.
        Set<SongV4> songSet = new TreeSet<>((o1, o2) -> o1.getBpm() - o2.getBpm());
        songSet.addAll(songList);
        System.out.println(songSet);
    }
}
