package main.com.ch12.ex10;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongSearch {
    private final List<Song> songs = new Songs().getSongs();

    void printTopFiveSongs() {
        List<String> topFive = songs.stream()
                                    .sorted(Comparator.comparingInt(Song::getTimePlayed))
                                    .limit(5)
                                    .map(song -> song.getTitle())
                                    .collect(Collectors.toList());
        System.out.println(topFive);
    }

    void search(String artist) {
        Optional<Song> result = songs.stream()
                                     .filter(song -> song.getArtist()
                                                         .equals(artist))
                                     .findFirst();
        if(result.isPresent()){
            System.out.println(result.get().getTitle());
        } else {
            System.out.println("No songs found by : "  + artist);
        }
    }
}
