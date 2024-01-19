package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProducerRepository extends CrudRepository<Producer, Integer> {
    List<Producer> findByOrderByNameAsc();
}
