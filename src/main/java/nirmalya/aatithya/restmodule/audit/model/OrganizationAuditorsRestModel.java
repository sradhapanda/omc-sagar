package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrganizationAuditorsRestModel {

	private String tOrgId;
	private String tOrgName;
	private String tOrgFName;
	private String tOrgMobile;
	private String tOrgEmail;
	private String tUserType;
	private String tOrgCountry;
	private String tOrgDist;
	private String tOrgAddress;
	private Boolean tStatus;
	private String tOrgLName;
	private String tOrgPINno;
	private String tPassword;
	private String tAuthNo;
	private String tOrgState;
	private String tDesc;
	private String tIMEI;
	private String tCreatedBy;
	private String tCreatedOn;
	private String designation;
	public OrganizationAuditorsRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganizationAuditorsRestModel(Object tOrgId, Object tOrgName, Object tOrgFName, Object tOrgMobile,
			Object tOrgEmail, Object tUserType, Object tOrgCountry, Object tOrgDist, Object tOrgAddress, Object tStatus,
			Object tOrgLName, Object tOrgPINno, Object tPassword, Object tAuthNo, Object tOrgState,
			Object tDesc, Object tIMEI, Object tCreatedBy, Object tCreatedOn,Object designation) {
		super();
		this.tOrgId = (String) tOrgId;
		this.tOrgName = (String) tOrgName;
		this.tOrgFName = (String) tOrgFName;
		this.tOrgMobile = (String) tOrgMobile;
		this.tOrgEmail = (String) tOrgEmail;
		this.tUserType = (String) tUserType;
		this.tOrgCountry = (String) tOrgCountry;
		this.tOrgDist = (String) tOrgDist;
		this.tOrgAddress = (String) tOrgAddress;
		this.tStatus = (Boolean) tStatus;
		this.tOrgLName = (String) tOrgLName;
		this.tOrgPINno = (String) tOrgPINno;
		this.tPassword = (String) tPassword;
		this.tAuthNo = (String) tAuthNo;
		this.tOrgState = (String) tOrgState;
		this.tDesc = (String) tDesc;
		this.tIMEI = (String) tIMEI;
		this.tCreatedBy = (String) tCreatedBy;
		this.tCreatedOn = (String) tCreatedOn;
		this.designation=(String)designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String gettOrgId() {
		return tOrgId;
	}

	public void settOrgId(String tOrgId) {
		this.tOrgId = tOrgId;
	}

	public String gettOrgName() {
		return tOrgName;
	}

	public void settOrgName(String tOrgName) {
		this.tOrgName = tOrgName;
	}

	public String gettOrgFName() {
		return tOrgFName;
	}

	public void settOrgFName(String tOrgFName) {
		this.tOrgFName = tOrgFName;
	}

	public String gettOrgMobile() {
		return tOrgMobile;
	}

	public void settOrgMobile(String tOrgMobile) {
		this.tOrgMobile = tOrgMobile;
	}

	public String gettOrgEmail() {
		return tOrgEmail;
	}

	public void settOrgEmail(String tOrgEmail) {
		this.tOrgEmail = tOrgEmail;
	}

	public String gettUserType() {
		return tUserType;
	}

	public void settUserType(String tUserType) {
		this.tUserType = tUserType;
	}

	public String gettOrgCountry() {
		return tOrgCountry;
	}

	public void settOrgCountry(String tOrgCountry) {
		this.tOrgCountry = tOrgCountry;
	}

	public String gettOrgDist() {
		return tOrgDist;
	}

	public void settOrgDist(String tOrgDist) {
		this.tOrgDist = tOrgDist;
	}

	public String gettOrgAddress() {
		return tOrgAddress;
	}

	public void settOrgAddress(String tOrgAddress) {
		this.tOrgAddress = tOrgAddress;
	}

	public Boolean gettStatus() {
		return tStatus;
	}

	public void settStatus(Boolean tStatus) {
		this.tStatus = tStatus;
	}

	public String gettOrgLName() {
		return tOrgLName;
	}

	public void settOrgLName(String tOrgLName) {
		this.tOrgLName = tOrgLName;
	}

	public String gettOrgPINno() {
		return tOrgPINno;
	}

	public void settOrgPINno(String tOrgPINno) {
		this.tOrgPINno = tOrgPINno;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String gettAuthNo() {
		return tAuthNo;
	}

	public void settAuthNo(String tAuthNo) {
		this.tAuthNo = tAuthNo;
	}

	public String gettOrgState() {
		return tOrgState;
	}

	public void settOrgState(String tOrgState) {
		this.tOrgState = tOrgState;
	}

	public String gettDesc() {
		return tDesc;
	}

	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}

	public String gettIMEI() {
		return tIMEI;
	}

	public void settIMEI(String tIMEI) {
		this.tIMEI = tIMEI;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}

	public String gettCreatedOn() {
		return tCreatedOn;
	}

	public void settCreatedOn(String tCreatedOn) {
		this.tCreatedOn = tCreatedOn;
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
