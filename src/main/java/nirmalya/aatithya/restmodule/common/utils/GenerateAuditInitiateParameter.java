package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.audit.model.InitiateInternalAuditModel;

public class GenerateAuditInitiateParameter {

	public static String initiateAudit(List<AuditInitiateModel> auditInitiate) {
		String s = "";
		String values="";
		if (auditInitiate.get(0).getAuditInitiate() != null && auditInitiate.get(0).getAuditInitiate() != "") {
			s = s + "@p_auditInitiate='" + auditInitiate.get(0).getAuditInitiate() + "',";
		}
		if (auditInitiate.get(0).getAuditType() != null && auditInitiate.get(0).getAuditType() != "") {
			s = s + "@p_auditType='" + auditInitiate.get(0).getAuditType() + "',";
		}
		if (auditInitiate.get(0).getFinancialYear() != null && auditInitiate.get(0).getFinancialYear() != "") {
			s = s + "@p_financialYear='" + auditInitiate.get(0).getFinancialYear() + "',";
		}
		if (auditInitiate.get(0).getInitiatedBy() != null && auditInitiate.get(0).getInitiatedBy() != "") {
			s = s + "@p_initiatedBy='" + auditInitiate.get(0).getInitiatedBy() + "',";
		}
		if (auditInitiate.get(0).getInitiatedDate() != null && auditInitiate.get(0).getInitiatedDate() != "") {
			s = s + "@p_initiatedDate='" + DateFormatter.getStringDate(auditInitiate.get(0).getInitiatedDate()) + "',";
		}
		if (auditInitiate.get(0).getSummary() != null && auditInitiate.get(0).getSummary() != "") {
			s = s + "@p_summary='" + auditInitiate.get(0).getSummary() + "',";
		}
		if (auditInitiate.get(0).getDocument() != null && auditInitiate.get(0).getDocument() != "") {
			s = s + "@p_document='" + auditInitiate.get(0).getDocument() + "',";
		}
		if (auditInitiate.get(0).getCreatedBy() != null && auditInitiate.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + auditInitiate.get(0).getCreatedBy() + "',";
		}
		if (auditInitiate.get(0).getOrganizaionName() != null && auditInitiate.get(0).getOrganizaionName() != "") {
			s = s + "@p_organization='" + auditInitiate.get(0).getOrganizaionName() + "',";
		}
		if (auditInitiate.get(0).getLetterNo() != null && auditInitiate.get(0).getLetterNo() != "") {
			s = s + "@p_letterNo='" + auditInitiate.get(0).getLetterNo() + "',";
		}
		
		
		
	
			
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			
			return s;
			
		}
	public static String initiateInternalAudit(AuditInitiateModel auditInitiate) {
		String s = "";
		
		if (auditInitiate.getAuditInitiate() != null && auditInitiate.getAuditInitiate() != "") {
			s = s + "@p_auditInitiate='" + auditInitiate.getAuditInitiate() + "',";
		}
		if (auditInitiate.getAuditType() != null && auditInitiate.getAuditType() != "") {
			s = s + "@p_auditType='" + auditInitiate.getAuditType() + "',";
		}
		if (auditInitiate.getRegion() != null && auditInitiate.getRegion() != "") {
			s = s + "@p_region='" + auditInitiate.getRegion() + "',";
		}
		if (auditInitiate.getAuditor() != null && auditInitiate.getAuditor() != "") {
			s = s + "@p_auditor='" + auditInitiate.getAuditor() + "',";
		}
		if (auditInitiate.getSummary() != null && auditInitiate.getSummary() != "") {
			s = s + "@p_summary='" + auditInitiate.getSummary() + "',";
		}
		if (auditInitiate.getRegionalManager()!= null && auditInitiate.getRegionalManager() != "") {
			s = s + "@p_regionalManager='" + auditInitiate.getRegionalManager() + "',";
		}
		if (auditInitiate.getConcernedFinance()!= null && auditInitiate.getConcernedFinance() != "") {
			s = s + "@p_concernedFinance='" + auditInitiate.getConcernedFinance() + "',";
		}
		if (auditInitiate.getFinancialYear() != null && auditInitiate.getFinancialYear() != "") {
			s = s + "@p_financialYear='" + auditInitiate.getFinancialYear() + "',";
		}
		if (auditInitiate.getQuarter() != null && auditInitiate.getQuarter() != "") {
			s = s + "@p_quarter='" + auditInitiate.getQuarter() + "',";
		}
		if (auditInitiate.getInitiatedDate() != null && auditInitiate.getInitiatedDate() != "") {
			s = s + "@p_initiatedDate='" + DateFormatter.getStringDate(auditInitiate.getInitiatedDate()) + "',";
		}
		
		if (auditInitiate.getDocument() != null && auditInitiate.getDocument() != "") {
			s = s + "@p_document='" + auditInitiate.getDocument() + "',";
		}
		if (auditInitiate.getCreatedBy() != null && auditInitiate.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + auditInitiate.getCreatedBy() + "',";
		}
		
		
		
	
			
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			
			return s;
			
		}


}