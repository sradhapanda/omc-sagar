package nirmalya.aatithya.restmodule.employee.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;

@Repository
public class HrmsEmployeeDao {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for employment list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmploymentList() {

		logger.info("Method : getEmploymentList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getEmploymentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmploymentList ends");

		return employmentList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends");

		return employmentList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGenderList() {

		logger.info("Method : getGenderList starts");

		List<DropDownModel> genderList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getGenderList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGenderList ends");

		return genderList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {

		logger.info("Method : getCountryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryList ends");

		return countryList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMaritalList() {

		logger.info("Method : getMaritalList starts");

		List<DropDownModel> maritalList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getMaritalList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				maritalList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getMaritalList ends");

		return maritalList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPayGradeList() {

		logger.info("Method : getPayGradeList starts");

		List<DropDownModel> payGaradeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getPayGradeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payGaradeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPayGradeList ends");

		return payGaradeList;
	}

	/**
	 * 
	 * @return job title list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobTitleList() {

		logger.info("Method : getJobTitleList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getJobTitleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobTitleList ends");

		return employmentList;
	}

	/**
	 * 
	 * @return designation list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserRole() {

		logger.info("Method : getUserRole starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "getUserRole")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getUserRole ends");

		return employmentList;
	}

	/**
	 * 
	 * @return nationality list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNationalityList() {

		logger.info("Method : getNationalityList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getNationalityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(employmentList);

		logger.info("Method : getNationalityList ends");

		return employmentList;
	}

	/**
	 * 
	 * @return getSupervisorByDept list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSupervisorByDept(String id) {

		logger.info("Method : getSupervisorByDept starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();
		String value = "SET @P_deptId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getJobTypeOnChange").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSupervisorByDept ends");

		return employmentList;
	}

	/**
	 * for all employee details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getemployeeDetails(DataTableRequest request) {

		logger.info("Method in Dao: getemployeeDetails starts");

		List<HrmsEmployeeModel> employeList = new ArrayList<HrmsEmployeeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewemployeeList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					HrmsEmployeeModel employe = new HrmsEmployeeModel(m[0], m[1], null, null, null, null, null, null,
							null, null, null, null, null, null, null, m[2], null, null, null, null, null, null, null,
							null, null, null, m[3], null, null, m[4], m[5], m[6], null, null, null, null, null, null,
							null, m[7], null, null, null, null, null, null, null, null, null);
					employeList.add(employe);
					// employe.setStatus((Boolean) m[7]);
					/*
					 * System.out.println("m[4]="+m[4]); System.out.println("m[0]="+m[0]);
					 * System.out.println("m[1]="+m[1]); System.out.println("m[2]="+m[2]);
					 * System.out.println("m[3]="+m[3]); System.out.println("m[5]="+m[5]);
					 * System.out.println("m[6]="+m[6]);
					 */

				}

				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeModel>> resp = new JsonResponse<List<HrmsEmployeeModel>>();
		resp.setBody(employeList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemployeeDetails ends");
		System.out.println(response);
		return response;
	}

	/**
	 * for add new employee
	 */
	public ResponseEntity<JsonResponse<Object>> addemployee(HrmsEmployeeModel employee) {

		logger.info("Method in Dao: addemployee starts");
		List<HrmsEmployeeModel> employeList = new ArrayList<HrmsEmployeeModel>();
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (employee.getEmployeeFname() == null || employee.getEmployeeFname() == "") {
			resp.setMessage("Employee  First Name required");
			validity = false;
		} else if (employee.getEmployeeFname() == null || employee.getEmployeeFname() == "") {
			resp.setMessage("Employee Last Name required");
			validity = false;
		} else if (employee.getEmployeeDepartment() == null || employee.getEmployeeDepartment() == "") {
			resp.setMessage("Employee Department required");
			validity = false;
		} else if (employee.getEmployeeEmployment() == null || employee.getEmployeeEmployment() == "") {
			resp.setMessage("Employee Employment required");
			validity = false;
		} else if (employee.getEmployeeJobTitle() == null || employee.getEmployeeJobTitle() == "") {
			resp.setMessage("Employee Job title required");
			validity = false;
		} else if (employee.getEmployeeMobilePhoneNo() == null || employee.getEmployeeMobilePhoneNo() == "") {
			resp.setMessage("Employee Mobile No required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateEmployeeParameter.getAddEmploymentParam(employee);
				if (employee.getEmployeeNo() == "" || employee.getEmployeeNo() == null) {

					@SuppressWarnings("unchecked")
					List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "addemployee").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						HrmsEmployeeModel employe = new HrmsEmployeeModel(m[0], m[1], null, null, null, null, null,
								null, null, null, m[2], null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, m[3], m[3], null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null);
						employeList.add(employe);

					}

				} else {

					em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "modifyemployee")
							.setParameter("actionValue", values).execute();

				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		System.out.println(employeList);
		resp.setBody(employeList);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addemployee ends");

		return response;
	}

	/*
	 * for edit employee
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsEmployeeModel>> getemployeeById(String id) {

		logger.info("Method in Dao: getemployeeById ends");

		List<HrmsEmployeeModel> pemployee = new ArrayList<HrmsEmployeeModel>();

		try {

			String value = "SET @P_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewEditemployee").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object dob = null;

				Object joinDate = null;
				Object cnfrmDate = null;
				Object termDate = null;
				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				if (m[27] != null) {
					joinDate = DateFormatter.returnStringDate(m[27]);
				}
				if (m[28] != null) {
					cnfrmDate = DateFormatter.returnStringDate(m[28]);
				}
				if (m[29] != null) {
					termDate = DateFormatter.returnStringDate(m[29]);
				}

				HrmsEmployeeModel employee = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], m[45], null, m[46],m[47]);
				/*
				 * (m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8], m[9], m[10], m[11],
				 * m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
				 * m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31],
				 * m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42],
				 * m[43], m[44], m[45], null, m[46]);
				 */

				/*
				 * (m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8], m[9], m[10], m[11],
				 * m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
				 * m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31],
				 * m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42],
				 * m[43], m[44], m[45], m[46],m[47]);
				 */
				/*
				 * (m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8], m[9], m[10], m[11],
				 * m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
				 * m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31],
				 * m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42],
				 * m[43], m[44],m[45],m[46],m[47]);
				 */
				pemployee.add(employee);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsEmployeeModel> resp = new JsonResponse<HrmsEmployeeModel>();
		resp.setBody(pemployee.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsEmployeeModel>> response = new ResponseEntity<JsonResponse<HrmsEmployeeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemployeeById ends");
		System.out.println("edit response=" + response);
		return response;

	}

	/*
	 * for delete employee
	 */
	public ResponseEntity<JsonResponse<Object>> deleteemployeeById(String id, String createdBy) {

		logger.info("Method in Dao: deleteemployeeById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_empId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "deleteemployee")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteemployeeById ends");

		return response;
	}

	/**
	 * DAO - Get Employee Details For View
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForView(String id) {

		logger.info("Method in Dao: getEmployeeByIdForView ends");

		List<HrmsEmployeeModel> pemployee = new ArrayList<HrmsEmployeeModel>();

		try {

			String value = "SET @P_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewEditemployee").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object dob = null;
				Object joinDate = null;
				Object cnfrmDate = null;
				Object termDate = null;
				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				if (m[27] != null) {
					joinDate = DateFormatter.returnStringDate(m[27]);
				}
				if (m[28] != null) {
					cnfrmDate = DateFormatter.returnStringDate(m[28]);
				}
				if (m[29] != null) {
					termDate = DateFormatter.returnStringDate(m[29]);
				}
				HrmsEmployeeModel employee = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], null, m[40], m[41], m[42], m[43], m[44], m[45], m[46],null);

				pemployee.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeModel>> resp = new JsonResponse<List<HrmsEmployeeModel>>();
		resp.setBody(pemployee);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getEmployeeByIdForView ends");
		return response;
	}

	/**
	 * DAO - Get Employee Details For View
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForModalView(String id) {

		logger.info("Method in Dao: getEmployeeByIdForModalView ends");

		List<HrmsEmployeeModel> pemployee = new ArrayList<HrmsEmployeeModel>();

		try {

			String value = "SET @P_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewModalEmployee").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object dob = null;

				Object joinDate = null;
				Object cnfrmDate = null;
				Object termDate = null;
				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				if (m[27] != null) {
					joinDate = DateFormatter.returnStringDate(m[27]);
				}
				if (m[28] != null) {
					cnfrmDate = DateFormatter.returnStringDate(m[28]);
				}
				if (m[29] != null) {
					termDate = DateFormatter.returnStringDate(m[29]);
				}

				HrmsEmployeeModel employee = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], null, m[38], null, m[39], m[40], m[41], m[42], m[43], m[44], m[45],null);

				
				pemployee.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeModel>> resp = new JsonResponse<List<HrmsEmployeeModel>>();
		resp.setBody(pemployee);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getEmployeeByIdForModalView ends");
		System.out.println("modal res=" + response);

		return response;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTypeOnChange(String deptId) {

		logger.info("Method : getJobTypeOnChange starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_deptId='" + deptId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getJobTypeOnChange").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getJobTypeOnChange ends");
		return response;
	}

	/*
	 * Drop down for state Change list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateChange(String countryId) {

		logger.info("Method : getStateChange starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_countryId='" + countryId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getStateChange").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getStateChange ends");
		return response;
	}

	/**
	 * DAO - Change The Status Of Employee
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> changeStatusById(String id, Boolean status, String createdBy) {
		logger.info("Method in Dao: changeStatusById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_empId='" + id + "',@p_status=" + status + ",@P_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "changeStatus")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: changeStatusById ends");

		return response;
	}

	/**
	 * 
	 * @return nationality list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateforEdit(String id) {

		logger.info("Method : getStateforEdit starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_countryId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getStateChange").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStateforEdit ends");

		return stateList;
	}

	/*
	 * First Stage Approval
	 * 
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<EmployeeOfferLetterSalaryDetailsModel>>
	 * getEmployeeSalaryDetails(String id) {
	 * 
	 * logger.info("Method : appraisalFormManagerApproval starts");
	 * 
	 * List<EmployeeOfferLetterSalaryDetailsModel> salaryDetails = new
	 * ArrayList<EmployeeOfferLetterSalaryDetailsModel>();
	 * JsonResponse<EmployeeOfferLetterSalaryDetailsModel> resp = new
	 * JsonResponse<EmployeeOfferLetterSalaryDetailsModel>();
	 * 
	 * try {
	 * 
	 * String value = "SET @P_empId='" + id + "' ;";
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
	 * .setParameter("actionType", "getSalaryDetails").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) { Object efDate = null; if (m[2] != null) { efDate =
	 * DateFormatter.returnStringDate(m[2]); } Object doj = null; if (m[15] != null)
	 * { doj = DateFormatter.returnStringDate(m[15]); }
	 * EmployeeOfferLetterSalaryDetailsModel EmployeeOfferLetterSalaryDetailsModel =
	 * new EmployeeOfferLetterSalaryDetailsModel( m[0], m[1], null, efDate, null,
	 * m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], null,
	 * null, m[14], null, null, null, null, null, null, null, null, null, null,
	 * null, null, null, null, null, null, null, null, null, null, null, null, null,
	 * null, null, null, doj, null, null, null, null, null, null, null, null, null);
	 * 
	 * salaryDetails.add(EmployeeOfferLetterSalaryDetailsModel);
	 * 
	 * } resp.setBody(salaryDetails.get(0)); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.set("MyResponseHeader", "MyValue");
	 * 
	 * ResponseEntity<JsonResponse<EmployeeOfferLetterSalaryDetailsModel>> response
	 * = new ResponseEntity<JsonResponse<EmployeeOfferLetterSalaryDetailsModel>>(
	 * resp, responseHeaders, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : appraisalFormManagerApproval ends");
	 * 
	 * return response; }
	 */

	public ResponseEntity<JsonResponse<Object>> changePassword(String id, String password) {
		logger.info("Method : changePassword starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_user='" + id + "', @p_pass='" + password + "';";

			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "changePassword")
					.setParameter("actionValue", values).execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : changePassword ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addTerminationDateDao(String id, String date) {
		logger.info("Method : addTerminationDateDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_user='" + id + "', @p_date='" + DateFormatter.getStringDate(date) + "';";
			System.out.println(values);
			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "addTerminationDate")
					.setParameter("actionValue", values).execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addTerminationDateDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpNameListByAutoSearch(String id) {
		logger.info("Method : getItemNameListByAutoSearch Dao starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			System.out.println(id);
			String value = "SET @P_empId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getEmpNameList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], null);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getItemNameListByAutoSearch Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpNameByAutoSearch(String id) {
		logger.info("Method : getEmpNameListByAutoSearch1 Dao starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			System.out.println(id);
			String value = "SET @p_empFName='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "getEmpName")
					.setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmpNameListByAutoSearch1 Dao ends");
		return response;
	}

	/**
	 * for Region list
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRegionList() {

		logger.info("Method : getDepartmentList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getRegionList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends");

		return employmentList;
	}
}
