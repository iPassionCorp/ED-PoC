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

import th.co.ipassion.ed.bean.prc.MBrandSecondBeanSave;
import th.co.ipassion.ed.bean.prc.MBrandSecondBeanSearch;


/**
 * The persistent class for the M_BRAND_SECOND database table.
 * 
 */
@Entity
@Table(name="M_BRAND_SECOND" , schema = "EDPRC")
@NamedQuery(name="MBrandSecond.findAll", query="SELECT m FROM MBrandSecond m")
public class MBrandSecond implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MBrandSecondPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="NAME_EN")
	private String nameEn;

	@Column(name="NAME_TH")
	private String nameTh;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	public MBrandSecond() {
	}
	
	public MBrandSecond(MBrandSecondBeanSearch bean) {
		super();
		this.id = new MBrandSecondPK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setBrandMainCode(bean.getBrandMainCode());
		this.id.setBrandSecondCode(bean.getBrandSecondCode());
		this.nameEn = bean.getNameEn();
		this.nameTh = bean.getNameTh();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}
	
	public MBrandSecond(MBrandSecondBeanSave bean) {
		super();
		this.id = new MBrandSecondPK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setBrandMainCode(bean.getBrandMainCode());
		this.id.setBrandSecondCode(bean.getBrandSecondCode());
		this.nameEn = bean.getNameEn();
		this.nameTh = bean.getNameTh();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}
	
	public String getDutyCode() {
		return this.id.getDutyCode();
	}
	
	public String getBrandMainCode() {
		return this.id.getBrandMainCode();
	}
	
	public String getBrandSecondCode() {
		return this.id.getBrandSecondCode();
	}
	
	public MBrandSecondPK getId() {
		return this.id;
	}

	public void setId(MBrandSecondPK id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameTh() {
		return this.nameTh;
	}

	public void setNameTh(String nameTh) {
		this.nameTh = nameTh;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}