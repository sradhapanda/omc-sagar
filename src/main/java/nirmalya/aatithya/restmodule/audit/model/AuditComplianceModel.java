package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditComplianceModel {

	private Integer quesId;
	private Integer auditId;
	private String comment;
	private String document;
	private String createdBy;
	private Byte auditStatus;
	private Byte obsType;
	private String agreedAct;
	private Byte severity;
	private String createdOn;
	private Byte replyStatus;
	private String person;
	private String personCC;
	private String roleName;
	private String documentName;
	public AuditComplianceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AuditComplianceModel(Object quesId, Object auditId, Object comment, Object document, Object createdBy,Object auditStatus, Object obsType, Object agreedAct, 
			Object severity,Object createdOn,Object replyStatus,Object person,Object personCC,Object roleName,Object documentName) {
		super();
		this.quesId = (Integer) quesId;
		this.auditId = (Integer) auditId;
		this.comment = (String) comment;
		this.document = (String) document;
		this.createdBy = (String) createdBy;
		this.auditStatus = (Byte) auditStatus;
		this.obsType = (Byte) obsType;
		this.agreedAct = (String) agreedAct;
		this.severity = (Byte) severity;
		this.createdOn = (String) createdOn;
		this.replyStatus=(Byte)replyStatus;
		this.person=(String) person;
		this.personCC=(String) personCC;
		this.roleName=(String) roleName;
		this.documentName=(String)documentName;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getQuesId() {
		return quesId;
	}

	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getPersonCC() {
		return personCC;
	}
	public void setPersonCC(String personCC) {
		this.personCC = personCC;
	}
	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
	}
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
	public Byte getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(Byte replyStatus) {
		this.replyStatus = replyStatus;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Byte getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Byte getObsType() {
		return obsType;
	}
	public void setObsType(Byte obsType) {
		this.obsType = obsType;
	}
	public String getAgreedAct() {
		return agreedAct;
	}
	public void setAgreedAct(String agreedAct) {
		this.agreedAct = agreedAct;
	}
	public Byte getSeverity() {
		return severity;
	}
	public void setSeverity(Byte severity) {
		this.severity = severity;
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
