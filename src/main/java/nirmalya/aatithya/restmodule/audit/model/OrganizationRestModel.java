package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrganizationRestModel {
	private String tOrg;
	private String tOrgName;
	private String tOrgMobile;
	private String tOrgPINno;
	private String tOrgAddress;
	private String tOrgCountry;
	private String tOrgState;
	private String tOrgDist;
	private String tOrgdesc;
	private Boolean tStatus;
	private String tCreatedBy;
	private String tCreatedOn;

	public OrganizationRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganizationRestModel(Object tOrg, Object tOrgName, Object tOrgMobile, Object tOrgPINno, Object tOrgAddress,
			Object tOrgCountry, Object tOrgState, Object tOrgDist, Object tOrgdesc, Object tStatus, Object tCreatedBy,
			Object tCreatedOn) {
		super();
		this.tOrg = (String) tOrg;
		this.tOrgName = (String) tOrgName;
		this.tOrgMobile = (String) tOrgMobile;
		this.tOrgPINno = (String) tOrgPINno;
		this.tOrgAddress = (String) tOrgAddress;
		this.tOrgCountry = (String) tOrgCountry;
		this.tOrgState = (String) tOrgState;
		this.tOrgDist = (String) tOrgDist;
		this.tOrgdesc = (String) tOrgdesc;
		this.tStatus = (Boolean) tStatus;
		this.tCreatedBy = (String) tCreatedBy;
		this.tCreatedOn = (String) tCreatedOn;
	}

	public String gettOrg() {
		return tOrg;
	}

	public void settOrg(String tOrg) {
		this.tOrg = tOrg;
	}

	public String gettOrgName() {
		return tOrgName;
	}

	public void settOrgName(String tOrgName) {
		this.tOrgName = tOrgName;
	}

	public String gettOrgMobile() {
		return tOrgMobile;
	}

	public void settOrgMobile(String tOrgMobile) {
		this.tOrgMobile = tOrgMobile;
	}

	public String gettOrgPINno() {
		return tOrgPINno;
	}

	public void settOrgPINno(String tOrgPINno) {
		this.tOrgPINno = tOrgPINno;
	}

	public String gettOrgAddress() {
		return tOrgAddress;
	}

	public void settOrgAddress(String tOrgAddress) {
		this.tOrgAddress = tOrgAddress;
	}

	public String gettOrgCountry() {
		return tOrgCountry;
	}

	public void settOrgCountry(String tOrgCountry) {
		this.tOrgCountry = tOrgCountry;
	}

	public String gettOrgState() {
		return tOrgState;
	}

	public void settOrgState(String tOrgState) {
		this.tOrgState = tOrgState;
	}

	public String gettOrgDist() {
		return tOrgDist;
	}

	public void settOrgDist(String tOrgDist) {
		this.tOrgDist = tOrgDist;
	}

	public String gettOrgdesc() {
		return tOrgdesc;
	}

	public void settOrgdesc(String tOrgdesc) {
		this.tOrgdesc = tOrgdesc;
	}

	public Boolean gettStatus() {
		return tStatus;
	}

	public void settStatus(Boolean tStatus) {
		this.tStatus = tStatus;
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
