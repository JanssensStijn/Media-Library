package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface EndUserRepository extends CrudRepository<EndUser, Integer> {
    EndUser findByUsername(String name);
}