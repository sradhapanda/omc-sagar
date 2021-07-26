package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAuidtReportModel {
	public RestAuidtReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String auditInitiate;
	private String auditType;
	private String auditFromDate;
	private String auidtToDate;
	private String summary;
	private String status;
	private String document;
	private String documentName;
	private String comment;
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
	public String getAuditFromDate() {
		return auditFromDate;
	}
	public void setAuditFromDate(String auditFromDate) {
		this.auditFromDate = auditFromDate;
	}
	public String getAuidtToDate() {
		return auidtToDate;
	}
	public void setAuidtToDate(String auidtToDate) {
		this.auidtToDate = auidtToDate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public RestAuidtReportModel(Object auditInitiate, Object auditType, Object auditFromDate, Object auidtToDate,
			Object summary, Object status, Object document, Object documentName, Object comment) {
		super();
		this.auditInitiate = (String) auditInitiate;
		this.auditType = (String) auditType;
		this.auditFromDate = (String) auditFromDate;
		this.auidtToDate = (String) auidtToDate;
		this.summary = (String) summary;
		this.status = (String) status;
		this.document = (String) document;
		this.documentName = (String) documentName;
		this.comment = (String) comment;
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
