package th.co.ipassion.ed.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the POC_PREFIX_POSTFIX database table.
 * 
 */
@Entity
@Table(name="POC_PREFIX_POSTFIX")
@NamedQuery(name="PocPrefixPostfix.findAll", query="SELECT p FROM PocPrefixPostfix p")
public class PocPrefixPostfix implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PP_ID")
	private long ppId;

	@Column(name="PP_POSTFIX")
	private String ppPostfix;

	@Column(name="PP_PREFIX")
	private String ppPrefix;

	public PocPrefixPostfix() {
	}

	public long getPpId() {
		return this.ppId;
	}

	public void setPpId(long ppId) {
		this.ppId = ppId;
	}

	public String getPpPostfix() {
		return this.ppPostfix;
	}

	public void setPpPostfix(String ppPostfix) {
		this.ppPostfix = ppPostfix;
	}

	public String getPpPrefix() {
		return this.ppPrefix;
	}

	public void setPpPrefix(String ppPrefix) {
		this.ppPrefix = ppPrefix;
	}

}