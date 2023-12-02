package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    /*@Query("SELECT b FROM Book b JOIN Author a WHERE (?1 IS NULL OR b.id = ?1)" +
            " AND (?2 IS NULL OR b.title ILIKE %?2%)" +
            " AND (?3 IS NULL OR a.name ILIKE %?3%)"+
            " AND (?4 IS NULL OR b.yearOfRelease = ?4)")

    List<Book> findByFilter(Integer id, String title, String author, Integer yearOfRelease);*/

    @Query("SELECT DISTINCT b FROM Book b " +
            "LEFT JOIN b.authors a " +
            "WHERE (:id IS NULL OR b.id = :id) " +
            "AND (:title IS NULL OR b.title LIKE %:title%) " +
            "AND (:author IS NULL OR a.name LIKE %:author%) " +
            "AND (:yearOfRelease IS NULL OR b.yearOfRelease = :yearOfRelease)")
    List<Book> findByFilter(
            @Param("id") Integer id,
            @Param("title") String title,
            @Param("author") String author,
            @Param("yearOfRelease") Integer yearOfRelease
    );
    Optional<Book> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Book> findFirstByOrderByIdAsc();

    Optional<Book> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Book> findFirstByOrderByIdDesc();
}
