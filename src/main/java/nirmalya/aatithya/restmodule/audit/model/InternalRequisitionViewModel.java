package nirmalya.aatithya.restmodule.audit.model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author USER
 *
 */
public class InternalRequisitionViewModel {
	private Integer reqId;
	private String auditId;
	private String document;
	private String comment;
	private String createdby;
	private String createdOn;
	private Byte commentStatus;
	private String role;
	private String draftComment;
	private Byte auditeeStatus;
	private List<String> personList = new ArrayList<String>();
	private List<String> file = new ArrayList<String>();

	public InternalRequisitionViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getReqId() {
		return reqId;
	}

	@SuppressWarnings("unchecked")
	public InternalRequisitionViewModel(Object reqId, Object auditId, Object document, Object comment, Object createdby,
			Object createdOn, Object commentStatus, Object role, Object draftComment, Object auditeeStatus,
			Object personList, Object file) {
		super();
		this.reqId = (Integer)reqId;
		this.auditId = (String)auditId;
		this.document =(String) document;
		this.comment =(String) comment;
		this.createdby = (String)createdby;
		this.createdOn = (String)createdOn;
		this.commentStatus =(Byte) commentStatus;
		this.role = (String)role;
		this.draftComment =(String) draftComment;
		this.auditeeStatus =(Byte) auditeeStatus;
		this.personList =(List<String>) personList;
		this.file =(List<String>) file;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public String getAuditId() {
		return auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Byte getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(Byte commentStatus) {
		this.commentStatus = commentStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDraftComment() {
		return draftComment;
	}

	public void setDraftComment(String draftComment) {
		this.draftComment = draftComment;
	}

	public Byte getAuditeeStatus() {
		return auditeeStatus;
	}

	public void setAuditeeStatus(Byte auditeeStatus) {
		this.auditeeStatus = auditeeStatus;
	}

	public List<String> getPersonList() {
		return personList;
	}

	public void setPersonList(List<String> personList) {
		this.personList = personList;
	}

	public List<String> getFile() {
		return file;
	}

	public void setFile(List<String> file) {
		this.file = file;
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
