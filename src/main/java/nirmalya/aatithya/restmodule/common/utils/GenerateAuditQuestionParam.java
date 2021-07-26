package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;

public class GenerateAuditQuestionParam {
	static String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&","%","'"};
	
	public static String getQuestionParam(AuditObservationModel obj) {
	
		String s = "";
		String asp = "";

		String people = "";

		String peopleCC = "";

		String aspemailTO="";
		String aspemailCc="";
		
	
		
		String personcc="";
		String[] str = obj.getPersonCc().split(",");		
		for (int i = 0; i < str.length; i++) {
			if(str[i]!="") {			
			personcc = personcc + "'" + str[i] + "',";
			}
		}
		if(personcc!="") {			
			aspemailCc =personcc.substring(0, personcc.length() - 1);
		}
			String personto = "";
			String[] str1 = obj.getPersonTo().split(",");
			for (int i = 0; i < str1.length; i++) {
			personto = personto + "'" + str1[i] + "',";

			}
			if(personto!="") {			
				aspemailTO =personto.substring(0, personto.length() - 1);
			}
			
			
				String region=obj.getRegion();
				for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(obj.getReqStatus().contains(metaCharacters[i])){
			        	obj.setReqStatus(obj.getReqStatus().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	obj.setQuestion(obj.getQuestion().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(obj.getCoStatus().contains(metaCharacters[i])){
			        	obj.setCoStatus(obj.getCoStatus().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	obj.setQuestion(obj.getQuestion().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
				String Status="1";
				
					s = s + "@p_question='" + obj.getQuestion() + "',";	
					s = s + "@p_obsType='" + obj.getObsType()+ "',";	
					s = s + "@p_severity='" + obj.getSeverity() + "',";	
					s = s + "@p_createdBy='" + obj.getCreatedBy() + "',";	
					s = s + "@p_document='" + obj.getDocument() + "',";	
					s = s + "@p_documentName='" + obj.getCoStatus() + "',";	
					s = s + "@p_documentComment='" + obj.getReqStatus() + "',";	
					s = s + "@p_status='" + Status + "',";	

				
				
				
			
		String notification ="1";	
		String[] arr = null;
		String[] arr1 = null;
		if(obj.getPersonTo()!=null) {
		arr = obj.getPersonTo().split(",");
		}
		if(obj.getPersonCc()!=null) {
		arr1 = obj.getPersonCc().split(",");
		}
		if(arr!=null) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!="") {
			people = people + "(@p_requestId,\"" + obj.getInitiateId() + "\",\"" + arr[i] + "\",\""+notification+"\",\""+obj.getCreatedBy()+"\"),";
		}
		}
		}
		if(arr1!=null) {
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!="") {
				
			peopleCC = peopleCC + "(@p_requestId,\"" + obj.getInitiateId() + "\",\"" + arr1[i] + "\",\""+notification+"\",\""+obj.getCreatedBy()+"\"),";
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
		//s = s + "@p_assignQues='" + asp + "',";
		s = s + "@p_auditId='" + obj.getInitiateId() + "',";
		//s = s + "@p_reqSubQuery='" + asp + "',";

		s = s + "@p_people='" + people + "',";
		
		
		s = s + "@p_peopleCC='" + peopleCC + "'";
		String asp1 = "@p_peopleEmail=\"("+aspemailTO+")\"";
		if (s != "") {
			s = s.substring(0, s.length());

			if(aspemailCc!=null&& aspemailCc!="") {
				s = "SET " + s + "," + asp1 + ",@p_peopleEmailCc=\"("+aspemailCc+")\";";
			}
			
			else {
				s = "SET " + s + "," + asp1 + ";";
			}
		}
	System.out.println(s);
		return s;
	}
	public static String getIRSParam(List<AuditObservationModel> obj) {
		
		String s = "";
		String asp = "";

		String people = "";

		String peopleCC = "";

		String personcc="";
	
		
	
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
		
		String[] str = obj.get(0).getPersonCc().split(",");		
		for (int i = 0; i < str.length; i++) {
			if(str[i]!="") {			
			personcc = personcc + "'" + str[i] + "',";
			}
		}
		if(personcc!="") {			
			aspemailCc =personcc.substring(0, personcc.length() - 1);
		}
			
			for (AuditObservationModel a : obj) {
				
				for (int i = 0 ; i < metaCharacters.length ; i++){
			        if(a.getReqStatus().contains(metaCharacters[i])){
			        	a.setReqStatus(a.getReqStatus().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			        if(a.getCoStatus().contains(metaCharacters[i])){
			        	a.setCoStatus(a.getCoStatus().replace(metaCharacters[i],"\\"+metaCharacters[i]));
			        	
			        }
			    }
				asp = asp + "(@p_requestId,\"" + a.getDocument() + "\",\"" + a.getReqStatus()+ "\",\""+a.getCoStatus()+"\"),";
				
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
			people = people + "(@p_requestId,\"" + obj.get(0).getInitiateId() + "\",\"" + arr[i] + "\",\""+obj.get(0).getCreatedBy()+"\"),";
		}
		}
		}
		if(arr1!=null) {
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!="") {
				
			peopleCC = peopleCC + "(@p_requestId,\"" + obj.get(0).getInitiateId() + "\",\"" + arr1[i] + "\",\""+obj.get(0).getCreatedBy()+"\"),";
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
		String finalObservation="finalObservation";
		s = s + "@p_assignQus='" + asp + "',";
		s = s + "@p_auditId='" + obj.get(0).getInitiateId() + "',";
		s = s + "@p_finalObservation='" + obj.get(0).getFinalObservation() + "',";
		s = s + "@p_riskrating='" + obj.get(0).getSeverity()+ "',";
		s = s + "@p_status='" + finalObservation+ "',";
		s = s + "@p_people='" + people + "',";
		
		
		s = s + "@p_peopleCC='" + peopleCC + "'";
		String asp1 = "@p_peopleEmail=\"("+aspemailTO+")\"";
		if (s != "") {
			s = s.substring(0, s.length());

			if(aspemailCc!=null&& aspemailCc!="") {
				s = "SET " + s + ","+ "@p_peopleEmailCc=\"("+aspemailCc+")\";";
			}
			
			else {
				s = "SET " + s + "," + asp1 +";";
			}
		}
	System.out.println(s);
		return s;
	}
	}
