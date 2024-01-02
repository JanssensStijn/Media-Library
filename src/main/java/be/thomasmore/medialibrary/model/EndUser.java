package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class EndUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String username;
    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<Movie> wishlistMovies;
    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<Movie> ownedMovies;
    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<Book> wishlistBooks;
    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<Book> ownedBooks;

    public EndUser() {}

    public int getId() { return id;}
    public void setId(int id) { this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

}
