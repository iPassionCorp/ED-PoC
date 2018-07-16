package th.co.ipassion.ed.model.rdb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the M_UNIT database table.
 * 
 */
@Entity
@Table(name="M_UNIT" , schema = "EDRDB")
@NamedQuery(name="MUnit.findAll", query="SELECT m FROM MUnit m")
public class MUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UNIT_CODE")
	private String unitCode;

	private String name;

	public MUnit() {
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}