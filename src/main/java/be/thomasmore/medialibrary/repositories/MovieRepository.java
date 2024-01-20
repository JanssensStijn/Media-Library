package be.thomasmore.medialibrary.repositories;

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
            " LEFT JOIN m.actors a" +
            " LEFT JOIN m.genres g" +
            " WHERE(:title IS NULL OR m.title ILIKE %:title%)" +
            " AND (:yearOfRelease IS NULL OR m.yearOfRelease = :yearOfRelease)" +
            " AND (:genre IS NULL OR g.name ILIKE %:genre%)"+
            " AND (:producer IS NULL OR p.name ILIKE %:producer%)"+
            " AND (:productionCompany IS NULL OR pc.name ILIKE %:productionCompany%)" +
            " AND (:actor IS NULL OR a.name ILIKE %:actor%)")
    List<Movie> findByFilter(@Param("title")String title,
                             @Param("yearOfRelease") Integer yearOfRelease,
                             @Param("genre") String genre,
                             @Param("producer") String producer,
                             @Param("productionCompany")String productionCompany,
                             @Param("actor")String actor);

    @Query("SELECT m FROM Movie m" +
            " LEFT JOIN m.producers p" +
            " LEFT JOIN m.productionCompanies pc" +
            " LEFT JOIN m.actors a" +
            " LEFT JOIN m.genres g" +
            " WHERE(:title IS NULL OR m.title ILIKE %:title%)" +
            " AND (:yearOfRelease IS NULL OR m.yearOfRelease = :yearOfRelease)" +
            " AND (:genre IS NULL OR g.name ILIKE %:genre%)"+
            " AND (:producer IS NULL OR p.name ILIKE %:producer%)"+
            " AND (:productionCompany IS NULL OR pc.name ILIKE %:productionCompany%)" +
            " AND (:actor IS NULL OR a.name ILIKE %:actor%)" +
            " ORDER BY m.title ASC")
    List<Movie> findByFilterSorted(@Param("title")String title,
                                   @Param("yearOfRelease") Integer yearOfRelease,
                                   @Param("genre") String genre,
                                   @Param("producer") String producer,
                                   @Param("productionCompany")String productionCompany,
                                   @Param("actor")String actor);

    @Query("SELECT m FROM Movie m" +
            " LEFT JOIN m.endUsersOwned me" +
            " GROUP BY m.id" +
            " ORDER BY COUNT(me.id) DESC" +
            " LIMIT 5")
    List<Movie> findTopBought();

    Optional<Movie> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Movie> findFirstByOrderByIdAsc();

    Optional<Movie> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Movie> findFirstByOrderByIdDesc();
    @Query("SELECT DISTINCT m.yearOfRelease FROM Movie m ORDER BY m.yearOfRelease")
    List<Integer> findDistinctYearsOfRelease();
}
