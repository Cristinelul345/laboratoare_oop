package lab2.task4;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //    public String toString() {
//        // TODO
//
//        return null;
//    }
    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + author + ", Year: " + year;
    }
}