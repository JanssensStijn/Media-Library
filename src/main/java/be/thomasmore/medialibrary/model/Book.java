package be.thomasmore.medialibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private int id;
    private String title;
    private String author;
    private Integer yearOfRelease;

    public Book() {
    }

    public Book(int id, String title, String author, Integer yearOfRelease) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}
