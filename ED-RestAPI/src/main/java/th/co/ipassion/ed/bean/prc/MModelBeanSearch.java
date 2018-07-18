package th.co.ipassion.ed.bean.prc;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class MModelBeanSearch {
	
	@NotBlank(message = "this field require")
	private String dutyCode;
	
	private String modelCode;
	private String desc;
	private Date startDate;
	private Date endDate;

	public MModelBeanSearch() {
	}
	
	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "MModelBeanSearch [dutyCode=" + dutyCode + ", modelCode=" + modelCode + ", desc=" + desc + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	
	
}