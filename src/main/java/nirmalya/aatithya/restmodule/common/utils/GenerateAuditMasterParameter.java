package nirmalya.aatithya.restmodule.common.utils;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.audit.model.AuditComplianceModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;

public class GenerateAuditMasterParameter {
	public static String addAuditParam(AuditMasterModel audit, int k) {
		String s = "";
		String qItem3 = "";
		String qItem1 = "";
		String addInfo = "";
		String docSubquery = "";
		String qItem4 = "";
		String qItem5 = "";

		// System.out.println(audit);

		if (k != 0) {
			s = s + "@p_count=" + k + ",";
		}
		if (audit.getAuditAutoGenId() != null) {
			s = s + "@p_auditId='" + audit.getAuditAutoGenId() + "',";
		} else {
			s = s + "@p_auditId='',";
		}
		if (audit.getAuditInitiated() != null && audit.getAuditInitiated() != "") {
			s = s + "@p_auditInitiate='" + audit.getAuditInitiated() + "',";
		} else {
			s = s + "@p_auditInitiate='',";
		}
		if (audit.getDepartment() != null && audit.getDepartment() != "") {
			s = s + "@p_department='" + audit.getDepartment() + "',";
		} else {
			String dept = "DPT002";
			s = s + "@p_department='" + dept + "',";
		}
		/*
		 * if (audit.getAuditName().equals("ADTM005")) { if (audit.getRegion() != null
		 * && audit.getRegion() != "") { s = s + "@p_section='" + audit.getRegion() +
		 * "',"; } else { s = s + "@p_section='',"; } } else {
		 */
		if (audit.getSection() != null && audit.getSection() != "") {
			s = s + "@p_section='" + audit.getSection() + "',";
		} else {
			s = s + "@p_section='',";
		}
		// }
		if (audit.getDeptHeadId() != null && audit.getDeptHeadId() != "") {
			s = s + "@p_deptHeadId='" + audit.getDeptHeadId() + "',";
		} else {
			s = s + "@p_deptHeadId='" + audit.getRegionalManager() + "',";
		}
		if (audit.getAuditor() != null && audit.getAuditor() != "") {
			s = s + "@p_auditor='" + audit.getAuditor() + "',";
		} else {
			s = s + "@p_auditor='',";
		}
		if (audit.getAuditee() != null && audit.getAuditee() != "") {
			s = s + "@p_auditee='" + audit.getAuditee() + "',";
		} else {
			s = s + "@p_auditee='',";
		}
		if (audit.getFromDate() != null && audit.getFromDate() != "") {

			String date = DateFormatter.getStringDate(audit.getFromDate());

			s = s + "@p_fromDate='" + date + "',";
		} else {
			s = s + "@p_fromDate=null,";
		}
		if (audit.getToDate() != null && audit.getToDate() != "") {

			String Date = DateFormatter.getStringDate(audit.getToDate());
			s = s + "@p_toDate='" + Date + "',";
		} else {
			s = s + "@p_toDate=null,";
		}

		if (audit.getAuditName() != null && audit.getAuditName() != "") {
			s = s + "@p_auditType='" + audit.getAuditName() + "',";
		} else {
			s = s + "@p_auditType='',";
		}
		if (audit.getFinancialYear() != null && audit.getFinancialYear() != "") {
			s = s + "@p_financialYear='" + audit.getFinancialYear() + "',";
		} else {
			s = s + "@p_financialYear='',";
		}
		if (audit.getInitiatedBy() != null && audit.getInitiatedBy() != "") {
			s = s + "@p_initiatedBy='" + audit.getInitiatedBy() + "',";
		} else {
			s = s + "@p_initiatedBy='',";
		}
		
		if (audit.getInitiatedDate() != null && audit.getInitiatedDate() != "") {
			s = s + "@p_initiatedDate='" + DateFormatter.getStringDateTimeMin(audit.getInitiatedDate()) + "',";
			} else {
			s = s + "@p_initiatedDate=null,";
		}
		if (audit.getSummary() != null && audit.getSummary() != "") {
			s = s + "@p_summary='" + audit.getSummary() + "',";
		} else {
			s = s + "@p_summary='',";
		}

		if (audit.getSubject() != null && audit.getSubject() != "") {
			s = s + "@p_subject='" + audit.getSubject() + "',";
		} else {
			s = s + "@p_subject='',";
		}
		if (audit.getGuideLineDoc() != null && audit.getGuideLineDoc() != "") {
			s = s + "@p_document='" + audit.getGuideLineDoc() + "',";
		} else {
			s = s + "@p_document='',";
		}
		if (audit.getCreatedBy() != null && audit.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + audit.getCreatedBy() + "',";
		} else {
			s = s + "@p_createdBy='',";
		}
		if (audit.getOrganisation() != null && audit.getOrganisation() != "") {
			s = s + "@p_organization='" + audit.getOrganisation() + "',";
		} else {
			s = s + "@p_organization='',";
		}
		if (audit.getLetterNo() != null && audit.getLetterNo() != "") {
			s = s + "@p_letterNo='" + audit.getLetterNo() + "',";
		} else {
			s = s + "@p_letterNo='',";
		}
		if (audit.getAuditor() != null && audit.getAuditor() != "") {
			s = s + "@p_auditor='" + audit.getAuditor() + "',";
		} else {
			s = s + "@p_auditor='',";
		}
		if (audit.getRegionalManager() != null && audit.getRegionalManager() != "") {
			s = s + "@p_RegionalManager='" + audit.getRegionalManager() + "',";
		} else {
			s = s + "@p_RegionalManager='',";
		}
		if (audit.getConcernedFinance() != null && audit.getConcernedFinance() != "") {
			s = s + "@p_ConcernedFinance='" + audit.getConcernedFinance() + "',";
		} else {
			s = s + "@p_ConcernedFinance='',";
		}

		if (audit.getQuarter() != null && audit.getQuarter() != "") {
			s = s + "@p_Quarter='" + audit.getQuarter() + "',";
		} else {
			s = s + "@p_Quarter='',";
		}
		if (audit.getRegion() != null && audit.getRegion() != "") {
			s = s + "@p_Region='" + audit.getRegion() + "',";
		} else {
			s = s + "@p_Region='',";
		}

		// subco-ordinator add

		/*
		 * if (audit.getSubcoordinator().size() > 0) { for (int i = 0; i <
		 * audit.getSubcoordinator().size(); i++) { qItem3 = qItem3 + "(@p_auditId,\"" +
		 * audit.getSubcoordinator().get(i) + "\",\"" + audit.getCreatedBy() + "\"),";
		 * 
		 * } if (qItem3.length() > 0) { qItem3 = qItem3.substring(0, qItem3.length() -
		 * 1); s = s + "@p_subCoordi='" + qItem3 + "',"; } }
		 */
		// Concerned Auditee add
		if (audit.getConcernedAuditee().size() > 0) {
			for (int i = 0; i < audit.getConcernedAuditee().size(); i++) {
				qItem4 = qItem4 + "(@p_auditId,@p_auditInitiate,\"" + audit.getConcernedAuditee().get(i) + "\",\""
						+ audit.getCreatedBy() + "\"),";
			}
		}
		if (qItem4.length() > 0) {
			qItem4 = qItem4.substring(0, qItem4.length() - 1);
			s = s + "@p_ConAuditee='" + qItem4 + "',";
		}
		if(qItem4.length() == 0){
		s = s + "@p_ConAuditee='',";
		}
		
		// CC add
		if (audit.getCcData().size() > 0) {
			for (int i = 0; i < audit.getCcData().size(); i++) {
				qItem5 = qItem5 + "(@p_auditId,@p_auditInitiate,\"" + audit.getCcData().get(i) + "\",\""
						+ audit.getCreatedBy() + "\"),";
			}
		}
		if (qItem5.length() > 0) {
			qItem5 = qItem5.substring(0, qItem5.length() - 1);
			s = s + "@p_ccData='" + qItem5 + "',";
		}
		if(qItem5.length() == 0){
			s = s + "@p_ccData='',";
		}
		if (audit.getAdditional().size() > 0) {
			for (int i = 0; i < audit.getAdditional().size(); i++) {
				addInfo = addInfo + "(@p_auditInitiate,\"" + audit.getAdditional().get(i).getDoc() + "\",\""
						+ audit.getAdditional().get(i).getDocName() + "\",\"" + audit.getAdditional().get(i).getInfo()
						+ "\",\"" + audit.getCreatedBy() + "\"),";

			}
			if (addInfo.length() > 0) {
				addInfo = addInfo.substring(0, addInfo.length() - 1);
				s = s + "@p_addInfo='" + addInfo + "',";
			}
		}

		if (audit.getDocuments().size() > 0) {

			for (int i = 0; i < audit.getDocuments().size(); i++) {

				docSubquery += "(@p_auditInitiate,\"" + audit.getDocuments().get(i).getDoc() + "\",\""
						+ audit.getDocuments().get(i).getDocName() + "\",\"" + audit.getDocuments().get(i).getInfo()
						+ "\"),";

			}
			if (docSubquery.length() > 0) {
				docSubquery = docSubquery.substring(0, docSubquery.length() - 1);
				s = s + "@p_docSubquery='" + docSubquery + "',";
			}
		}
		String deptHead = "";
		String aspemail = "";
		String listProduct = "";
		for (int i = 0; i < audit.getConcernedAuditee().size(); i++) {
			aspemail = audit.getConcernedAuditee().get(i).replace("(", "").replace(")", "");
			listProduct = listProduct + "'" + audit.getConcernedAuditee().get(i) + "',";
		}

		if (listProduct != "") {
			aspemail = listProduct.substring(0, listProduct.length() - 1);
		}
		String asp1 = "";
		if (aspemail != "") {
			asp1 = "@p_peopleEmail=\"(" + aspemail + ")\"";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			if (asp1 != "") {
				s = "SET " + s + "," + asp1 + ";";
			} else {
				s = "SET " + s + ";";
			}
		}

		System.out.println(s);
		return s;
	}

	/*
	 * // HouseKeeping Task public static String forwardAudit(AuditComplianceModel
	 * obj) { String s = "";
	 * 
	 * String qItem1 = ""; String qItem2 = ""; for (int i = 0; i <
	 * obj.getPerson().size(); i++) { qItem1 = qItem1 + "(\"" + obj.getAuditId() +
	 * "\",\"" + obj.getPerson().get(i) + "\",\"" + obj.getCreatedBy() + "\"),"; }
	 * for (int i = 0; i < obj.getPersonCC().size(); i++) { qItem2 = qItem2 + "(\""
	 * + obj.getAuditId() + "\",\"" + obj.getPersonCC().get(i) + "\",\"" +
	 * obj.getCreatedBy() + "\"),"; } if (qItem1 != null && qItem1 != "") { qItem1 =
	 * qItem1.substring(0, qItem1.length() - 1); s = s + "@p_qItemSubQuery='" +
	 * qItem1 + "',"; } if (qItem2 != null && qItem2 != "") { qItem2=
	 * qItem2.substring(0, qItem2.length() - 1); s = s + "@p_ccQuery='" + qItem2 +
	 * "',"; }
	 * 
	 * s = s + "@p_id='" + obj.getAuditId() + "',"; s = s + "@p_createdBy='" +
	 * obj.getCreatedBy() + "',"; s = s + "@p_comment='" + obj.getComment() + "',";
	 * if (s != "") { s = s.substring(0, s.length() - 1);
	 * 
	 * s = "SET " + s + ";"; }
	 * 
	 * 
	 * return s; }
	 */

	// My ViewRequest
	public static String addViewRequest(RequisitionViewModel requisitionViewModel) {
		String s = "";

		s = s + "@p_qItemSubQuery='" + requisitionViewModel.getDocument() + "',";
		s = s + "@p_id='" + requisitionViewModel.getAuditId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}