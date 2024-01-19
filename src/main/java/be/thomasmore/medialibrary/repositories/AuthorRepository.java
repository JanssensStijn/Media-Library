package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findByOrderByNameAsc();
}
