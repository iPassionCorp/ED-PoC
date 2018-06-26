package th.co.ipassion.ed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.PocCustomerType;

@Repository
public interface PocCustomerTypeRepository extends CrudRepository<PocCustomerType, Long> {

    List<PocCustomerType> findAllByOrderByCTypeIdAsc();
    
}
