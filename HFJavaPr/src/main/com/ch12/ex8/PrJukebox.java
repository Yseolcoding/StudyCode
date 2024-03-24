package main.com.ch12.ex8;

import java.util.List;
import java.util.stream.Collectors;

/*
    p. 449 람다 계속해서 테스트 해보기.
 */
public class PrJukebox {
    public static void main(String[] args) {
        List<Song> allSongs = new Songs().getSongs();

        // 원곡을 부를 아티스트는 제외하고 그 곡을 커버한 적이 있는 모든 아티스트의 목록 리턴하기.
        String songTitle = "With a Little Help from My Friends";
        List<String> result = allSongs.stream()
                                      .filter(song -> song.getTitle()                   // songTitle과 일치하는 노래 담기
                                                          .equals(songTitle))
                                      .map(song -> song.getArtist())                   // song을 아티스트(String)로 바꿔 담기
                                      .filter(artist -> !artist.equals("The Beatles"))  // 아티스트명이 비틀즈인 것 거르기
                                      .collect(Collectors.toList());                   // 리스트에 담기

        System.out.println(result);


    }
}

/*
    실행 결과 : [Joe Cocker]

    실행시 리스트에 아무런 아티스트도 담기지 않아서
    의도헀던 실행 결과를 얻기까지 Song의 곡들의 제목을 복사 붙여넣기하는데..
    오타가 있었던 것 같은데 정확히 확인되지 않음..ㅠ
 */
