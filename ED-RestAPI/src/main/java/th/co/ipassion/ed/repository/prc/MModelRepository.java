package th.co.ipassion.ed.repository.prc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.prc.MModel;


@Repository
public interface MModelRepository extends CrudRepository<MModel, String> {
	
//	List<MDuty> findByNameIsContainingOrderByDutyCodeAsc(String name);
//	List<MDuty> findByDutyCodeIsContainingOrderByDutyCodeAsc(String dutyCode);
	

}
