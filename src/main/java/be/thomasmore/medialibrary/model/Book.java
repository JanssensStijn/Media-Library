package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Collection;

@Entity
public class Book{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @NotBlank(message = "Enter a title")
    private String title;
    private String imageUrl;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy")
    @NotNull(message = "Enter a year of release")
    @Digits(message = "number must have 4 digits", fraction = 0, integer = 4)
    private Integer yearOfRelease;
    @NotBlank(message = "enter a short description")
    private String description;

    @NotEmpty(message = "select author(s)")
    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<Author> authors;
    @NotEmpty(message = "select genre(s)")
    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<Genre> genres;
    @ManyToMany(mappedBy = "wishlistBooks", fetch = FetchType.LAZY)
    private Collection<EndUser> endUsersWishlist;
    @ManyToMany(mappedBy = "ownedBooks", fetch = FetchType.LAZY)
    private Collection<EndUser> endUsersOwned;

    public Book() {}

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

    public String getDescription() {
        return description;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public Collection<EndUser> getEndUsersWishlist() {
        return endUsersWishlist;
    }

    public Collection<EndUser> getEndUsersOwned() {
        return endUsersOwned;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }
    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }
}
