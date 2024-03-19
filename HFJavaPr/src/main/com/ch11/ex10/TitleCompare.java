package main.com.ch11.ex10;

import java.util.Comparator;

public class TitleCompare implements Comparator<SongV4> {

    @Override
    public int compare(SongV4 one, SongV4 two) {
        return one.getTitle().compareTo(two.getTitle());
    }
}
