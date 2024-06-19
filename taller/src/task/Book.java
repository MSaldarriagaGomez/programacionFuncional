package task;

public class Book {
    String title;
    String author;
    int year;
    String genre;
    double price;

    // constructor, getters and setters
    Book(String title, String author, int year, String genre, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }

    // getters
    String getTitle() { return title; }
    String getAuthor() { return author; }
    int getYear() { return year; }
    String getGenre() { return genre; }
    double getPrice() { return price; }
}
