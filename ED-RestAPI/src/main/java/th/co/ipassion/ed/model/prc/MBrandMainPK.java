package th.co.ipassion.ed.model.prc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The primary key class for the M_BRAND_MAIN database table.
 * 
 */
@Embeddable
public class MBrandMainPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DUTY_CODE",nullable = false )
	private String dutyCode;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BRAND_MAIN_CODE" , insertable=false,updatable = false ,nullable = false )
	private String brandMainCode;

	public MBrandMainPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MBrandMainPK)) {
			return false;
		}
		MBrandMainPK castOther = (MBrandMainPK)other;
		return 
			this.dutyCode.equals(castOther.dutyCode)
			&& this.brandMainCode.equals(castOther.brandMainCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dutyCode.hashCode();
		hash = hash * prime + this.brandMainCode.hashCode();
		
		return hash;
	}
}