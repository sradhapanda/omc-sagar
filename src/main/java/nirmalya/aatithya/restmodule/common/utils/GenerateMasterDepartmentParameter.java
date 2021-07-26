package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.OutStandingParaModel;
import nirmalya.aatithya.restmodule.audit.model.RegionMasterModel;

public class GenerateMasterDepartmentParameter {

	public static String getAddDepartmentParam(RegionMasterModel region) {

		String s = "";

		
		if (region.getDepartment() != null && region.getDepartment() != " ") {
			s = s + "@p_department='" + region.getDepartment() + "',";
		}

		if (region.getRegionId() != null && region.getRegionId() != " ") {
			s = s + "@p_regionId='" + region.getRegionId() + "',";
		}

		if (region.getRegionName() != null && region.getRegionName() != " ") {
			s = s + "@p_regionName='" + region.getRegionName() + "',";
		}

		if (region.getDescription() != null && region.getDescription() != " ") {
			s = s + "@p_description='" + region.getDescription() + "',";
		}
		if (region.getStatus() == true || region.getStatus() == false) {
			s = s + "@p_status=" + region.getStatus() + ",";
		}

		if (region.getCreatedBy() != null && region.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + region.getCreatedBy() + "',";

		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("param  : " + s);

		return s;
	}
	public static String addOutstandingParam(OutStandingParaModel paras) {
		
		String s = "";
		
		
		if (paras.getYear() != null && paras.getYear() != " ") {
			s = s + "@p_year='" + paras.getYear() + "',";
		}
		
		if (paras.getIrs()!= null ) {
			s = s + "@p_irs=" + paras.getIrs() + ",";
		}
		
		if (paras.getParas()!= null ) {
			s = s + "@p_paras=" + paras.getParas() + ",";
		}
		
		if (paras.getMoneyValue() != null ) {
			s = s + "@p_moneyValue=" + paras.getMoneyValue() + ",";
		}
		
		
		if (paras.getCreatedBy() != null && paras.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + paras.getCreatedBy() + "',";
			
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		
		System.out.println("param  : " + s);
		
		return s;
	}
}
