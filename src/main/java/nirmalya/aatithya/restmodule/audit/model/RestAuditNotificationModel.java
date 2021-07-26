package nirmalya.aatithya.restmodule.audit.model;

public class RestAuditNotificationModel {

	public RestAuditNotificationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String auditInitiate;
	private String auditType;
	private String auditCreated;
	
	
	
	public RestAuditNotificationModel(Object auditInitiate, Object auditType, Object auditCreated) {
		super();
		this.auditInitiate = (String) auditInitiate;
		this.auditType = (String) auditType;
		this.auditCreated = (String) auditCreated;
	}

	public String getAuditInitiate() {
		return auditInitiate;
	}

	public void setAuditInitiate(String auditInitiate) {
		this.auditInitiate = auditInitiate;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getAuditCreated() {
		return auditCreated;
	}

	public void setAuditCreated(String auditCreated) {
		this.auditCreated = auditCreated;
	}

	
}
