package th.co.ipassion.ed.model.rdb;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the M_ADDRESS_THAILAND database table.
 * 
 */
@Embeddable
public class MAddressThailandPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROVINCE_ID")
	private long provinceId;

	@Column(name="BORDER_ID")
	private long borderId;

	@Column(name="DISTRICT_ID")
	private long districtId;

	public MAddressThailandPK() {
	}
	public long getProvinceId() {
		return this.provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}
	public long getBorderId() {
		return this.borderId;
	}
	public void setBorderId(long borderId) {
		this.borderId = borderId;
	}
	public long getDistrictId() {
		return this.districtId;
	}
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MAddressThailandPK)) {
			return false;
		}
		MAddressThailandPK castOther = (MAddressThailandPK)other;
		return 
			(this.provinceId == castOther.provinceId)
			&& (this.borderId == castOther.borderId)
			&& (this.districtId == castOther.districtId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.provinceId ^ (this.provinceId >>> 32)));
		hash = hash * prime + ((int) (this.borderId ^ (this.borderId >>> 32)));
		hash = hash * prime + ((int) (this.districtId ^ (this.districtId >>> 32)));
		
		return hash;
	}
}