package th.co.ipassion.ed.model.prc;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import th.co.ipassion.ed.bean.prc.MModelBeanSave;
import th.co.ipassion.ed.bean.prc.MModelBeanSearch;


/**
 * The persistent class for the M_MODEL database table.
 * 
 */
@Entity
@Table(name="M_MODEL"  , schema = "EDPRC")
@NamedQuery(name="MModel.findAll", query="SELECT m FROM MModel m")
public class MModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MModelPK id;

	@Column(name="DESCRIPTION")
	private String desc;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	public MModel() {
	}
	
	public MModel(MModelBeanSearch bean) {
		super();
		this.id = new MModelPK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setModelCode(bean.getModelCode());
		this.desc = bean.getDesc();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}
	
	public MModel(MModelBeanSave bean) {
		super();
		this.id = new MModelPK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setModelCode(bean.getModelCode());
		this.desc = bean.getDesc();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}

	public MModelPK getId() {
		return this.id;
	}

	public void setId(MModelPK id) {
		this.id = id;
	}
	
	public String getDutyCode() {
		return this.id.getDutyCode();
	}
	
	public String getModelCode() {
		return this.id.getModelCode();
	}
	
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}