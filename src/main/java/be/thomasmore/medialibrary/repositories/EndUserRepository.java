package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.EndUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface EndUserRepository extends CrudRepository<EndUser, Integer> {
    Optional<EndUser> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<EndUser> findFirstByOrderByIdAsc();

    Optional<EndUser> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<EndUser> findFirstByOrderByIdDesc();

    Iterable<EndUser> findByNameContainsIgnoreCase(String keyword);

    List<EndUser> findAllByNameContainsIgnoreCase(String keyword);

    EndUser findByUsername(String name);
}