package main.com.ch11.ex11;

import java.util.Comparator;

public class ArtistCompare implements Comparator<SongV4> {
    @Override
    public int compare(SongV4 one, SongV4 two) {
        // (아티스트 정보가 담긴) String 변수한테 비교 작업 시키기. String에는 이미 알파벳 순으로 비교하는 기능이 있음.
        return one.getArtist().compareTo(two.getArtist());
    }
}
