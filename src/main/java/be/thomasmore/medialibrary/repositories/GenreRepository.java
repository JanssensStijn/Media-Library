package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {}
