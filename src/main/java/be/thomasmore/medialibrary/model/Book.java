package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;

@Entity
public class Book{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String title;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy")
    private Integer yearOfRelease;

    private String description;

    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<Author> authors;

    public Book() {
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

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }
    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }
}
