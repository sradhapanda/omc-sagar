package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestMailModel {
private Boolean mailStatus;

public RestMailModel(Boolean mailStatus) {
	
	this.mailStatus =(Boolean)mailStatus;
}

public Boolean getMailStatus() {
	return mailStatus;
}

public void setMailStatus(Boolean mailStatus) {
	this.mailStatus = mailStatus;
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
