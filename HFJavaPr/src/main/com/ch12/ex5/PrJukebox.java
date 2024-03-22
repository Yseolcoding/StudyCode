package main.com.ch12.ex5;
/*
    p. 441 모의코드를 사용한 전체 출력 메인 메소드 구현 (람다 사용)
 */
public class PrJukebox {
    public static void main(String[] args) {
        Songs songs = new Songs();
        songs.getSongs().forEach(song -> System.out.println(song));
    }
}
