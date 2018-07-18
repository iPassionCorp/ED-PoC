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

import th.co.ipassion.ed.bean.prc.MSizeBeanSave;
import th.co.ipassion.ed.bean.prc.MSizeBeanSearch;


/**
 * The persistent class for the M_SIZE database table.
 * 
 */
@Entity
@Table(name="M_SIZE"  , schema = "EDPRC")
@NamedQuery(name="MSize.findAll", query="SELECT m FROM MSize m")
public class MSize implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MSizePK id;

	@Column(name="DESCRIPTION")
	private String desc;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="UNIT_CODE")
	private String unitCode;

	public MSize() {
	}
	
	public MSize(MSizeBeanSearch bean) {
		super();
		this.id = new MSizePK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setSizeCode(bean.getSizeCode());
		this.desc = bean.getDesc();
		this.unitCode = bean.getUnitCode();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}
	
	public MSize(MSizeBeanSave bean) {
		super();
		this.id = new MSizePK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setSizeCode(bean.getSizeCode());
		this.desc = bean.getDesc();
		this.unitCode = bean.getUnitCode();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}

	public MSizePK getId() {
		return this.id;
	}

	public void setId(MSizePK id) {
		this.id = id;
	}
	
	public String getDutyCode() {
		return this.id.getDutyCode();
	}
	
	public String getSizeCode() {
		return this.id.getSizeCode();
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

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

}