package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RegionAuditPartyMasterModel {

	private String regionId;
	private String regionName;
	private String auditId;
	private String auditor;
	private String desc;
	private Boolean status;
	private String createdBy;
	private String isEdit;
	
	public RegionAuditPartyMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegionAuditPartyMasterModel(Object regionId, Object regionName, Object auditId, Object auditor, Object desc,
			Object status, Object createdBy, Object isEdit) {
		this.regionId = (String) regionId;
		this.regionName = (String) regionName;
		this.auditId = (String) auditId;
		this.auditor = (String) auditor;
		this.desc = (String) desc;
		this.status = (Boolean) status;
		this.createdBy = (String) createdBy;
		this.isEdit = (String) isEdit;
	}

	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
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
