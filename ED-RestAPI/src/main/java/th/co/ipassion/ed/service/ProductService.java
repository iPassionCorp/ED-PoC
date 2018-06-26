package th.co.ipassion.ed.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import th.co.ipassion.ed.bean.SaveData;
import th.co.ipassion.ed.model.PocRegisCusProd;
import th.co.ipassion.ed.model.PocRegisCusProdPK;
import th.co.ipassion.ed.repository.PocRegisCusProdRepository;

@Service("productService")
public class ProductService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PocRegisCusProdRepository pocRegisCusProdRepository;
	
	@Transactional
	public Map<String,Object> saveCusProduct(SaveData data,Map<String,Object> res){
		
//		for(PocRegisCusProd pro:data.getProducts()) {
//			pro.setCusId(data.getCusId());
//			if(pocRegisCusProdRepository.findAlLByCusIdAndGpIdAndProductId(pro.getCusId(),pro.getGpId(),pro.getProductId()).size()>1) {
//				res.put("error", "Dup"+pro.toString());
//			}
//		}
		
		for(PocRegisCusProdPK prod:data.getProducts()) {
			prod.setCusId(data.getCusId());
//			pro.get.setCusId(data.getCusId());
//			if(pocRegisCusProdRepository.findAlLByCusIdAndGpIdAndProductId(prod.getCusId(),prod.getGpId(),prod.getProductId()).size()>1) {
				//
//			}else {
				pocRegisCusProdRepository.save(new PocRegisCusProd(prod));
//			}
		}
		
		return res;
	}
}
