package main.com.ch12.ex6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
    p. 441 모의코드를 사용한 전체 출력 메인 메소드 구현 (람다 사용)
 */
public class PrJukebox {
    public static void main(String[] args) {
        Songs songs = new Songs();
        songs.getSongs().forEach(song -> System.out.println(song));

        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        //Consumer<String> printConsumer = s -> System.out.println(s);
        list.forEach(s -> System.out.println(s));
    }
}
