package th.co.ipassion.ed.model.prc;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the M_SIZE database table.
 * 
 */
@Embeddable
public class MSizePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DUTY_CODE")
	private String dutyCode;

	@Column(name="SIZE_CODE")
	private String sizeCode;

	public MSizePK() {
	}
	public String getDutyCode() {
		return this.dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	public String getSizeCode() {
		return this.sizeCode;
	}
	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MSizePK)) {
			return false;
		}
		MSizePK castOther = (MSizePK)other;
		return 
			this.dutyCode.equals(castOther.dutyCode)
			&& this.sizeCode.equals(castOther.sizeCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dutyCode.hashCode();
		hash = hash * prime + this.sizeCode.hashCode();
		
		return hash;
	}
}