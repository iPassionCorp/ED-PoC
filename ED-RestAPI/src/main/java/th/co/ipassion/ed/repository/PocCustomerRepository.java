package th.co.ipassion.ed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.PocCustomer;

@Repository
public interface PocCustomerRepository extends CrudRepository<PocCustomer, Long> {

	 List<PocCustomer> findByCardIdIsAndFullNameIsContaining(String cardId,String name);
	 List<PocCustomer> findByCardId(String cardId);
	 List<PocCustomer> findByFullNameIsContaining(String name);
	 
}
