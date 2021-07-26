package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditObservationModel {
	private Integer auditId;
	private String deptId;
	private String sectionId;
	private Integer slNo;
	private String question;
	private String observation;
	private String document;
	private String file;
	private String obsType;
	private String auditStatus;
	private Integer quesId;
	private String severity;
	private String iRStatus;
	private String reqStatus;
	private String qusDoc;
	private String sectionStatus;
	private String auditorStatus;
	private String coStatus;
	private String qusCoStatus;
	private String auditeeStatus;
	private String comStatus;
	private String personForwardStatus;
	private String forwardStatus;
	private String obsForStatus;
	private Boolean rejectStatus;
	private String region;
	private String auditParty;
	private String assignStatus;
	private String date;
	private String initiateId;
	private String createdBy;
	private String addObsStatus;
	private String checklistRef;
	private String finalObservation;
	private String riskRating;
	private String auditType;
	private String personTo ;
	private String personCc;
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

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getFinalObservation() {
		return finalObservation;
	}

	public void setFinalObservation(String finalObservation) {
		this.finalObservation = finalObservation;
	}

	public String getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(String riskRating) {
		this.riskRating = riskRating;
	}

	
	public String getChecklistRef() {
		return checklistRef;
	}

	public void setChecklistRef(String checklistRef) {
		this.checklistRef = checklistRef;
	}

	public String getAddObsStatus() {
		return addObsStatus;
	}

	public void setAddObsStatus(String addObsStatus) {
		this.addObsStatus = addObsStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}

	public Integer getAuditId() {
		return auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	
	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	

	public String getObsType() {
		return obsType;
	}

	public void setObsType(String obsType) {
		this.obsType = obsType;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getQuesId() {
		return quesId;
	}

	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getiRStatus() {
		return iRStatus;
	}

	public void setiRStatus(String iRStatus) {
		this.iRStatus = iRStatus;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public String getQusDoc() {
		return qusDoc;
	}

	public void setQusDoc(String qusDoc) {
		this.qusDoc = qusDoc;
	}

	public String getSectionStatus() {
		return sectionStatus;
	}

	public void setSectionStatus(String sectionStatus) {
		this.sectionStatus = sectionStatus;
	}

	public String getAuditorStatus() {
		return auditorStatus;
	}

	public void setAuditorStatus(String auditorStatus) {
		this.auditorStatus = auditorStatus;
	}

	public String getCoStatus() {
		return coStatus;
	}

	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}

	public String getQusCoStatus() {
		return qusCoStatus;
	}

	public void setQusCoStatus(String qusCoStatus) {
		this.qusCoStatus = qusCoStatus;
	}

	public String getAuditeeStatus() {
		return auditeeStatus;
	}

	public void setAuditeeStatus(String auditeeStatus) {
		this.auditeeStatus = auditeeStatus;
	}

	public String getComStatus() {
		return comStatus;
	}

	public void setComStatus(String comStatus) {
		this.comStatus = comStatus;
	}

	public String getPersonForwardStatus() {
		return personForwardStatus;
	}

	public void setPersonForwardStatus(String personForwardStatus) {
		this.personForwardStatus = personForwardStatus;
	}

	public String getForwardStatus() {
		return forwardStatus;
	}

	public void setForwardStatus(String forwardStatus) {
		this.forwardStatus = forwardStatus;
	}

	public String getObsForStatus() {
		return obsForStatus;
	}

	public void setObsForStatus(String obsForStatus) {
		this.obsForStatus = obsForStatus;
	}

	public Boolean getRejectStatus() {
		return rejectStatus;
	}

	public void setRejectStatus(Boolean rejectStatus) {
		this.rejectStatus = rejectStatus;
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

	public AuditObservationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public AuditObservationModel(Object auditId, Object deptId, Object sectionId, Object slNo, Object question,
			Object observation, Object document, Object file, Object obsType,Object auditStatus, Object quesId,
			Object severity,Object iRStatus,Object reqStatus,Object qusDoc,Object sectionStatus,Object auditorStatus,
			Object coStatus,Object qusCoStatus,Object auditeeStatus,Object comStatus,Object personForwardStatus,
			Object forwardStatus,Object obsForStatus,Object rejectStatus,Object region,Object auditParty,Object assignStatus,
			Object date,Object initiateId,Object createdBy,Object addObsStatus,Object checklistRef,Object finalObservation ,
			Object riskRating,Object auditType,Object personTo,Object personCc) {
		super();
		this.auditId = (Integer) auditId;
		this.deptId = (String) deptId;
		this.sectionId = (String) sectionId;
		this.slNo = (Integer) slNo;
		this.question = (String) question;
		this.observation = (String) observation;
		this.document = (String) document;
		this.file = (String) file;
		this.obsType = (String) obsType;
		this.auditStatus = (String) auditStatus;
		this.quesId = (Integer) quesId;
		this.severity = (String) severity;
		this.iRStatus=(String)iRStatus;
		this.reqStatus=(String)reqStatus;
		this.qusDoc=(String)qusDoc;
		this.sectionStatus=(String)sectionStatus;
		this.auditorStatus=(String)auditorStatus;
		this.coStatus=(String)coStatus;
		this.qusCoStatus=(String)qusCoStatus;
		this.auditeeStatus=(String)auditeeStatus;
		this.comStatus=(String)comStatus;
		this.personForwardStatus=(String)personForwardStatus;
		this.forwardStatus=(String)forwardStatus;
		this.obsForStatus=(String)obsForStatus;
		this.rejectStatus=(Boolean)rejectStatus;
		this.region=(String)region;
		this.auditParty=(String)auditParty;
		this.assignStatus=(String)assignStatus;
		this.date=(String)date;
		this.initiateId=(String) initiateId;
		this.createdBy=(String)createdBy;
		this.addObsStatus=(String)addObsStatus;
		this.checklistRef=(String)checklistRef;
		this.finalObservation=(String)finalObservation;
		this.riskRating=(String)riskRating;
		this.auditType=(String)auditType;
		this.personTo=(String)personTo;
		this.personCc=(String)personCc;
	}


	public String getInitiateId() {
		return initiateId;
	}

	public void setInitiateId(String initiateId) {
		this.initiateId = initiateId;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}



	
}
