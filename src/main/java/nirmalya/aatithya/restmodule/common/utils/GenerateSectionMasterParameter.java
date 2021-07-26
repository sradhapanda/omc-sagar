package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.audit.model.RestSectionMasterModel;

public class GenerateSectionMasterParameter {

	public static String addSectionParam(RestSectionMasterModel form) {
		String s = "";

		if (form.getSection() != null && form.getSection() != "") {
			s = s + "@p_section='" + form.getSection() + "',";
		}

		if (form.getSectionName() != null && form.getSectionName() != "") {
			s = s + "@p_sectionName='" + form.getSectionName() + "',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (form.getDepartment() != null && form.getDepartment() != "") {
			s = s + "@p_department='" + form.getDepartment() + "',";
		}

		if (form.getSectionStatus() != null) {
			s = s + "@p_status=" + form.getSectionStatus() + ",";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
