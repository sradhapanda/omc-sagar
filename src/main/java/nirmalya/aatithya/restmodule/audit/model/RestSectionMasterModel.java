package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSectionMasterModel {
	private String section;
	private String department;
	private String sectionName;
	private Boolean sectionStatus;
	private String createdBy;
	public RestSectionMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestSectionMasterModel(Object section, Object department, Object sectionName, Object sectionStatus) {
		super();

		try {
			this.section = (String) section;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.department = (String) department;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sectionName = (String) sectionName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sectionStatus = (Boolean) sectionStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Boolean getSectionStatus() {
		return sectionStatus;
	}
	public void setSectionStatus(Boolean sectionStatus) {
		this.sectionStatus = sectionStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;

	}
}
