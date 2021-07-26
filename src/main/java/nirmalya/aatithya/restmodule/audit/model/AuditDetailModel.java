/**
 * 
 */
package nirmalya.aatithya.restmodule.audit.model;

/**
 * @author USER
 *
 */
public class AuditDetailModel {
	private Integer id;
	private String inititaeId;
	private String document;
	private String comment;
	private String createdby;
	private String createdOn;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInititaeId() {
		return inititaeId;
	}
	public void setInititaeId(String inititaeId) {
		this.inititaeId = inititaeId;
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
	public AuditDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuditDetailModel(Object id, Object inititaeId, Object document, Object comment, Object createdby,
			Object createdOn) {
		super();
		this.id = (Integer)id;
		this.inititaeId = (String)inititaeId;
		this.document =(String) document;
		this.comment = (String)comment;
		this.createdby =(String) createdby;
		this.createdOn =(String) createdOn;
	}
	
}
