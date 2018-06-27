package th.co.ipassion.ed.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import th.co.ipassion.ed.bean.SaveData;
import th.co.ipassion.ed.bean.SaveDataAll;
import th.co.ipassion.ed.model.Customer;
import th.co.ipassion.ed.model.PocCustomer;
import th.co.ipassion.ed.repository.CustomerRepository;
import th.co.ipassion.ed.repository.PocCustomerRepository;
import th.co.ipassion.ed.repository.PocMGroupProductRepository;
import th.co.ipassion.ed.repository.PocRegisCusProdRepository;
import th.co.ipassion.ed.service.ProductService;

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
	PocRegisCusProdRepository pocRegisCusProdRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProductService productService;
	
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
		return pocCustomerRepository.findAllByOrderByCusIdAsc();
	}
	
	//4001
	@RequestMapping(value = "/findCustomer", method = RequestMethod.POST )
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<PocCustomer> findCustomer(@RequestBody Map<String, Object> req) {
		String cardId = (String)req.get("cardId");
		String name = (String)req.get("fullName");
		Iterable<PocCustomer> res= null;
		if((!StringUtils.isEmpty(cardId))&&(!StringUtils.isEmpty(name))) {
			res = pocCustomerRepository.findByCardIdIsContainingAndFullNameIsContainingOrderByCusIdAsc(cardId, name);
		}else if((!StringUtils.isEmpty(cardId))&&(StringUtils.isEmpty(name))) {
			res = pocCustomerRepository.findByCardIdIsContainingOrderByCusIdAsc(cardId);
		}else if((StringUtils.isEmpty(cardId))&&(!StringUtils.isEmpty(name))) {
			res = pocCustomerRepository.findByFullNameIsContainingOrderByCusIdAsc(name);
		}else {
			res = pocCustomerRepository.findAllByOrderByCusIdAsc();
		}
		return res;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST )
	public Map<String, Object> saveCus(@RequestBody PocCustomer pocCustomer) {
		Map<String, Object> res = new HashMap<>();
		Gson gson = new Gson();
		try {
			Locale lc = new Locale("th","TH");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy",lc);
			pocCustomer.setReceivedate_date(formatter.parse(pocCustomer.getReceivedate()));
			pocCustomerRepository.save(pocCustomer);
			log.info(gson.toJson(pocCustomer));
			res.put("res", "saved");
		} catch (Exception e) {
			res.put("res", e.getMessage() );
			log.error(e.getMessage(),e);
		}
		return res;
	}
	
	//4004
//	@RequestMapping("/saveData")
	@RequestMapping(value = "/saveCusProducts", method = RequestMethod.POST )
	public Map<String, Object> saveData(@RequestBody SaveData data) {
		Map<String, Object> res = new HashMap<>();
		Gson gson = new Gson();
		try {
			//todo
			productService.saveCusProduct(data, res);
			
			res.put("products", pocRegisCusProdRepository.findAlLByIdCusId(data.getCusId()));
			log.info(gson.toJson(data));
			res.put("res", "saved");
		} catch (Exception e) {
			res.put("res", e.getMessage() );
			log.error(e.getMessage(),e);
		}
		return res;
	}
	
	@RequestMapping(value = "/getProductsByCus", method = RequestMethod.POST )
	public Map<String, Object> getCustomer(@RequestBody PocCustomer pocCustomer) {
		Map<String, Object> res = new HashMap<>();
		Gson gson = new Gson();
		try {
			log.info(gson.toJson(pocCustomer));
//			res.put("pocCustomer",pocCustomerRepository.findById(pocCustomer.getCusId()) );
			res.put("products", pocRegisCusProdRepository.findAlLByIdCusId(pocCustomer.getCusId() ));
		} catch (Exception e) {
			res.put("res", e.getMessage() );
			log.error(e.getMessage(),e);
		}
		return res;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST )
	public Map<String, Object> register(@RequestBody SaveDataAll data) {
		Map<String, Object> res = new HashMap<>();
		Gson gson = new Gson();
		try {
			//todo
			log.info(gson.toJson(data));
			productService.register(data.getCustomer(),new SaveData(data.getCustomer().getCusId(),data.getProducts()), res);
			res.put("res", "saved");
		} catch (Exception e) {	
			res.put("res", e.getMessage() );
			log.error(e.getMessage(),e);
		}
		return res;
	}
	
	
}
