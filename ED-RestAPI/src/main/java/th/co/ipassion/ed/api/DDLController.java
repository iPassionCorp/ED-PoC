package th.co.ipassion.ed.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import th.co.ipassion.ed.bean.Categorie;
import th.co.ipassion.ed.model.PocCustomerType;
import th.co.ipassion.ed.model.PocMGroupProduct;
import th.co.ipassion.ed.model.PocPrefixPostfix;
import th.co.ipassion.ed.model.PocReceiver;
import th.co.ipassion.ed.repository.PocCustomerRepository;
import th.co.ipassion.ed.repository.PocCustomerTypeRepository;
import th.co.ipassion.ed.repository.PocMGroupProductRepository;
import th.co.ipassion.ed.repository.PocPrefixPostfixRepository;
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
	PocPrefixPostfixRepository pocPrefixPostfixRepository;
	
	@Autowired
	private PocMGroupProductRepository pocMGroupProductRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/getReceiver")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<PocReceiver> getReceiver() {
		return pocReceiverRepository.findAllByOrderByRIdAsc();
	}
	
	@RequestMapping("/getCustomerType")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<PocCustomerType> getAllCustomerType() {
		return pocCustomerTypeRepository.findAllByOrderByCTypeIdAsc();
	}
	
	@RequestMapping("/getAllPrePostFix")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<PocPrefixPostfix> getAllPrePostFix() {
		return pocPrefixPostfixRepository.findAllByOrderByPpId();
	}
	
	//4002
	@RequestMapping("/getCategories")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public  List<Map<String, Object>> getCategories() {
		return jdbcTemplate.queryForList("select  gp_id,GP_NAME from POC_M_GROUP_PRODUCT group by gp_id,GP_NAME ORDER by Gp_Name asc");
	}
	
	//4003
	@RequestMapping("/getAllProductList")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<PocMGroupProduct> getProductList() {
		return pocMGroupProductRepository.findAllByOrderByGpNameAsc();
	}
	
	@RequestMapping("/getAllCat")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public  List<Categorie> getAllCat() {
		return jdbcTemplate.query("SELECT GP_ID,GP_NAME FROM POC_M_GROUP_PRODUCT GROUP BY GP_ID,GP_NAME ORDER BY GP_NAME ASC" ,rowMapperCategorie);
	}
	
	//4003
	@RequestMapping("/getProductByCatId")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<PocMGroupProduct> getProductByCatId(@RequestParam("gpId") String gpId) {
		return pocMGroupProductRepository.findAllByIdGpId(gpId);
	}
	
	private static final RowMapper<Categorie> rowMapperCategorie = new RowMapper<Categorie>() { 
		@Override 
		public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException { 
			Categorie dto = new Categorie(); 
			dto.setGpId(rs.getString("GP_ID"));
			dto.setGpName(rs.getString("GP_NAME"));
			return dto; 
		} 
	};

	
}
