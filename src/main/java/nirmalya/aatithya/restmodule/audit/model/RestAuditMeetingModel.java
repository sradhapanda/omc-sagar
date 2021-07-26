package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAuditMeetingModel {
	private Integer id;
	private Integer audit;
	private String initiate;
	private String date;
	private String fromTime;
	private String toTime;
	private String section;
	private String sectionHead;
	private String createdBy;
	private String personTo;
	private String document;
	private String documentName;
	private String comment;
	private String meetingType;
	private String auditType;
	private String comments;
	

	public RestAuditMeetingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getInitiate() {
		return initiate;
	}

	public void setInitiate(String initiate) {
		this.initiate = initiate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSectionHead() {
		return sectionHead;
	}

	public void setSectionHead(String sectionHead) {
		this.sectionHead = sectionHead;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPersonTo() {
		return personTo;
	}

	public void setPersonTo(String personTo) {
		this.personTo = personTo;
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

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public RestAuditMeetingModel(Object id, Object audit, Object initiate, Object date, Object fromTime, Object toTime,
			Object section, Object sectionHead,Object createdBy,Object personTo,Object document,Object documentName,Object meetingType,Object auditType,Object comment,Object comments) {
		super();
		this.id = (Integer)id;
		this.audit = (Integer) audit;
		this.initiate = (String) initiate;
		this.date = (String) date;
		this.fromTime = (String) fromTime;
		this.toTime = (String) toTime;
		this.section = (String) section;
		this.sectionHead = (String) sectionHead;
		this.createdBy = (String) createdBy;
		this.personTo = (String) personTo;
		this.document = (String) document;
		this.documentName = (String) documentName;
		this.meetingType = (String) meetingType;
		this.auditType = (String) auditType;
		this.comment=(String)comment;
		this.comments=(String)comments;
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