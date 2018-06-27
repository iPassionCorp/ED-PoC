package th.co.ipassion.ed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.PocReceiver;

@Repository
public interface PocReceiverRepository extends CrudRepository<PocReceiver, Long> {

	List<PocReceiver> findAllByOrderByRIdAsc();
	
}
