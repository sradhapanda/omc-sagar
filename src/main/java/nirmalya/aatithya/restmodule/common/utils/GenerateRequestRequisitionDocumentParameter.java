package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;

public class GenerateRequestRequisitionDocumentParameter {
	static String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&","%","'"};
	
	public static String addDocument(List<RequisitionViewModel> obj) {
		
		String s = "";
		String asp = "";

		String people = "";

		String peopleCC = "";

		String initiate = "";
		String aspemailCc="";
		String aspemailTO="";
		String prevauditid="";

		
		if (obj.get(0).getRoleName() != null && obj.get(0).getRoleName() != "") {
			initiate = obj.get(0).getRoleName();
		}
		
		String notification ="1";	
		String personto = "";
		String revertMailTO="";
		String[] str1 = obj.get(0).getPersonTo().split(",");
		for (int i = 0; i < str1.length; i++) {
		personto = personto + "'" + str1[i] + "',";

		}
		if(personto!="") {			
			aspemailTO =personto.substring(0, personto.length() - 1);
			revertMailTO =personto.substring(0, personto.length() - 1);
		}
		
		String personcc="";
		String[] str = obj.get(0).getPersonCc().split(",");		
		for (int i = 0; i < str.length; i++) {
			if(str[i]!="") {			
			personcc = personcc + "'" + str[i] + "',";
			}
		}
		if(personcc!="") {			
			aspemailCc =personcc.substring(0, personcc.length() - 1);
		}
			String asp1 = "@p_id='" + obj.get(0).getAuditId() + "',@p_reqId='" + obj.get(0).getReqId() + "',@p_createdBy='" + obj.get(0).getCreatedby() + "',@p_prevauditid='" + obj.get(0).getPrevauditid() + "',@p_subject='" + obj.get(0).getSubject()
				+ "',@p_priority='" + obj.get(0).getPriority() + "',@p_document='" + obj.get(0).getDocument() + "',@p_comment='" + obj.get(0).getComment()
				+ "',@p_initiate='" + initiate + "',@p_peopleEmail=\"("+aspemailTO+")\",@p_revertRecipient=\"("+revertMailTO+")\",@p_identifier='"+obj.get(0).getIdentifier()+"',@p_hiddenId='"+obj.get(0).getDraftHiddenId()+"'";

		for (RequisitionViewModel a : obj) {
			if(a.getDocument()!=null && a.getDocument() !="") {
					for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(a.getDocumentName().contains(metaCharacters[i])){
			        	a.setDocumentName(a.getDocumentName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(a.getDocumentComment().contains(metaCharacters[i])){
			        	a.setDocumentComment(a.getDocumentComment().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
				
				
			asp = asp + "(@p_requestId,\"" + a.getDocument() + "\",\"" + a.getDocumentName() + "\",\""+a.getDocumentComment()+"\"),";
		}
	}
		String[] arr = null;
		String[] arr1 = null;
		if(obj.get(0).getPersonTo()!=null) {
		arr = obj.get(0).getPersonTo().split(",");
		}
		if(obj.get(0).getPersonCc()!=null) {
		arr1 = obj.get(0).getPersonCc().split(",");
		}
		
		if(arr!=null) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!="") {
			people = people + "(@p_requestId,\"" + obj.get(0).getAuditId() + "\",\"" + arr[i] + "\",\""+notification+"\",\""+obj.get(0).getCreatedby()+"\",\""+ obj.get(0).getAuditType()+ "\",\"" + obj.get(0).getInitiatedId() +"\"),";
		}
		}
		}
		if(arr1!=null) {
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!="") {
				
			peopleCC = peopleCC + "(@p_requestId,\"" + obj.get(0).getAuditId() + "\",\"" + arr1[i] + "\",\""+notification+"\",\""+obj.get(0).getCreatedby()+"\",\""+ obj.get(0).getAuditType()+ "\",\"" + obj.get(0).getInitiatedId() +"\"),";
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

		s = s + "@p_reqSubQuery='" + asp + "',";

		s = s + "@p_people='" + people + "',";
		
		
		
		s = s + "@p_peopleCC='" + peopleCC + "'";

		if (s != "") {
			s = s.substring(0, s.length());
			
		if(aspemailCc!=null&& aspemailCc!="") {
			s = "SET " + s + "," + asp1 + ",@p_peopleEmailCc=\"("+aspemailCc+")\";";
		}
		
		else {
			s = "SET " + s + "," + asp1 + ";";
		}
	}
		return s;

	}
	
	public static String addForwardReq(List<RequisitionViewModel> obj) {
			
		String s = "";
		String asp = "";
		String asp2 = "";

		String people = "";

		String peopleCC = "";

		String initiate = "";
		
		
		
		
		if (obj.get(0).getRoleName() != null && obj.get(0).getRoleName() != "") {
			initiate = obj.get(0).getRoleName();
		}
		String aspemailCc="";
		String aspemailTO="";
		String personto = "";
		String[] str1 = obj.get(0).getPersonTo().split(",");
		for (int i = 0; i < str1.length; i++) {
		personto = personto + "'" + str1[i] + "',";

		}
		if(personto!="") {			
			aspemailTO =personto.substring(0, personto.length() - 1);
		}
		
		String personcc="";
		String[] str = obj.get(0).getPersonCc().split(",");		
		for (int i = 0; i < str.length; i++) {
			if(str[i]!="") {			
			personcc = personcc + "'" + str[i] + "',";
			}
		}
		if(personcc!="") {			
			aspemailCc =personcc.substring(0, personcc.length() - 1);
		}
		
		
		String asp1 = "@p_id='" + obj.get(0).getAuditId() + "',@p_createdBy='" + obj.get(0).getCreatedby()
				+ "',@p_document='" + obj.get(0).getDocument() + "',@p_comment='" + obj.get(0).getComment()
				+ "',@p_initiate='" + initiate + "',@p_peopleEmail=\"("+aspemailTO+")\"";

		for (RequisitionViewModel a : obj) {
			if(a.getDocument()!="" && a.getDocument()!=null) {
				for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(a.getDocumentName().contains(metaCharacters[i])){
			        	a.setDocumentName(a.getDocumentName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(a.getDocumentComment().contains(metaCharacters[i])){
			        	a.setDocumentComment(a.getDocumentComment().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
			asp = asp + "(@p_requestId,\"" + a.getDocument() + "\",\"" + a.getDocumentName() + "\",\""+a.getDocumentComment()+"\"),";
			asp2 = asp2 + "(@p_noteId,\"" + a.getDocument() + "\",\"" + a.getDocumentName() + "\",\""+a.getDocumentComment()+"\"),";
			}
		}
		String notification ="1";	
		String[] arr = null;
		String[] arr1 = null;
		if(obj.get(0).getPersonTo()!=null) {
		arr = obj.get(0).getPersonTo().split(",");
		}
		if(obj.get(0).getPersonCc()!=null) {
		arr1 = obj.get(0).getPersonCc().split(",");
		}
		if(arr!=null) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=""&& arr[i]!=null) {
			people = people + "(@p_noteId,\""+initiate+"\",\"" + arr[i] + "\",\""+notification+"\",\""+obj.get(0).getCreatedby()+"\"),";
		}
		}
		}
		if(arr1!=null) {
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!=""&& arr1[i]!=null) {
			peopleCC = peopleCC + "(@p_noteId,\""+initiate+"\",\"" + arr1[i] + "\",\""+notification+"\",\""+obj.get(0).getCreatedby()+"\"),";
		}
		}
		}
		if (asp != "") {
			asp = asp.substring(0, asp.length() - 1);
		}
		if (asp2 != "") {
			asp2 = asp2.substring(0, asp2.length() - 1);
		}

		if (people != "") {
			people = people.substring(0, people.length() - 1);
		}

		if (peopleCC != "") {
			peopleCC = peopleCC.substring(0, peopleCC.length() - 1);
		}

		s = s + "@p_reqSubQuery='" + asp + "',";
		s = s + "@p_noteSubQuery='" + asp2 + "',";

		s = s + "@p_people='" + people + "',";

		s = s + "@p_peopleCC='" + peopleCC + "'";

		if (s != "") {
			s = s.substring(0, s.length());

			if(aspemailCc!=null&& aspemailCc!="") {
				s = "SET " + s + "," + asp1 + ",@p_peopleEmailCc=\"("+aspemailCc+")\";";
			}
			
			else {
				s = "SET " + s + "," + asp1 + ";";
			}
		}

		return s;

	}
	public static String addForwardObservation(List<RequisitionViewModel> obj) {
		String s = "";
		String asp = "";

		String people = "";

		String peopleCC = "";

		String initiate = "";

		if (obj.get(0).getRoleName() != null && obj.get(0).getRoleName() != "") {
			initiate = obj.get(0).getRoleName();
		}
		String aspemailCc="";
		String aspemailTO="";
		String personto = "";
		String[] str1 = obj.get(0).getPersonTo().split(",");
		for (int i = 0; i < str1.length; i++) {
		personto = personto + "'" + str1[i] + "',";

		}
		if(personto!="") {			
			aspemailTO =personto.substring(0, personto.length() - 1);
		}
		
		String personcc="";
		String[] str = obj.get(0).getPersonCc().split(",");		
		for (int i = 0; i < str.length; i++) {
			if(str[i]!="") {			
			personcc = personcc + "'" + str[i] + "',";
			}
		}
		if(personcc!="") {			
			aspemailCc =personcc.substring(0, personcc.length() - 1);
		}
		
		
		String asp1 = "@p_id='" + obj.get(0).getAuditId() + "',@p_createdBy='" + obj.get(0).getCreatedby()
				+ "',@p_document='" + obj.get(0).getDocument() + "',@p_comment='" + obj.get(0).getComment()
				+ "',@p_initiate='" + initiate + "',@p_peopleEmail=\"("+aspemailTO+")\"";

		for (RequisitionViewModel a : obj) {
			if(a.getDocument()!=null && a.getDocument()!="") {
				for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(a.getDocumentName().contains(metaCharacters[i])){
			        	a.setDocumentName(a.getDocumentName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(a.getDocumentComment().contains(metaCharacters[i])){
			        	a.setDocumentComment(a.getDocumentComment().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
				
			asp = asp + " (@p_commentId,\"" + a.getAuditId() + "\",\"" + a.getDocument() + "\",\"" + a.getDocumentName()
			+ "\",\""+a.getDocumentComment()+"\"),";
			}
		}
		String[] arr = null;
		String[] arr1 = null;
		if(obj.get(0).getPersonTo()!=null && obj.get(0).getPersonTo()!="") {
		arr = obj.get(0).getPersonTo().split(",");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=null && arr[i]!="") {
			people = people + "(@p_commentId,\"" + obj.get(0).getAuditId() + "\",\"" + arr[i] + "\"),";
				}
			}
		}
		if(obj.get(0).getPersonCc()!=null && obj.get(0).getPersonCc()!="") {
		arr1 = obj.get(0).getPersonCc().split(",");
		
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!=null && arr1[i]!="") {
			peopleCC = peopleCC + "(@p_commentId,\"" + obj.get(0).getAuditId() + "\",\"" + arr1[i] + "\"),";
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

		s = s + "@p_reqSubQuery='" + asp + "',";

		s = s + "@p_people='" + people + "',";

		s = s + "@p_peopleCC='" + peopleCC + "'";

		if (s != "") {
			s = s.substring(0, s.length());

			if(aspemailCc!=null&& aspemailCc!="") {
				s = "SET " + s + "," + asp1 + ",@p_peopleEmailCc=\"("+aspemailCc+")\";";
			}
			
			else {
				s = "SET " + s + "," + asp1 + ";";
			}
		}

		return s;

	}
	public static String addCompliance(List<RequisitionViewModel> obj) {
		
		String s = "";
		String asp = "";

		String people = "";

		String peopleCC = "";

		String initiate = "";
		String aspemailCc="";
		String aspemailTO="";
		String personto = "";
		String[] str1 = obj.get(0).getPersonTo().split(",");
		for (int i = 0; i < str1.length; i++) {
		personto = personto + "'" + str1[i] + "',";

		}
		if(personto!="") {			
			aspemailTO =personto.substring(0, personto.length() - 1);
		}
		
		String personcc="";
		String[] str = obj.get(0).getPersonCc().split(",");		
		for (int i = 0; i < str.length; i++) {
			if(str[i]!="") {			
			personcc = personcc + "'" + str[i] + "',";
			}
		}
		if(personcc!="") {			
			aspemailCc =personcc.substring(0, personcc.length() - 1);
		}
		if (obj.get(0).getRoleName() != null && obj.get(0).getRoleName() != "") {
			initiate = obj.get(0).getRoleName();
		}

		String asp1 = "@p_id='" + obj.get(0).getAuditId() + "',@p_quesId='" + obj.get(0).getReqId() + "',@p_createdBy='" + obj.get(0).getCreatedby()
				+ "',@p_document='" + obj.get(0).getDocument() + "',@p_comment='" + obj.get(0).getComment()
				+ "',@p_initiate='" + initiate + "',@p_peopleEmail=\"("+aspemailTO+")\"";

		for (RequisitionViewModel a : obj) {
					for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(a.getDocumentName().contains(metaCharacters[i])){
			        	a.setDocumentName(a.getDocumentName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(a.getDocumentComment().contains(metaCharacters[i])){
			        	a.setDocumentComment(a.getDocumentComment().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
			asp = asp + " (@p_commentId,\"" + a.getDocument() + "\",\"" + a.getDocumentName()
			+ "\",\""+a.getDocumentComment()+"\"),";
		
		}
		String[] arr = null;
		String[] arr1 = null;
		if(obj.get(0).getPersonTo()!=null && obj.get(0).getPersonTo()!="") {
		arr = obj.get(0).getPersonTo().split(",");
		}
		if(obj.get(0).getPersonCc()!=null && obj.get(0).getPersonCc()!="") {
		arr1 = obj.get(0).getPersonCc().split(",");
		}
		if(arr!=null) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=null && arr[i]!="") {
			people = people + "(@p_commentId,\"" + obj.get(0).getAuditId() + "\",\"" + arr[i] + "\"),";
		}
		}
		}
		if(arr1!=null) {
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!=null && arr1[i]!="") {
			peopleCC = peopleCC + "(@p_commentId,\"" + obj.get(0).getAuditId() + "\",\"" + arr1[i] + "\"),";
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

		s = s + "@p_reqSubQuery='" + asp + "',";

		s = s + "@p_people='" + people + "',";

		s = s + "@p_peopleCC='" + peopleCC + "'";

		if (s != "") {
			s = s.substring(0, s.length());

			if(aspemailCc!=null&& aspemailCc!="") {
				s = "SET " + s + "," + asp1 + ",@p_peopleEmailCc=\"("+aspemailCc+")\";";
			}
			
			else {
				s = "SET " + s + "," + asp1 + ";";
			}
		}
System.out.println("compliance" + s);
		return s;

	}
	public static String addDocumentUpload(List<RequisitionViewModel> obj) {
		
		String s = "";
		String asp = "";
		String initiate = "";

		

		String asp1 = "@p_auditType='" + obj.get(0).getRoleName() + "',@p_createdBy='" + obj.get(0).getCreatedby()
				+ "',@p_financialYear='" + obj.get(0).getPersonTo() + "',@p_quarter='" + obj.get(0).getPersonCc()
				+ "',@p_folder='" + obj.get(0).getFolder()+ "'";

		for (RequisitionViewModel a : obj) {
			if(a.getDocument()!=null && a.getDocument() !="") {
				for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(a.getDocumentName().contains(metaCharacters[i])){
			        	a.setDocumentName(a.getDocumentName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(a.getDocumentComment().contains(metaCharacters[i])){
			        	a.setDocumentComment(a.getDocumentComment().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
			asp = asp + "(@p_requestId,\"" + a.getDocument() + "\",\"" + a.getDocumentName() + "\",\""+a.getDocumentComment()+"\"),";
		}
	}
		
		
		if (asp != "") {
			asp = asp.substring(0, asp.length() - 1);
		}
		s = s + "@p_reqSubQuery='" + asp + "'";

		if (s != "") {
			s = s.substring(0, s.length());

			s = "SET " + s + "," + asp1 + ";";
		}
		return s;

	}
	
	/*
	 * draft Section by Deepak
	 */
public static String addDraft(List<RequisitionViewModel> obj) {
		
		String s = "";
		String asp = "";

		String people = "";

		String peopleCC = "";
		
		String status = "0";
		
		if(obj.get(0).getDraftStatus() != null && obj.get(0).getDraftStatus() != "") {
			status = obj.get(0).getDraftStatus();
		}
		
		String ab = "";
		
		if(obj.get(0).getSection() != null && obj.get(0).getSection() != "") {
			ab = ",@p_section='"+obj.get(0).getSection()+"'";
		}
		if(obj.get(0).getPriority() != null && obj.get(0).getPriority() != "") {
			ab = ab+",@p_priority='"+obj.get(0).getPriority()+"'";
		}

		String asp1 = "@p_id='" + obj.get(0).getAuditTrialId() + "',@p_subject='"+ obj.get(0).getSubject()+"',@p_comment='" + obj.get(0).getComment()+"',"
				+ "@p_createdBy='" + obj.get(0).getCreatedby() + "',@p_hiddenId='"+obj.get(0).getDraftHiddenId()+"',@p_status='"+status+"'"+ab;
		

		for (RequisitionViewModel a : obj) {
			if(a.getDocument()!=null && a.getDocument() !="") {
					for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(a.getDocumentName().contains(metaCharacters[i])){
			        	a.setDocumentName(a.getDocumentName().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(a.getDocumentComment().contains(metaCharacters[i])){
			        	a.setDocumentComment(a.getDocumentComment().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
				
				
			asp = asp + "(@p_requestId,\"" + a.getDocument() + "\",\"" + a.getDocumentName() + "\",\""+a.getDocumentComment()+"\",\"" + obj.get(0).getCreatedby() + "\",\"" + obj.get(0).getAuditTrialId() + "\"),";
		}
	}
		String[] arr = null;
		String[] arr1 = null;
		if(obj.get(0).getPersonTo()!=null) {
		arr = obj.get(0).getPersonTo().split(",");
		}
		if(obj.get(0).getPersonCc()!=null) {
		arr1 = obj.get(0).getPersonCc().split(",");
		}
		
		if(arr!=null) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!="") {
			people = people + "(@p_requestId,\"" + arr[i] + "\",\""+obj.get(0).getCreatedby()+"\",\"" + obj.get(0).getAuditTrialId() + "\"),";
		}
		}
		}
		if(arr1!=null) {
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!="") {
				
			peopleCC = peopleCC + "(@p_requestId,\"" + arr1[i] + "\",\""+obj.get(0).getCreatedby()+"\",\"" + obj.get(0).getAuditTrialId() + "\"),";
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

		s = s + "@p_reqSubQuery='" + asp + "',";

		s = s + "@p_people='" + people + "',";
		
		
		
		s = s + "@p_peopleCC='" + peopleCC + "'";

		if (s != "") {
			s = s.substring(0, s.length());
			
		
			s = "SET " + s + "," + asp1 + ";";
		
	}
		return s;

	}
}
