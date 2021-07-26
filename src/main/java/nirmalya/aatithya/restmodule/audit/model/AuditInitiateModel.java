package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditInitiateModel {
	
	private String auditInitiate;
	
	private String auditType;
	
	private String financialYear;
	
	private String initiatedBy;
	
	private String initiatedDate;
	
	private String summary;
	
	private String document;
	
	private String initiatedStatus;
	
	private String createdBy;
	
	private String organizaionName;
	
	private String auditTypeId;
	
	private String letterNo;
	
	private String fromDate;
	
	private String toDate;
	
	private String auditorName;
	
	private String designation;
	private Boolean dtlStatus;
	
	private String region;
	
	private String auditor;
	
	private String regionalManager;
	
	private String concernedFinance;
	private String quarter;
	private Integer audit;
	private String documentName;
	private String reportStatus;
	private String approveStatus;
	private String personTo;
	private String personCc;
	private String documentComment;
	
	public AuditInitiateModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditInitiateModel(Object auditInitiate, Object auditType, Object financialYear, Object initiatedBy,
			Object initiatedDate, Object summary, Object document, Object initiatedStatus, Object createdBy, 
			Object organizaionName, Object auditTypeId,Object letterNo,Object fromDate,Object toDate,
			Object auditorName,Object designation,Object dtlStatus,Object region,Object auditor,Object regionalManager,
			Object  concernedFinance,Object quarter,Object audit,Object documentName,Object reportStatus,Object approveStatus ,
			Object personTo,Object personCc,Object documentComment) {
		super();
		this.auditInitiate = (String) auditInitiate;
		this.auditType = (String) auditType;
		this.financialYear = (String) financialYear;
		this.initiatedBy = (String) initiatedBy;
		this.initiatedDate = (String) initiatedDate;
		this.summary = (String) summary;
		this.document = (String) document;
		this.initiatedStatus = (String) initiatedStatus;
		this.createdBy = (String) createdBy;
		this.organizaionName = (String) organizaionName;
		this.auditTypeId = (String) auditTypeId;
		this.letterNo=(String) letterNo;
		this.fromDate=(String) fromDate;
		this.toDate=(String) toDate;
		this.auditorName=(String) auditorName;
		this.designation=(String) designation;
		this.dtlStatus=(Boolean)dtlStatus;
		this.region=(String)region;
		this.auditor=(String)auditor;
		this.regionalManager=(String)regionalManager;
		this.concernedFinance=(String)concernedFinance;
		this.quarter=(String)quarter;
		this.audit=(Integer)audit;
		this.documentName=(String) documentName;
		this.reportStatus=(String) reportStatus;
		this.approveStatus=(String) approveStatus;
		this.personTo=(String) personTo;
		this.personCc=(String) personCc;
		this.documentComment=(String) documentComment;
		
	}


	public String getDocumentComment() {
		return documentComment;
	}

	public void setDocumentComment(String documentComment) {
		this.documentComment = documentComment;
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

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAuditor() {
		return auditor;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getRegionalManager() {
		return regionalManager;
	}

	public void setRegionalManager(String regionalManager) {
		this.regionalManager = regionalManager;
	}

	public String getConcernedFinance() {
		return concernedFinance;
	}

	public void setConcernedFinance(String concernedFinance) {
		this.concernedFinance = concernedFinance;
	}

	public Boolean getDtlStatus() {
		return dtlStatus;
	}

	public void setDtlStatus(Boolean dtlStatus) {
		this.dtlStatus = dtlStatus;
	}

	public String getLetterNo() {
		return letterNo;
	}

	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	public String getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(String initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getInitiatedStatus() {
		return initiatedStatus;
	}

	public void setInitiatedStatus(String initiatedStatus) {
		this.initiatedStatus = initiatedStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getOrganizaionName() {
		return organizaionName;
	}

	public void setOrganizaionName(String organizaionName) {
		this.organizaionName = organizaionName;
	}

	public String getAuditTypeId() {
		return auditTypeId;
	}

	public void setAuditTypeId(String auditTypeId) {
		this.auditTypeId = auditTypeId;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
