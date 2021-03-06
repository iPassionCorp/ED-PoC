package th.co.ipassion.ed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.co.ipassion.ed.model.PocPrefixPostfix;

@Repository
public interface PocPrefixPostfixRepository extends CrudRepository<PocPrefixPostfix, Long> {

    List<PocPrefixPostfix> findAllByOrderByPpId();
    
}
