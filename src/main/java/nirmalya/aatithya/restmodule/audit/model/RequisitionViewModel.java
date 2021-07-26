/**
 * 
 */
package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author USER
 *
 */
public class RequisitionViewModel {
	public RequisitionViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer draftHiddenId;
	private String draftStatus;
	private Integer reqId;
	private Integer auditId;
	private String document;
	private String comment;
	private String createdby;
	private String createdOn;
	private String commentStatus;
	private String draftComment;
	private String auditeeStatus;
	private String createdRole;
	private String documentName;
	private String roleName;
	private String personTo ;
	private String personCc;
	private String documentComment;
	private String totalReq;
	private String identifier;
	private String subject;
	private String createdById;
	private String initiatedId;
	private String priority;
	private String mailFrom;
	private String reminderDate;
	private String auditType;
	private List<String> personToId = new ArrayList<String>();
	private String personCcId;
	private String coStatus;
	private String sectionStatus;
	private String folder;
	private String emailstatus;
	private String prevauditid;
	private String auditTrialId;
	private String section;
	
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Integer getDraftHiddenId() {
		return draftHiddenId;
	}
	public void setDraftHiddenId(Integer draftHiddenId) {
		this.draftHiddenId = draftHiddenId;
	}
	public String getDraftStatus() {
		return draftStatus;
	}
	public void setDraftStatus(String draftStatus) {
		this.draftStatus = draftStatus;
	}
	public String getPrevauditid() {
		return prevauditid;
	}
	public void setPrevauditid(String prevauditid) {
		this.prevauditid = prevauditid;
	}
	public String getEmailstatus() {
		return emailstatus;
	}
	public void setEmailstatus(String emailstatus) {
		this.emailstatus = emailstatus;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getCreatedById() {
		return createdById;
	}
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getInitiatedId() {
		return initiatedId;
	}
	public void setInitiatedId(String initiatedId) {
		this.initiatedId = initiatedId;
	}
	public String getTotalReq() {
		return totalReq;
	}
	public void setTotalReq(String totalReq) {
		this.totalReq = totalReq;
	}
	public String getDocumentComment() {
		return documentComment;
	}
	public void setDocumentComment(String documentComment) {
		this.documentComment = documentComment;
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
	public String getDraftComment() {
		return draftComment;
	}
	public void setDraftComment(String draftComment) {
		this.draftComment = draftComment;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
	
	
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getComment() {
		return comment;
	}
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getReminderDate() {
		return reminderDate;
	}
	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}
	
	public RequisitionViewModel(Object reqId, Object auditId, Object document, Object comment, Object createdby,Object createdOn,Object commentStatus,Object draftComment,Object auditeeStatus,
			Object createdRole,Object documentName,Object roleName,Object personTo,Object personCc,Object totalReq,Object createdById,Object personToId,Object personCcId,Object coStatus,Object sectionStatus,Object prevauditid) {
		super();
		this.reqId = (Integer)reqId;
		this.auditId =(Integer) auditId;
		this.document =(String) document;
		this.comment = (String)comment;
		this.createdby = (String)createdby;
		this.createdOn=(String)createdOn;
		this.commentStatus=(String)commentStatus;
		this.draftComment=(String)draftComment;
		this.auditeeStatus=(String)auditeeStatus;
		this.createdRole=(String)createdRole;
		this.documentName=(String) documentName;
		this.roleName=(String) roleName;
		this.personTo=(String)  personTo;
		this.personCc=(String)  personCc;
		this.totalReq=(String)  totalReq;
		this.identifier=(String)  identifier;
		this.createdById=(String)  createdById;
		this.personToId=(List<String>)  personToId;
		this.personCcId=(String)  personCcId;
		this.coStatus=(String)  coStatus;
		this.sectionStatus=(String)  sectionStatus;
		this.prevauditid=(String)  prevauditid;
	}
	
	public RequisitionViewModel(Object document, Object createdby,Object createdRole, Object documentName, Object documentComment, Object subject, Object priority) {
		this.document = (String) document;
		this.createdby = (String) createdby;
		this.documentName = (String) documentName;
		this.documentComment = (String) documentComment;
		this.subject = (String) subject;
		this.priority = (String) priority;
		this.createdRole = (String) createdRole;
	}
	public RequisitionViewModel(Object mailFrom, Object roleName, Object personTo, Object reminderDate, Object Subject , Object reqId, Object auditId,Object emailstatus) {
		this.mailFrom = (String) mailFrom;
		this.roleName = (String) roleName;
		this.personTo = (String) personTo;
		this.reminderDate = (String) reminderDate;
		this.subject = (String) Subject;
		this.reqId = (Integer) reqId;
		this.auditId = (Integer) auditId;
		this.emailstatus = (String) emailstatus;
	}
	
	public RequisitionViewModel(Object personTo, Object personCc, Object createdby, Object comment, Object subject) {
		this.personTo = (String) personTo;
		this.personCc = (String) personCc;
		this.createdby = (String) createdby;
		this.comment = (String) comment;
		this.subject = (String) subject;
	}
	public String getAuditeeStatus() {
		return auditeeStatus;
	}
	public void setAuditeeStatus(String auditeeStatus) {
		this.auditeeStatus = auditeeStatus;
	}
	public String getPersonTo() {
		return personTo;
	}
	public void setPersonTo(String personTo) {
		this.personTo = personTo;
	}
	public String getPersonCc() {
		return personCc;
	}
	public void setPersonCc(String personCc) {
		this.personCc = personCc;
	}
	public String getCreatedRole() {
		return createdRole;
	}
	public void setCreatedRole(String createdRole) {
		this.createdRole = createdRole;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public List<String> getPersonToId() {
		return personToId;
	}
	public void setPersonToId(List<String> personToId) {
		this.personToId = personToId;
	}
	public String getPersonCcId() {
		return personCcId;
	}
	public void setPersonCcId(String personCcId) {
		this.personCcId = personCcId;
	}
	public String getCoStatus() {
		return coStatus;
	}
	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}
	public String getSectionStatus() {
		return sectionStatus;
	}
	public void setSectionStatus(String sectionStatus) {
		this.sectionStatus = sectionStatus;
	}
	public String getAuditTrialId() {
		return auditTrialId;
	}

	public void setAuditTrialId(String auditTrialId) {
		this.auditTrialId = auditTrialId;
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
