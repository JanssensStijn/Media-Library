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

    public Movie() {
    }

    public Movie(int id,String imdb, String title, int yearOfRelease, String producer, String productionCompany ) {
        this.id = id;
        this.imdb = imdb;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.producer = producer;
        this.productionCompany = productionCompany;
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

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }
}
