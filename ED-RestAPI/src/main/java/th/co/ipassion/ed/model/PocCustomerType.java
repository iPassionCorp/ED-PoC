package th.co.ipassion.ed.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the POC_CUSTOMER_TYPE database table.
 * 
 */
@Entity
@Table(name="POC_CUSTOMER_TYPE")
@NamedQuery(name="PocCustomerType.findAll", query="SELECT p FROM PocCustomerType p")
public class PocCustomerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_TYPE_ID")
	private long cTypeId;

	@Column(name="C_TYPE_NAME")
	private String cTypeName;

	public PocCustomerType() {
	}

	public long getCTypeId() {
		return this.cTypeId;
	}

	public void setCTypeId(long cTypeId) {
		this.cTypeId = cTypeId;
	}

	public String getCTypeName() {
		return this.cTypeName;
	}

	public void setCTypeName(String cTypeName) {
		this.cTypeName = cTypeName;
	}

}