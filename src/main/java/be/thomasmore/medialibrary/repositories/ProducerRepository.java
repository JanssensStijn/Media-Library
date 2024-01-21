package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProducerRepository extends CrudRepository<Producer, Integer> {
    List<Producer> findByOrderByNameAsc();
    Optional<Producer> findFirstByIdGreaterThanOrderByIdAsc(Integer id);
    Optional<Producer> findFirstByOrderByIdAsc();
    Optional<Producer> findFirstByIdLessThanOrderByIdDesc(Integer id);
    Optional<Producer> findFirstByOrderByIdDesc();
}
