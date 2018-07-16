package th.co.ipassion.ed.model.prc;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the M_MODEL database table.
 * 
 */
@Entity
@Table(name="M_MODEL"  , schema = "EDPRC")
@NamedQuery(name="MModel.findAll", query="SELECT m FROM MModel m")
public class MModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MModelPK id;

	@Column(name="\"DESC\"")
	private String desc;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	public MModel() {
	}

	public MModelPK getId() {
		return this.id;
	}

	public void setId(MModelPK id) {
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

}