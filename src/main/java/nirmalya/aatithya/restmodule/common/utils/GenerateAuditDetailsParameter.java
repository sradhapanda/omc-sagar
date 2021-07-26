package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;
import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;

public class GenerateAuditDetailsParameter {

	public static String addDocument(List<AuditInitiateModel> obj) {
		String s = "";
		String asp = "";
		String people = "";
		String peopleCC = "";

		String aspemailCc = "";
		String aspemailTO = "";
		int audit = 0;
		if (obj.get(0).getAudit() != null) {
			audit = obj.get(0).getAudit();
		}
		String personto = "";
		String[] str1 = obj.get(0).getPersonTo().split(",");
		for (int i = 0; i < str1.length; i++) {
			personto = personto + "'" + str1[i] + "',";

		}
		if (personto != "") {
			aspemailTO = personto.substring(0, personto.length() - 1);
		}

		String personcc = "";
		String[] str = obj.get(0).getPersonCc().split(",");
		for (int i = 0; i < str.length; i++) {
			if (str[i] != "") {
				personcc = personcc + "'" + str[i] + "',";
			}
		}
		if (personcc != "") {
			aspemailCc = personcc.substring(0, personcc.length() - 1);
		}

		String asp1 = "@p_id='" + obj.get(0).getAuditInitiate() + "',@p_createdBy='" + obj.get(0).getCreatedBy()
				+ "',@p_document='" + obj.get(0).getDocument() + "',@p_comment='" + obj.get(0).getSummary()
				+ "',@p_auditType='" + obj.get(0).getAuditType() + "',@p_audit='" + audit + "',@p_type='" + obj.get(0).getAuditTypeId() + "',@p_peopleEmail=\"("
				+ aspemailTO + ")\"";

		for (AuditInitiateModel a : obj) {
			if (a.getDocument() != null && a.getDocument() != "") {
				asp = asp + " (@p_aId,\"" + a.getDocument() + "\",\"" + a.getDocumentName() + "\",\""
						+ a.getDocumentComment() + "\"),";
			}
		}

		String notification = "1";
		String[] arr = null;
		String[] arr1 = null;
		// System.out.println(arr.length);
		if (obj.get(0).getPersonTo() != null) {
			arr = obj.get(0).getPersonTo().split(",");
		}
		if (obj.get(0).getPersonCc() != null) {
			arr1 = obj.get(0).getPersonCc().split(",");
		}
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != "") {
					people = people + "(@p_aId,\"" + obj.get(0).getAuditInitiate() + "\",\"" + arr[i] + "\",\""
							+ notification + "\",\"" + obj.get(0).getCreatedBy() + "\",\"" + obj.get(0).getAuditType()
							+ "\"),";
				}
			}
		}
		// System.out.println("arr1"+arr1.length);
		if (arr1.length > 0) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != "") {
					peopleCC = peopleCC + "(@p_aId,\"" + obj.get(0).getAuditInitiate() + "\",\"" + arr1[i] + "\",\""
							+ notification + "\",\"" + obj.get(0).getCreatedBy() + "\",\"" + obj.get(0).getAuditType()
							+ "\"),";
				}
			}
		}
		if (asp != "") {
			asp = asp.substring(0, asp.length() - 1);
		}

		if (people != "") {
			people = people.substring(0, people.length() - 1);
		}

		if (peopleCC != "") {
			peopleCC = peopleCC.substring(0, peopleCC.length() - 1);
		}

		s = s + "@p_reqSubQuery ='" + asp + "',";

		s = s + "@p_people='" + people + "',";

		s = s + "@p_peopleCC='" + peopleCC + "'";

		if (s != "") {
			s = s.substring(0, s.length());

			if (aspemailCc != null && aspemailCc != "") {
				s = "SET " + s + "," + asp1 + ",@p_peopleEmailCc=\"(" + aspemailCc + ")\";";
			}

			else {
				s = "SET " + s + "," + asp1 + ";";
			}
		}
		System.out.println(s);
		return s;

	}

}
