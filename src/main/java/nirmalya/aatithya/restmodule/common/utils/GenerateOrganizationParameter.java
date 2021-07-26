package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.OrganizationRestModel;

public class GenerateOrganizationParameter {

	// Add Guest 
	public static String addOrganizationParam(OrganizationRestModel orgMaster) {
String s = "";
		
		if(orgMaster.gettOrg()!=null)
		{
			s = s + "@p_Org='" + orgMaster.gettOrg() + "',";
		}
		if(orgMaster.gettOrgName()!=null && orgMaster.gettOrgName()!="")
		{
			s = s + "@p_OrgName='" + orgMaster.gettOrgName() + "',";
		}
		 
		if(orgMaster.gettOrgMobile()!=null && orgMaster.gettOrgMobile()!="")
		{
			s = s + "@p_OrgMob='" + orgMaster.gettOrgMobile() + "',";
		}
		if(orgMaster.gettOrgPINno()!=null && orgMaster.gettOrgPINno()!="")
		{
			s = s + "@p_Orgpinno='" + orgMaster.gettOrgPINno() + "',";
		}
		if(orgMaster.gettOrgAddress()!=null && orgMaster.gettOrgAddress()!="")
		{
			s = s + "@p_OrgAddress='" + orgMaster.gettOrgAddress() + "',";
		}
		if(orgMaster.gettOrgCountry()!=null && orgMaster.gettOrgCountry()!="")
		{
			s = s + "@p_OrgCountry='" + orgMaster.gettOrgCountry() + "',";
		}
		if(orgMaster.gettOrgState()!=null && orgMaster.gettOrgState()!="")
		{
			s = s + "@p_OrgState='" + orgMaster.gettOrgState() + "',";
		}
		if(orgMaster.gettOrgDist()!=null && orgMaster.gettOrgDist()!="")
		{
			s = s + "@p_OrgDist='" + orgMaster.gettOrgDist() + "',";
		}
		if(orgMaster.gettOrgdesc()!=null && orgMaster.gettOrgdesc()!=" ")
		{
			s = s + "@p_OrgDesc='" + orgMaster.gettOrgdesc() + "',";
		}
		if(orgMaster.gettCreatedBy()!=null && orgMaster.gettCreatedBy()!=" ")
		{
			s = s + "@p_CreatedBy='" + orgMaster.gettCreatedBy() + "',";
		}
		if(orgMaster.gettStatus()==true || orgMaster.gettStatus()==false)
		{
			s = s + "@p_active=" + orgMaster.gettStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}

}