package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;

@RestController
@RequestMapping("employee/")
public class HrmsEmployeeRestController {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeRestController.class);

	@Autowired
	HrmsEmployeeDao hrmsEmployeeDao;

	/*
	 * for get employment list
	 */
	@RequestMapping(value = "getEmploymentList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmploymentList() {

		logger.info("Method : getEmploymentList starts");
		logger.info("Method : getEmploymentList ends");

		return hrmsEmployeeDao.getEmploymentList();
	}

	/**
	 * 
	 * @return department list
	 */
	@RequestMapping(value = "getDepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");
		logger.info("Method : getDepartmentList ends");

		return hrmsEmployeeDao.getDepartmentList();
	}

	/**
	 * 
	 * @return department list
	 */
	@RequestMapping(value = "getGenderList", method = { RequestMethod.GET })
	public List<DropDownModel> getGenderList() {

		logger.info("Method : getGenderList starts");
		logger.info("Method : getGenderList ends");

		return hrmsEmployeeDao.getGenderList();
	}

	/**
	 * 
	 * @return Marital list
	 */
	@RequestMapping(value = "getMaritalList", method = { RequestMethod.GET })
	public List<DropDownModel> getMaritalList() {

		logger.info("Method : getMaritalList starts");
		logger.info("Method : getMaritalList ends");

		return hrmsEmployeeDao.getMaritalList();
	}

	/**
	 * 
	 * @return department list
	 */
	@RequestMapping(value = "getCountryList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {

		logger.info("Method : getCountryList starts");
		logger.info("Method : getCountryList ends");

		return hrmsEmployeeDao.getCountryList();
	}

	/**
	 * 
	 * @return department list
	 */
	@RequestMapping(value = "getPayGradeList", method = { RequestMethod.GET })
	public List<DropDownModel> getPayGradeList() {

		logger.info("Method : getPayGradeList starts");
		logger.info("Method : getPayGradeList ends");

		return hrmsEmployeeDao.getPayGradeList();
	}

	/**
	 * 
	 * @return job title list
	 */
	@RequestMapping(value = "getJobTitleList", method = { RequestMethod.GET })
	public List<DropDownModel> getJobTitleList() {
		logger.info("Method : getJobTitleList starts");
		logger.info("Method : getJobTitleList ends");
		return hrmsEmployeeDao.getJobTitleList();
	}

	/**
	 * 
	 * @return designation list
	 */
	@RequestMapping(value = "getUserRole", method = { RequestMethod.GET })
	public List<DropDownModel> getUserRole() {

		logger.info("Method : getUserRole starts");
		logger.info("Method : getUserRole ends");

		return hrmsEmployeeDao.getUserRole();
	}

	/**
	 * Nationality list
	 * 
	 * @return
	 */
	@RequestMapping(value = "getNationalityList", method = { RequestMethod.GET })
	public List<DropDownModel> getNationalityList() {

		logger.info("Method : getNationalityList starts");
		logger.info("Method : getNationalityList ends");

		return hrmsEmployeeDao.getNationalityList();
	}

	/**
	 * 
	 * @return supervisor list by item id
	 */
	@RequestMapping(value = "getSupervisorByDept", method = { RequestMethod.GET })
	public List<DropDownModel> getSupervisorByDept(@RequestParam String id) {

		logger.info("Method : getSupervisorByDept starts");
		logger.info("Method : getSupervisorByDept ends");

		return hrmsEmployeeDao.getSupervisorByDept(id);
	}

	/**
	 * add Employee
	 * 
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "restAddemployee", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddemployee(@RequestBody HrmsEmployeeModel employee) {
		logger.info("Method : restAddemployee starts");

		logger.info("Method : restAddemployee ends");

		return hrmsEmployeeDao.addemployee(employee);
	}

	/**
	 * for employee list view
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getemployeeDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getemployeeDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getemployeeDetails starts");

		logger.info("Method : getemployeeDetails ends");

		return hrmsEmployeeDao.getemployeeDetails(request);
	}

	/**
	 * for Employee Edit
	 */
	@RequestMapping(value = "getemployeeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsEmployeeModel>> getemployeeById(@RequestParam String id) {
		logger.info("Method : getemployeeById starts");

		logger.info("Method : getemployeeById ends");

		return hrmsEmployeeDao.getemployeeById(id);
	}

	/*
	 * for employee Delete
	 */
	@RequestMapping(value = "deleteemployee", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteemployeeById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteemployeeById starts");

		logger.info("Method : deleteemployeeById ends");

		return hrmsEmployeeDao.deleteemployeeById(id, createdBy);
	}

	/**
	 * Rest Controller - Get Employee Details For View
	 *
	 */
	@RequestMapping(value = "getEmployeeByIdForView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForView(@RequestParam String id) {
		logger.info("Method : getEmployeeByIdForView starts");

		logger.info("Method : getEmployeeByIdForView ends");
		return hrmsEmployeeDao.getEmployeeByIdForView(id);
	}

	/**
	 * Rest Controller - Get Employee Details For View
	 *
	 */
	@RequestMapping(value = "getEmployeeByIdForModalView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForModalView(@RequestParam String id) {
		logger.info("Method : getEmployeeByIdForModalView starts");

		logger.info("Method : getEmployeeByIdForModalView ends");
		return hrmsEmployeeDao.getEmployeeByIdForModalView(id);
	}

	/*
	 * for drop down of job type
	 */
	@RequestMapping(value = "/getJobTypeOnChange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTypeOnChange(@RequestParam String deptId) {
		logger.info("Method in rest: getJobTypeOnChange starts");

		logger.info("Method in rest: getJobTypeOnChange ends");
		return hrmsEmployeeDao.getJobTypeOnChange(deptId);
	}

	/*
	 * for drop down of state change
	 */
	@RequestMapping(value = "/getStateChange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateChange(@RequestParam String countryId) {
		logger.info("Method in rest: getStateChange starts");

		logger.info("Method in rest: getStateChange ends");
		return hrmsEmployeeDao.getStateChange(countryId);
	}

	/**
	 * Nationality list
	 * 
	 * @return
	 */
	@RequestMapping(value = "getStateforEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getStateforEdit(@RequestParam String id) {

		logger.info("Method : getStateforEdit starts");
		logger.info("Method : getStateforEdit ends");

		return hrmsEmployeeDao.getStateforEdit(id);
	}

	/**
	 * Rest Controller - Change The Status Of Employee
	 *
	 */
	@RequestMapping(value = "changeStatusById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeStatusById(@RequestParam("id") String id,
			@RequestParam("status") Boolean status, @RequestParam("createdBy") String createdBy) {
		logger.info("Method : changeStatusById starts");

		logger.info("Method : changeStatusById ends");
		return hrmsEmployeeDao.changeStatusById(id, status, createdBy);
	}

	/*
	 * @RequestMapping(value = "getEmployeeSalaryDetails", method = {
	 * RequestMethod.GET }) public
	 * ResponseEntity<JsonResponse<EmployeeOfferLetterSalaryDetailsModel>>
	 * getEmployeeSalaryDetails(
	 * 
	 * @RequestParam("id") String id) {
	 * logger.info("Method : getEmployeeSalaryDetails starts");
	 * 
	 * logger.info("Method : getEmployeeSalaryDetails ends");
	 * 
	 * return hrmsEmployeeDao.getEmployeeSalaryDetails(id); }
	 */
	@RequestMapping(value = "/changePassword", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changePassword(@RequestParam String id, @RequestParam String password) {
		logger.info("Method : changePassword starts");

		logger.info("Method : changePassword ends");
		return hrmsEmployeeDao.changePassword(id, password);
	}

	@RequestMapping(value = "/addTerminationDate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restAddTerminationDate(@RequestParam String id,
			@RequestParam String date) {
		logger.info("Method : restAddTerminationDate starts");

		logger.info("Method : restAddTerminationDate ends");
		return hrmsEmployeeDao.addTerminationDateDao(id, date);
	}

	@RequestMapping(value = "/getEmpNameListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemNameListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getItemNameListByAutoSearch starts");

		logger.info("Method : getItemNameListByAutoSearch ends");
		return hrmsEmployeeDao.getEmpNameListByAutoSearch(id);
	}

	@RequestMapping(value = "/getEmpNameByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpNameByAutoSearch(@RequestParam String id) {
		logger.info("Method : getItemNameListByAutoSearch starts");

		logger.info("Method : getItemNameListByAutoSearch ends");
		return hrmsEmployeeDao.getEmpNameByAutoSearch(id);
	}

	/**
	 *
	 * @return department list
	 */
	@RequestMapping(value = "getRegionList", method = { RequestMethod.GET })
	public List<DropDownModel> getRegionList() {

		logger.info("Method : getRegionList starts");
		logger.info("Method : getRegionList ends");

		return hrmsEmployeeDao.getRegionList();
	}
}
