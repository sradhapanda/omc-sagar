package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditHistoryRestModel {
	private Integer histId;
	private String auditId;
	private String createdBy;
	private String createdOn;
	private String action;
	

	public AuditHistoryRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditHistoryRestModel(Object histId, Object auditId, Object createdBy, Object createdOn, Object action) {
		super();
		this.histId = (Integer) histId;
		this.auditId = (String) auditId;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.action = (String) action;
		
	}

	

	public Integer getHistId() {
		return histId;
	}

	public void setHistId(Integer histId) {
		this.histId = histId;
	}

	public String getAuditId() {
		return auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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
