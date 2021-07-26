package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.DepartmentAuditorModel;

public class GenerateDepartmentAuditorParameter {
	public static String addDepartmentAuditorParam(DepartmentAuditorModel form) {
		String s = "";

		if (form.getDepartmentId() != null && form.getDepartmentId() != "") {
			s = s + "@p_departmentId='" + form.getDepartmentId() + "',";
		}

		if (form.getSection() != null && form.getSection() != "") {
			s = s + "@p_sectionName='" + form.getSection() + "',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (form.getDepartmentHead() != null && form.getDepartmentHead() != "") {
			s = s + "@p_departmentHead='" + form.getDepartmentHead() + "',";
		}
		if (form.getAuditor() != null && form.getAuditor() != "") {
			s = s + "@p_auditor='" + form.getAuditor() + "',";
		}
		

		if (form.getStatus() != null) {
			s = s + "@p_status=" + form.getStatus() + ",";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
