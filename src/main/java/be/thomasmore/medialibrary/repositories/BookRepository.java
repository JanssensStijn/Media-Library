package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE (?1 IS NULL OR b.id = ?1)" +
            " AND (?2 IS NULL OR b.id = ?2)" +
            " AND (?3 IS NULL OR b.title LIKE ?3)" +
            " AND (?4 IS NULL OR b.author LIKE ?4)"+
            " AND (?5 IS NULL OR b.yearOfRelease = ?5)")
    List<Book> findByFilter(Integer id, String title, String linkMoreInfo, Integer yearOfRelease);
    Optional<Book> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Book> findFirstByOrderByIdAsc();

    Optional<Book> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Book> findFirstByOrderByIdDesc();
}
