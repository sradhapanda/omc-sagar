/**
 * 
 */
package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author USER
 *
 */
public class InitiateInternalAuditModel {
	public InitiateInternalAuditModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String auditInitiate;
	
	private String auditType;
	
	private String region;
	
	private String auditor;
	
	private String summary;
	
	private String regionalManager;
	
	private String concernedFinance;
	
	private String financialYear;
	
	private String quarter;
	
	private String initiatedDate;
	
	
	private String document;
	
	private String createdBy;
	
	private Byte auditStatus;
	private Byte reqStatus;
	private Byte irStatus;
	private Byte approveStatus;
	private String auditNameId;
	private String auditAt;
	private Byte coStatus;
	private Byte sectionHeadStatus;
	private Byte sectionReqStatus;
	private Byte forwardStatus;
	
	public InitiateInternalAuditModel(Object auditInitiate, Object auditType, Object region, Object auditor,
			Object summary, Object regionalManager, Object concernedFinance, Object financialYear, Object quarter,
			Object initiatedDate, Object document, Object createdBy,Object auditStatus,Object reqStatus,Object irStatus,Object approveStatus,
			Object auditNameId,Object auditAt,
			Object coStatus,Object sectionHeadStatus,Object  sectionReqStatus,Object forwardStatus ) {
		super();
		this.auditInitiate =(String) auditInitiate;
		this.auditType =(String)  auditType;
		this.region =(String)  region;
		this.auditor =(String)  auditor;
		this.summary =(String)  summary;
		this.regionalManager = (String) regionalManager;
		this.concernedFinance =(String) concernedFinance;
		this.financialYear = (String)financialYear;
		this.quarter = (String)quarter;
		this.initiatedDate =(String) initiatedDate;
		this.document = (String)document;
		this.createdBy =(String) createdBy;
		this.auditStatus=(Byte)auditStatus;
		this.reqStatus =(Byte) reqStatus;
		this.irStatus =(Byte) irStatus;
		this.approveStatus =(Byte) approveStatus;
		this.auditNameId =(String) auditNameId;
		this.coStatus =(Byte) coStatus;
		this.sectionHeadStatus =(Byte) sectionHeadStatus;
		this.sectionReqStatus =(Byte) sectionReqStatus;
		this.forwardStatus =(Byte) forwardStatus;
		
	}
	public Byte getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(Byte approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getAuditAt() {
		return auditAt;
	}
	public void setAuditAt(String auditAt) {
		this.auditAt = auditAt;
	}
	public Byte getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Byte getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(Byte reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Byte getIrStatus() {
		return irStatus;
	}

	public void setIrStatus(Byte irStatus) {
		this.irStatus = irStatus;
	}

	public String getAuditNameId() {
		return auditNameId;
	}

	public void setAuditNameId(String auditNameId) {
		this.auditNameId = auditNameId;
	}

	public Byte getCoStatus() {
		return coStatus;
	}

	public void setCoStatus(Byte coStatus) {
		this.coStatus = coStatus;
	}

	public Byte getSectionHeadStatus() {
		return sectionHeadStatus;
	}

	public void setSectionHeadStatus(Byte sectionHeadStatus) {
		this.sectionHeadStatus = sectionHeadStatus;
	}

	public Byte getSectionReqStatus() {
		return sectionReqStatus;
	}

	public void setSectionReqStatus(Byte sectionReqStatus) {
		this.sectionReqStatus = sectionReqStatus;
	}

	public Byte getForwardStatus() {
		return forwardStatus;
	}

	public void setForwardStatus(Byte forwardStatus) {
		this.forwardStatus = forwardStatus;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
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
