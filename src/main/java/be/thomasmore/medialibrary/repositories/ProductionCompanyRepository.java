package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.ProductionCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductionCompanyRepository extends CrudRepository<ProductionCompany, Integer> {

    Optional<ProductionCompany> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<ProductionCompany> findFirstByOrderByIdAsc();

    Optional<ProductionCompany> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<ProductionCompany> findFirstByOrderByIdDesc();
}
