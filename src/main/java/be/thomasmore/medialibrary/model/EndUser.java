package be.thomasmore.medialibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collection;

@Entity
public class EndUser {

    @Id
    private int id;
    private String name;
    private String username;
    @ManyToMany
    private Collection<Movie> wishlistMovies;
    @ManyToMany
    private Collection<Movie> ownedMovies;

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
