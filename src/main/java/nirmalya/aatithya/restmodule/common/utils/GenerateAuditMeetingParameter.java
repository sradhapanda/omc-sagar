package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.audit.model.RestAuditMeetingModel;

public class GenerateAuditMeetingParameter {
	static String[] metaCharacters = { "\\", "^", "$", "{", "}", "[", "]", "(", ")", ".", "*", "+", "?", "|", "<", ">",
			"-", "&", "%", "'" };

	public static String addMeeting(List<RestAuditMeetingModel> obj) {
		String s = "";
		String asp = "";
		String people = "";
		String aspemail = "";

		String personto = "";
		String[] str1 = obj.get(0).getPersonTo().split(",");
		for (int i = 0; i < str1.length; i++) {
			personto = personto + "'" + str1[i] + "',";

			aspemail = personto.substring(0, personto.length() - 1);
		}

		if (obj.get(0).getInitiate() != null && obj.get(0).getInitiate() != "") {
			s = s + "@p_auditInitiate='" + obj.get(0).getInitiate() + "',";
		} else {
			s = s + "@p_auditInitiate='" + 1 + "',";
		}

		if (obj.get(0).getAudit() != null) {
			s = s + "@p_audit='" + obj.get(0).getAudit() + "',";
		}

		if (obj.get(0).getDate() != null && obj.get(0).getDate() != "") {
			String date = null;
			date = DateFormatter.getStringDate(obj.get(0).getDate());
			s = s + "@p_date='" + date + "',";
		}

		if (obj.get(0).getFromTime() != null && obj.get(0).getFromTime() != "") {
			s = s + "@p_fromTime='" + obj.get(0).getFromTime() + "',";
		}

		if (obj.get(0).getToTime() != null && obj.get(0).getToTime() != "") {
			s = s + "@p_toTime='" + obj.get(0).getToTime() + "',";
		}

		if (obj.get(0).getSection() != null && obj.get(0).getSection() != "") {
			s = s + "@p_section='" + obj.get(0).getSection() + "',";
		}

		if (obj.get(0).getSectionHead() != null && obj.get(0).getSectionHead() != "") {
			s = s + "@p_sectionHead='" + obj.get(0).getSectionHead() + "',";
		}
		if (obj.get(0).getCreatedBy() != null && obj.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + obj.get(0).getCreatedBy() + "',";
		}
		if (obj.get(0).getMeetingType() != null && obj.get(0).getMeetingType() != "") {
			s = s + "@p_meetingType='" + obj.get(0).getMeetingType() + "',";
		}
		if (obj.get(0).getAuditType() != null && obj.get(0).getAuditType() != "") {
			s = s + "@p_auditType='" + obj.get(0).getAuditType() + "',";
		}
		if (obj.get(0).getComments() != null && obj.get(0).getComments() != "") {
			s = s + "@p_comment='" + obj.get(0).getComments() + "',";
		}

		s = s + "@p_peopleEmail=\"(" + aspemail + ")\",";

		for (RestAuditMeetingModel a : obj) {
			if (a.getDocument() != "" && a.getDocument() != null) {
				for (int i = 0; i < metaCharacters.length; i++) {
					if (a.getDocumentName().contains(metaCharacters[i])) {
						a.setDocumentName(a.getDocumentName().replace(metaCharacters[i], "\\" + metaCharacters[i]));

					}
					if (a.getComment().contains(metaCharacters[i])) {
						a.setComment(a.getComment().replace(metaCharacters[i], "\\" + metaCharacters[i]));

					}
				}

				asp = asp + "(@p_aId,\"" + a.getDocument() + "\",\"" + a.getDocumentName() + "\",\"" + a.getComment()
						+ "\"),";
			}
		}

		String[] arr = null;

		if (obj.get(0).getPersonTo() != null) {
			arr = obj.get(0).getPersonTo().split(",");
		}

		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != "" && arr[i] != null) {
					people = people + "(@p_aId,\"" + obj.get(0).getInitiate() + "\",\"" + arr[i] + "\"),";
				}
			}
		}
		if (asp != "") {
			asp = asp.substring(0, asp.length() - 1);
		}

		if (people != "") {
			people = people.substring(0, people.length() - 1);
		}

		s = s + "@p_reqSubQuery ='" + asp + "',";

		s = s + "@p_people='" + people + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
}
