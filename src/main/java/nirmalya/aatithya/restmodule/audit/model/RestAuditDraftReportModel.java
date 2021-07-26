package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAuditDraftReportModel {

	private String draftId;
	private String draftNo;
	private String version;
	private String date;
	private String auditType;
	private String initiateId;
	private String reportType;
	private String comment;

	private String fYear;
	private String type;
	private String attachDate;
	private String attachfileName;
	private String attachDocument;
	private String attachComment;

	private String infoFileName;
	private String infoDocument;
	private String infoComment;

	private String qlfyFileName;
	private String qlfyDocument;
	private String qlfyComment;

	private List<RestAuditReportAdditionalInfoModel> additionalInfo;
	private List<RestAuditReportBasicsQualifyModel> basicOfQualify;
	private List<RestAuditDraftReportModel> attachmment;

	private List<String> personTo = new ArrayList<String>();
	private List<String> personCC = new ArrayList<String>();
	private String createdBy;
	private String designation;
	private String organisation;
	private Integer commentId;
	
	@SuppressWarnings("unchecked")
	public RestAuditDraftReportModel(Object draftId, Object draftNo, Object version, Object date, Object auditType,
			Object initiateId, Object reportType, Object comment, Object fYear, Object type, Object attachDate,
			Object attachfileName, Object attachDocument, Object attachComment, Object infoFileName,
			Object infoDocument, Object infoComment, Object qlfyFileName, Object qlfyDocument, Object qlfyComment,
			Object additionalInfo, Object basicOfQualify, Object attachment, Object personTo, Object personCC,
			Object createdBy,Object designation,Object organisation,Object commentId) {
		super();
		this.draftId = (String) draftId;
		this.draftNo = (String) draftNo;
		this.version = (String) version;
		this.date = (String) date;
		this.auditType = (String) auditType;
		this.initiateId = (String) initiateId;
		this.reportType = (String) reportType;
		this.comment = (String) comment;
		this.fYear = (String) fYear;
		this.type = (String) type;
		this.attachDate = (String) attachDate;
		this.attachfileName = (String) attachfileName;
		this.attachDocument = (String) attachDocument;
		this.attachComment = (String) attachComment;
		this.infoFileName = (String) infoFileName;
		this.infoDocument = (String) infoDocument;
		this.infoComment = (String) infoComment;
		this.qlfyFileName = (String) qlfyFileName;
		this.qlfyDocument = (String) qlfyDocument;
		this.qlfyComment = (String) qlfyComment;
		this.additionalInfo = (List<RestAuditReportAdditionalInfoModel>) additionalInfo;
		this.basicOfQualify = (List<RestAuditReportBasicsQualifyModel>) basicOfQualify;
		this.attachmment = (List<RestAuditDraftReportModel>) basicOfQualify;
		this.personTo = (List<String>) personTo;
		this.personCC = (List<String>) personCC;
		this.createdBy = (String) createdBy;
		this.designation = (String) designation;
		this.organisation = (String) organisation;
		this.commentId = (Integer)commentId;
	}

	
	

	public Integer getCommentId() {
		return commentId;
	}


	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOrganisation() {
		return organisation;
	}


	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public RestAuditDraftReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDraftId() {
		return draftId;
	}

	public void setDraftId(String draftId) {
		this.draftId = draftId;
	}

	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getInitiateId() {
		return initiateId;
	}

	public void setInitiateId(String initiateId) {
		this.initiateId = initiateId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getfYear() {
		return fYear;
	}

	public void setfYear(String fYear) {
		this.fYear = fYear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttachDate() {
		return attachDate;
	}

	public void setAttachDate(String attachDate) {
		this.attachDate = attachDate;
	}

	public String getAttachfileName() {
		return attachfileName;
	}

	public void setAttachfileName(String attachfileName) {
		this.attachfileName = attachfileName;
	}

	public String getAttachDocument() {
		return attachDocument;
	}

	public void setAttachDocument(String attachDocument) {
		this.attachDocument = attachDocument;
	}

	public String getAttachComment() {
		return attachComment;
	}

	public void setAttachComment(String attachComment) {
		this.attachComment = attachComment;
	}

	public String getInfoFileName() {
		return infoFileName;
	}

	public void setInfoFileName(String infoFileName) {
		this.infoFileName = infoFileName;
	}

	public String getInfoDocument() {
		return infoDocument;
	}

	public void setInfoDocument(String infoDocument) {
		this.infoDocument = infoDocument;
	}

	public String getInfoComment() {
		return infoComment;
	}

	public void setInfoComment(String infoComment) {
		this.infoComment = infoComment;
	}

	public String getQlfyFileName() {
		return qlfyFileName;
	}

	public void setQlfyFileName(String qlfyFileName) {
		this.qlfyFileName = qlfyFileName;
	}

	public String getQlfyDocument() {
		return qlfyDocument;
	}

	public void setQlfyDocument(String qlfyDocument) {
		this.qlfyDocument = qlfyDocument;
	}

	public String getQlfyComment() {
		return qlfyComment;
	}

	public void setQlfyComment(String qlfyComment) {
		this.qlfyComment = qlfyComment;
	}

	public List<RestAuditReportAdditionalInfoModel> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(List<RestAuditReportAdditionalInfoModel> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public List<RestAuditReportBasicsQualifyModel> getBasicOfQualify() {
		return basicOfQualify;
	}

	public void setBasicOfQualify(List<RestAuditReportBasicsQualifyModel> basicOfQualify) {
		this.basicOfQualify = basicOfQualify;
	}

	public List<RestAuditDraftReportModel> getAttachmment() {
		return attachmment;
	}

	public void setAttachmment(List<RestAuditDraftReportModel> attachmment) {
		this.attachmment = attachmment;
	}

	public List<String> getPersonTo() {
		return personTo;
	}

	public void setPersonTo(List<String> personTo) {
		this.personTo = personTo;
	}

	public List<String> getPersonCC() {
		return personCC;
	}

	public void setPersonCC(List<String> personCC) {
		this.personCC = personCC;
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
