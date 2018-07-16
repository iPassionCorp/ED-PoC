package th.co.ipassion.ed.model.prc;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the M_BRAND_SECOND database table.
 * 
 */
@Entity
@Table(name="M_BRAND_SECOND" , schema = "EDPRC")
@NamedQuery(name="MBrandSecond.findAll", query="SELECT m FROM MBrandSecond m")
public class MBrandSecond implements Serializable {
	private static final long serialVersionUID = 1L;

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