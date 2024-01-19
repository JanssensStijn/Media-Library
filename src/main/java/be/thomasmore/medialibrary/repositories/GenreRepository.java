package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Genre;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    List<Genre> findByGenreFor(String genreFor);
}
