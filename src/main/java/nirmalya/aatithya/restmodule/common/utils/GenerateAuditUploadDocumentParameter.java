package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;


import nirmalya.aatithya.restmodule.master.model.AuditUploadDocumentReportModel;

public class GenerateAuditUploadDocumentParameter {
	public static String getUploadAuditDociumentParam(List<AuditUploadDocumentReportModel> auditUploadDocumentReportModel) {
		String s = "";
		String asp = "";
		for (AuditUploadDocumentReportModel a : auditUploadDocumentReportModel) {

			asp = asp + "(\"" + a.getDesc() + "\",\"" + a.getDocument() + "\",\"" + a.getYear() + "\",\"" + a.getAuditType() +"\"),";

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_uploadDeatils='" + asp + "',";
		s = s + "@p_auditId='" + auditUploadDocumentReportModel.get(0).getDocumentUploadId() + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
