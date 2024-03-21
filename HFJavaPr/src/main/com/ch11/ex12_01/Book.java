package main.com.ch11.ex12_01;



public class Book implements Comparable<Book>{
    private String title;
    public Book(String t){
        title = t;
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }
}
