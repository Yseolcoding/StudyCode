package main.com.ch11.ex1;

import java.util.ArrayList;
import java.util.List;

public class MockSongs {
    // 이 클래스에는 인스턴스 필드가 없고, 인스턴스 필드를 쓸 필요도 없기 때문에 정적 메서드로 만듭니다.
    public static List<String> getSongStrings() {

        List<String> songs = new ArrayList<>();
        songs.add("somersault");
        songs.add("cassidy");
        songs.add("$10");
        songs.add("havana");
        songs.add("Cassidy");
        songs.add("50 Ways");
        return songs;
    }
}

/*
    ArrayList도 List이기 때문에 ArrayList를 생성하고 List에 저장한 다음 그 메서드에서 List를 리턴할 수 있습니다.
    실전에서도 구현하는 타입(ArrayList)을 숨기고 대신 인터페이스 타입(List)을 리턴하는 자바 코드를 많이 사용하게 될 겁니다.
 */