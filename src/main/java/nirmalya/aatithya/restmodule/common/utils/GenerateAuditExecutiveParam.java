package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.audit.model.RestAuditExecutiveModel;


public class GenerateAuditExecutiveParam {
	public static String getAddAuditExecutivParam(
			List<RestAuditExecutiveModel> auditExecutiveModel) {

		String s = "";

		String asp = "";
		
		s = s + "@p_executive='" + auditExecutiveModel.get(0).getExecutiveId() + "',";
		s = s + "@p_financialYear='" + auditExecutiveModel.get(0).getFinancialYearId() + "',";
		if(auditExecutiveModel.get(0).getCheckListRefNo()==null || auditExecutiveModel.get(0).getCheckListRefNo()=="") {
		s = s + "@p_checkListRef='" + 1 + "',";
		}
		else {
			s = s + "@p_checkListRef='" + auditExecutiveModel.get(0).getCheckListRefNo()+ "',";
		}
		s = s + "@p_department='" + auditExecutiveModel.get(0).getDepartmentId() + "',";
		s = s + "@p_createdBy='" + auditExecutiveModel.get(0).getCreatedBy() + "',";
		s = s + "@p_auditId='" + auditExecutiveModel.get(0).getAuditId() + "',";
		for (RestAuditExecutiveModel a : auditExecutiveModel) {
			
			if(auditExecutiveModel.get(0).getCheckListRefNo()==null || auditExecutiveModel.get(0).getCheckListRefNo()=="") {
				a.setCheckListRefNo("1");
				}
				else {
					a.setCheckListRefNo(a.getCheckListRefNo());
				}
			
			
			
				asp = asp + "(@p_executive,\"" + a.getObservation() + "\",\"" + a.getResolved() + "\",\"" + a.getNotResolved() + "\",\"" + a.getPending()+"\",\""+ a.getCreatedBy() + "\",\""+a.getCheckListRefNo()+"\"),";
				
				
				
			
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_assignEdu='" + asp + "',";
	
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
