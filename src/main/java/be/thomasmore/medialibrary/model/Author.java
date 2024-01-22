package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Author {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private int id;
        private String name;
        private String biography;
        private String hometown;
        private String nationality;
        @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
        private Collection<Book> books;

        public Author() {}

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

        public String getBiography() {
                return biography;
        }

        public void setBiography(String biography) {
                this.biography = biography;
        }

        public String getHometown() {
                return hometown;
        }

        public void setHometown(String hometown) {
                this.hometown = hometown;
        }

        public String getNationality() {
                return nationality;
        }

        public void setNationality(String nationality) {
                this.nationality = nationality;
        }

        public Collection<Book> getBooks() {
                return books;
        }
        public void setBooks(Collection<Book> books) {
                this.books = books;
        }
}
