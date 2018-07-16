package th.co.ipassion.ed.repository.prc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.prc.MBrandMain;


@Repository
public interface MBrandMainRepository extends CrudRepository<MBrandMain, String> {
	
//	List<MDuty> findByNameIsContainingOrderByDutyCodeAsc(String name);
//	List<MDuty> findByDutyCodeIsContainingOrderByDutyCodeAsc(String dutyCode);
	

}
