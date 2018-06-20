package th.co.ipassion.ed.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import th.co.ipassion.ed.model.Customer;
import th.co.ipassion.ed.model.PocCustomer;
import th.co.ipassion.ed.model.PocMGroupProduct;
import th.co.ipassion.ed.repository.CustomerRepository;
import th.co.ipassion.ed.repository.PocCustomerRepository;
import th.co.ipassion.ed.repository.PocMGroupProductRepository;

@RestController
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private PocCustomerRepository pocCustomerRepository;
	
	@Autowired
	private PocMGroupProductRepository pocMGroupProductRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/listAllCustomer")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<Customer> listAllCustomer() {

		List<Customer> result = new ArrayList<Customer>();

		// save a couple of customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		for (Customer customer : repository.findAll()) {
			result.add(customer);
		}
		
		return result;
	}
	
	@RequestMapping("/getAllCustomer")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<PocCustomer> getAllCustomer() {
		return pocCustomerRepository.findAll();
	}
	
	//4001
	@RequestMapping("/findCustomer")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<PocCustomer> findCustomer() {
		return pocCustomerRepository.findAll();
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
	
	//4004
//	@RequestMapping("/saveData")
	@RequestMapping(value = "/saveData", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> saveData(@RequestBody Map<String, Object> req) {
		Map<String, Object> res = new HashMap<>();
		Gson gson = new Gson();
		try {
			//todo
			log.info(gson.toJson(req));
			res.put("res", "saved");
		} catch (Exception e) {
			res.put("res", "error");
		}
		return res;
	}
	
}
