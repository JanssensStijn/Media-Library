package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    List<Actor> findByOrderByNameAsc();
}
