package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;

public class GenerateEmployeeParameter {

	public static String getAddEmploymentParam(HrmsEmployeeModel employee) {

		String dob = null;
		String joindate = null;
		String confirmdate = null;
		String terminationDate = null;
		try {
			dob = DateFormatter.getStringDate(employee.getEmployeeDob());
			joindate = DateFormatter.getStringDate(employee.getEmployeeJoinDate());
			confirmdate = DateFormatter.getStringDate(employee.getEmployeeConfirmDate());
			if(employee.getEmployeeTerminateDate()!=null)
			terminationDate = DateFormatter.getStringDate(employee.getEmployeeTerminateDate());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		String s = "";

		if (employee.getEmployeeNo() != null) {
			s = s + "@P_empId='" + employee.getEmployeeNo() + "',";
		}
		if (employee.getEmployeeFname() != null && employee.getEmployeeFname() != "") {
			s = s + "@p_empFName='" + employee.getEmployeeFname() + "',";
		}
		if (employee.getEmployeeMname() != null) {
			s = s + "@p_empMName='" + employee.getEmployeeMname() + "',";
		}
		if (employee.getEmployeeLname() != null && employee.getEmployeeLname() != "") {
			s = s + "@p_empLName='" + employee.getEmployeeLname() + "',";
		}
		if (employee.getEmployeeNationality() != null && employee.getEmployeeNationality() != "") {
			s = s + "@p_empNationality='" + employee.getEmployeeNationality() + "',";
		}
		if (employee.getEmployeeDob() != null && employee.getEmployeeDob() != "") {
			s = s + "@p_empDob='" + dob + "',";
		}
		if (employee.getEmployeeGender() != null && employee.getEmployeeGender() != "") {
			s = s + "@p_empGen='" + employee.getEmployeeGender() + "',";
		}
		if (employee.getEmployeeImage() != null) {
			s = s + "@p_empImage='" + employee.getEmployeeImage() + "',";
		}
		if (employee.getEmployeeMarital() != null && employee.getEmployeeMarital() != "") {
			s = s + "@p_empMarital='" + employee.getEmployeeMarital() + "',";
		}
		if (employee.getEmployeeEsicNo() != null && employee.getEmployeeEsicNo() != "") {
			s = s + "@p_empEsic='" + employee.getEmployeeEsicNo() + "',";
		}
		if (employee.getEmployeePassword() != null && employee.getEmployeePassword() != "") {
			s = s + "@p_empIPassword='" + employee.getEmployeePassword() + "',";
		}
		if (employee.getEmployeepPin() != null) {
			s = s + "@p_emppPin='" + employee.getEmployeepPin() + "',";
		}
		if (employee.getEmployeeAdhar() != null) {
			s = s + "@p_empAdhar='" + employee.getEmployeeAdhar() + "',";
		}
		if (employee.getEmployeeOtherId() != null) {
			s = s + "@p_empOtherId='" + employee.getEmployeeOtherId() + "',";
		}
		if (employee.getEmployeeDl() != null) {
			s = s + "@p_empDl='" + employee.getEmployeeDl() + "',";
		}
		if (employee.getEmployeeEmployment() != null && employee.getEmployeeEmployment() != "") {
			s = s + "@p_empEmployment='" + employee.getEmployeeEmployment() + "',";
		}

		if (employee.getEmployeePayGrade() != null && employee.getEmployeePayGrade() != "") {
			s = s + "@p_empPaygrade='" + employee.getEmployeePayGrade() + "',";
		}
		if (employee.getEmployeeWorkStationId() != null) {
			s = s + "@p_empWorkstation='" + employee.getEmployeeWorkStationId() + "',";
		}
		if (employee.getEmployeeAddress() != null && employee.getEmployeeAddress() != "") {
			s = s + "@p_empAddress='" + employee.getEmployeeAddress() + "',";
		}
		if (employee.getEmployeeCity() != null) {
			s = s + "@p_empCity='" + employee.getEmployeeCity() + "',";
		}
		if (employee.getEmployeeCountry() != null && employee.getEmployeeCountry() != "") {
			s = s + "@p_empCountry='" + employee.getEmployeeCountry() + "',";
		}
		if (employee.getEmployeePin() != null && employee.getEmployeePin() != "") {
			s = s + "@p_empPin='" + employee.getEmployeePin() + "',";
		}
		if (employee.getEmployeeHomePhoneNo() != null) {
			s = s + "@p_empHphone='" + employee.getEmployeeHomePhoneNo() + "',";
		}
		if (employee.getEmployeeMobilePhoneNo() != null) {
			s = s + "@p_empMphone='" + employee.getEmployeeMobilePhoneNo() + "',";
		}
		if (employee.getEmployeeWorkPhoneNo() != null) {
			s = s + "@p_empWphone='" + employee.getEmployeeWorkPhoneNo() + "',";
		}
		if (employee.getEmployeeWorkEmail() != null) {
			s = s + "@p_empWemail='" + employee.getEmployeeWorkEmail() + "',";
		}
		if (employee.getEmployeePersonalEmail() != null) {
			s = s + "@p_empPemail='" + employee.getEmployeePersonalEmail() + "',";
		}
		if (employee.getEmployeeJoinDate() != null) {
			s = s + "@p_empJoindate='" + joindate + "',";
		}
		if (employee.getEmployeeConfirmDate() != null) {
			s = s + "@p_empConfmdate='" + confirmdate + "',";
		}
		if (employee.getEmployeeTerminateDate() != null && employee.getEmployeeTerminateDate()!=""){

			s = s + "@p_empTermdate='" + terminationDate + "',";
		}		
		if (employee.getEmployeeDepartment() != null && employee.getEmployeeDepartment() != "") {
			s = s + "@p_empDeprt='" + employee.getEmployeeDepartment() + "',";
		}
		
		
		if (employee.getEmployeeSupervisor() != null && employee.getEmployeeSupervisor() != "") {
			s = s + "@p_empSupervisor='" + employee.getEmployeeSupervisor() + "',";
		}
		if (employee.getEmployeeIndSupervisor() != null && employee.getEmployeeIndSupervisor() != "") {
			s = s + "@p_empIndSupervisor='" + employee.getEmployeeIndSupervisor() + "',";
		}
		if (employee.getEmployeeFirstApp() != null && employee.getEmployeeFirstApp() != "") {
			s = s + "@p_emp1stApp='" + employee.getEmployeeFirstApp() + "',";
		}
		if (employee.getEmployeeSecApp() != null && employee.getEmployeeSecApp() != "") {
			s = s + "@p_emp2ndApp='" + employee.getEmployeeSecApp() + "',";
		}
		if (employee.getEmployeeThirdApp() != null && employee.getEmployeeThirdApp() != "") {
			s = s + "@p_emp3rdApp='" + employee.getEmployeeThirdApp() + "',";
		}
		if (employee.getEmployeeNotes() != null) {
			s = s + "@p_empNotes='" + employee.getEmployeeNotes() + "',";
		}
		if (employee.getCreatedBy() != null && employee.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + employee.getCreatedBy() + "',";
		}
		if (employee.getCompanyId() != null && employee.getCompanyId() != "") {
			s = s + "@p_companyId='" + employee.getCompanyId() + "',";
		}
		if (employee.getEmployeeJobTitle() != null && employee.getEmployeeJobTitle() != "") {
			s = s + "@p_empJobtitle='" + employee.getEmpDesignation() + "',";
		}
		if (employee.getEmployeeState() != null && employee.getEmployeeState() != "") {
			s = s + "@p_empState='" + employee.getEmployeeState() + "',";
		}
		if (employee.getEmployeeRegion() != null && employee.getEmployeeRegion() != "") {
			s = s + "@p_empRegion='" + employee.getEmployeeRegion() + "',";
			}
		String[] roleList = employee.getEmployeeJobTitle().split(",");
		String roles = "";
		for (int i = 0; i < roleList.length; i++) {
			roles = roles + "(@P_empId,\"" + roleList[i] + "\"),";
		}
		roles = roles.substring(0, roles.length() - 1);
		s = s + "@p_userRoles='" + roles + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
