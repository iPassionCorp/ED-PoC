package th.co.ipassion.ed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.PocRegisCusProd;

@Repository
public interface PocRegisCusProdRepository extends CrudRepository<PocRegisCusProd, Long> {

	List<PocRegisCusProd> findAlLByIdCusId(long cusId);
	
//	List<PocRegisCusProd> findAlLByCusIdAndGpIdAndProductId(long cusId,String gpId,long prodId);
	
}
