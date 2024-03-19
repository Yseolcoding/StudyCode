package main.com.ch11.ex11;


public class SongV4 implements Comparable<SongV4> {
    /*
        public class "SongV4" implements Comaparable<"SongV4">
        보통 이 둘은 같습니다. Comparable 인터페이스를 구현하는 클래스에서 대소 비교를 할
     */

    // 파일에 있는 세 개의 곡 정보를 위한 세 개의 인스턴스 변수
    private String title;
    private String artist;
    private int bpm;

    @Override
    public boolean equals(Object aSong) {           // Song 객체가 인자로 전달됩니다.
        SongV4 other = (SongV4) aSong;
        return title.equals(other.getTitle());      // title이 String이라는 것이 얼마나 다행인지 모릅니다. String에서는 equals() 메서드를 이미 오버라이드해 놓았거든요.
    }

    @Override
    public int hashCode() {
        return title.hashCode();
        // 여기도 마찬가지입니다. String 클래스에서 hashcode() 메서드도 오버라이드해 놓았기 때문에 title의 hashcode() 메서드에서 리턴한 결과만 리턴하면 됩니다.
        // hashcode()하고 equals()에서 똑같은 인스턴스 변수를 사용하는 이유가 무엇인지 한번 확인해보세요.
    }

    // sort() 메서드에서는 compareTo()에 어떤 SongV4 객체를 인자로 전달하여
    // 그 SongV4 객체를 compareTo() 메서드가 호출된 SongV4 객체하고 비교해 줍니다.
    public int compareTo(SongV4 s) {
        return title.compareTo(s.getTitle()); // 간단하게 그냥 title이라는 String 객체에 할 일을 넘겨버리면 됩니다. String에도 compareTo() 메서드가 있으니까요.
    }

    // 새 Song이 생성될 때마다 생성자에서 변수들을 설정합니다.
    SongV4(String title, String artist, int bpm){
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
