package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.EndUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface EndUserRepository extends CrudRepository<EndUser, Integer> {
    EndUser findByUsername(String name);
}