package nirmalya.aatithya.restmodule.audit.model;

public class AuditAdditionalInfoModel {
	public AuditAdditionalInfoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String docName;
	private String doc;
	private String info;
	
	public AuditAdditionalInfoModel(Object docName, Object doc, Object info) {
		super();
		this.docName =(String) docName;
		this.doc = (String) doc;
		this.info = (String) info;
	}
	
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "AuditAdditionalInfoModel [docName=" + docName + ", doc=" + doc + ", info=" + info + "]";
	}
	
	
}
