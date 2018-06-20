package th.co.ipassion.ed.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the POC_M_TUMBON database table.
 * 
 */
@Entity
@Table(name="POC_M_TUMBON")
@NamedQuery(name="PocMTumbon.findAll", query="SELECT p FROM PocMTumbon p")
public class PocMTumbon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TB_ID")
	private long tbId;

	@Column(name="AP_ID")
	private BigDecimal apId;

	@Column(name="AP_NAME")
	private String apName;

	@Column(name="CT_ID")
	private BigDecimal ctId;

	@Column(name="CT_NAME")
	private String ctName;

	@Column(name="POST_ID")
	private BigDecimal postId;

	@Column(name="TB_NAME")
	private String tbName;

	public PocMTumbon() {
	}

	public long getTbId() {
		return this.tbId;
	}

	public void setTbId(long tbId) {
		this.tbId = tbId;
	}

	public BigDecimal getApId() {
		return this.apId;
	}

	public void setApId(BigDecimal apId) {
		this.apId = apId;
	}

	public String getApName() {
		return this.apName;
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	public BigDecimal getCtId() {
		return this.ctId;
	}

	public void setCtId(BigDecimal ctId) {
		this.ctId = ctId;
	}

	public String getCtName() {
		return this.ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public BigDecimal getPostId() {
		return this.postId;
	}

	public void setPostId(BigDecimal postId) {
		this.postId = postId;
	}

	public String getTbName() {
		return this.tbName;
	}

	public void setTbName(String tbName) {
		this.tbName = tbName;
	}

}