package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAuditReportAdditionalInfoModel {
	private String infoFileName;
	private String infoDocument;
	private String infoComment;
	private Integer commentId;
	
	public RestAuditReportAdditionalInfoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestAuditReportAdditionalInfoModel(Object infoFileName, Object infoDocument, Object infoComment,Object commentId) {
		super();
		this.infoFileName = (String) infoFileName;
		this.infoDocument = (String) infoDocument;
		this.infoComment = (String) infoComment;
		this.commentId = (Integer) commentId;
	}
	
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getInfoFileName() {
		return infoFileName;
	}
	public void setInfoFileName(String infoFileName) {
		this.infoFileName = infoFileName;
	}
	public String getInfoDocument() {
		return infoDocument;
	}
	public void setInfoDocument(String infoDocument) {
		this.infoDocument = infoDocument;
	}
	public String getInfoComment() {
		return infoComment;
	}
	public void setInfoComment(String infoComment) {
		this.infoComment = infoComment;
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
