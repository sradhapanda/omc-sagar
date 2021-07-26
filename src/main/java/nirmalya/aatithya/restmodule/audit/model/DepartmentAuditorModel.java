package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DepartmentAuditorModel {
	private String departmentId;
	private String section;
	private String departmentHead;
	private String auditor;
	private String auditee;
	private String depId;
	private String SecId;
	private Boolean status;
	private String createdBy;
	private String isEdit;
	public DepartmentAuditorModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentAuditorModel(Object departmentId, Object section, Object departmentHead, Object auditor,Object auditee,Object status,Object depId,Object SecId,Object isEdit) {
		super();

		try {
			this.departmentId = (String) departmentId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.section = (String) section;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.departmentHead = (String) departmentHead;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.auditor = (String) auditor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.auditee = (String) auditee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.status = (Boolean) status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.depId = (String) depId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.SecId = (String) SecId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.isEdit = (String) isEdit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getAuditee() {
		return auditee;
	}
	public void setAuditee(String auditee) {
		this.auditee = auditee;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getSecId() {
		return SecId;
	}

	public void setSecId(String secId) {
		SecId = secId;
	}

	public String getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
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
