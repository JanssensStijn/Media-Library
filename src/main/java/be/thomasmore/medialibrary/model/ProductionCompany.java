package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class ProductionCompany {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private int id;
        private String name;
        private String location;
        private String biography;
        @ManyToMany(mappedBy = "productionCompanies")
        private Collection<Movie> movies;

        public ProductionCompany() {}

        public int getId() {
                return id;
        }
        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public String getBiography() {
                return biography;
        }

        public void setBiography(String biography) {
                this.biography = biography;
        }

        public Collection<Movie> getMovies() {
                return movies;
        }
        public void setMovies(Collection<Movie> movies) {
                this.movies = movies;
        }
}
