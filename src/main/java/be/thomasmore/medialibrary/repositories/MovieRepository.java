package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Book;
import be.thomasmore.medialibrary.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m" +
            " LEFT JOIN m.producers p" +
            " LEFT JOIN m.productionCompanies pc" +
            " WHERE (:id IS NULL OR m.id = :id) " +
            " AND (:imdb IS NULL OR m.imdb ILIKE :imdb)" + //LIKE = case sensitive / ILIKE = not case sensitive
            " AND (:title IS NULL OR m.title ILIKE %:title%)" +
            " AND (:yearOfRelease IS NULL OR m.yearOfRelease = :yearOfRelease)" +
            " AND (:producer IS NULL OR p.name ILIKE %:producer%)"+
            " AND (:productionCompany IS NULL OR pc.name ILIKE %:productionCompany%)")
    List<Movie> findByFilter(@Param("id")Integer id,
                             @Param("imdb")String imdb,
                             @Param("title")String title,
                             @Param("yearOfRelease") Integer yearOfRelease,
                             @Param("producer") String producer,
                             @Param("productionCompany")String productionCompany);


    Optional<Movie> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Movie> findFirstByOrderByIdAsc();

    Optional<Movie> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Movie> findFirstByOrderByIdDesc();
}
