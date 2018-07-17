package th.co.ipassion.ed.bean.prc;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class MBrandSecondBeanSearch {
	
	@NotBlank(message = "this field require")
	private String dutyCode;
	@NotBlank(message = "this field require")
	private String brandMainCode;
	
	private String brandSecondCode;
	private Date endDate;
	private String nameEn;
	private String nameTh;
	private Date startDate;

	public MBrandSecondBeanSearch() {
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public String getBrandMainCode() {
		return brandMainCode;
	}

	public void setBrandMainCode(String brandMainCode) {
		this.brandMainCode = brandMainCode;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameTh() {
		return this.nameTh;
	}

	public void setNameTh(String nameTh) {
		this.nameTh = nameTh;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getBrandSecondCode() {
		return brandSecondCode;
	}

	public void setBrandSecondCode(String brandSecondCode) {
		this.brandSecondCode = brandSecondCode;
	}

	@Override
	public String toString() {
		return "MBrandSecondBeanSearch [dutyCode=" + dutyCode + ", brandMainCode=" + brandMainCode
				+ ", brandSecondCode=" + brandSecondCode + ", endDate=" + endDate + ", nameEn=" + nameEn + ", nameTh="
				+ nameTh + ", startDate=" + startDate + "]";
	}

	
	
	
}