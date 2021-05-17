package org.example.classes;

public class Book {

    public int id;
    public String name;
    public int year;
    public String author;

    public Book(int id, String name, int year, String author) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
    }

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
