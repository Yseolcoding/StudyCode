package main.com.ch11.ex9;


public class SongV3 implements Comparable<SongV3> {
    /*
        public class "SongV3" implements Comaparable<"SongV3">
        보통 이 둘은 같습니다. Comparable 인터페이스를 구현하는 클래스에서 대소 비교를 할
     */

    // 파일에 있는 세 개의 곡 정보를 위한 세 개의 인스턴스 변수
    private String title;
    private String artist;
    private int bpm;

    // sort() 메서드에서는 compareTo()에 어떤 SongV3 객체를 인자로 전달하여
    // 그 SongV3 객체를 compareTo() 메서드가 호출된 SongV3 객체하고 비교해 줍니다.
    public int compareTo(SongV3 s) {
        return title.compareTo(s.getTitle()); // 간단하게 그냥 title이라는 String 객체에 할 일을 넘겨버리면 됩니다. String에도 compareTo() 메서드가 있으니까요.
    }

    // 새 Song이 생성될 때마다 생성자에서 변수들을 설정합니다.
    SongV3(String title, String artist, int bpm){
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    // 세 개의 속성을 위한 세 개의 게터 메서드
    public String getTitle(){
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    // System.out.println(aSongObject)를 호출하면 곡명이 출력되도록 toString() 메서드를 오버라이드합니다.
    public String toString() {
        return title;
    }

}
