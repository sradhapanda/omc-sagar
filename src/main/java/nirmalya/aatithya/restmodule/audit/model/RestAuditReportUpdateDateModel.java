package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAuditReportUpdateDateModel {
	
	public RestAuditReportUpdateDateModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String draftRepId;
	private String desc;
	private String docName;
	private String fileName;
	private String comment;
	private String date;
	private String createdBy;
	private Boolean isEdit;
	private String auditNo;
	private String auditType;
	private String startDate;
	private String endDate;
	
	
	public RestAuditReportUpdateDateModel(Object draftRepId, Object desc, Object docName, Object fileName,
			Object comment, Object date,  Object createdBy,Object auditNo,Object auditType,Object startDate ,Object endDate ) {
		super();
		this.draftRepId = (String) draftRepId;
		this.desc = (String) desc;
		this.docName = (String) docName;
		this.fileName = (String) fileName;
		this.comment = (String) comment;
		this.date = (String) date;
		this.createdBy = (String) createdBy;
		this.auditNo = (String) auditNo;
		this.auditType = (String) auditType;
		this.startDate = (String) startDate;
		this.endDate = (String) endDate;
	}
	
	
	public Boolean getIsEdit() {
		return isEdit;
	}


	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}


	public String getAuditNo() {
		return auditNo;
	}


	public void setAuditNo(String auditNo) {
		this.auditNo = auditNo;
	}


	public String getAuditType() {
		return auditType;
	}


	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getDraftRepId() {
		return draftRepId;
	}
	public void setDraftRepId(String draftRepId) {
		this.draftRepId = draftRepId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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

