package th.co.ipassion.ed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.PocCustomer;

@Repository
public interface PocCustomerRepository extends CrudRepository<PocCustomer, Long> {

	 List<PocCustomer> findByCardIdIsContainingAndFullNameIsContainingOrderByCusIdAsc(String cardId,String name);
	 List<PocCustomer> findByCardIdIsContainingOrderByCusIdAsc(String cardId);
	 List<PocCustomer> findByFullNameIsContainingOrderByCusIdAsc(String name);
	 
	 List<PocCustomer> findAllByOrderByCusIdAsc();
	 
	 
}
