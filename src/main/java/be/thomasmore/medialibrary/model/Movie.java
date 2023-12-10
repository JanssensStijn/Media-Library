package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;

@Entity
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String imdb;
    private String title;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy")
    private Integer yearOfRelease;
    private String trailerLink;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Actor> actors;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Producer> producers;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<ProductionCompany> productionCompanies;

    public Movie() {
    }

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

}
