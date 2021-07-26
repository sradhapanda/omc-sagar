package nirmalya.aatithya.restmodule.audit.model;

public class AuditMasterPdfModel {

	public AuditMasterPdfModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Integer auditId;
	private String auditTo;
	private String summery;
	private String question;
	private String observation;
	private Byte auditType;
	private String agreedAction;
	private Byte severity;
	private String auditName;
	public AuditMasterPdfModel(Object auditId, Object auditTo, Object summery, Object question, Object observation,
			Object auditType ,Object agreedAction, Object severity,Object auditName ) {
		super();
		this.auditId = (Integer) auditId;
		this.auditTo = (String) auditTo;
		this.summery = (String) summery;
		this.question = (String) question;
		this.observation = (String) observation;
		this.auditType = (Byte) auditType;
		this.agreedAction = (String) agreedAction;
		this.severity = (Byte) severity;
		this.auditName=(String)auditName;
	}

	public Integer getAuditId() {
		return auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	public String getAuditTo() {
		return auditTo;
	}

	public void setAuditTo(String auditTo) {
		this.auditTo = auditTo;
	}

	public String getSummery() {
		return summery;
	}

	public void setSummery(String summery) {
		this.summery = summery;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Byte getAuditType() {
		return auditType;
	}

	public void setAuditType(Byte auditType) {
		this.auditType = auditType;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public String getAgreedAction() {
		return agreedAction;
	}

	public void setAgreedAction(String agreedAction) {
		this.agreedAction = agreedAction;
	}

	public Byte getSeverity() {
		return severity;
	}

	public void setSeverity(Byte severity) {
		this.severity = severity;
	}

	@Override
	public String toString() {
		return "AuditMasterPdfModel [auditId=" + auditId + ", auditTo=" + auditTo + ", summery=" + summery
				+ ", question=" + question + ", observation=" + observation + ", auditType=" + auditType + "]";
	}

}
