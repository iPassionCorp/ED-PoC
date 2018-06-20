package th.co.ipassion.ed.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the POC_M_GROUP_PRODUCT database table.
 * 
 */
@Entity
@Table(name="POC_M_GROUP_PRODUCT")
@NamedQuery(name="PocMGroupProduct.findAll", query="SELECT p FROM PocMGroupProduct p")
public class PocMGroupProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PocMGroupProductPK id;

	@Column(name="GP_NAME")
	private String gpName;

	@Column(name="PRODUCT_NAME")
	private String productName;

	public PocMGroupProduct() {
	}

	public PocMGroupProductPK getId() {
		return this.id;
	}

	public void setId(PocMGroupProductPK id) {
		this.id = id;
	}

	public String getGpName() {
		return this.gpName;
	}

	public void setGpName(String gpName) {
		this.gpName = gpName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}