package th.co.ipassion.ed.api;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.co.ipassion.ed.model.PocCustomerType;
import th.co.ipassion.ed.model.PocMGroupProduct;
import th.co.ipassion.ed.model.PocReceiver;
import th.co.ipassion.ed.repository.PocCustomerRepository;
import th.co.ipassion.ed.repository.PocCustomerTypeRepository;
import th.co.ipassion.ed.repository.PocMGroupProductRepository;
import th.co.ipassion.ed.repository.PocReceiverRepository;

@RestController
@RequestMapping("/DDL")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class DDLController {
	
	private static final Logger log = LoggerFactory.getLogger(DDLController.class);
	
	@Autowired
	PocReceiverRepository pocReceiverRepository;
	
	@Autowired 
	PocCustomerTypeRepository pocCustomerTypeRepository;
	
	@Autowired
	private PocCustomerRepository pocCustomerRepository;
	
	@Autowired
	private PocMGroupProductRepository pocMGroupProductRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/getReceiver")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<PocReceiver> getReceiver() {
		return pocReceiverRepository.findAll();
	}
	
	@RequestMapping("/getCustomerType")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<PocCustomerType> getAllCustomerType() {
		return pocCustomerTypeRepository.findAll();
	}
	
	//4002
	@RequestMapping("/getCategories")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public  List<Map<String, Object>> getCategories() {
		return jdbcTemplate.queryForList("select  gp_id,GP_NAME from POC_M_GROUP_PRODUCT group by gp_id,GP_NAME");
	}
	
	//4003
	@RequestMapping("/getProductList")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<PocMGroupProduct> getProductList() {
		return pocMGroupProductRepository.findAll();
	}
	
}
