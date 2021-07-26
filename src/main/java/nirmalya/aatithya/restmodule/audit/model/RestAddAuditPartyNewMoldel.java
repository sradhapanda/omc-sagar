package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAddAuditPartyNewMoldel {
	public RestAddAuditPartyNewMoldel() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String tAduitNewId;
	private String tAduitNewName;
	private String tAduitNewFName;
	private String tAduitNewLName;
	private String tAduitNewMobile;
	private String tAduitNewEmail;
	/* private String tUserType; */
	private String tAduitNewCountry;
	private String tAduitNewState;
	private String tAduitNewDist;
	private String tAduitNewAddress;
	private String tStatus;
	
	private String tAduitNewPINno;
	private String tPassword;

	
	private String tCreatedBy;
	private String tUpdatedBy;
	private String tCreatedOn;
	private String tUpdatedOn;
	private String designation;
	private String option;
	

	


	public RestAddAuditPartyNewMoldel(Object tAduitNewId, Object tAduitNewName, Object tAduitNewFName,
			Object tAduitNewLName, Object tAduitNewMobile, Object tAduitNewEmail, Object tAduitNewCountry,
			Object tAduitNewState, Object tAduitNewDist, Object tAduitNewAddress, Object tStatus,
			Object tAduitNewPINno, Object designation, Object tPassword, Object tCreatedBy, Object tUpdatedBy, Object tCreatedOn,
			Object tUpdatedOn) {
		super();
		this.tAduitNewId = (String)tAduitNewId;
		this.tAduitNewName = (String)tAduitNewName;
		this.tAduitNewFName = (String)tAduitNewFName;
		this.tAduitNewLName =(String)tAduitNewLName;
		this.tAduitNewMobile = (String)tAduitNewMobile;
		this.tAduitNewEmail = (String)tAduitNewEmail;
		this.tAduitNewCountry = (String)tAduitNewCountry;
		this.tAduitNewState = (String)tAduitNewState;
		this.tAduitNewDist = (String)tAduitNewDist;
		this.tAduitNewAddress = (String)tAduitNewAddress;
		this.tStatus = (String) tStatus;
		this.tAduitNewPINno = (String)tAduitNewPINno;
		this.designation = (String)designation;
		this.tCreatedBy = (String)tCreatedBy;
		this.tUpdatedBy = (String)tUpdatedBy;
		this.tCreatedOn = (String)tCreatedOn;
		this.tUpdatedOn = (String)tUpdatedOn;
		this.designation = (String)designation;
	}


	public String gettAduitNewId() {
		return tAduitNewId;
	}


	public void settAduitNewId(String tAduitNewId) {
		this.tAduitNewId = tAduitNewId;
	}


	public String gettAduitNewName() {
		return tAduitNewName;
	}


	public void settAduitNewName(String tAduitNewName) {
		this.tAduitNewName = tAduitNewName;
	}


	public String gettAduitNewFName() {
		return tAduitNewFName;
	}


	public void settAduitNewFName(String tAduitNewFName) {
		this.tAduitNewFName = tAduitNewFName;
	}


	public String gettAduitNewLName() {
		return tAduitNewLName;
	}


	public void settAduitNewLName(String tAduitNewLName) {
		this.tAduitNewLName = tAduitNewLName;
	}


	public String gettAduitNewMobile() {
		return tAduitNewMobile;
	}


	public void settAduitNewMobile(String tAduitNewMobile) {
		this.tAduitNewMobile = tAduitNewMobile;
	}


	public String gettAduitNewEmail() {
		return tAduitNewEmail;
	}


	public void settAduitNewEmail(String tAduitNewEmail) {
		this.tAduitNewEmail = tAduitNewEmail;
	}


	public String gettAduitNewCountry() {
		return tAduitNewCountry;
	}


	public void settAduitNewCountry(String tAduitNewCountry) {
		this.tAduitNewCountry = tAduitNewCountry;
	}


	public String gettAduitNewState() {
		return tAduitNewState;
	}


	public void settAduitNewState(String tAduitNewState) {
		this.tAduitNewState = tAduitNewState;
	}


	public String gettAduitNewDist() {
		return tAduitNewDist;
	}


	public void settAduitNewDist(String tAduitNewDist) {
		this.tAduitNewDist = tAduitNewDist;
	}


	public String gettAduitNewAddress() {
		return tAduitNewAddress;
	}


	public void settAduitNewAddress(String tAduitNewAddress) {
		this.tAduitNewAddress = tAduitNewAddress;
	}


	public String gettStatus() {
		return tStatus;
	}


	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}


	public String gettAduitNewPINno() {
		return tAduitNewPINno;
	}


	public void settAduitNewPINno(String tAduitNewPINno) {
		this.tAduitNewPINno = tAduitNewPINno;
	}


	public String gettPassword() {
		return tPassword;
	}


	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}


	public String gettCreatedBy() {
		return tCreatedBy;
	}


	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}


	public String gettUpdatedBy() {
		return tUpdatedBy;
	}


	public void settUpdatedBy(String tUpdatedBy) {
		this.tUpdatedBy = tUpdatedBy;
	}


	public String gettCreatedOn() {
		return tCreatedOn;
	}


	public void settCreatedOn(String tCreatedOn) {
		this.tCreatedOn = tCreatedOn;
	}


	public String gettUpdatedOn() {
		return tUpdatedOn;
	}


	public void settUpdatedOn(String tUpdatedOn) {
		this.tUpdatedOn = tUpdatedOn;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
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


	public String getOption() {
		return option;
	}


	public void setOption(String option) {
		this.option = option;
	}

}
