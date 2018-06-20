package th.co.ipassion.ed.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the POC_RECEIVER database table.
 * 
 */
@Entity
@Table(name="POC_RECEIVER")
@NamedQuery(name="PocReceiver.findAll", query="SELECT p FROM PocReceiver p")
public class PocReceiver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="R_ID")
	private String rId;

	@Column(name="R_FULL_NAME")
	private String rFullName;

	public PocReceiver() {
	}

	public String getRId() {
		return this.rId;
	}

	public void setRId(String rId) {
		this.rId = rId;
	}

	public String getRFullName() {
		return this.rFullName;
	}

	public void setRFullName(String rFullName) {
		this.rFullName = rFullName;
	}

}