package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeModel {
	private String employeeNo;
	private String employeeFname;
	private String employeeMname;
	private String employeeLname;
	private String employeeNationality;
	private String employeeDob;
	private String employeeImage;
	private String employeeGender;
	private String employeeMarital;
	private String employeeEsicNo;
	private String employeePassword;
	private String employeeAdhar;
	private String employeeOtherId;
	private String employeeDl;
	private String employeeEmployment;
	private String employeeJobTitle;
	private String employeePayGrade;
	private String employeeWorkStationId;
	private String employeeAddress;
	private String employeeCity;
	private String employeeCountry;
	private String employeePin;
	private String employeeHomePhoneNo;
	private String employeeMobilePhoneNo;
	private String employeeWorkPhoneNo;
	private String employeeWorkEmail;
	private String employeePersonalEmail;
	private String employeeJoinDate;
	private String employeeConfirmDate;
	private String employeeTerminateDate;
	private String employeeDepartment;
	private String employeeSupervisor;
	private String employeeIndSupervisor;
	private String employeeFirstApp;
	private String employeeSecApp;
	private String employeeThirdApp;
	private String employeeNotes;
	private String createdBy;
	private String companyId;
	private String employeepPin;
	private Boolean status;
	private String empDesignation;
	private String empDesignationName;
	private String employeeState;
	private String employeeCountyName;
	private String employeeStateName;
	private String employeeGenderName;
	private String employeePaygradeName;
	private String employeeMaritalName;
	private String employeeRegion;
	public HrmsEmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrmsEmployeeModel(Object employeeNo, Object employeeFname, Object employeeMname, Object employeeLname,
			Object employeeNationality, Object employeeDob, Object employeeImage, Object employeeGender,
			Object employeeMarital, Object employeeEsicNo, Object employeePassword, Object employeeAdhar,
			Object employeeOtherId, Object employeeDl, Object employeeEmployment, Object employeeJobTitle,
			Object employeePayGrade, Object employeeWorkStationId, Object employeeAddress, Object employeeCity,
			Object employeeCountry, Object employeePin, Object employeeHomePhoneNo, Object employeeMobilePhoneNo,
			Object employeeWorkPhoneNo, Object employeeWorkEmail, Object employeePersonalEmail, Object employeeJoinDate,
			Object employeeConfirmDate, Object employeeTerminateDate, Object employeeDepartment,
			Object employeeSupervisor, Object employeeIndSupervisor, Object employeeFirstApp, Object employeeSecApp,
			Object employeeThirdApp, Object employeeNotes, Object createdBy,  Object employeepPin,
			Object status, Object empDesignation, Object empDesignationName, Object employeeState,
			Object employeeCountyName, Object employeeStateName, Object employeeGenderName, Object employeePaygradeName,
			Object employeeMaritalName,Object employeeRegion)

	 {
		super();
		this.employeeNo = (String) employeeNo;
		this.employeeFname = (String) employeeFname;
		this.employeeMname = (String) employeeMname;
		this.employeeLname = (String) employeeLname;
		this.employeeNationality = (String) employeeNationality;
		this.employeeDob = (String) employeeDob;
		this.employeeImage = (String) employeeImage;
		this.employeeGender = (String) employeeGender;
		this.employeeMarital = (String) employeeMarital;
		this.employeeEsicNo = (String) employeeEsicNo;
		this.employeePassword = (String) employeePassword;
		this.employeeAdhar = (String) employeeAdhar;
		this.employeeOtherId = (String) employeeOtherId;
		this.employeeDl = (String) employeeDl;
		this.employeeEmployment = (String) employeeEmployment;
		this.employeeJobTitle = (String) employeeJobTitle;
		this.employeePayGrade = (String) employeePayGrade;
		this.employeeWorkStationId = (String) employeeWorkStationId;
		this.employeeAddress = (String) employeeAddress;
		this.employeeCity = (String) employeeCity;
		this.employeeCountry = (String) employeeCountry;
		this.employeePin = (String) employeePin;
		this.employeeHomePhoneNo = (String) employeeHomePhoneNo;
		this.employeeMobilePhoneNo = (String) employeeMobilePhoneNo;
		this.employeeWorkPhoneNo = (String) employeeWorkPhoneNo;
		this.employeeWorkEmail =(String) employeeWorkEmail;
		this.employeePersonalEmail = (String)(String) employeePersonalEmail;
		this.employeeJoinDate = (String)employeeJoinDate;
		this.employeeConfirmDate = (String)employeeConfirmDate;
		this.employeeTerminateDate =(String) employeeTerminateDate;
		this.employeeDepartment = (String)employeeDepartment;
		this.employeeSupervisor =(String) employeeSupervisor;
		this.employeeIndSupervisor = (String)employeeIndSupervisor;
		this.employeeFirstApp = (String)employeeFirstApp;
		this.employeeSecApp =(String) employeeSecApp;
		this.employeeThirdApp =(String) employeeThirdApp;
		this.employeeNotes = (String)employeeNotes;
		this.createdBy = (String)createdBy;
		
		this.employeepPin =(String) employeepPin;
		this.status = (Boolean) status;
		this.empDesignation = (String)empDesignation;
		this.empDesignationName = (String)empDesignationName;
		this.employeeState =(String) employeeState;
		this.employeeCountyName = (String)employeeCountyName;
		this.employeeStateName = (String)employeeStateName;
		this.employeeGenderName = (String)employeeGenderName;
		this.employeePaygradeName = (String)employeePaygradeName;
		this.employeeMaritalName =(String) employeeMaritalName;
		this.employeeRegion =(String) employeeRegion;
	}

	public String getEmployeeRegion() {
		return employeeRegion;
	}
	public void setEmployeeRegion(String employeeRegion) {
		this.employeeRegion = employeeRegion;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeFname() {
		return employeeFname;
	}

	public void setEmployeeFname(String employeeFname) {
		this.employeeFname = employeeFname;
	}

	public String getEmployeeMname() {
		return employeeMname;
	}

	public void setEmployeeMname(String employeeMname) {
		this.employeeMname = employeeMname;
	}

	public String getEmployeeLname() {
		return employeeLname;
	}

	public void setEmployeeLname(String employeeLname) {
		this.employeeLname = employeeLname;
	}

	public String getEmployeeNationality() {
		return employeeNationality;
	}

	public void setEmployeeNationality(String employeeNationality) {
		this.employeeNationality = employeeNationality;
	}

	public String getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(String employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeMarital() {
		return employeeMarital;
	}

	public void setEmployeeMarital(String employeeMarital) {
		this.employeeMarital = employeeMarital;
	}

	public String getEmployeeEsicNo() {
		return employeeEsicNo;
	}

	public void setEmployeeEsicNo(String employeeEsicNo) {
		this.employeeEsicNo = employeeEsicNo;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeAdhar() {
		return employeeAdhar;
	}

	public void setEmployeeAdhar(String employeeAdhar) {
		this.employeeAdhar = employeeAdhar;
	}

	public String getEmployeeOtherId() {
		return employeeOtherId;
	}

	public void setEmployeeOtherId(String employeeOtherId) {
		this.employeeOtherId = employeeOtherId;
	}

	public String getEmployeeDl() {
		return employeeDl;
	}

	public void setEmployeeDl(String employeeDl) {
		this.employeeDl = employeeDl;
	}

	public String getEmployeeEmployment() {
		return employeeEmployment;
	}

	public void setEmployeeEmployment(String employeeEmployment) {
		this.employeeEmployment = employeeEmployment;
	}

	public String getEmployeeJobTitle() {
		return employeeJobTitle;
	}

	public void setEmployeeJobTitle(String employeeJobTitle) {
		this.employeeJobTitle = employeeJobTitle;
	}

	public String getEmployeePayGrade() {
		return employeePayGrade;
	}

	public void setEmployeePayGrade(String employeePayGrade) {
		this.employeePayGrade = employeePayGrade;
	}

	public String getEmployeeWorkStationId() {
		return employeeWorkStationId;
	}

	public void setEmployeeWorkStationId(String employeeWorkStationId) {
		this.employeeWorkStationId = employeeWorkStationId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public String getEmployeeCountry() {
		return employeeCountry;
	}

	public void setEmployeeCountry(String employeeCountry) {
		this.employeeCountry = employeeCountry;
	}

	public String getEmployeePin() {
		return employeePin;
	}

	public void setEmployeePin(String employeePin) {
		this.employeePin = employeePin;
	}

	public String getEmployeeHomePhoneNo() {
		return employeeHomePhoneNo;
	}

	public void setEmployeeHomePhoneNo(String employeeHomePhoneNo) {
		this.employeeHomePhoneNo = employeeHomePhoneNo;
	}

	public String getEmployeeMobilePhoneNo() {
		return employeeMobilePhoneNo;
	}

	public void setEmployeeMobilePhoneNo(String employeeMobilePhoneNo) {
		this.employeeMobilePhoneNo = employeeMobilePhoneNo;
	}

	public String getEmployeeWorkPhoneNo() {
		return employeeWorkPhoneNo;
	}

	public void setEmployeeWorkPhoneNo(String employeeWorkPhoneNo) {
		this.employeeWorkPhoneNo = employeeWorkPhoneNo;
	}

	public String getEmployeeWorkEmail() {
		return employeeWorkEmail;
	}

	public void setEmployeeWorkEmail(String employeeWorkEmail) {
		this.employeeWorkEmail = employeeWorkEmail;
	}

	public String getEmployeePersonalEmail() {
		return employeePersonalEmail;
	}

	public void setEmployeePersonalEmail(String employeePersonalEmail) {
		this.employeePersonalEmail = employeePersonalEmail;
	}

	public String getEmployeeJoinDate() {
		return employeeJoinDate;
	}

	public void setEmployeeJoinDate(String employeeJoinDate) {
		this.employeeJoinDate = employeeJoinDate;
	}

	public String getEmployeeConfirmDate() {
		return employeeConfirmDate;
	}

	public void setEmployeeConfirmDate(String employeeConfirmDate) {
		this.employeeConfirmDate = employeeConfirmDate;
	}

	public String getEmployeeTerminateDate() {
		return employeeTerminateDate;
	}

	public void setEmployeeTerminateDate(String employeeTerminateDate) {
		this.employeeTerminateDate = employeeTerminateDate;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeSupervisor() {
		return employeeSupervisor;
	}

	public void setEmployeeSupervisor(String employeeSupervisor) {
		this.employeeSupervisor = employeeSupervisor;
	}

	public String getEmployeeIndSupervisor() {
		return employeeIndSupervisor;
	}

	public void setEmployeeIndSupervisor(String employeeIndSupervisor) {
		this.employeeIndSupervisor = employeeIndSupervisor;
	}

	public String getEmployeeFirstApp() {
		return employeeFirstApp;
	}

	public void setEmployeeFirstApp(String employeeFirstApp) {
		this.employeeFirstApp = employeeFirstApp;
	}

	public String getEmployeeSecApp() {
		return employeeSecApp;
	}

	public void setEmployeeSecApp(String employeeSecApp) {
		this.employeeSecApp = employeeSecApp;
	}

	public String getEmployeeThirdApp() {
		return employeeThirdApp;
	}

	public void setEmployeeThirdApp(String employeeThirdApp) {
		this.employeeThirdApp = employeeThirdApp;
	}

	public String getEmployeeNotes() {
		return employeeNotes;
	}

	public void setEmployeeNotes(String employeeNotes) {
		this.employeeNotes = employeeNotes;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getEmployeepPin() {
		return employeepPin;
	}

	public void setEmployeepPin(String employeepPin) {
		this.employeepPin = employeepPin;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDesignationName() {
		return empDesignationName;
	}

	public void setEmpDesignationName(String empDesignationName) {
		this.empDesignationName = empDesignationName;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public String getEmployeeCountyName() {
		return employeeCountyName;
	}

	public void setEmployeeCountyName(String employeeCountyName) {
		this.employeeCountyName = employeeCountyName;
	}

	public String getEmployeeStateName() {
		return employeeStateName;
	}

	public void setEmployeeStateName(String employeeStateName) {
		this.employeeStateName = employeeStateName;
	}

	public String getEmployeeGenderName() {
		return employeeGenderName;
	}

	public void setEmployeeGenderName(String employeeGenderName) {
		this.employeeGenderName = employeeGenderName;
	}

	public String getEmployeePaygradeName() {
		return employeePaygradeName;
	}

	public void setEmployeePaygradeName(String employeePaygradeName) {
		this.employeePaygradeName = employeePaygradeName;
	}

	public String getEmployeeMaritalName() {
		return employeeMaritalName;
	}

	public void setEmployeeMaritalName(String employeeMaritalName) {
		this.employeeMaritalName = employeeMaritalName;
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
