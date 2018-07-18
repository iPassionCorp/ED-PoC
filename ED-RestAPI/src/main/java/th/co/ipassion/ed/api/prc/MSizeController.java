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

import th.co.ipassion.ed.bean.prc.MSizeBeanSave;
import th.co.ipassion.ed.bean.prc.MSizeBeanSearch;
import th.co.ipassion.ed.model.prc.MSize;
import th.co.ipassion.ed.repository.prc.MSizeRepository;

@RestController
public class MSizeController {
	
	private static final Logger log = LoggerFactory.getLogger(MSizeController.class);
	
	@Autowired
	private MSizeRepository mSizeRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/findSizeCodeByObject")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<MSize> findSizeCodeByObject(@Valid@RequestBody MSizeBeanSearch mSizeBean) {
		//TODO write with criteria builder
		return mSizeRepository.findAll();
	}
	
	@RequestMapping("/saveSizeCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public MSize saveSizeCode(@Valid@RequestBody MSizeBeanSearch mSizeBean) {
		log.info(mSizeBean.toString());
		if(StringUtils.isEmpty(mSizeBean.getSizeCode())) {
			mSizeBean.setSizeCode(jdbcTemplate.queryForObject("SELECT LPAD(EDPRC.SIZE_SEQ.NEXTVAL, 3, '0') FROM DUAL", String.class));
		}
		return mSizeRepository.save(new MSize(mSizeBean));
	}
	@RequestMapping("/deleteSizeCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public void deleteSizeCode(@Valid@RequestBody MSizeBeanSave mSizeBean) {
		 mSizeRepository.delete(new MSize(mSizeBean));
		 //TODO return success;
	}
	
}
