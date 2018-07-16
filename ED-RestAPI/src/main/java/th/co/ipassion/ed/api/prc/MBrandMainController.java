package th.co.ipassion.ed.api.prc;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.co.ipassion.ed.bean.prc.MBrandMainBean;
import th.co.ipassion.ed.model.prc.MBrandMain;
import th.co.ipassion.ed.repository.prc.MBrandMainRepository;

@RestController
public class MBrandMainController {
	
	private static final Logger log = LoggerFactory.getLogger(MBrandMainController.class);
	
	@Autowired
	private MBrandMainRepository mBrandMainRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/findBrandMainCodeByObject")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<MBrandMain> findBrandMainCodeByObject(@RequestBody MBrandMainBean mBrandMainBean) {
		//TODO write with criteria builder
		return mBrandMainRepository.findAll();
	}
	
	@RequestMapping("/saveBrandMainCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public MBrandMain saveBrandMainCode(@Valid@RequestBody MBrandMainBean mBrandMainBean) {
		log.info(mBrandMainBean.toString());
		if(StringUtils.isEmpty(mBrandMainBean.getBrandMainCode())) {
			mBrandMainBean.setBrandMainCode(jdbcTemplate.queryForObject("SELECT LPAD(EDPRC.BRAND_MAIN_SEQ.NEXTVAL, 3, '0') FROM DUAL", String.class));
		}
		return mBrandMainRepository.save(new MBrandMain(mBrandMainBean));
	}
	@RequestMapping("/deleteBrandMainCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public void deleteBrandMainCode(@RequestBody MBrandMainBean mBrandMainBean) {
		 mBrandMainRepository.delete(new MBrandMain(mBrandMainBean));
		 //TODO return success;
	}
	
}
