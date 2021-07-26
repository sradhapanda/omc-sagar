package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.AuditPartyMasterModel;

public class GenerateAuditPartyParameter {

	public static String addStructParam(AuditPartyMasterModel auditParty) {
		

	System.out.println("auditParty##"+auditParty);
	String s = "";
	
	if(auditParty.getAuditPartyId() != null && auditParty.getAuditPartyId() != "")
	{
		s = s + "@p_auditId='" + auditParty.getAuditPartyId() + "',";
	}
	if(auditParty.getAuditPartyFirstName() != null && auditParty.getAuditPartyFirstName() != "")
	{
		s = s + "@p_auditFirstName='" + auditParty.getAuditPartyFirstName() + "',";
	}
	if(auditParty.getAuditPartyLastName() != null && auditParty.getAuditPartyLastName() != "")
	{
		s = s + "@p_auditLastName='" + auditParty.getAuditPartyLastName() + "',";
	}
	/*if(auditParty.getAddress() != null && auditParty.getAddress() != "")
	{
		s = s + "@p_desc='" + auditParty.getAddress() + "',";
	}*/
	if(auditParty.getAuditPartyActive() != null)
	{
		s = s + "@p_status=" + auditParty.getAuditPartyActive() + ",";
	}
	if(auditParty.getCreatedBy() != null && auditParty.getCreatedBy() != "")
	{
		s = s + "@p_createdBy='" + auditParty.getCreatedBy() + "',";
	}
	
	if(s != "") {
		s = s.substring(0, s.length()-1);
		
		s = "SET " + s + ";" ;
	}
	
	System.out.println(s);
	return s;
	}
	
}
