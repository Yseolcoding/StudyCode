package main.com.ch11.ex3;

public class SongV2 {
    // 파일에 있는 세 개의 곡 정보를 위한 세 개의 인스턴스 변수
    private String title;
    private String artist;
    private int bpm;

    // 새 Song이 생성될 때마다 생성자에서 변수들을 설정합니다.
    SongV2(String title, String artist, int bpm){
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
