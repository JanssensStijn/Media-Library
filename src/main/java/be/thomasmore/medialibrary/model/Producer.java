package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Producer {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private int id;
        private String name;
        @ManyToMany(mappedBy = "producers")
        private Collection<Movie> movies;
        public Producer() {
        }

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

        public Collection<Movie> getMovies() {
                return movies;
        }
        public void setMovies(Collection<Movie> movies) {
                this.movies = movies;
        }
}
