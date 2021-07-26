package nirmalya.aatithya.restmodule.audit.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

public class DraftModel {
	private List<DropDownModel> documents = new ArrayList<DropDownModel>();
	private List<DropDownModel> personTo = new ArrayList<DropDownModel>();
	private List<DropDownModel> personCc = new ArrayList<DropDownModel>();
	
	@SuppressWarnings("unchecked")
	public DraftModel(Object documents, Object personTo, Object personCc) {
		super();
		
			this.documents =  (List<DropDownModel>)documents;
			this.personTo =  (List<DropDownModel>)personTo;
			this.personCc =  (List<DropDownModel>)personCc;
		
	}
	public DraftModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<DropDownModel> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DropDownModel> documents) {
		this.documents = documents;
	}
	public List<DropDownModel> getPersonTo() {
		return personTo;
	}
	public void setPersonTo(List<DropDownModel> personTo) {
		this.personTo = personTo;
	}
	public List<DropDownModel> getPersonCc() {
		return personCc;
	}
	public void setPersonCc(List<DropDownModel> personCc) {
		this.personCc = personCc;
	}
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}

