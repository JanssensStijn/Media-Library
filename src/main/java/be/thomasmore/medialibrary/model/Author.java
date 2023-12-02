package be.thomasmore.medialibrary.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Author {

        @Id
        private int id;
        private String name;
        @Temporal(TemporalType.DATE)
        private Date birthday;
        private String placeOfBirth;
        private String nationality;

        private String bio;
        @ManyToMany(mappedBy = "authors")
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

        public Date getBirthday() {
                return birthday;
        }

        public void setBirthday(Date birthday) {
                this.birthday = birthday;
        }

        public String getPlaceOfBirth() {
                return placeOfBirth;
        }

        public void setPlaceOfBirth(String placeOfBirth) {
                this.placeOfBirth = placeOfBirth;
        }

        public String getBio() {
                return bio;
        }

        public void setBio(String bio) {
                this.bio = bio;
        }

        public Collection<Book> getBooks() {
                return books;
        }

        public void setBooks(Collection<Book> books) {
                this.books = books;
        }

        public String getNationality() {
                return nationality;
        }

        public void setNationality(String nationality) {
                this.nationality = nationality;
        }
}
