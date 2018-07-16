package th.co.ipassion.ed.model.rdb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the M_ADDRESS_THAILAND database table.
 * 
 */
@Entity
@Table(name="M_ADDRESS_THAILAND" , schema = "EDRDB")
@NamedQuery(name="MAddressThailand.findAll", query="SELECT m FROM MAddressThailand m")
public class MAddressThailand implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MAddressThailandPK id;

	@Column(name="BORDER_NAME")
	private String borderName;

	@Column(name="BORDER_POSTAL_CODE")
	private BigDecimal borderPostalCode;

	@Column(name="DISTRICT_NAME")
	private String districtName;

	@Column(name="DISTRICT_POSTAL_CODE")
	private BigDecimal districtPostalCode;

	@Column(name="PROVINCE_NAME")
	private String provinceName;

	public MAddressThailand() {
	}

	public MAddressThailandPK getId() {
		return this.id;
	}

	public void setId(MAddressThailandPK id) {
		this.id = id;
	}

	public String getBorderName() {
		return this.borderName;
	}

	public void setBorderName(String borderName) {
		this.borderName = borderName;
	}

	public BigDecimal getBorderPostalCode() {
		return this.borderPostalCode;
	}

	public void setBorderPostalCode(BigDecimal borderPostalCode) {
		this.borderPostalCode = borderPostalCode;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public BigDecimal getDistrictPostalCode() {
		return this.districtPostalCode;
	}

	public void setDistrictPostalCode(BigDecimal districtPostalCode) {
		this.districtPostalCode = districtPostalCode;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}