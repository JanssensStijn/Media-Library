package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {}
