package nirmalya.aatithya.restmodule.audit.model;

public class RestAuditReportBasicsQualifyModel {
	private String qlfyFileName;;
	private String qlfyDocument;
	private String qlfyComment;

	public RestAuditReportBasicsQualifyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestAuditReportBasicsQualifyModel(Object qlfyFileName, Object qlfyDocument, Object qlfyComment) {
		super();
		this.qlfyFileName = (String) qlfyFileName;
		this.qlfyDocument = (String) qlfyDocument;
		this.qlfyComment = (String) qlfyComment;
	}

	public String getQlfyFileName() {
		return qlfyFileName;
	}

	public void setQlfyFileName(String qlfyFileName) {
		this.qlfyFileName = qlfyFileName;
	}

	public String getQlfyDocument() {
		return qlfyDocument;
	}

	public void setQlfyDocument(String qlfyDocument) {
		this.qlfyDocument = qlfyDocument;
	}

	public String getQlfyComment() {
		return qlfyComment;
	}

	public void setQlfyComment(String qlfyComment) {
		this.qlfyComment = qlfyComment;
	}

}
