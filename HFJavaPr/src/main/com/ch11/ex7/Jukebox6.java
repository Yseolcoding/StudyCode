package main.com.ch11.ex7;


import java.util.List;

/*
    p. 384 람다를 가지고 주크박스 코드 고쳐 보기
 */
public class Jukebox6 {
    public static void main(String[] args) {
        new Jukebox6().go();
    }

    public void go() {
        // List의 타입을 String이 아닌 SongV2로 변경합니다.
        // 가짜 클래스(MockSongs)를 호출해서 곡 데이터를 곡명 리스트에 채워 줍니다.
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);

        // 람다 표현식 사용.
        // Comparator 클래스를 따로 만들 필요 없이 그냥 sort 메서드를 호출할 때 정렬을 위한 논리만 집어넣어 주면 됩니다.
        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        songList.sort((one, two) -> one.getArtist().compareTo(two.getArtist()));
        System.out.println(songList);
    }
}
