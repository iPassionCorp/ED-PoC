package th.co.ipassion.ed.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the POC_CUSTOMER database table.
 * 
 */
@Entity
@Table(name="POC_CUSTOMER")
@NamedQuery(name="PocCustomer.findAll", query="SELECT p FROM PocCustomer p")
public class PocCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUS_ID")
	private long cusId;

	private String address;

	@Column(name="CARD_ID")
	private String cardId;

	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;

	public PocCustomer() {
	}

	public long getCusId() {
		return this.cusId;
	}

	public void setCusId(long cusId) {
		this.cusId = cusId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}