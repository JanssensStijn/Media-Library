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

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public Collection<Movie> getWishlistMovies() {
        return wishlistMovies;
    }
    public void setWishlistMovies(Collection<Movie> wishlistMovies) {
        this.wishlistMovies = wishlistMovies;
    }

    public Collection<Movie> getOwnedMovies() {
        return ownedMovies;
    }
    public void setOwnedMovies(Collection<Movie> ownedMovies) {
        this.ownedMovies = ownedMovies;
    }

    public Collection<Book> getWishlistBooks() {
        return wishlistBooks;
    }
    public void setWishlistBooks(Collection<Book> wishlistBooks) {
        this.wishlistBooks = wishlistBooks;
    }

    public Collection<Book> getOwnedBooks() {
        return ownedBooks;
    }
    public void setOwnedBooks(Collection<Book> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }
}
