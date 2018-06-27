package th.co.ipassion.ed.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


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
	
	@Column(name="RECEIVEID")
	private long receiveid;
	
	@Transient
	private String receivedate;
	
	@Column(name="RECEIVEDATE")
	@Temporal(TemporalType.DATE)
    private Date receivedate_date;
	
	@Column(name="R_ID")
	private String receiver;

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

	public long getReceiveid() {
		return receiveid;
	}

	public void setReceiveid(long receiveid) {
		this.receiveid = receiveid;
	}

	public String getReceivedate() {
		return receivedate;
	}

	public void setReceivedate(String receivedate) {
		this.receivedate = receivedate;
	}

	public Date getReceivedate_date() {
		return receivedate_date;
	}

	public void setReceivedate_date(Date receivedate_date) {
		this.receivedate_date = receivedate_date;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	

}