package main.com.ch12.ex10;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    p. 450 람다 계속해서 테스트 해보기.
 */
public class PrJukebox {
    public static void main(String[] args) {
        List<Song> allSongs = new Songs().getSongs();

        // 메서드 레퍼런스 사용 예시
        //Function<Song, String> getGenre = song -> song.getGenre();
        Function<Song, String> getGenre = Song::getGenre;

        System.out.println(getGenre);

        // 람다 표현식 사용 예시
        List<Song> result1 = allSongs.stream()
                                     .sorted((o1, o2) -> o1.getYear() - o2.getYear())
                                     .collect(Collectors.toList());
        // 메서드 레퍼런스 사용 예시
        List<Song> result = allSongs.stream()
                                    .sorted(Comparator.comparingInt(Song::getYear))
                                    .collect(Collectors.toList());

        System.out.println(result);


    }
}
