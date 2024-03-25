package main.com.ch12.ex10;

/*
    p. 458 수영장 퍼즐
 */
public class StreamPuzzle {
    public static void main(String[] args) {
        SongSearch songSearch = new SongSearch();
        songSearch.printTopFiveSongs();
        songSearch.search("The Beatles");
        songSearch.search("The beach Boys");

    }
}
