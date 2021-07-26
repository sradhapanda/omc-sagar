package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.RegionAuditPartyMasterModel;

public class GenerateRegionalOfficerParameter {

	
	public static String addRegionalMasterParam(RegionAuditPartyMasterModel form) {
		String s = "";

		if (form.getRegionId() != null && form.getRegionId() != "") {
			s = s + "@p_regId='" + form.getRegionId() + "',";
		}

		if (form.getAuditId() != null && form.getAuditId() != "") {
			s = s + "@p_auditId='" + form.getAuditId() + "',";
		}
		
		if (form.getDesc() != null && form.getDesc() != "") {
			s = s + "@p_desc='" + form.getDesc() + "',";
		}

		if (form.getStatus() != null) {
			s = s + "@p_status=" + form.getStatus() + ",";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
	
}
