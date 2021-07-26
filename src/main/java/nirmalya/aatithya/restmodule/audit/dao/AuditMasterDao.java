package nirmalya.aatithya.restmodule.audit.dao;

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

import nirmalya.aatithya.restmodule.audit.model.AuditCommentsModel;
import nirmalya.aatithya.restmodule.audit.model.AuditComplianceModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterPdfModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditorParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AuditMasterDao {

	Logger logger = LoggerFactory.getLogger(AuditMasterDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditTypeByAuditName(String id) {
		logger.info("Method : getAuditTypeByAuditName starts");

		List<DropDownModel> auditType = new ArrayList<DropDownModel>();
		String value = "SET @p_auditInit='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getAuditType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditTypeByAuditName ends");
		return auditType;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeptList() {
		logger.info("Method : getDeptList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getDeptList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeptList ends");

		return dept;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSectionList(String id) {
		logger.info("Method : getSectionList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		String value = "SET @p_dept='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getSectionList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSectionList ends");

		return dept;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentHeadList(String id) {
		logger.info("Method : getDepartmentHeadList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		String value = "SET @p_dept='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getDeptHeadList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentHeadList ends");

		return dept;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getConcernAuditList(String id) {
		logger.info("Method : getConcernAuditList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		String value = "SET @p_dept='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getAuditeeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getConcernAuditList ends");

		return dept;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSelectedConcernAuditList(String id) {
		logger.info("Method : getSelectedConcernAuditList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		String value = "SET @p_audit='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "SelectedConcernAuditee").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSelectedConcernAuditList ends");
		return dept;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSelectedSubCoordList(String id) {
		logger.info("Method : getSelectedSubCoordList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		String value = "SET @p_audit='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "SelectedSubCo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSelectedSubCoordList ends");

		return dept;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSelectedDeptList(String id) {
		logger.info("Method : getSelectedDeptList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		String value = "SET @p_audit='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "selectedDeptList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSelectedDeptList ends");
		return dept;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSectionListByDept(String id) {

		logger.info("Method : getSectionListByDept starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_dept='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getSectionList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

			resp.setBody(dept);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dept);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSectionListByDept ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptHeadListByDept(String id) {

		logger.info("Method : getDeptHeadListByDept starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_dept= \"(" + id + ")\";";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getDeptHeadList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

			resp.setBody(dept);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(resp);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDeptHeadListByDept ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditeeListByDept(String id) {

		logger.info("Method : getAuditeeListByDept starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_dept='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getAuditeeList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

			resp.setBody(dept);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAuditeeListByDept ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditorListByOrg(String id) {

		logger.info("Method : getAuditorListByOrg starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "orgAuditorList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

			resp.setBody(dept);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAuditorListByOrg ends");

		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> addNewAudit(List<AuditMasterModel> audit) {
		logger.info("Method : addNewAudit starts");

		Boolean validity = true;

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");
		resp.setCode("");

		for (AuditMasterModel l : audit) {

			// if (l.getAuditName() == null || l.getAuditName() == "") {
			// validity = false;
			// resp.setCode("Field Validation Error");
			// resp.setMessage("Audit Name Required");
			// break;
			// } else if (l.getOrganisation() == null || l.getOrganisation() == "") {
			// validity = false;
			// resp.setCode("Field Validation Error");
			// resp.setMessage("Auditor Name Required");
			// break;
			// } else if (l.getDepartment() == null || l.getDepartment() == "") {
			// validity = false;
			// resp.setCode("Field Validation Error");
			// resp.setMessage("Department Required");
			// break;
			// } else if (l.getSection() == null || l.getSection() == "") {
			// validity = false;
			// resp.setCode("Field Validation Error");
			// resp.setMessage("Section / Region Required");
			// break;
			// }
			/*
			 * else if (l.getDeptHeadId() == null || l.getDeptHeadId() == "") { validity =
			 * false; resp.setCode("Field Validation Error");
			 * resp.setMessage("Section/RM Head Required"); break; }
			 */

			/*
			 * else if (l.getAuditee() == null || l.getAuditee() == "") { validity = false;
			 * resp.setCode("Field Validation Error"); resp.setMessage("Auditee Required");
			 * break; } / / else if (l.getAuditor() == null || l.getAuditor() == "") {
			 * validity = false; resp.setCode("Field Validation Error");
			 * resp.setMessage("Auditor Required"); break; }
			 */// else if (l.getFromDate() == null || l.getFromDate() == "") {
			/*
			 * validity = false; resp.setCode("Field Validation Error");
			 * resp.setMessage("From Date Required"); break; } else if (l.getToDate() ==
			 * null || l.getToDate() == "") { validity = false;
			 * resp.setCode("Field Validation Error"); resp.setMessage("To Date Required");
			 * break; }
			 */
		}
		if (validity) {
			try {
				int i = 0;
				for (AuditMasterModel l : audit) {
					i++;
					List<DropDownModel> ques = new ArrayList<DropDownModel>();
					String values = GenerateAuditMasterParameter.addAuditParam(l, i);
					System.out.println(values);
					if (audit.get(0).getAuditInitiated() != null && audit.get(0).getAuditInitiated() != "") {
						@SuppressWarnings("unchecked")
						List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
								.setParameter("actionType", "modifyAudit").setParameter("actionValue", values)
								.getResultList();
						if (!x.isEmpty()) {
							for (Object[] m : x) {

								DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
								ques.add(dropDownModel);
								resp.setBody(ques);
							}
						}

					} else {

						if (l.getConcernedAuditee().size() > 0) {
							@SuppressWarnings("unchecked")
							List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
									.setParameter("actionType", "addAuditwithDept").setParameter("actionValue", values)
									.getResultList();
							if (!x.isEmpty()) {
								for (Object[] m : x) {

									DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
									ques.add(dropDownModel);
									resp.setBody(ques);
								}

							}
						}

						else {
							em.createNamedStoredProcedureQuery("auditMasterRoutines")
									.setParameter("actionType", "addAuditwithoutDept")
									.setParameter("actionValue", values).execute();
							resp.setMessage("Success");

						}
						/////

					}

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
		}
		resp.setCode(resp.getMessage());

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addNewAudit ends");
		System.out.println(response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<AuditObservationModel> getQuestionList(Integer id, String deptId, String sectionId) {
		logger.info("Method : getQuestionList starts");

		List<AuditObservationModel> ques = new ArrayList<AuditObservationModel>();
		String value = "SET @p_id=" + id + ", @p_dept='" + deptId + "', @p_section='" + sectionId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getQuestionList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditObservationModel dropDownModel = new AuditObservationModel(m[0], null, null, null, m[1], m[2],
						m[3], null, m[4], m[5], m[6], m[7], m[8], m[9], null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				ques.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getQuestionList ends");
		return ques;
	}

	@SuppressWarnings("unchecked")
	public List<AuditObservationModel> getQuestionListForApprove(Integer id) {
		logger.info("Method : getQuestionListForApprove starts");

		List<AuditObservationModel> ques = new ArrayList<AuditObservationModel>();
		String value = "SET @p_id=" + id + ";";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getQuestionListForApprv").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				AuditObservationModel dropDownModel = new AuditObservationModel(m[0], null, null, null, m[1], m[2],
						m[3], null, m[4], m[5], m[6], m[7], m[8], m[9], null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				ques.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getQuestionListForApprove ends");
		return ques;
	}

	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditMasterModel>>> getAllAuditMaster(DataTableRequest request) {

		logger.info("Method in Dao: getAllAuditMaster starts");

		List<AuditMasterModel> auditInitiateModelList = new ArrayList<AuditMasterModel>();

		if (request.getParam2() != null && request.getParam2() != "") {
			request.setParam2(DateFormatter.getStringDate(request.getParam2()));
		}
		if (request.getParam3() != null && request.getParam3() != "") {
			request.setParam3(DateFormatter.getStringDate(request.getParam3()));
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getAllAuditMaster").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object fromDate = null;
					fromDate = DateFormatter.returnStringDate(m[10]);
					Object toDate = null;
					toDate = DateFormatter.returnStringDate(m[11]);
					AuditMasterModel auditInitiateModel = new AuditMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], fromDate, toDate, m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null,null);
					auditInitiateModelList.add(auditInitiateModel);

				}

				if (x.get(0).length > 20) {
					BigInteger t = (BigInteger) x.get(0)[20];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditMasterModel>> resp = new JsonResponse<List<AuditMasterModel>>();
		resp.setBody(auditInitiateModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditMasterModel>>> response = new ResponseEntity<JsonResponse<List<AuditMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllAuditMaster ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> auditeeCommentSave(AuditComplianceModel index) {
		logger.info("Method : auditeeCommentSave starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (index.getQuesId() == null) {
			resp.setMessage("Question Id Required");
			validity = false;
		} else if (index.getAuditId() == null) {
			resp.setMessage("Audit Id Required");
			validity = false;
		} else if (index.getComment() == null || index.getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		} else if (index.getCreatedBy() == null || index.getCreatedBy() == "") {
			resp.setMessage("Created By Required");
			validity = false;
		}

		if (validity)
			try {

				// String values = GenerateAuditeeParameter.addDocument(index);

				em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "auditeeSave")
						.setParameter("actionValue", "").execute();
				resp.setCode("Data Saved Successfully");

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

		logger.info("Method : auditeeCommentSave ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> auditorCommentSave(AuditComplianceModel index) {
		logger.info("Method : auditorCommentSave starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (index.getQuesId() == null) {
			resp.setMessage("Question Id Required");
			validity = false;
		} else if (index.getAuditId() == null) {
			resp.setMessage("Audit Id Required");
			validity = false;
		} else if (index.getCreatedBy() == null || index.getCreatedBy() == "") {
			resp.setMessage("Created By Required");
			validity = false;
		}

		if (validity)
			try {

				String values = GenerateAuditorParameter.addAuditorComment(index);

				em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "auditorSave")
						.setParameter("actionValue", values).execute();
				resp.setCode("Data Saved Successfully");

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

		logger.info("Method : auditorCommentSave ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditComplianceModel>>> getViewCommentList(Integer id) {
		logger.info("Method : getViewCommentList starts");

		List<AuditComplianceModel> parkingLot = new ArrayList<AuditComplianceModel>();
		JsonResponse<List<AuditComplianceModel>> resp = new JsonResponse<List<AuditComplianceModel>>();
		try {

			String value = "SET @p_quesId=" + id + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "viewCompliance").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				AuditComplianceModel parking = new AuditComplianceModel(m[0], null, m[1], m[2], null, null, null, null,
						null, null, null, null, null, null, null);
				parkingLot.add(parking);
			}

			resp.setBody(parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AuditComplianceModel>>> response = new ResponseEntity<JsonResponse<List<AuditComplianceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getViewCommentList ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditObservationModel>>> pdfQuestionList(Integer id) {
		logger.info("Method : pdfQuestionList starts");

		List<AuditObservationModel> parkingLot = new ArrayList<AuditObservationModel>();
		JsonResponse<List<AuditObservationModel>> resp = new JsonResponse<List<AuditObservationModel>>();
		try {

			String value = "SET @p_auditId=" + id + ";";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "pdfQuestionList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				AuditObservationModel parking = new AuditObservationModel(m[0], null, null, null, m[1], null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				parkingLot.add(parking);
			}

			resp.setBody(parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AuditObservationModel>>> response = new ResponseEntity<JsonResponse<List<AuditObservationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : pdfQuestionList ends");

		return response;
	}
	/*
	 * @SuppressWarnings("unchecked") public List<DropDownModel> getHotelLogo(String
	 * logoType) { logger.info("Method : getHotelLogo starts");
	 * 
	 * List<DropDownModel> logoList = new ArrayList<DropDownModel>();
	 * 
	 * try { String value = "SET @p_logoType='" + logoType + "';";
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("logoImageRoutines")
	 * .setParameter("actionType", "getHotelLogo") .setParameter("actionValue",
	 * value) .getResultList();
	 * 
	 * for(Object[] m : x) { DropDownModel dropDownModel = new
	 * DropDownModel(m[0],m[1]); logoList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * logger.info("Method : getHotelLogo ends");
	 * 
	 * return logoList; }
	 */

	/**
	 * DAO returns all assigned asset to staff
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditMasterPdfModel>>> getAllAuditDetailsByAuditId(
			DataTableRequest request) {

		logger.info("Method : getAllAuditDetailsByAuditId starts");

		List<AuditMasterPdfModel> bookTable = new ArrayList<AuditMasterPdfModel>();

		String values = "SET @p_auditId='" + request.getParam1() + "';";

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getAuditPdf").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				AuditMasterPdfModel user = new AuditMasterPdfModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8]);
				bookTable.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditMasterPdfModel>> resp = new JsonResponse<List<AuditMasterPdfModel>>();
		resp.setBody(bookTable);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditMasterPdfModel>>> response = new ResponseEntity<JsonResponse<List<AuditMasterPdfModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAllAuditDetailsByAuditId ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getApprovalStage(Integer id, String userId) {
		logger.info("Method : getApprovalStage starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		String value = "SET @p_id=" + id + ", @p_userId='" + userId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getApprovalStage").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getApprovalStage ends");
		return dept;
	}

	@SuppressWarnings("unchecked")
	public List<AuditCommentsModel> getCommentsList(Integer id) {
		logger.info("Method : getCommentsList starts");

		List<AuditCommentsModel> dept = new ArrayList<AuditCommentsModel>();
		String value = "SET @p_id=" + id + ";";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getCommentsList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[2] != null) {
					date = DateFormatter.returnStringDate(m[2]);
				}
				AuditCommentsModel dropDownModel = new AuditCommentsModel(m[0], m[1], date, m[3]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCommentsList ends");
		return dept;
	}

	/*
	 * for get approveAccept
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendRequestRequisition(String id, String createdBy, String document, String comment) {
		logger.info("Method in Dao: sendRequestRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "',@p_document='" + document
					+ "',@p_comment='" + comment + "';";

			em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "requestRequisition")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendRequestRequisition ends");

		return resp;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendResponseRequisition(String id, String createdBy, String document, String comment) {
		logger.info("Method in Dao: sendResponseRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "',@p_document='" + document
					+ "',@p_comment='" + comment + "';";

			em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "responseRequisition")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendResponseRequisition ends");

		return resp;
	}

	/*
	 * for view Document
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> viewDocument(String id) {
		logger.info("Method in Dao: viewDocument starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "viewDocument").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDate(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
					requisitionViewModel.add(dropDownModel);
				}
				resp.setBody(requisitionViewModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RequisitionViewModel>>> response = new ResponseEntity<JsonResponse<List<RequisitionViewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewDocument ends");

		return resp;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> viewReqDocument(String id) {
		logger.info("Method in Dao: viewReqDocument starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "viewReqDocument").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDate(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
					requisitionViewModel.add(dropDownModel);
				}
				resp.setBody(requisitionViewModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RequisitionViewModel>>> response = new ResponseEntity<JsonResponse<List<RequisitionViewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewReqDocument ends");

		return resp;
	}

	/*
	 * for get AuditOrganization
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditOrganization(String audit) {
		logger.info("Method in Dao: getAuditOrganization starts");

		List<DropDownModel> auditInitiateModelList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_audit='" + audit + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getAuditOrg1").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel auditInitiateModel = new DropDownModel(m[0], m[1]);
					auditInitiateModelList.add(auditInitiateModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(auditInitiateModelList);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method in Dao: getAuditOrganization ends");
		return response;
	}

	// save request for IR Status
	public ResponseEntity<JsonResponse<Object>> getIRStatus(AuditMasterModel auditMasterModel) {
		logger.info("Method : getIRStatus starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (auditMasterModel.getAuditAutoGenId() == null) {
			resp.setMessage("Audit Id Required");
			validity = false;
		} else if (auditMasterModel.getDepartment() == null || auditMasterModel.getDepartment() == "") {
			resp.setMessage("Department Id Required");
			validity = false;
		} else if (auditMasterModel.getCreatedBy() == null || auditMasterModel.getCreatedBy() == "") {
			resp.setMessage("Created By Required");
			validity = false;
		} else if (auditMasterModel.getOrganisation() == null || auditMasterModel.getOrganisation() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}

		if (validity)
			try {
				Integer audit = 0;
				String dept = "";
				String document = "";
				String createdBy = "";
				String organization = "";
				if (auditMasterModel.getAuditAutoGenId() != null) {
					audit = auditMasterModel.getAuditAutoGenId();
				}
				if (auditMasterModel.getDepartment() != null || auditMasterModel.getDepartment() == "") {
					dept = auditMasterModel.getDepartment();
				}
				if (auditMasterModel.getGuideLineDoc() != null || auditMasterModel.getGuideLineDoc() == "") {
					document = auditMasterModel.getGuideLineDoc();
				}
				if (auditMasterModel.getCreatedBy() != null || auditMasterModel.getCreatedBy() == "") {
					createdBy = auditMasterModel.getCreatedBy();
				}
				if (auditMasterModel.getOrganisation() != null || auditMasterModel.getOrganisation() == "") {
					organization = auditMasterModel.getOrganisation();
				}
				String value = "SET @p_audit=" + audit + ",@p_department='" + dept + "',@p_document='" + document
						+ "',@p_comment='" + organization + "',@p_createdBy='" + createdBy + "';";

				em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "saveIrReort")
						.setParameter("actionValue", value).execute();
				resp.setCode("Data Saved Successfully");

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

		logger.info("Method : getIRStatus ends");

		return response;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> getIrStatusReportView(String id) {
		logger.info("Method in Dao: getIrStatusReportView starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "IrView").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDate(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
					requisitionViewModel.add(dropDownModel);
				}
				resp.setBody(requisitionViewModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RequisitionViewModel>>> response = new ResponseEntity<JsonResponse<List<RequisitionViewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getIrStatusReportView ends");

		return resp;
	}

	// save request for IR Status
	public ResponseEntity<JsonResponse<Object>> sendIRStatus(AuditMasterModel auditMasterModel) {
		logger.info("Method : sendIRStatus starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (auditMasterModel.getAuditAutoGenId() == null) {
			resp.setMessage("Audit Id Required");
			validity = false;
		} else if (auditMasterModel.getDepartment() == null || auditMasterModel.getDepartment() == "") {
			resp.setMessage("Department Id Required");
			validity = false;
		} else if (auditMasterModel.getCreatedBy() == null || auditMasterModel.getCreatedBy() == "") {
			resp.setMessage("Created By Required");
			validity = false;
		} else if (auditMasterModel.getOrganisation() == null || auditMasterModel.getOrganisation() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}

		if (validity)
			try {
				Integer audit = 0;
				String dept = "";
				String document = "";
				String createdBy = "";
				String organization = "";
				if (auditMasterModel.getAuditAutoGenId() != null) {
					audit = auditMasterModel.getAuditAutoGenId();
				}
				if (auditMasterModel.getDepartment() != null || auditMasterModel.getDepartment() == "") {
					dept = auditMasterModel.getDepartment();
				}
				if (auditMasterModel.getGuideLineDoc() != null || auditMasterModel.getGuideLineDoc() == "") {
					document = auditMasterModel.getGuideLineDoc();
				}
				if (auditMasterModel.getCreatedBy() != null || auditMasterModel.getCreatedBy() == "") {
					createdBy = auditMasterModel.getCreatedBy();
				}
				if (auditMasterModel.getOrganisation() != null || auditMasterModel.getOrganisation() == "") {
					organization = auditMasterModel.getOrganisation();
				}
				String value = "SET @p_audit=" + audit + ",@p_department='" + dept + "',@p_document='" + document
						+ "',@p_comment='" + organization + "',@p_createdBy='" + createdBy + "';";

				em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "savefinIrReort")
						.setParameter("actionValue", value).execute();
				resp.setCode("Data Saved Successfully");

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

		logger.info("Method : sendIRStatus ends");

		return response;
	}

	/*
	 * for get sendDraft
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendDraft(String id, String createdBy, String document, String comment) {
		logger.info("Method in Dao: sendDraft starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "',@p_document='" + document
					+ "',@p_comment='" + comment + "';";

			em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "sendDraft")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendDraft ends");

		return resp;
	}

	/*
	 * for view Document
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> getDraft(String id) {
		logger.info("Method in Dao: getDraft starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getDraft").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDate(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
					requisitionViewModel.add(dropDownModel);
				}
				resp.setBody(requisitionViewModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RequisitionViewModel>>> response = new ResponseEntity<JsonResponse<List<RequisitionViewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDraft ends");

		return resp;
	}

	/*
	 * for get sendCompliance
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendCompliance(String id, String createdBy, String document, String comment) {
		logger.info("Method in Dao: sendCompliance starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "',@p_document='" + document
					+ "',@p_comment='" + comment + "';";

			em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "sendCompliance")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendCompliance ends");

		return resp;
	}

	/*
	 * for get sendDraft
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendDraftPara(String id, String createdBy, String document, String comment) {
		logger.info("Method in Dao: sendDraftPara starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "',@p_document='" + document
					+ "',@p_comment='" + comment + "';";

			em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "sendDraftPara")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendDraftPara ends");

		return resp;
	}

	/*
	 * for view Document
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> getDraftPara(String id) {
		logger.info("Method in Dao: getDraftPara starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getDraftPara").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDate(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
					requisitionViewModel.add(dropDownModel);
				}
				resp.setBody(requisitionViewModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RequisitionViewModel>>> response = new ResponseEntity<JsonResponse<List<RequisitionViewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDraftPara ends");

		return resp;
	}

	/*
	 * for get sendCompliance
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendParaCompliance(String id, String createdBy, String document, String comment) {
		logger.info("Method in Dao: sendParaCompliance starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "',@p_document='" + document
					+ "',@p_comment='" + comment + "';";

			em.createNamedStoredProcedureQuery("auditMasterRoutines").setParameter("actionType", "sendParaCompliance")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendParaCompliance ends");

		return resp;
	}

	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditMasterModel>>> getAllTransAuditMaster(DataTableRequest request) {

		logger.info("Method in Dao: getAllTransAuditMaster starts");

		List<AuditMasterModel> auditInitiateModelList = new ArrayList<AuditMasterModel>();

		if (request.getParam2() != null && request.getParam2() != "") {
			request.setParam2(DateFormatter.getStringDate(request.getParam2()));
		}
		if (request.getParam3() != null && request.getParam3() != "") {
			request.setParam3(DateFormatter.getStringDate(request.getParam3()));
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getAllTransAuditMaster").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object fromDate = null;
					fromDate = DateFormatter.returnStringDate(m[10]);
					Object toDate = null;
					toDate = DateFormatter.returnStringDate(m[11]);
					AuditMasterModel auditInitiateModel = new AuditMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], fromDate, toDate, m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null,null);
					auditInitiateModelList.add(auditInitiateModel);

				}

				if (x.get(0).length > 20) {
					BigInteger t = (BigInteger) x.get(0)[20];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditMasterModel>> resp = new JsonResponse<List<AuditMasterModel>>();
		resp.setBody(auditInitiateModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditMasterModel>>> response = new ResponseEntity<JsonResponse<List<AuditMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllTransAuditMaster ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSubCoordList() {
		logger.info("Method : getSubCoordList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getSubCoordList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSubCoordList ends");

		return dept;
	}

}
