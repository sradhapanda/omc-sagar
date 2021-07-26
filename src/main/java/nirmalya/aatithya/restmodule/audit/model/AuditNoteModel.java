package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditNoteModel {
	public AuditNoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String noteId;
	private String doc;
	private String date;
	private String time;
	private String organisation;
	private String createdBy;
	private String designtion;
	private String comment;
	private String personTo;
	private String personCc;
	private String totalAuditorReq;
	
	
	public AuditNoteModel(Object noteId, Object doc, Object date,Object time, Object organisation,Object createdBy,Object designation, Object comment,Object personTo,Object personCc,Object totalAuditorReq) {
		super();
		this.noteId = (String) noteId;
		this.doc = (String) doc;
		this.date = (String) date;
		this.time = (String) time;
		this.organisation = ((String) organisation);
		this.createdBy = ((String) createdBy);
		this.designtion = ((String) designation);
		this.comment = (String) comment;
		this.personTo = (String) personTo;
		this.personCc = (String) personCc;
		this.totalAuditorReq = (String) totalAuditorReq;
	}


	public String getTotalAuditorReq() {
		return totalAuditorReq;
	}


	public void setTotalAuditorReq(String totalAuditorReq) {
		this.totalAuditorReq = totalAuditorReq;
	}


	public String getNoteId() {
		return noteId;
	}


	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}


	public String getDoc() {
		return doc;
	}


	public void setDoc(String doc) {
		this.doc = doc;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
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


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
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


	public String getDesigntion() {
		return designtion;
	}


	public void setDesigntion(String designtion) {
		this.designtion = designtion;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
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

