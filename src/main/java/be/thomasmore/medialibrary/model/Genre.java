package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Genre {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private int id;
        private String name;
        private String genreFor; //values shall be "movie" or "book"
        @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
        private Collection<Movie> movies;

        @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
        private Collection<Book> books;

        public Genre() {}

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

        public String getGenreFor() {
                return genreFor;
        }
        public void setGenreFor(String genreFor) {
                this.genreFor = genreFor;
        }

        public Collection<Movie> getMovies() {
                return movies;
        }
        public void setMovies(Collection<Movie> movies) {
                this.movies = movies;
        }

        public Collection<Book> getBooks() {
                return books;
        }
        public void setBooks(Collection<Book> books) {
                this.books = books;
        }
}
