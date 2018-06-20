package th.co.ipassion.ed.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the POC_M_GROUP_PRODUCT database table.
 * 
 */
@Embeddable
public class PocMGroupProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GP_ID")
	private String gpId;

	@Column(name="PRODUCT_ID")
	private long productId;

	public PocMGroupProductPK() {
	}
	public String getGpId() {
		return this.gpId;
	}
	public void setGpId(String gpId) {
		this.gpId = gpId;
	}
	public long getProductId() {
		return this.productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PocMGroupProductPK)) {
			return false;
		}
		PocMGroupProductPK castOther = (PocMGroupProductPK)other;
		return 
			this.gpId.equals(castOther.gpId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.gpId.hashCode();
		hash = hash * prime + ((int) (this.productId ^ (this.productId >>> 32)));
		
		return hash;
	}
}