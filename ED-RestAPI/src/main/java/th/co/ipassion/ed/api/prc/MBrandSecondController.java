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

import th.co.ipassion.ed.bean.prc.MBrandSecondBeanSave;
import th.co.ipassion.ed.bean.prc.MBrandSecondBeanSearch;
import th.co.ipassion.ed.model.prc.MBrandSecond;
import th.co.ipassion.ed.repository.prc.MBrandSecondRepository;

@RestController
public class MBrandSecondController {
	
	private static final Logger log = LoggerFactory.getLogger(MBrandSecondController.class);
	
	@Autowired
	private MBrandSecondRepository mBrandSecondRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/findBrandSecondCodeByObject")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<MBrandSecond> findBrandSecondCodeByObject(@Valid@RequestBody MBrandSecondBeanSearch mBrandSecondBean) {
		//TODO write with criteria builder
		return mBrandSecondRepository.findAll();
	}
	
	@RequestMapping("/saveBrandSecondCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public MBrandSecond saveBrandSecondCode(@Valid@RequestBody MBrandSecondBeanSearch mBrandSecondBean) {
		log.info(mBrandSecondBean.toString());
		if(StringUtils.isEmpty(mBrandSecondBean.getBrandSecondCode())) {
			mBrandSecondBean.setBrandSecondCode(jdbcTemplate.queryForObject("SELECT LPAD(EDPRC.BRAND_SECOND_SEQ.NEXTVAL, 2, '0') FROM DUAL", String.class));
		}
		return mBrandSecondRepository.save(new MBrandSecond(mBrandSecondBean));
	}
	@RequestMapping("/deleteBrandSecondCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public void deleteBrandSecondCode(@Valid@RequestBody MBrandSecondBeanSave mBrandSecondBean) {
		 mBrandSecondRepository.delete(new MBrandSecond(mBrandSecondBean));
		 //TODO return success;
	}
	
}
