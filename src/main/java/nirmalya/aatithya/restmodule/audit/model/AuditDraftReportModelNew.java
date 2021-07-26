package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditDraftReportModelNew {
	private String draftId;
	private String draftNo;
	private String version;
	private String date;
	private String auditType;
	private String initiateId;
	private String reportType;
	private String comment;
	private String action;

	private String edit;
	private List<AuditAttachmentNewModel> auditAttachmentNewModelList;
	private List<RestAuditReportAdditionalInfoModel> additionalInfoList;
	private List<RestAuditReportBasicsQualifyModel> basicOfQualifyList;
	private List<String> personTo = new ArrayList<String>();
	private List<String> personCC = new ArrayList<String>();

	public AuditDraftReportModelNew() {
		super();
	}

	public AuditDraftReportModelNew(Object draftId, Object draftNo, Object version, Object date, Object auditType,
			Object initiateId, Object reportType, Object comment) {
		super();
		this.draftId = (String) draftId;
		this.draftNo = (String) draftNo;
		this.version = (String) version;
		this.date = (String) date;
		this.auditType = (String) auditType;
		this.initiateId = (String) initiateId;
		this.reportType = (String) reportType;
		this.comment = (String) comment;
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

	public List<AuditAttachmentNewModel> getAuditAttachmentNewModelList() {
		return auditAttachmentNewModelList;
	}

	public void setAuditAttachmentNewModelList(List<AuditAttachmentNewModel> auditAttachmentNewModelList) {
		this.auditAttachmentNewModelList = auditAttachmentNewModelList;
	}

	public List<RestAuditReportAdditionalInfoModel> getAdditionalInfoList() {
		return additionalInfoList;
	}

	public void setAdditionalInfoList(List<RestAuditReportAdditionalInfoModel> additionalInfoList) {
		this.additionalInfoList = additionalInfoList;
	}

	public List<RestAuditReportBasicsQualifyModel> getBasicOfQualifyList() {
		return basicOfQualifyList;
	}

	public void setBasicOfQualifyList(List<RestAuditReportBasicsQualifyModel> basicOfQualifyList) {
		this.basicOfQualifyList = basicOfQualifyList;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
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
