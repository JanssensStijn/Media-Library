package be.thomasmore.medialibrary.repositories;

import be.thomasmore.medialibrary.model.ProductionCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductionCompanyRepository extends CrudRepository<ProductionCompany, Integer> {
    List<ProductionCompany> findByOrderByNameAsc();
}
