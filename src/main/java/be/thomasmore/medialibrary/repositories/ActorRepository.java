package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    List<Actor> findByOrderByNameAsc();
    Optional<Actor> findFirstByIdGreaterThanOrderByIdAsc(Integer id);
    Optional<Actor> findFirstByOrderByIdAsc();
    Optional<Actor> findFirstByIdLessThanOrderByIdDesc(Integer id);
    Optional<Actor> findFirstByOrderByIdDesc();
}
