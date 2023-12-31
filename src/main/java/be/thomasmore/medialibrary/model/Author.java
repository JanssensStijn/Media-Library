package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Author {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private int id;
        private String name;
        @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
        private Collection<Book> books;

        public Author() {
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

        public Collection<Book> getBooks() {
                return books;
        }
        public void setBooks(Collection<Book> books) {
                this.books = books;
        }
}
