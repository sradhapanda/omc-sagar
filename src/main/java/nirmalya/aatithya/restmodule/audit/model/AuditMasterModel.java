package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditMasterModel {

	private Integer auditAutoGenId;
	private String auditInitiated;
	private String auditName;
	private String organisation;
	private String department;
	private String section;
	private String deptHead;
	private String deptHeadId;
	private String auditee;
	private String auditor;
	private String fromDate;
	private String toDate;
	private String createdBy;
	private String departmentId;
	private String sectionId;
	private String guideLineDoc;
	private String auditStatus;
	private String reqStatus;
	private String irStatus;
	private String approveStatus;
	private String auditNameId;
	private String auditAt;
	private String coStatus;
	private String sectionHeadStatus;
	private String sectionReqStatus;
	private String forwardStatus;
	private String region;
	private String auditParty;
	private String quarter;
	private String initiatedDate;
	private String regionName;
	private String auditPartyName;
	private boolean dtlStatus;
	private String summary;
	private String financialYear;
	private String letterNo;
	private String initiatedBy;

	private String submissionDate;
	private List<String> subcoordinator = new ArrayList<String>(); 

	private List<String> concernedAuditee = new ArrayList<String>();
	private List<String> ccData = new ArrayList<String>();
	private List<AuditAdditionalInfoModel> documents = new ArrayList<AuditAdditionalInfoModel>();
	private List<AuditAdditionalInfoModel> additional = new ArrayList<AuditAdditionalInfoModel>();
	private List<String> documentName = new ArrayList<String>();
	private String auditTypeName;
	
	private String regionalManager;
	private String concernedFinance;
	private List<String> docs = new ArrayList<String>();
	private List<String> docNames = new ArrayList<String>();
	private List<String> docComments = new ArrayList<String>();
	private List<String> docFiles = new ArrayList<String>();
	private String subject;
	private String prevauditid;
	


	public  AuditMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public AuditMasterModel(Object auditAutoGenId, Object auditInitiated, Object auditName, Object organisation,
			Object department, Object section, Object deptHead, Object deptHeadId, Object auditee, Object auditor,
			Object fromDate, Object toDate, Object departmentId, Object sectionId, Object guideLineDoc,
			Object auditStatus, Object reqStatus, Object irStatus, Object approveStatus, Object auditNameId,
			Object auditAt, Object coStatus, Object sectionHeadStatus, Object sectionReqStatus, Object forwardStatus,
			Object region, Object auditParty, Object quarter, Object initiatedDate, Object regionName,
			Object auditPartyName, Object dtlStatus, Object summary, Object financialYear, Object letterNo,
			Object initiatedBy, Object submissionDate, Object subcoordinator, Object concernedAuditee,
			Object documents,Object additional ,Object documentName,Object auditTypeName,Object subject,Object prevauditid) {
		super();
		this.auditAutoGenId = (Integer) auditAutoGenId;
		this.auditInitiated = (String) auditInitiated;
		
		this.auditName = (String) auditName;
		this.organisation = (String) organisation;
		this.department = (String) department;
		this.section = (String) section;
		this.deptHead = (String) deptHead;
		this.deptHeadId = (String) deptHeadId;
		this.auditee = (String) auditee;
		this.auditor = (String) auditor;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.departmentId = (String) departmentId;
		this.sectionId = (String) sectionId;
		this.guideLineDoc = (String) guideLineDoc;
		this.auditStatus = (String) auditStatus;
		this.reqStatus = (String) reqStatus;
		this.irStatus = (String) irStatus;
		this.approveStatus = (String) approveStatus;
		this.auditNameId = (String) auditNameId;
		this.auditAt = (String) auditAt;
		this.coStatus = (String) coStatus;
		this.sectionHeadStatus = (String) sectionHeadStatus;
		this.sectionReqStatus = (String) sectionReqStatus;
		this.forwardStatus = (String) forwardStatus;
		this.region = (String) region;
		this.auditParty = (String) auditParty;
		this.quarter = (String) quarter;
		this.initiatedDate = (String) initiatedDate;
		this.regionName = (String) regionName;
		this.auditPartyName = (String) auditPartyName;
		this.dtlStatus = (Boolean) dtlStatus;
		this.summary = (String) summary;
		this.financialYear = (String) financialYear;
		this.letterNo = (String) letterNo;
		this.initiatedBy = (String) initiatedBy;
		this.submissionDate = (String) submissionDate;
		this.subcoordinator = (List<String>) subcoordinator;
		this.concernedAuditee = (List<String>) concernedAuditee;
		this.documents=(List<AuditAdditionalInfoModel>) documents;
		this.additional=(List<AuditAdditionalInfoModel>) additional;
		this.documentName=(List<String>) documentName;
		this.auditTypeName=(String)auditTypeName;
		this.subject=(String)subject;
		this.prevauditid=(String)prevauditid;
	}


	public String getPrevauditid() {
		return prevauditid;
	}

	public void setPrevauditid(String prevauditid) {
		this.prevauditid = prevauditid;
	}

	public Integer getAuditAutoGenId() {
		return auditAutoGenId;
	}

	public void setAuditAutoGenId(Integer auditAutoGenId) {
		this.auditAutoGenId = auditAutoGenId;
	}

	public String getAuditInitiated() {
		return auditInitiated;
	}

	public void setAuditInitiated(String auditInitiated) {
		this.auditInitiated = auditInitiated;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	public String getDeptHeadId() {
		return deptHeadId;
	}

	public void setDeptHeadId(String deptHeadId) {
		this.deptHeadId = deptHeadId;
	}

	public String getAuditee() {
		return auditee;
	}

	public void setAuditee(String auditee) {
		this.auditee = auditee;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getGuideLineDoc() {
		return guideLineDoc;
	}

	public void setGuideLineDoc(String guideLineDoc) {
		this.guideLineDoc = guideLineDoc;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public String getIrStatus() {
		return irStatus;
	}

	public void setIrStatus(String irStatus) {
		this.irStatus = irStatus;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getAuditNameId() {
		return auditNameId;
	}

	public void setAuditNameId(String auditNameId) {
		this.auditNameId = auditNameId;
	}

	public String getAuditAt() {
		return auditAt;
	}

	public void setAuditAt(String auditAt) {
		this.auditAt = auditAt;
	}

	public String getCoStatus() {
		return coStatus;
	}

	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}

	public String getSectionHeadStatus() {
		return sectionHeadStatus;
	}

	public void setSectionHeadStatus(String sectionHeadStatus) {
		this.sectionHeadStatus = sectionHeadStatus;
	}

	public String getSectionReqStatus() {
		return sectionReqStatus;
	}

	public void setSectionReqStatus(String sectionReqStatus) {
		this.sectionReqStatus = sectionReqStatus;
	}

	public String getForwardStatus() {
		return forwardStatus;
	}

	public void setForwardStatus(String forwardStatus) {
		this.forwardStatus = forwardStatus;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAuditParty() {
		return auditParty;
	}

	public void setAuditParty(String auditParty) {
		this.auditParty = auditParty;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(String initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getAuditPartyName() {
		return auditPartyName;
	}

	public void setAuditPartyName(String auditPartyName) {
		this.auditPartyName = auditPartyName;
	}

	public boolean isDtlStatus() {
		return dtlStatus;
	}

	public void setDtlStatus(boolean dtlStatus) {
		this.dtlStatus = dtlStatus;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getLetterNo() {
		return letterNo;
	}

	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public List<String> getSubcoordinator() {
		return subcoordinator;
	}

	public void setSubcoordinator(List<String> subcoordinator) {
		this.subcoordinator = subcoordinator;
	}

	public List<String> getConcernedAuditee() {
		return concernedAuditee;
	}

	public void setConcernedAuditee(List<String> concernedAuditee) {
		this.concernedAuditee = concernedAuditee;
	}

	public List<AuditAdditionalInfoModel> getDocuments() {
		return documents;
	}

	public void setDocuments(List<AuditAdditionalInfoModel> documents) {
		this.documents = documents;
	}

	public List<AuditAdditionalInfoModel> getAdditional() {
		return additional;
	}

	public void setAdditional(List<AuditAdditionalInfoModel> additional) {
		this.additional = additional;
	}

	public List<String> getDocumentName() {
		return documentName;
	}

	public void setDocumentName(List<String> documentName) {
		this.documentName = documentName;
	}

	public String getAuditTypeName() {
		return auditTypeName;
	}

	public void setAuditTypeName(String auditTypeName) {
		this.auditTypeName = auditTypeName;
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

	public List<String> getDocs() {
		return docs;
	}

	public void setDocs(List<String> docs) {
		this.docs = docs;
	}

	public List<String> getDocNames() {
		return docNames;
	}

	public void setDocNames(List<String> docNames) {
		this.docNames = docNames;
	}

	public List<String> getDocComments() {
		return docComments;
	}

	public void setDocComments(List<String> docComments) {
		this.docComments = docComments;
	}

	public List<String> getDocFiles() {
		return docFiles;
	}

	public void setDocFiles(List<String> docFiles) {
		this.docFiles = docFiles;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getCcData() {
		return ccData;
	}

	public void setCcData(List<String> ccData) {
		this.ccData = ccData;
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
