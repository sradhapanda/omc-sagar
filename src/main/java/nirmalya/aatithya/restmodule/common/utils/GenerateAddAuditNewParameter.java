package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.RestAddAuditPartyNewMoldel;

public class GenerateAddAuditNewParameter {
	public static String addAuditNewParam(RestAddAuditPartyNewMoldel auditRegionNewMstr) {
		String s = "";

		if (auditRegionNewMstr.gettAduitNewId() != null) {
			s = s + " @p_Region='" + auditRegionNewMstr.gettAduitNewId() + "',";
		}

		if (auditRegionNewMstr.gettAduitNewName() != null && auditRegionNewMstr.gettAduitNewName() != "") {
			s = s + "@p_TAPNM_Region_Name='" + auditRegionNewMstr.gettAduitNewName() + "',";
		}

		if (auditRegionNewMstr.gettAduitNewFName() != null && auditRegionNewMstr.gettAduitNewFName() != "") {
			s = s + "@p_TAPNM_FName='" + auditRegionNewMstr.gettAduitNewFName() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewLName() != null && auditRegionNewMstr.gettAduitNewLName() != "") {
			s = s + "@p_TAPNM_LName='" + auditRegionNewMstr.gettAduitNewLName() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewMobile() != null && auditRegionNewMstr.gettAduitNewMobile() != "") {
			s = s + "@p_TAPNM_Mobile='" + auditRegionNewMstr.gettAduitNewMobile() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewEmail() != null && auditRegionNewMstr.gettAduitNewEmail() != "") {
			s = s + "@p_TAPNM_Email='" + auditRegionNewMstr.gettAduitNewEmail() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewCountry() != null && auditRegionNewMstr.gettAduitNewCountry() != "") {
			s = s + "@p_TAPNM_Country='" + auditRegionNewMstr.gettAduitNewCountry() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewState() != null && auditRegionNewMstr.gettAduitNewState() != "") {
			s = s + "@p_TAPNM_State='" + auditRegionNewMstr.gettAduitNewState() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewDist() != null && auditRegionNewMstr.gettAduitNewDist() != "") {
			s = s + "@p_TAPNM_Dist='" + auditRegionNewMstr.gettAduitNewDist() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewAddress() != null && auditRegionNewMstr.gettAduitNewAddress() != " ") {
			s = s + "@p_TAPNM_Address='" + auditRegionNewMstr.gettAduitNewAddress() + "',";
		}
		if (auditRegionNewMstr.gettAduitNewPINno() != null|| auditRegionNewMstr.gettAduitNewPINno() != " ") {
			s = s + "@p_TAPNM_Pin=" + auditRegionNewMstr.gettAduitNewPINno() + ",";
		}
		/*
		 * if (auditRegionNewMstr.gettStatus() == true ||
		 * auditRegionNewMstr.gettStatus() == false) { s = s + "@p_TAPNM_Status=" +
		 * auditRegionNewMstr.gettStatus() + ","; }
		 */
	
		if (auditRegionNewMstr.gettStatus() != null|| auditRegionNewMstr.gettStatus()  != " ") {
			s = s + "@p_TAPNM_Status=" + auditRegionNewMstr.gettStatus() + ",";
		}
		/*
		 * if(auditRegionNewMstr.gettCreatedBy()!=null &&
		 * auditRegionNewMstr.gettCreatedBy()!=" ") { s = s + "@p_CreatedBy='" +
		 * auditRegionNewMstr.gettCreatedBy() + "',"; }
		 * if(auditRegionNewMstr.gettUpdatedBy()!=null &&
		 * auditRegionNewMstr.gettUpdatedBy()!=" ") { s = s + "@p_CreatedBy='" +
		 * auditRegionNewMstr.gettCreatedBy() + "',"; }
		 */
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
