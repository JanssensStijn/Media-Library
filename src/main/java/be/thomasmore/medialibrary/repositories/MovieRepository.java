package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m WHERE (?1 IS NULL OR m.id = ?1)" +
            " AND (?2 IS NULL OR m.imdb ILIKE ?2)" + //LIKE = case sensitive / ILIKE = not case sensitive
            " AND (?3 IS NULL OR m.title ILIKE %?3%)" +
            " AND (?4 IS NULL OR m.linkMoreInfo ILIKE %?4%)"+
            " AND (?5 IS NULL OR m.yearOfRelease = ?5)")
    List<Movie> findByFilter(Integer id, String imdb, String title, String linkMoreInfo, Integer yearOfRelease);
    Optional<Movie> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Movie> findFirstByOrderByIdAsc();

    Optional<Movie> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Movie> findFirstByOrderByIdDesc();
}
