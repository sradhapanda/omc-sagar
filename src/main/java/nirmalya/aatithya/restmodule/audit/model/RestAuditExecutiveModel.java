package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAuditExecutiveModel {
	private String financialYear;
	private String financialYearId;
	private String department;
	private String departmentId;
	private String auditType;
	private String checkListRefNo;
	private String observation;
	private String resolved;
	private String notResolved;
	private String pending;
	private String createdBy;
	private String executiveId;
	private String auditId;
	public RestAuditExecutiveModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RestAuditExecutiveModel(Object financialYear, Object financialYearId, Object department, Object departmentId,
			Object auditType, Object checkListRefNo, Object observation, Object resolved, Object notResolved,
			Object pending, Object createdBy,Object executiveId,Object auditId) {
		super();
		this.financialYear = (String) financialYear;
		this.financialYearId = (String) financialYearId;
		this.department = (String) department;
		this.departmentId = (String) departmentId;
		this.auditType = (String) auditType;
		this.checkListRefNo = (String) checkListRefNo;
		this.observation = (String) observation;
		this.resolved = (String) resolved;
		this.notResolved = (String) notResolved;
		this.pending = (String) pending;
		this.createdBy = (String) createdBy;
		this.executiveId=(String) executiveId;
		this.auditId=(String) auditId;
	}




	public String getFinancialYear() {
		return financialYear;
	}


	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}


	public String getFinancialYearId() {
		return financialYearId;
	}


	public void setFinancialYearId(String financialYearId) {
		this.financialYearId = financialYearId;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}


	public String getAuditType() {
		return auditType;
	}


	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}


	public String getCheckListRefNo() {
		return checkListRefNo;
	}


	public void setCheckListRefNo(String checkListRefNo) {
		this.checkListRefNo = checkListRefNo;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
		this.resolved = resolved;
	}


	public String getNotResolved() {
		return notResolved;
	}


	public void setNotResolved(String notResolved) {
		this.notResolved = notResolved;
	}


	public String getPending() {
		return pending;
	}


	public void setPending(String pending) {
		this.pending = pending;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getExecutiveId() {
		return executiveId;
	}


	public void setExecutiveId(String executiveId) {
		this.executiveId = executiveId;
	}


	public String getAuditId() {
		return auditId;
	}


	public void setAuditId(String auditId) {
		this.auditId = auditId;
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
