package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProducerRepository extends CrudRepository<Producer, Integer> {

    Optional<Producer> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Producer> findFirstByOrderByIdAsc();

    Optional<Producer> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Producer> findFirstByOrderByIdDesc();
}
