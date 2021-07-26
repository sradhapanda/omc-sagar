package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.audit.model.AuditComplianceModel;

public class GenerateAuditorParameter {

	public static String addAuditorComment(AuditComplianceModel index) {
		String s = "";
		if(index.getQuesId()!=null) {
			s = s + "@p_quesId=" + index.getQuesId() + ",";
		}
		if(index.getAuditId()!=null) {
			s = s + "@p_auditId=" + index.getAuditId() + ",";
		}
		if(index.getComment()!=null && index.getComment()!="") {
			s = s + "@p_comment='" + index.getComment() + "',";
		}
		if(index.getDocument()!=null && index.getDocument()!="") {
			s = s + "@p_document='" + index.getDocument() + "',";
		}
		if(index.getCreatedBy()!=null && index.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + index.getCreatedBy() + "',";
		}
		if(index.getAuditStatus()!=null) {
			s = s + "@p_auditStatus=" + index.getAuditStatus() + ",";
		}
		if(index.getObsType()!=null) {
			s = s + "@p_obsType=" + index.getObsType() + ",";
		}
		if(index.getAgreedAct()!=null && index.getAgreedAct()!="") {
			s = s + "@p_agreedAct='" + index.getAgreedAct() + "',";
		}
		if(index.getSeverity()!=null) {
			s = s + "@p_severity=" + index.getSeverity() + ",";
		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			s = "SET " + s + ";" ;
		}
		
		
		return s;
	}
	public static String addObsComment(AuditComplianceModel index) {
		String s = "";
	
		if(index.getQuesId()!=null) {
		s = s + "@p_quesId=" + index.getQuesId() + ",";
		}
		if(index.getComment()!=null && index.getComment()!="") {
		s = s + "@p_comment='" + index.getComment() + "',";
		}
		if(index.getCreatedBy()!=null && index.getCreatedBy()!="") {
		s = s + "@p_createdBy='" + index.getCreatedBy() + "',";
		}
		if(index.getAuditStatus()!=null) {
		s = s + "@p_auditStatus=" + index.getAuditStatus() + ",";
		}
		if(s != "") {
		s = s.substring(0, s.length()-1);
		s = "SET " + s + ";" ;
		}


		return s;
		}

}
