package main.com.ch12.ex6;

public class Song {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private final int timePlayed;

    public Song(String title, String artist, String genre, int year, int timePlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timePlayed = timePlayed;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", timePlayed=" + timePlayed +
                '}';
    }
}
