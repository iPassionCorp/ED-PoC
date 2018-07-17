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

import th.co.ipassion.ed.bean.prc.MBrandMainBeanSave;
import th.co.ipassion.ed.bean.prc.MBrandMainBeanSearch;


/**
 * The persistent class for the M_BRAND_MAIN database table.
 * 
 */
@Entity
@Table(name="M_BRAND_MAIN" , schema = "EDPRC")
@NamedQuery(name="MBrandMain.findAll", query="SELECT m FROM MBrandMain m")
public class MBrandMain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MBrandMainPK id;

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

	public MBrandMain() {
	}
	
	public MBrandMain(MBrandMainBeanSearch bean) {
		super();
		this.id = new MBrandMainPK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setBrandMainCode(bean.getBrandMainCode());
		this.nameEn = bean.getNameEn();
		this.nameTh = bean.getNameTh();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}
	
	public MBrandMain(MBrandMainBeanSave bean) {
		super();
		this.id = new MBrandMainPK();
		this.id.setDutyCode(bean.getDutyCode());
		this.id.setBrandMainCode(bean.getBrandMainCode());
		this.nameEn = bean.getNameEn();
		this.nameTh = bean.getNameTh();
		this.startDate = bean.getStartDate();
		this.endDate = bean.getEndDate();
	}

	public MBrandMainPK getId() {
		return this.id;
	}

	public void setId(MBrandMainPK id) {
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
	
	public String getDutyCode() {
		return this.id.getDutyCode();
	}
	public void setDutyCode(String dutyCode) {
		this.id.setDutyCode(dutyCode);
	}
	public String getBrandMainCode() {
		return this.id.getBrandMainCode();
	}
	public void setBrandMainCode(String brandMainCode) {
		this.id.setBrandMainCode(brandMainCode);
	}
	
	
}