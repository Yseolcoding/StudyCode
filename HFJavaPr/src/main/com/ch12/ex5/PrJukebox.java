package main.com.ch12.ex5;

import java.util.List;
import java.util.stream.Collectors;

/*
    p. 444 본격적으로 Stream 사용해보기
 */
public class PrJukebox {
    public static void main(String[] args) {

        List<Song> songs = new Songs().getSongs();

        // 스트림 파이프라인에서 "Rock" 장르인 Song의 List를 리턴합니다.
        List<Song> rockSongs = songs.stream()
                                    //filter()는 Song의 Stream에 대해 작용하기 때문에 이건 Song 입니다.
                                    //이 람다는 Predicate를 구현합니다.
                                    .filter(song -> song.getGenre()
                                                        .equals("Rock"))
                                    .collect(Collectors.toList());

        System.out.println(rockSongs);

        // 스트림을 통해 "Rock" 장르의 범주인 모든 곡의 목록 리턴
        List<Song> rockSongsList = songs.stream()
                                        .filter(song -> song.getGenre()
                                                            .contains("Rock"))
                                        .collect(Collectors.toList());

        System.out.println(rockSongsList);

        // 비틀스가 만든 곡 리스트
        List<Song> beatlesSongs = songs.stream()
                                       .filter(song -> song.getArtist()
                                                           .contains("Beatles"))
                                       .collect(Collectors.toList());

        System.out.println(beatlesSongs);

        //'H'로 시작하는 곡
        List<Song> hSongs = songs.stream()
                                 .filter(song -> song.getTitle()
                                                     .startsWith("H"))
                                 .collect(Collectors.toList());
        System.out.println(hSongs);

        // 1995년 이후로 나온 곡
        List<Song> yearSongs = songs.stream()
                                    .filter(song -> song.getYear()>1995)
                                    .collect(Collectors.toList());
        System.out.println(yearSongs);
    }
}
