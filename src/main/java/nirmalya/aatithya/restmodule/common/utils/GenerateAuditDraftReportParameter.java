package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.RestAuditDraftReportModel;

public class GenerateAuditDraftReportParameter {

	public static String addAuditReportParam(RestAuditDraftReportModel audit) {

		String s = "";
		String qItem = "";
		String qItem1 = "";
		String qItem2 = "";
		String qItem3 = "";
		String qItem4 = "";

		for (int i = 0; i < audit.getAdditionalInfo().size(); i++) {
			qItem1 = qItem1 + "(@p_auditReportId,\"" + audit.getAdditionalInfo().get(i).getInfoFileName() + "\",\""
					+ audit.getAdditionalInfo().get(i).getInfoDocument() + "\",\""
					+ audit.getAdditionalInfo().get(i).getInfoComment() + "\",\"" + "2" + "\"),";
		}
		for (int i = 0; i < audit.getBasicOfQualify().size(); i++) {
			qItem2 = qItem2 + "(@p_auditReportId,\"" + audit.getBasicOfQualify().get(i).getQlfyFileName() + "\",\""
					+ audit.getBasicOfQualify().get(i).getQlfyDocument() + "\",\""
					+ audit.getBasicOfQualify().get(i).getQlfyComment() + "\",\"" + "3" + "\"),";
		}
		for (int i = 0; i < audit.getAttachmment().size(); i++) {
			qItem = qItem + "(@p_auditReportId,\"" + audit.getAttachmment().get(i).getfYear() + "\",\""
					+ audit.getAttachmment().get(i).getType() + "\",\""
					+ audit.getAttachmment().get(i).getAttachfileName() + "\",\""
					+ audit.getAttachmment().get(i).getAttachDocument() + "\",\""
					+ audit.getAttachmment().get(i).getAttachComment() + "\",\"" + "1" + "\"),";
		}

		String cc = "";
		for (String ac : audit.getPersonCC()) {
			cc += ac + ",";
		}
		String bc = "";
		for (String ac : audit.getPersonTo()) {
			bc += ac + ",";
		}
		if(cc != null && cc != "")
		cc = cc.substring(0, cc.length() - 1);
		if(bc != null && bc != "")
		bc = bc.substring(0, bc.length() - 1);


		if (cc != null && cc != "") {
			s = s + "@p_cc='" + cc + "',";
		}
		if (bc != null && bc != "") {
			s = s + "@p_bc='" + bc + "',";
		}

		if (audit.getDraftId() != null && audit.getDraftId() != "") {
			s = s + "@p_auditReportId='" + audit.getDraftId() + "',";
		}
		if (audit.getDraftNo() != null && audit.getDraftNo() != "") {
			s = s + "@p_draftNo='" + audit.getDraftNo() + "',";
		}
		if (audit.getVersion() != null && audit.getVersion() != "") {
			s = s + "@p_version='" + audit.getVersion() + "',";
		}
		if (audit.getDate() != null && audit.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(audit.getDate()) + "',";
		}
		if (audit.getAuditType() != null && audit.getAuditType() != "") {
			s = s + "@p_auditType='" + audit.getAuditType() + "',";
		}
		if (audit.getInitiateId() != null && audit.getInitiateId() != "") {
			s = s + "@p_initiatedId='" + audit.getInitiateId() + "',";
		} 
		if (audit.getReportType() != null && audit.getReportType() != "") {
			s = s + "@p_reportType='" + audit.getReportType() + "',";
		}
		if (audit.getComment() != null && audit.getComment() != "") {
			s = s + "@p_comment='" + audit.getComment() + "',";
		}
		if (audit.getVersion() != null && audit.getVersion() != "") {
			s = s + "@p_version='" + audit.getVersion() + "',";
		}

		qItem = qItem.substring(0, qItem.length() - 1);

		s = s + "@p_docAttachmentSubQuery='" + qItem + "',";

		qItem1 = qItem1.substring(0, qItem1.length() - 1);

		s = s + "@p_additionalInfoSubQuery='" + qItem1 + "',";

		qItem2 = qItem2.substring(0, qItem2.length() - 1);

		s = s + "@p_qualificationSubQuery='" + qItem2 + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}

}
