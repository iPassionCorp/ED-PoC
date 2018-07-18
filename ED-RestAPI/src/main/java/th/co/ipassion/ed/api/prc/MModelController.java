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

import th.co.ipassion.ed.bean.prc.MModelBeanSave;
import th.co.ipassion.ed.bean.prc.MModelBeanSearch;
import th.co.ipassion.ed.model.prc.MModel;
import th.co.ipassion.ed.repository.prc.MModelRepository;

@RestController
public class MModelController {
	
	private static final Logger log = LoggerFactory.getLogger(MModelController.class);
	
	@Autowired
	private MModelRepository mModelRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/findModelCodeByObject")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Iterable<MModel> findModelCodeByObject(@Valid@RequestBody MModelBeanSearch mModelBean) {
		//TODO write with criteria builder
		return mModelRepository.findAll();
	}
	
	@RequestMapping("/saveModelCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public MModel saveModelCode(@Valid@RequestBody MModelBeanSearch mModelBean) {
		log.info(mModelBean.toString());
		if(StringUtils.isEmpty(mModelBean.getModelCode())) {
			mModelBean.setModelCode(jdbcTemplate.queryForObject("SELECT LPAD(EDPRC.MODEL_SEQ.NEXTVAL, 3, '0') FROM DUAL", String.class));
		}
		return mModelRepository.save(new MModel(mModelBean));
	}
	@RequestMapping("/deleteModelCode")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public void deleteModelCode(@Valid@RequestBody MModelBeanSave mModelBean) {
		 mModelRepository.delete(new MModel(mModelBean));
		 //TODO return success;
	}
	
}
