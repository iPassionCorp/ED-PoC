package th.co.ipassion.ed.model.prc;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the M_SIZE database table.
 * 
 */
@Entity
@Table(name="M_SIZE"  , schema = "EDPRC")
@NamedQuery(name="MSize.findAll", query="SELECT m FROM MSize m")
public class MSize implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MSizePK id;

	@Column(name="\"DESC\"")
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

	public MSizePK getId() {
		return this.id;
	}

	public void setId(MSizePK id) {
		this.id = id;
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