package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditPartyMasterModel {

	private String auditPartyId;
	
	private String auditPartyFirstName;
	
	private String auditPartyLastName;
	
	private String auditPartyDesc;

	private Boolean auditPartyActive;

	private String createdBy;
	
	private  Integer slNo;
	
	

	public AuditPartyMasterModel(Object auditPartyId, Object auditPartyFirstName,Object auditPartyLastName,  Object auditPartyDesc,
			Object auditPartyActive, Object createdBy, Object slNo) {
		super();
		this.auditPartyId = (String) auditPartyId;
		this.auditPartyFirstName = (String) auditPartyFirstName;
		this.auditPartyLastName = (String) auditPartyLastName;
		this.auditPartyDesc = (String) auditPartyDesc;
		this.auditPartyActive = (Boolean) auditPartyActive;
		this.createdBy = (String) createdBy;
		this.slNo = (Integer) slNo;
	}

	public AuditPartyMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAuditPartyId() {
		return auditPartyId;
	}

	public void setAuditPartyId(String auditPartyId) {
		this.auditPartyId = auditPartyId;
	}

	

	public String getAuditPartyFirstName() {
		return auditPartyFirstName;
	}

	public void setAuditPartyFirstName(String auditPartyFirstName) {
		this.auditPartyFirstName = auditPartyFirstName;
	}

	public String getAuditPartyLastName() {
		return auditPartyLastName;
	}

	public void setAuditPartyLastName(String auditPartyLastName) {
		this.auditPartyLastName = auditPartyLastName;
	}

	public String getAuditPartyDesc() {
		return auditPartyDesc;
	}

	public void setAuditPartyDesc(String auditPartyDesc) {
		this.auditPartyDesc = auditPartyDesc;
	}

	public Boolean getAuditPartyActive() {
		return auditPartyActive;
	}

	public void setAuditPartyActive(Boolean auditPartyActive) {
		this.auditPartyActive = auditPartyActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
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
