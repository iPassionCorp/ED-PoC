package th.co.ipassion.ed.model.prc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

/**
 * The primary key class for the M_MODEL database table.
 * 
 */
@Embeddable
public class MModelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="DUTY_CODE")
	private String dutyCode;
	
	@GeneratedValue
	@Column(name="MODEL_CODE")
	private String modelCode;

	public MModelPK() {
	}
	public String getDutyCode() {
		return this.dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	public String getModelCode() {
		return this.modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MModelPK)) {
			return false;
		}
		MModelPK castOther = (MModelPK)other;
		return 
			this.dutyCode.equals(castOther.dutyCode)
			&& this.modelCode.equals(castOther.modelCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dutyCode.hashCode();
		hash = hash * prime + this.modelCode.hashCode();
		
		return hash;
	}
}