package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;

@Entity
public class Movie{

    /*************** FIELDS ****************/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @NotBlank(message = "Enter a unique imdb")
    private String imdb;
    @NotBlank(message = "Enter a title")
    private String title;

    private String imageUrl;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy")
    @NotNull(message = "Enter a year of release")
    @Digits(message = "number must have 4 digits", fraction = 0, integer = 4)
    private Integer yearOfRelease;
    @NotBlank(message = "Enter a unique Youtube id")
    private String trailerLink;
    @NotBlank(message = "enter a short description")
    private String description;

    @NotEmpty(message = "select actor(s)")
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Actor> actors;
    @NotEmpty(message = "select producer(s)")
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Producer> producers;
    @NotEmpty(message = "select production company")
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<ProductionCompany> productionCompanies;
    @NotEmpty(message = "select genre(s)")
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Genre> genres;

    @ManyToMany(mappedBy = "wishlistMovies", fetch = FetchType.LAZY)
    private Collection<EndUser> endUsersWishlist;
    @ManyToMany(mappedBy = "ownedMovies", fetch = FetchType.LAZY)
    private Collection<EndUser> endUsersOwned;

    /************ CONSTRUCTORS *************/
    public Movie() {
    }

    /********** GETTERS & SETTERS **********/

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getImdb() {
        return imdb;
    }
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }
    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Actor> getActors() {
        return actors;
    }
    public void setActors(Collection<Actor> actors) {
        this.actors = actors;
    }

    public Collection<Producer> getProducers() {
        return producers;
    }
    public void setProducers(Collection<Producer> producers) {
        this.producers = producers;
    }

    public Collection<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }
    public void setProductionCompanies(Collection<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public Collection<EndUser> getEndUsersWishlist() {
        return endUsersWishlist;
    }
    public void setEndUsersWishlist(Collection<EndUser> endUsers) {
        this.endUsersWishlist = endUsers;
    }

    public Collection<EndUser> getEndUsersOwned() {
        return endUsersOwned;
    }
    public void setEndUsersOwned(Collection<EndUser> endUsersOwned) {
        this.endUsersOwned = endUsersOwned;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }
}
