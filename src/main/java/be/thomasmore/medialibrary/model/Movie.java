package be.thomasmore.medialibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collection;

@Entity
public class Movie {
    @Id
    private int id;

    private String imdb;
    private String title;
    private Integer yearOfRelease;
    private String producer;
    private String productionCompany;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }


}
