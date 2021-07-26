package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.OrganizationAuditorsRestModel;

public class GenerateOrganizationAuditorsParameter {

	// Add Guest
	public static String addOrganizationAuditorsParam(OrganizationAuditorsRestModel orgMaster) {
		String s = "";

		if (orgMaster.gettOrgId() != null) {
			s = s + "@p_OrgId='" + orgMaster.gettOrgId() + "',";
		}
		if (orgMaster.gettOrgName() != null && orgMaster.gettOrgName() != "") {
			s = s + "@p_OrgName='" + orgMaster.gettOrgName() + "',";
		}

		if (orgMaster.gettOrgFName() != null && orgMaster.gettOrgFName() != "") {
			s = s + "@p_OrgFName='" + orgMaster.gettOrgFName() + "',";
		}
		if (orgMaster.gettOrgMobile() != null && orgMaster.gettOrgMobile() != "") {
			s = s + "@p_OrgMobile='" + orgMaster.gettOrgMobile() + "',";
		}
		if (orgMaster.gettOrgEmail() != null && orgMaster.gettOrgEmail() != "") {
			s = s + "@p_OrgEmail='" + orgMaster.gettOrgEmail() + "',";
		}
		if (orgMaster.gettUserType() != null && orgMaster.gettUserType() != "") {
			s = s + "@p_UserType='" + orgMaster.gettUserType() + "',";
		}
		if (orgMaster.gettOrgCountry() != null && orgMaster.gettOrgCountry() != "") {
			s = s + "@p_OrgCountry='" + orgMaster.gettOrgCountry() + "',";
		}
		if (orgMaster.gettOrgDist() != null && orgMaster.gettOrgDist() != "") {
			s = s + "@p_OrgDist='" + orgMaster.gettOrgDist() + "',";
		}
		if (orgMaster.gettOrgAddress() != null && orgMaster.gettOrgAddress() != " ") {
			s = s + "@p_OrgAddress='" + orgMaster.gettOrgAddress() + "',";
		}
		if (orgMaster.gettOrgLName() != null && orgMaster.gettOrgLName() != " ") {
			s = s + "@p_OrgLName='" + orgMaster.gettOrgLName() + "',";
		}
		if (orgMaster.gettPassword() != null && orgMaster.gettPassword() != " ") {
			s = s + "@p_OrgPassword='" + orgMaster.gettPassword() + "',";
		}
		if (orgMaster.gettAuthNo() != null && orgMaster.gettAuthNo() != " ") {
			s = s + "@p_OrgAuthNo='" + orgMaster.gettAuthNo() + "',";
		}
		if (orgMaster.gettOrgState() != null && orgMaster.gettOrgState() != " ") {
			s = s + "@p_OrgState='" + orgMaster.gettOrgState() + "',";
		}
		if (orgMaster.gettDesc() != null && orgMaster.gettDesc() != " ") {
			s = s + "@p_OrgDesc='" + orgMaster.gettDesc() + "',";
		}
		if (orgMaster.gettIMEI() != null && orgMaster.gettIMEI() != " ") {
			s = s + "@p_OrgIMEI='" + orgMaster.gettIMEI() + "',";
		}
		if (orgMaster.gettOrgPINno() != null && orgMaster.gettOrgPINno() != " ") {
			s = s + "@p_OrgPinNo='" + orgMaster.gettOrgPINno() + "',";
		}
		if (orgMaster.gettCreatedBy() != null && orgMaster.gettCreatedBy() != " ") {
			s = s + "@p_CreatedBy='" + orgMaster.gettCreatedBy() + "',";
		}
		if (orgMaster.getDesignation() != null && orgMaster.getDesignation() != " ") {
			s = s + "@p_designation='" + orgMaster.getDesignation() + "',";
		}
		if (orgMaster.gettStatus() == true || orgMaster.gettStatus() == false) {
			s = s + "@p_active=" + orgMaster.gettStatus() + ",";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
