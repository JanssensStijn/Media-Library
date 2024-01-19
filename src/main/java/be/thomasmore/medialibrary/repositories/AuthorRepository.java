package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {}
