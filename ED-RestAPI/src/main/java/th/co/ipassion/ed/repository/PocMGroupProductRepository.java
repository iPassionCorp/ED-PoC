package th.co.ipassion.ed.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.PocMGroupProduct;

@Repository
public interface PocMGroupProductRepository extends CrudRepository<PocMGroupProduct, Long> {

}
