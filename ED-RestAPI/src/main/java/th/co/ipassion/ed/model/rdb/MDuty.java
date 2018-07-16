package th.co.ipassion.ed.model.rdb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the M_DUTY database table.
 * 
 */
@Entity
@Table(name="M_DUTY" , schema = "EDRDB")
@NamedQuery(name="MDuty.findAll", query="SELECT m FROM MDuty m")
public class MDuty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DUTY_CODE")
	private String dutyCode;

	private String name;

	public MDuty() {
	}

	public String getDutyCode() {
		return this.dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}