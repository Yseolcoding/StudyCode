package main.com.ch11.ex11;

import java.util.ArrayList;
import java.util.List;

public class MockSongs {
/*    public static List<String> getSongStrings() {

        List<String> songs = new ArrayList<>();
        songs.add("somersault");q
        songs.add("cassidy");
        songs.add("$10");
        songs.add("havana");
        songs.add("Cassidy");
        songs.add("50 Ways");
        return songs;
    }*/

    public static List<SongV4> getSongsV3() {
        List<SongV4> songs = new ArrayList<>();
        songs.add(new SongV4("somersault", "zero 7", 147));
        songs.add(new SongV4("cassidy", "grateful dead", 158));
        songs.add(new SongV4("$10", "hitchhiker", 140));
        songs.add(new SongV4("havana", "cabello", 105));
        songs.add(new SongV4("Cassidy", "grateful dead", 158));
        songs.add(new SongV4("50 ways", "simon", 102));
        return songs;
    }

}
