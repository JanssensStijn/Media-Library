package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query("SELECT DISTINCT b FROM Book b " +
            "LEFT JOIN b.authors a " +
            "LEFT JOIN b.genres g " +
            "WHERE (:title IS NULL OR b.title ILIKE %:title%) " +
            "AND (:author IS NULL OR a.name ILIKE %:author%) " +
            "AND (:genre IS NULL OR g.name ILIKE %:genre%) " +
            "AND (:yearOfRelease IS NULL OR b.yearOfRelease = :yearOfRelease)")
    List<Book> findByFilter(
            @Param("title") String title,
            @Param("author") String author,
            @Param("genre") String genre,
            @Param("yearOfRelease") Integer yearOfRelease
    );

    @Query("SELECT DISTINCT b FROM Book b " +
            "LEFT JOIN b.authors a " +
            "LEFT JOIN b.genres g " +
            "WHERE (:title IS NULL OR b.title ILIKE %:title%) " +
            "AND (:author IS NULL OR a.name ILIKE %:author%) " +
            "AND (:genre IS NULL OR g.name ILIKE %:genre%) " +
            "AND (:yearOfRelease IS NULL OR b.yearOfRelease = :yearOfRelease)" +
            "ORDER BY b.title ASC")
    List<Book> findByFilterSorted(
            @Param("title") String title,
            @Param("author") String author,
            @Param("genre") String genre,
            @Param("yearOfRelease") Integer yearOfRelease
    );

    Optional<Book> findFirstByIdGreaterThanOrderByIdAsc(Integer id);
    Optional<Book> findFirstByOrderByIdAsc();
    Optional<Book> findFirstByIdLessThanOrderByIdDesc(Integer id);
    Optional<Book> findFirstByOrderByIdDesc();
}
