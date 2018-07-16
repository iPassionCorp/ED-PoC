package th.co.ipassion.ed.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import th.co.ipassion.ed.bean.SaveData;
import th.co.ipassion.ed.model.PocCustomer;
import th.co.ipassion.ed.model.PocRegisCusProd;
import th.co.ipassion.ed.model.PocRegisCusProdPK;
import th.co.ipassion.ed.repository.PocCustomerRepository;
import th.co.ipassion.ed.repository.PocRegisCusProdRepository;

@Service("productService")
public class ProductService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PocRegisCusProdRepository pocRegisCusProdRepository;
	
	@Autowired
	private PocCustomerRepository pocCustomerRepository;
	
	@Transactional
	public Map<String,Object> saveCusProduct(SaveData data,Map<String,Object> res){
		
//		deleteByCusId
//		pocRegisCusProdRepository.deleteAll(pocRegisCusProdRepository.findAlLByIdCusId(data.getCusId()));
		
		
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
	
	
	@Transactional
	public Map<String,Object> register(PocCustomer pocCustomer, SaveData product,Map<String,Object> res) throws ParseException{
		Locale lc = new Locale("th","TH");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy",lc);
		pocCustomer.setReceivedate_date(formatter.parse(pocCustomer.getReceivedate()));
		pocCustomerRepository.save(pocCustomer);
		this.saveCusProduct( product , res);
		
		return res;
	}
}
