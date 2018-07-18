package th.co.ipassion.ed.bean.prc;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class MSizeBeanSearch {
	
	@NotBlank(message = "this field require")
	private String dutyCode;
	
	private String sizeCode;
	private String desc;
	private String unitCode;
	private Date startDate;
	private Date endDate;

	public MSizeBeanSearch() {
	}
	
	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public String getSizeCode() {
		return sizeCode;
	}

	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
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
	
	
	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	@Override
	public String toString() {
		return "MSizeBeanSearch [dutyCode=" + dutyCode + ", sizeCode=" + sizeCode + ", desc=" + desc + ", unitCode="
				+ unitCode + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	
	
	
}