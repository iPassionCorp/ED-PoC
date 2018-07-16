package th.co.ipassion.ed.repository.rdb;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.rdb.MDuty;

@Repository
public interface MDutyRepository extends CrudRepository<MDuty, String> {
	
	List<MDuty> findByNameIsContainingOrderByDutyCodeAsc(String name);
	List<MDuty> findByDutyCodeIsContainingOrderByDutyCodeAsc(String dutyCode);
	

}
