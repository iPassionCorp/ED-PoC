package th.co.ipassion.ed.model.prc;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the M_BRAND_SECOND database table.
 * 
 */
@Embeddable
public class MBrandSecondPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DUTY_CODE")
	private String dutyCode;

	@Column(name="BRAND_MAIN_CODE")
	private String brandMainCode;

	@Column(name="BRAND_SECOND_CODE")
	private String brandSecondCode;

	public MBrandSecondPK() {
	}
	public String getDutyCode() {
		return this.dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	public String getBrandMainCode() {
		return this.brandMainCode;
	}
	public void setBrandMainCode(String brandMainCode) {
		this.brandMainCode = brandMainCode;
	}
	public String getBrandSecondCode() {
		return this.brandSecondCode;
	}
	public void setBrandSecondCode(String brandSecondCode) {
		this.brandSecondCode = brandSecondCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MBrandSecondPK)) {
			return false;
		}
		MBrandSecondPK castOther = (MBrandSecondPK)other;
		return 
			this.dutyCode.equals(castOther.dutyCode)
			&& this.brandMainCode.equals(castOther.brandMainCode)
			&& this.brandSecondCode.equals(castOther.brandSecondCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dutyCode.hashCode();
		hash = hash * prime + this.brandMainCode.hashCode();
		hash = hash * prime + this.brandSecondCode.hashCode();
		
		return hash;
	}
}