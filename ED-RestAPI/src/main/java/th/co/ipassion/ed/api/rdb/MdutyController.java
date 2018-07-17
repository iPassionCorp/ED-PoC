package th.co.ipassion.ed.api.rdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.co.ipassion.ed.model.rdb.MDuty;
import th.co.ipassion.ed.repository.rdb.MDutyRepository;

@RestController
public class MdutyController {
	
	private static final Logger log = LoggerFactory.getLogger(MdutyController.class);
	
	@Autowired
	private MDutyRepository mDutyRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("/findDutyCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<MDuty> findDutyCode(@RequestBody MDuty mDuty) {
		//TODO write with criteria builder
		return mDutyRepository.findAll();
	}
	
}
