package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditDraftReportModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditReportUpdateDateModel;

public class GenerateAuditDraftDetailsParameter {

	public static String addDocument(List<RestAuditDraftReportModel> obj) {

		String s = "";
		String asp = "";


		String asp1 = "@p_id='" + obj.get(0).getDraftId() + "',@p_document='" + obj.get(0).getAttachDocument()
				+ "',@p_comment='" + obj.get(0).getComment() + "',@p_auditType='" + obj.get(0).getAuditType()
				+ "',@p_audit='" + obj.get(0).getDraftId() + "',@p_initId='"+obj.get(0).getInitiateId()+"',@p_createdBy='"+obj.get(0).getCreatedBy()+"'";
		
		for (RestAuditDraftReportModel a : obj) {
			if( a.getAttachDocument()!=null &&  a.getAttachDocument()!="") {
			asp = asp + " (@id,@p_id,\"" + a.getAttachDocument()+ "\",\"" + a.getAttachfileName()+ "\",\""+a.getAttachComment()+"\"),";
		}
		}
		if (asp != "") {
			asp = asp.substring(0, asp.length() - 1);
		}

		s = s + "@p_reqSubQuery ='" + asp + "'";

		if (s != "") {
			s = s.substring(0, s.length());

			s = "SET " + s + "," + asp1 + ";";
		}

		return s;

	}
public static String getUpdateDateParams(List<RestAuditReportUpdateDateModel> data) {
		
		String s = "";
		String query = "";
		for(RestAuditReportUpdateDateModel m : data) {
			query += "(\""+m.getDraftRepId()+"\",\""+m.getDesc()+"\",\""+m.getDate()+"\",\""+m.getDocName()+"\",\""+m.getFileName()+"\",\""+m.getComment()+"\",\""+m.getCreatedBy()+"\"),";
		}
		
		if (query != "") {
			query = query.substring(0, query.length() - 1);
		}

		s = s + "@p_SubQuery ='" + query + "'";
		if(data.get(0).getIsEdit()!=null) {
			if (s != "") {
				s = s.substring(0, s.length());

				s = "SET @p_repID='" +data.get(0).getDraftRepId()+"',"+ s + ";";
			}

			return s;
		}else {
			if (s != "") {
				s = s.substring(0, s.length());

				s = "SET " + s + ";";
			}

			return s;
		}
		
	}
}
