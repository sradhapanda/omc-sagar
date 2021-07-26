/**
 * 
 */
package nirmalya.aatithya.restmodule.audit.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import nirmalya.aatithya.restmodule.audit.model.AuditCommentsModel;
import nirmalya.aatithya.restmodule.audit.model.AuditComplianceModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterPdfModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.DraftListModel;
import nirmalya.aatithya.restmodule.audit.model.DraftModel;
import nirmalya.aatithya.restmodule.audit.model.PersonListModel;
import nirmalya.aatithya.restmodule.audit.model.PersonModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuidtReportModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditQuestionParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditorParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateRequestRequisitionDocumentParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestStatutaryAuditDao {

	Logger logger = LoggerFactory.getLogger(RestStatutaryAuditDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditMasterModel>>> getAllStatutaryAudit(DataTableRequest request) {

		logger.info("Method in Dao: getAllStatutaryAudit starts");

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

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getAllStatutaryAudit").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object fromDate = null;
					if (m[10] != null) {
						fromDate = DateFormatter.returnStringDate(m[10]);
					}
					Object toDate = null;
					if (m[11] != null) {
						toDate = DateFormatter.returnStringDate(m[11]);
					}
					AuditMasterModel auditInitiateModel = new AuditMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], fromDate, toDate, m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							null, m[20], m[21], m[22], m[23], null, null, null, null, null, null, m[24], null, null,
							null, null, null, null, null, null, null, null, null, null,null);
					auditInitiateModelList.add(auditInitiateModel);

				}

				if (x.get(0).length > 25) {
					BigInteger t = (BigInteger) x.get(0)[25];
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

		logger.info("Method in Dao: getAllStatutaryAudit ends");

		return response;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> fowardedStatuReq(List<RequisitionViewModel> requisitionViewModel) {

		logger.info("Method in Dao: fowardedStatuReq starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = GenerateRequestRequisitionDocumentParameter.addForwardReq(requisitionViewModel);
			System.out.println(value);
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "fowardedReq").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
					resp.setBody(dropDownModel);
				}

			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (requisitionViewModel.get(0).getPersonCc() != null && requisitionViewModel.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
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

		if (resp.getMessage() == null) {
			resp.setMessage("success");
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: fowardedStatuReq ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> fowardedStatuPom(List<RequisitionViewModel> requisitionViewModel) {

		logger.info("Method in Dao: fowardedStatuPom starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = GenerateRequestRequisitionDocumentParameter.addForwardReq(requisitionViewModel);
			System.out.println(value);
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "fowardedPom").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
					resp.setBody(dropDownModel);
				}

			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (requisitionViewModel.get(0).getPersonCc() != null && requisitionViewModel.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
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

		if (resp.getMessage() == null) {
			resp.setMessage("success");
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: fowardedStatuPom ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> forwardIRS(List<RequisitionViewModel> requisitionViewModel) {

		logger.info("Method in Dao: forwardIRS starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = GenerateRequestRequisitionDocumentParameter.addForwardReq(requisitionViewModel);
			System.out.println(value);
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "forwardIRS").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
					resp.setBody(dropDownModel);
				}

			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (requisitionViewModel.get(0).getPersonCc() != null && requisitionViewModel.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
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

		if (resp.getMessage() == null) {
			resp.setMessage("success");
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardIRS ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> forwardPara(List<RequisitionViewModel> requisitionViewModel) {

		logger.info("Method in Dao: forwardPara starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = GenerateRequestRequisitionDocumentParameter.addForwardReq(requisitionViewModel);
			System.out.println(value);
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "forwardPara").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
					resp.setBody(dropDownModel);
				}

			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (requisitionViewModel.get(0).getPersonCc() != null && requisitionViewModel.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
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

		if (resp.getMessage() == null) {
			resp.setMessage("success");
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardPara ends");
		System.out.println(response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<AuditObservationModel> getStatuQuestionList(Integer id, String deptId, String sectionId,
			String userId) {
		logger.info("Method : getStatuQuestionList starts");

		List<AuditObservationModel> ques = new ArrayList<AuditObservationModel>();
		String value = "SET @p_id=" + id + ", @p_dept='" + deptId + "', @p_section='" + sectionId + "',@userId='"
				+ userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getStatuQuestionList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object DateString = null;
				if (m[24] != null) {
					DateString = (String) DateFormatter.returnStringDateTime(m[24]);
				}
				AuditObservationModel dropDownModel = new AuditObservationModel(m[0], m[1], m[2], null, m[3], m[4],
						m[5], null, m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19], m[20], m[21], m[22], null, m[27], m[23], DateString, null, m[26], m[25], null,
						null, null, null, null, null);
				ques.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStatuQuestionList ends");
		return ques;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOnlyQuestions(String id) {
		logger.info("Method : getOnlyQuestions starts");

		List<DropDownModel> ques = new ArrayList<DropDownModel>();
		String value = "SET @p_id='" + id + "';";
		System.out.println("value for getOnlyQuestions " + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getOnlyQuestions").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				ques.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getOnlyQuestions ends");
		System.out.println("ques in getOnlyQuestions " + ques);
		return ques;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOnlyIRS(String id) {
		logger.info("Method : getOnlyIRS starts");

		List<DropDownModel> ques = new ArrayList<DropDownModel>();
		String value = "SET @p_id='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getOnlyIRS").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				ques.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getOnlyIRS ends");
		System.out.println(ques);
		return ques;
	}

	@SuppressWarnings("unchecked")
	public List<AuditObservationModel> getDeviationQuestionList(Integer id, String deptId, String sectionId,
			String userId) {
		logger.info("Method : getDeviationQuestionList starts");

		List<AuditObservationModel> ques = new ArrayList<AuditObservationModel>();
		String value = "SET @p_id=" + id + ", @p_dept='" + deptId + "', @p_section='" + sectionId + "',@userId='"
				+ userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getDeviationQuesList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object DateString = null;
				if (m[24] != null) {
					DateString = (String) DateFormatter.returnStringDateTime(m[24]);
				}
				AuditObservationModel dropDownModel = new AuditObservationModel(m[0], m[1], m[2], null, m[3], m[4],
						m[5], null, m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19], m[20], m[21], m[22], null, m[27], m[23], DateString, null, m[26], m[25], m[30],
						m[28], m[29], m[31], null, null);
				ques.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDeviationQuestionList ends");
		return ques;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddStatuQuestion(
			List<AuditObservationModel> auditObservationModel) {

		logger.info("Method in restAddStatuQuestion starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AuditObservationModel a : auditObservationModel) {
			if (a.getQuestion() == null || a.getQuestion() == "") {
				resp.setMessage("Question Can not beleft Blank.");
			}

		}
		if (validity)
			try {
				List<DropDownModel> summery = new ArrayList<DropDownModel>();
				for (AuditObservationModel l : auditObservationModel) {
					String values = GenerateAuditQuestionParam.getQuestionParam(l);

					@SuppressWarnings("unchecked")
					List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
							.setParameter("actionType", "addQuestion").setParameter("actionValue", values)
							.getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
							summery.add(dropDownModel);
							resp.setBody(summery);

						}
					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				// @SuppressWarnings("unchecked");
				if (auditObservationModel.get(0).getPersonCc() != null
						&& auditObservationModel.get(0).getPersonCc() != "") {
					String values = GenerateAuditQuestionParam.getQuestionParam(auditObservationModel.get(0));
					@SuppressWarnings("unchecked")

					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in restAddStatuQuestion ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddStatuIrs(List<AuditObservationModel> auditObservationModel) {

		logger.info("Method in restAddStatuIrs starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AuditObservationModel a : auditObservationModel) {
			if (a.getQuestion() == null || a.getQuestion() == "") {
				resp.setMessage("IRS Can not beleft Blank.");
			}

		}
		if (validity)
			try {
				List<DropDownModel> summery = new ArrayList<DropDownModel>();
				for (AuditObservationModel l : auditObservationModel) {
					String values = GenerateAuditQuestionParam.getQuestionParam(l);
					@SuppressWarnings("unchecked")
					List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "addIRS").setParameter("actionValue", values).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
							summery.add(dropDownModel);
							resp.setBody(summery);

						}
					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (auditObservationModel.get(0).getPersonCc() != null
						&& auditObservationModel.get(0).getPersonCc() != "") {
					String values = GenerateAuditQuestionParam.getQuestionParam(auditObservationModel.get(0));
					@SuppressWarnings("unchecked")
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in restAddStatuIrs ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddStatuPara(List<AuditObservationModel> auditObservationModel) {

		logger.info("Method in restAddStatuPara starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AuditObservationModel a : auditObservationModel) {
			if (a.getQuestion() == null || a.getQuestion() == "") {
				resp.setMessage("IRS Can not beleft Blank.");
			}

		}
		if (validity)
			try {
				List<DropDownModel> summery = new ArrayList<DropDownModel>();
				for (AuditObservationModel l : auditObservationModel) {
					String values = GenerateAuditQuestionParam.getQuestionParam(l);
					@SuppressWarnings("unchecked")
					List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "addPARA").setParameter("actionValue", values).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
							summery.add(dropDownModel);
							resp.setBody(summery);

						}
					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (auditObservationModel.get(0).getPersonCc() != null
						&& auditObservationModel.get(0).getPersonCc() != "") {
					String values = GenerateAuditQuestionParam.getQuestionParam(auditObservationModel.get(0));
					@SuppressWarnings("unchecked")
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in restAddStatuPara ends");
		System.out.println(response);
		return response;
	}

	
	public ResponseEntity<JsonResponse<Object>> restAddnewPara(List<AuditObservationModel> auditObservationModel) {

		logger.info("Method in restAddnewPara starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AuditObservationModel a : auditObservationModel) {
			if (a.getQuestion() == null || a.getQuestion() == "") {
				resp.setMessage("IRS Can not beleft Blank.");
			}

		}
		if (validity)
			try {
				List<DropDownModel> summery = new ArrayList<DropDownModel>();
				for (AuditObservationModel l : auditObservationModel) {
					String values = GenerateAuditQuestionParam.getQuestionParam(l);
					System.out.println("values 123 "+values);
					@SuppressWarnings("unchecked")
					List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "addDraftNewPARA").setParameter("actionValue", values).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
							summery.add(dropDownModel);
							resp.setBody(summery);

						}
					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (auditObservationModel.get(0).getPersonCc() != null
						&& auditObservationModel.get(0).getPersonCc() != "") {
					String values = GenerateAuditQuestionParam.getQuestionParam(auditObservationModel.get(0));
					@SuppressWarnings("unchecked")
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in restAddnewPara ends");
		System.out.println(response);
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> restforPara(List<AuditObservationModel> auditObservationModel) {
		
		logger.info("Method in restforPara starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		for (AuditObservationModel a : auditObservationModel) {
			if (a.getQuestion() == null || a.getQuestion() == "") {
				resp.setMessage("IRS Can not beleft Blank.");
			}
			
		}
		if (validity)
			try {
				List<DropDownModel> summery = new ArrayList<DropDownModel>();
				for (AuditObservationModel l : auditObservationModel) {
					String values = GenerateAuditQuestionParam.getQuestionParam(l);
					System.out.println("values 123 "+values);
					@SuppressWarnings("unchecked")
					List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "addNewPARA").setParameter("actionValue", values).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
							summery.add(dropDownModel);
							resp.setBody(summery);
							
						}
					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (auditObservationModel.get(0).getPersonCc() != null
						&& auditObservationModel.get(0).getPersonCc() != "") {
					String values = GenerateAuditQuestionParam.getQuestionParam(auditObservationModel.get(0));
					@SuppressWarnings("unchecked")
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m : x1) {
							
							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}
						
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
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method in restforPara ends");
		System.out.println(response);
		return response;
	}
	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * approveObsInStatutaryAudit(List<AuditObservationModel> observation) {
	 * logger.info("Method : approveObsInTransAudit starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode(""); for
	 * (AuditObservationModel l : observation) { if (l.getQuesId() == null) {
	 * validity = false; resp.setCode("Field Validation Error");
	 * resp.setMessage("Question Required"); break; } }
	 * 
	 * if (validity) { try { String values =
	 * GenerateObservationParameter.approveObservationParam(observation);
	 * 
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "apprObsStaAudit") .setParameter("actionValue",
	 * values).execute();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); } } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : approveObsInTransAudit ends"); return response; }
	 */
	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * forwardStatutaryToApprove(List<AuditObservationModel> observation) {
	 * logger.info("Method : forwardStatutaryToApprove starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode(""); for
	 * (AuditObservationModel l : observation) { if (l.getQuesId() == null) {
	 * validity = false; resp.setCode("Field Validation Error");
	 * resp.setMessage("Question Required"); break; } else if (l.getObsType() ==
	 * null) { validity = false; resp.setCode("Field Validation Error");
	 * resp.setMessage("Observation Type Required"); break; } else if
	 * (l.getSeverity() == null) { validity = false;
	 * resp.setCode("Field Validation Error"); resp.setMessage("Severity Required");
	 * break; } }
	 * 
	 * if (validity) { try { String values =
	 * GenerateObservationParameter.forwardToApproveObservationParam(observation);
	 * 
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "forwardStatToApprv") .setParameter("actionValue",
	 * values).execute();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); } } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : forwardStatutaryToApprove ends"); return response; }
	 */
	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * addStatuObservation(List<AuditObservationModel> observation) {
	 * logger.info("Method : addStatuObservation starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode(""); for
	 * (AuditObservationModel l : observation) { if (l.getObservation() == null ||
	 * l.getObservation() == "") { validity = false;
	 * resp.setCode("Field Validation Error");
	 * resp.setMessage("Observation Required"); break; } else if (l.getObsType() ==
	 * null) { validity = false; resp.setCode("Field Validation Error");
	 * resp.setMessage("Observation Type Required"); break; } }
	 * 
	 * if (validity) { try { String values =
	 * GenerateObservationParameter.addObservationParam(observation);
	 * 
	 * em.createNamedStoredProcedureQuery("statutaryRoutines")
	 * .setParameter("actionType",
	 * "addStatuObservation").setParameter("actionValue", values) .execute();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); } } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : addStatuObservation ends"); return response; }
	 */

	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * addStatuDevObservation(List<AuditObservationModel> observation) {
	 * logger.info("Method : addStatuDevObservation starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode(""); for
	 * (AuditObservationModel l : observation) { if (l.getObservation() == null ||
	 * l.getObservation() == "") { validity = false;
	 * resp.setCode("Field Validation Error");
	 * resp.setMessage("Observation Required"); break; } else if (l.getObsType() ==
	 * null) { validity = false; resp.setCode("Field Validation Error");
	 * resp.setMessage("Observation Type Required"); break; } }
	 * 
	 * if (validity) { try { String values =
	 * GenerateObservationParameter.addObservationParam(observation);
	 * 
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "addDevObservation") .setParameter("actionValue",
	 * values).execute();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); } } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : addStatuDevObservation ends"); return response; }
	 */
	/*
	 * for all audit master
	 */
	public ResponseEntity<JsonResponse<Object>> forwardStatuObs(List<RequisitionViewModel> obj) {

		logger.info("Method in Dao: forwardStatuObs starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			List<DropDownModel> summery = new ArrayList<DropDownModel>();
			String values = GenerateRequestRequisitionDocumentParameter.addForwardObservation(obj);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "forwardStatuObs").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);
					resp.setBody(summery);

				}
			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
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

		if (resp.getMessage() == null || resp.getMessage() == "") {
			resp.setMessage("success");

		} else {
			resp.setCode(resp.getMessage());
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardStatuObs ends");
		System.out.println(response);
		return response;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * auditeeStatuCommentSave(List<AuditComplianceModel> index) {
	 * logger.info("Method : auditeeStatuCommentSave starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode("");
	 * 
	 * 
	 * if (index.get(0).getComment() == null || index.get(0).getComment() == "") {
	 * resp.setMessage("Comment Required"); validity = false; }
	 * 
	 * 
	 * if (validity) try {
	 * 
	 * String values = GenerateAuditeeParameter.addDocument(index);
	 * 
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "statuAuditeeSave") .setParameter("actionValue",
	 * values).execute(); resp.setCode("Data Saved Successfully");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : auditeeStatuCommentSave ends"); return response; }
	 */

	@SuppressWarnings("unchecked")
	public List<AuditComplianceModel> getStatuViewCommentList(Integer id, String userId) {
		logger.info("Method : getStatuViewCommentList starts");

		List<AuditComplianceModel> compliance = new ArrayList<AuditComplianceModel>();
		try {

			String value = "SET @p_quesId='" + id + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "viewStatuCompliance").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[4] != null) {
						date = DateFormatter.returnStringDateTime(m[5]);
					}

					AuditComplianceModel parking = new AuditComplianceModel(m[0], m[1], m[2], m[3], m[4], null, null,
							null, null, date, m[6], m[8], m[9], m[7], null);
					compliance.add(parking);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStatuViewCommentList ends");
		return compliance;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public List<RequisitionViewModel> getStatuReqDocument(String id, String userId) {
		logger.info("Method in Dao: viewStatuReqDocument starts");

		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();

		try {
			String value = "SET @p_id='" + id + "',@p_userId='" + userId + "';";
			//System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "viewReqDocument").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDateTime(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14].toString(), m[15],null,m[16],m[17],m[18],m[19]);
					String[] commaSeparatedArr = dropDownModel.getPersonCcId().split(",");
					 dropDownModel.setPersonToId(Arrays.stream(commaSeparatedArr).collect(Collectors.toList()));
					requisitionViewModel.add(dropDownModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : viewStatuReqDocument ends");
		System.out.println("requisitionViewModel" + requisitionViewModel);
		return requisitionViewModel;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReqDocList(String id, String userId) {
		logger.info("Method in Dao: getReqDocList starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_id='" + id + "',@p_userId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "viewDocList").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getReqDocList ends");

		return dropDownModel;
	}

	/*
	 * for get approveAccept
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> sendStatuRequestRequisition(List<RequisitionViewModel> obj) {
		logger.info("Method in Dao: sendStatuRequestRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;

		if (obj.get(0).getComment() == null || obj.get(0).getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}

		if (validity)

			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();

				String value = GenerateRequestRequisitionDocumentParameter.addDocument(obj);
				System.out.println("PARAMS : "+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "requestRequisition").setParameter("actionValue", value)
						.getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						System.out.println("hiiiiiiiiiiii "+Arrays.toString(m));
						if(m[0] != null) {
							m[0] = m[0].toString();
						}
						if(m[2] != null) {
							m[2] = m[2].toString();
						}
						DropDownModel data = new DropDownModel(m[0], m[1],m[2]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
					}

				}
				if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							
							//System.out.println("data1 "+data1);
							
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		// resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendStatuRequestRequisition ends");
		
		System.out.println("response "+response);
		return response;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendStatuResponseRequisition(List<RequisitionViewModel> obj) {
		logger.info("Method in Dao: sendResponseRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		Boolean validity = true;
		/*
		 * if (obj.get(0).getComment() == null || obj.get(0).getComment() == "") {
		 * resp.setMessage("Comment Required"); validity = false; }
		 */
		if (validity)

			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				String value = GenerateRequestRequisitionDocumentParameter.addDocument(obj);
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "responseRequisition").setParameter("actionValue", value)
						.getResultList();

				if (!x.isEmpty()) {
					for (Object[] m : x) {

						DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
					}

				}
				if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
					List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

					}
				}
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

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditObservationModel>>> pdfStatuQuestionList(Integer id) {
		logger.info("Method : pdfStatuQuestionList starts");

		List<AuditObservationModel> parkingLot = new ArrayList<AuditObservationModel>();
		JsonResponse<List<AuditObservationModel>> resp = new JsonResponse<List<AuditObservationModel>>();
		try {

			String value = "SET @p_auditId=" + id + ";";

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
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

		logger.info("Method : pdfStatuQuestionList ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> approveObsInStatuAudit(List<RequisitionViewModel> observation) {
		logger.info("Method : approveObsInStatuAudit starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RequisitionViewModel l : observation) {
			/*
			 * if (l.getQuesId() == null) { validity = false;
			 * resp.setCode("Field Validation Error"); resp.setMessage("Question Required");
			 * break; }
			 */
		}

		if (validity) {
			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				String value = GenerateRequestRequisitionDocumentParameter.addForwardObservation(observation);

				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "apprObsStaAudit").setParameter("actionValue", value)
						.getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {

						DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
					}

				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (observation.get(0).getPersonCc() != null && observation.get(0).getPersonCc() != "") {
					@SuppressWarnings("unchecked")
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : approveObsInStatuAudit ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStatuApprovalStage(Integer id, String userId) {
		logger.info("Method : getStatuApprovalStage starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		String value = "SET @p_id=" + id + ", @p_userId='" + userId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getApprovalStage").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
					dept.add(dropDownModel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStatuApprovalStage ends");
		return dept;
	}

	/**
	 * DAO returns all assigned asset to staff
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditMasterPdfModel>>> getAllStatuAuditDetailsByAuditId(
			DataTableRequest request) {

		logger.info("Method : getAllStatuAuditDetailsByAuditId starts");

		List<AuditMasterPdfModel> bookTable = new ArrayList<AuditMasterPdfModel>();

		String values = "SET @p_auditId='" + request.getParam1() + "';";

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
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

		logger.info("Method : getAllStatuAuditDetailsByAuditId ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<AuditCommentsModel> getStatuCommentsList(Integer id) {
		logger.info("Method : getCommentsList starts");

		List<AuditCommentsModel> dept = new ArrayList<AuditCommentsModel>();
		String value = "SET @p_id=" + id + ";";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
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
	 * for all audit master
	 */
	public ResponseEntity<JsonResponse<Object>> forwardStatuReply(List<RequisitionViewModel> obj) {

		logger.info("Method in Dao: forwardStatuReply starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			String values = GenerateRequestRequisitionDocumentParameter.addCompliance(obj);

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "forwardStatuReply").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
					resp.setBody(dropDownModel);
				}

			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
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

		if (resp.getMessage() == null || resp.getMessage() == "") {
			resp.setMessage("success");
		} else {
			resp.setCode(resp.getMessage());
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardStatuReply ends");
		System.out.println(response);
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> concernAudicomment(List<RequisitionViewModel> index) {
		logger.info("Method : concernAudicomment starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		/*
		 * if (index.get(0).getComment() == null || index.get(0).getComment()== "") {
		 * resp.setMessage("Comment Required"); validity = false; }
		 */

		if (validity)
			try {

				String values = GenerateRequestRequisitionDocumentParameter.addCompliance(index);

				em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "concernAudicomment")
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

		logger.info("Method : concernAudicomment ends");
		return response;
	}

	/*
	 * for all audit master
	 */
	public ResponseEntity<JsonResponse<Object>> forwardToCo(String id, String createdBy) {

		logger.info("Method in Dao: forwardToCo starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "forwardToCo")
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

		if (resp.getBody() == null) {
			resp.setMessage("success");
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardToCo ends");

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
		}
		if (validity)
			try {

				String values = GenerateAuditorParameter.addAuditorComment(index);

				em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "auditorSave")
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

	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> cordinatorforwardToAuditor(List<RequisitionViewModel> obj) {

		logger.info("Method in Dao: cordinatorforwardToAuditor starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			// String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" +
			// obj.getCreatedBy() + "',@p_comment='"+obj.getComment()+"';";
			String value = GenerateRequestRequisitionDocumentParameter.addForwardObservation(obj);
			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "forwardToAuditor")
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

		if (resp.getBody() == null) {
			resp.setMessage("success");
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: cordinatorforwardToAuditor ends");

		return response;
	}

	/*
	 * for forward To Concern
	 */
	public ResponseEntity<JsonResponse<Object>> forwardToCrn(List<RequisitionViewModel> obj) {

		logger.info("Method in Dao: forwardToCrn starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			String value = GenerateRequestRequisitionDocumentParameter.addDocument(obj);
System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "forwardToCrn").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
					resp.setBody(dropDownModel);
				}

			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}

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

		if (resp.getMessage() == "" || resp.getMessage() == null) {
			resp.setMessage("success");
		} else {
			resp.setCode(resp.getCode());
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardToCrn ends");
		return response;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> reqForwardBysec(List<RequisitionViewModel> obj) {
		logger.info("Method in Dao: reqForwardBysec starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		/*
		 * if (obj.get(0).getComment() == null || obj.get(0).getComment() == "") {
		 * resp.setMessage("Comment Required"); validity = false; }
		 */
		if (validity)

			try {
System.out.println("obj 123  "+obj);
				String value = GenerateRequestRequisitionDocumentParameter.addDocument(obj);
				System.out.println(value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "reqForwardBysec").setParameter("actionValue", value)
						.getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
						summery.add(dropDownModel);

					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

					}
				}
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
		resp.setBody(summery);
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: reqForwardBysec ends");

		return response;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> rejectReq(List<RequisitionViewModel> obj) {

		logger.info("Method in Dao: rejectReq starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;

		if (obj.get(0).getComment() == null || obj.get(0).getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}
		if (validity) {

			try {
				String value = GenerateRequestRequisitionDocumentParameter.addDocument(obj);
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "rejectReq").setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
						summery.add(dropDownModel);
						resp.setBody(summery);
					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
					@SuppressWarnings("unchecked")
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

					}

				}
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

		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: rejectReq ends");
		System.out.println(response);
		return response;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * saveRequisitionComment(RequisitionViewModel summery) {
	 * logger.info("Method : saveRequisitionComment starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
	 * 
	 * try { Integer id = summery.getAuditId(); String summery1 =
	 * summery.getComment(); String value = "SET @p_summery='" + summery1 +
	 * "',@p_id='" + id + "'";
	 * 
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "saveRequisitionComment") .setParameter("actionValue",
	 * value).execute();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : saveRequisitionComment ends"); return response; }
	 */

	public ResponseEntity<JsonResponse<Object>> saveRequisitionComment(RequisitionViewModel summery) {
		logger.info("Method : saveRequisitionComment starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {
			Integer id = summery.getAuditId();
			String summery1 = summery.getComment().replace("\n", "");

			// String[] metaCharacters =
			// {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&","%","'"};

			String value = "SET @p_id='" + id + "', @p_summery='" + summery1 + "';";

			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "saveRequisitionComment")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : saveRequisitionComment ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionComment(String id) {
		logger.info("Method : getRequisitionComment starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_id='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getRequisitionComment").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getRequisitionComment ends");

		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReqResponse(String id) {
		logger.info("Method : getReqResponse starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_id='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getReqResponse").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getReqResponse ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveResponse(RequisitionViewModel obj) {
		logger.info("Method : saveResponse starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {

			String value = "SET @p_id='" + obj.getInitiatedId() + "',@p_summery='" + obj.getComment() + "';";

			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "saveResponse")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : saveResponse ends");
		return response;
	}

	/*
	 * // Save Comment Replay public ResponseEntity<JsonResponse<Object>>
	 * saveSecComment(List<AuditComplianceModel> index) {
	 * logger.info("Method : saveSecComment starts"); Boolean validity = true;
	 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
	 * 
	 * 
	 * if (index.get(0).getComment() == null || index.get(0).getComment() == "") {
	 * resp.setMessage("Comment Required"); validity = false; }
	 * 
	 * if (validity) { try {
	 * 
	 * String value = GenerateAuditeeParameter.addDocument(index); ;
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "saveSecComment") .setParameter("actionValue",
	 * value).execute();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); } } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : saveSecComment ends"); return response; }
	 */

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSecComment(String queId) {
		logger.info("Method : getSecComment starts");
		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_quesId='" + queId + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getSecComment").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSecComment ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveObsComment(AuditComplianceModel index) {
		logger.info("Method : saveObsComment starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {

			String value = GenerateAuditorParameter.addObsComment(index);
			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "saveObsComment")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : saveObsComment ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getObsComment(String queId) {
		logger.info("Method : getObsComment starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {

			String value = "SET @p_quesId='" + queId + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getObsComment").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getObsComment ends");

		return response;
	}
	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * saveConAudiComment(List<AuditComplianceModel> index) {
	 * logger.info("Method : saveConAudiComment starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
	 * 
	 * try {
	 * 
	 * String value = GenerateAuditeeParameter.addDocument(index);
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "saveConAudiComment") .setParameter("actionValue",
	 * value).execute();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : saveConAudiComment ends"); return response; }
	 */

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getConAudiComment(String queId) {
		logger.info("Method : getConAudiComment starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_quesId='" + queId + "';";
			;
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getConAudiComment").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getConAudiComment ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> auditeeStatuCommentconsernsave(List<RequisitionViewModel> index) {
		logger.info("Method : auditeeStatuCommentconsernsave starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		/*
		 * if (index.get(0).getComment() == null || index.get(0).getComment() == "") {
		 * resp.setMessage("Comment Required"); validity = false; }
		 */

		if (validity)
			try {
				List<DropDownModel> summery = new ArrayList<DropDownModel>();
				String values = GenerateRequestRequisitionDocumentParameter.addCompliance(index);

				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "auditeeConsernSave").setParameter("actionValue", values)
						.getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
						summery.add(dropDownModel);
						resp.setBody(summery);
					}
				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if (index.get(0).getPersonCc() != null && index.get(0).getPersonCc() != "") {
					@SuppressWarnings("unchecked")
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : auditeeStatuCommentconsernsave ends");
		System.out.println(response);
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectResponse(List<RequisitionViewModel> obj) {
		logger.info("Method : rejectResponse starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {

			@SuppressWarnings("unchecked")

			String values = GenerateRequestRequisitionDocumentParameter.addDocument(obj);

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "rejectResponse").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);
					resp.setBody(summery);
				}
			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
				if (!x1.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (resp.getMessage() == null || resp.getMessage() == "") {
			resp.setMessage("success");
		} else {
			resp.setCode(resp.getMessage());
		}
		// resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : rejectResponse ends");
System.out.println(response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<PersonListModel> getPersonList() {
		logger.info("Method : getPersonList starts");
		List<PersonListModel> dept = new ArrayList<PersonListModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getPersonList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				PersonListModel dropDownModel = new PersonListModel(m[0], m[1], m[2]);
				dept.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPersonList ends");
		System.out.println(dept);
		return dept;
	}

	/*
	 * for all audit master
	 */
	public ResponseEntity<JsonResponse<Object>> forwardToPerson(List<RequisitionViewModel> obj) {

		logger.info("Method in Dao: forwardToPerson starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			/*
			 * String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" +
			 * obj.getCreatedBy() + "',@p_comment='" + obj.getComment() + "';";
			 */
			String values = GenerateRequestRequisitionDocumentParameter.addForwardObservation(obj);
			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "forwardToPerson")
					.setParameter("actionValue", values).execute();

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

		if (resp.getMessage() == null || resp.getMessage() == "") {
			resp.setMessage("success");
		} else {
			resp.setCode(resp.getMessage());
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardToPerson ends");

		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectObsBySec(AuditComplianceModel obj) {
		logger.info("Method : rejectObsBySec starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {

			@SuppressWarnings("unchecked")

			String value = "SET @quesId='" + obj.getQuesId() + "',@p_id='" + obj.getAuditId() + "',@p_comment='"
					+ obj.getComment() + "',@p_createdBy='" + obj.getCreatedBy() + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "rejectObsBySec").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : rejectObsBySec ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> rejectObsByCoordinator(RequisitionViewModel obj) {
		logger.info("Method : rejectObsByCoordinator starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity) {

			try {

				String value = "SET @p_id='" + obj.getAuditId() + "',@p_comment='" + obj.getComment()
						+ "',@p_createdBy='" + obj.getCreatedby() + "';";

				em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "rejectObsByCoordinator").setParameter("actionValue", value)
						.execute();

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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : rejectObsByCoordinator ends");

		return response;
	}

	// my view request dao
	public ResponseEntity<JsonResponse<Object>> addDocument(List<RequisitionViewModel> request) {
		logger.info("Method : addDocument starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity) {
			try {
				String values = "";
				for (RequisitionViewModel m : request) {
					values = GenerateAuditMasterParameter.addViewRequest(m);
				}

				em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "addViewRequest")
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
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addDocument ends");
		return response;
	}

	// Edit Response################
	public ResponseEntity<JsonResponse<Object>> addDocuments(List<RequisitionViewModel> request) {
		logger.info("Method : addStatuObservation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity) {
			try {
				String values = "";
				for (RequisitionViewModel m : request) {
					values = GenerateAuditMasterParameter.addViewRequest(m);
				}

				em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "addViewRequest")
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
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addStatuObservation ends");
		return response;
	}

	// ######## Edit Response #########
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> editStatuReqDocument(String id, String userId) {
		logger.info("Method in Dao: editStatuReqDocument starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "',@p_userId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "EditviewReqDocument").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDateTime(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							m[6], null, null, null, null, null, null, null, null, null, null, null, null, null,null);
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

		logger.info("Method : editStatuReqDocument ends");

		return resp;
	}

	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> forwardToAuditorDirect(String id, String createdBy) {

		logger.info("Method in Dao: forwardToAuditorDirect starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "forwardToAuditor")
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

		if (resp.getBody() == null) {
			resp.setMessage("success");
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardToAuditorDirect ends");

		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectObs(AuditComplianceModel obj) {
		logger.info("Method : rejectObs starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_id='" + obj.getAuditId() + "',@p_comment='" + obj.getComment() + "',@p_createdBy='"
					+ obj.getCreatedBy() + "';";

			// @SuppressWarnings("unchecked")
			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "rejectObs")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : rejectObs ends");

		return response;
	}

	/*
	 * for get Person List
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PersonModel>>> getPersonList(String id) {

		logger.info("Method in Dao: getPersonList starts");
		JsonResponse<List<PersonModel>> resp = new JsonResponse<List<PersonModel>>();
		List<PersonModel> dept = new ArrayList<PersonModel>();
		try {

			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "personList").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PersonModel dropDownModel = new PersonModel(m[0], m[1]);
					dept.add(dropDownModel);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(dept);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PersonModel>>> response = new ResponseEntity<JsonResponse<List<PersonModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getPersonList ends");

		return response;
	}

	/*
	 * for get Person List
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PersonModel>>> getSectionHeadName() {

		logger.info("Method in Dao: getSectionHeadName starts");
		JsonResponse<List<PersonModel>> resp = new JsonResponse<List<PersonModel>>();
		List<PersonModel> dept = new ArrayList<PersonModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getSectionHeadName").setParameter("actionValue", "").getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PersonModel dropDownModel = new PersonModel(m[0], m[1]);
					dept.add(dropDownModel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(dept);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PersonModel>>> response = new ResponseEntity<JsonResponse<List<PersonModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getSectionHeadName ends");
		return response;
	}

	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> coordinatorforward(@RequestBody List<RequisitionViewModel> obj) {

		logger.info("Method in Dao: coordinatorforward starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			List<DropDownModel> dept = new ArrayList<DropDownModel>();
			String values = GenerateRequestRequisitionDocumentParameter.addForwardObservation(obj);

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "cordinatorforward").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					dept.add(dropDownModel);
					resp.setBody(dept);
				}
			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
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

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: coordinatorforward ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for get Person List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getforwardPersonList(String id) {

		logger.info("Method in Dao: forwardPersonList starts");

		List<DropDownModel> forwardPersonList = new ArrayList<DropDownModel>();
		try {

			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "forwardPersonList").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					forwardPersonList.add(dropDownModel);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getPersonList ends");

		return forwardPersonList;
	}

	/*
	 * for get Person List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> frowardPersonCCList(String id) {
		logger.info("Method in Dao: frowardPersonCCList starts");
		List<DropDownModel> frowardPersonCCList = new ArrayList<DropDownModel>();
		try {

			String value = "SET @p_id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "frowardPersonCCList").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					frowardPersonCCList.add(dropDownModel);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: frowardPersonCCList ends");
		return frowardPersonCCList;
	}

	// Multiple Document
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> getStatuMulDocument(String id) {
		logger.info("Method in Dao: getStatuMulDocument starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_reqId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "viewMulDocument").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], null, m[1], null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
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

		logger.info("Method : getStatuMulDocument ends");
		return resp;
	}

	// Multiple Document
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getConcernAuditees() {
		logger.info("Method in Dao: getConcernAuditees starts");
		List<DropDownModel> requisitionViewModel = new ArrayList<DropDownModel>();

		try {
			// String value = "SET @p_audit='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getConcernAuditees").setParameter("actionValue", "").getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					requisitionViewModel.add(dropDownModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getConcernAuditees ends");
		return requisitionViewModel;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * editCommentSaveRespond(RequisitionViewModel index) {
	 * logger.info("Method : auditeeStatuCommentSave starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode("");
	 * 
	 * if (validity) try {
	 * 
	 * String values = GenerateAuditeeParameter.editCommentSaveRespond(index);
	 * em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
	 * "actionType", "editCommentRespond") .setParameter("actionValue",
	 * values).execute(); resp.setCode("Data Saved Successfully");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : auditeeStatuCommentSave ends"); return response; }
	 */

	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public List<AuditMasterModel> getAllStatutaryAuditList(String id, String sectionId, String userId) {

		logger.info("Method in Dao: getAllStatutaryAudit starts");

		List<AuditMasterModel> auditInitiateModelList = new ArrayList<AuditMasterModel>();

		String value = "SET @p_audit='" + id + "',@p_sectionId='" + sectionId + "',@p_userId='" + userId + "';";
		System.out.println(value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getAuditMstrDtl").setParameter("actionValue", value).getResultList();
			
			//System.out.println("list of 3rd collaps "+x);
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					
				System.out.println("list of 3rd collaps "+Arrays.toString(m));

					Object fromDate = null;
					if (m[10] != null) {
						fromDate = DateFormatter.returnStringDate(m[10]);
					}
					Object toDate = null;
					if (m[11] != null) {
						toDate = DateFormatter.returnStringDate(m[11]);
					}
					AuditMasterModel auditInitiateModel = new AuditMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], fromDate, toDate, m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							null, m[20], m[21], m[22], m[23], null, null, null, null, null, null, m[24], null, null,
							null, null, null, null, null, null, null, null, null, null,m[25]);
					auditInitiateModelList.add(auditInitiateModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getAllStatutaryAudit ends");
		
		System.out.println("auditInitiateModelList :-"+auditInitiateModelList);
		
		return auditInitiateModelList;
	}

	/*
	 *
	 * get Audit Note By id dao
	 */
	public List<RequisitionViewModel> getCoForwardDetails(String id) {

		logger.info("Method in Dao: getCoForwardDetails ends");

		List<RequisitionViewModel> auditNote = new ArrayList<RequisitionViewModel>();

		try {

			String value = "SET @P_auditId='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "coForwardDtls").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				Object Date = null;

				if (m[4] != null) {
					Date = DateFormatter.returnStringDateTime(m[4]);

				}
				RequisitionViewModel note = new RequisitionViewModel(m[0], null, m[1], m[2], m[3], Date, null, null,
						null, null, null, m[5], m[6], m[7], null, null, null, null, null, null,null);
				auditNote.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getCoForwardDetails ends");

		return auditNote;

	}

	/*
	 * Forward Documents
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getForDocList(String id) {
		logger.info("Method in Dao: getForDocList starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "viewForDocList").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getForDocList ends");

		return dropDownModel;
	}

	/*
	 *
	 * get Audit Note By id dao
	 */
	public List<RequisitionViewModel> getCoObsForwardDetails(String id, String userId) {

		logger.info("Method in Dao: getCoObsForwardDetails ends");

		List<RequisitionViewModel> auditNote = new ArrayList<RequisitionViewModel>();

		try {

			String value = "SET @p_id='" + id + "',@p_userId='" + userId + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "CoObsForwardDtls").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				String Date = "";

				if (m[5] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[5]);

				}
				RequisitionViewModel note = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], Date, null, null,
						null, null, m[6], m[7], m[8], m[9], null, null, null, null, null, null,null);
				auditNote.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println("auditNote"+auditNote);
		logger.info("Method in Dao: getCoObsForwardDetails ends");
		return auditNote;

	}

	/*
	 *
	 * get Audit Note By id dao
	 */
	public List<RequisitionViewModel> getObsReportDetails(String id) {

		logger.info("Method in Dao: getObsReportDetails ends");

		List<RequisitionViewModel> auditNote = new ArrayList<RequisitionViewModel>();

		try {

			String value = "SET @p_id='" + id + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "ObsForwardReportDtls").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				String Date = "";

				if (m[5] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[5]);

				}
				RequisitionViewModel note = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], Date, null, null,
						null, null, m[6], m[7], m[8], m[9], null, null, null, null, null, null,null);
				auditNote.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getObsReportDetails ends");
		System.out.println(auditNote);
		return auditNote;

	}

	/*
	 * Observation Forward Details
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getObsForDocList(String id) {
		logger.info("Method in Dao: getObsForDocList starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "ObsForDocList").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getObsForDocList ends");
		return dropDownModel;
	}

	/*
	 * Forward Documents
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getComplianceDocList(String id) {
		logger.info("Method in Dao: getComplianceDocList starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_id='" + id + "';";
			// System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "ComplDocList").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getComplianceDocList ends");
		// System.out.println(dropDownModel);
		return dropDownModel;
	}

	/*
	 * Observation Forward Details
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditNoteDocList(String id) {
		logger.info("Method in Dao: getAuditNoteDocList starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_id='" + id + "';";
			// System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "AuditNoteDocList").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditNoteDocList ends");
		// System.out.println(dropDownModel);
		return dropDownModel;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> forwardRemark(List<RequisitionViewModel> requisitionViewModel) {

		logger.info("Method in Dao: forwardRemark starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateRequestRequisitionDocumentParameter.addDocument(requisitionViewModel);

			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "forwardRemark")
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

		if (resp.getMessage() == null || resp.getMessage() == "") {
			resp.setMessage("success");
		} else {
			resp.setCode(resp.getMessage());
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: forwardRemark ends");

		return response;
	}

	/*
	 * Observation Forward Details
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public List<RestAuidtReportModel> getAllAuditReport(String id) {
		logger.info("Method in Dao: getAllAuditReport starts");

		List<RestAuidtReportModel> dropDownModel = new ArrayList<RestAuidtReportModel>();

		try {
			String value = "SET @p_id='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "AllAuditReport").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date1 = null;
					Object date2 = null;
					if (m[2] != null) {
						date1 = DateFormatter.returnStringDate(m[2]);
					}
					if (m[3] != null) {
						date2 = DateFormatter.returnStringDate(m[3]);
					}
					RestAuidtReportModel data = new RestAuidtReportModel(m[0], m[1], date1, date2, m[4], null, m[5],
							m[6], m[7]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllAuditReport ends");
		System.out.println(dropDownModel);
		return dropDownModel;
	}

	/*
	 * Observation Forward Details
	 */
	@SuppressWarnings({ "unchecked" })
	public List<RestAuidtReportModel> getAllAuditReportDtl(DataTableRequest request) {
		logger.info("Method in Dao: getAllAuditReportDtl starts");

		List<RestAuidtReportModel> dropDownModel = new ArrayList<RestAuidtReportModel>();
		if (request.getParam5() != null && request.getParam5() != "") {
			request.setParam5(DateFormatter.getStringDate(request.getParam5()));
		}
		if (request.getParam6() != null && request.getParam6() != "") {
			request.setParam6(DateFormatter.getStringDate(request.getParam6()));
		}

		String values = GenerateParameter.getSearchParam(request);
		System.out.println(values);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "AllAuditRept").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date1 = null;
					Object date2 = null;
					if (m[2] != null) {
						date1 = DateFormatter.returnStringDate(m[2]);
					}
					if (m[3] != null) {
						date2 = DateFormatter.returnStringDate(m[3]);
					}
					RestAuidtReportModel data = new RestAuidtReportModel(m[0], m[1], date1, date2, m[4], null, m[5],
							m[6], m[7]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllAuditReportDtl ends");
		return dropDownModel;
	}

	/*
	 * Observation Forward Details
	 */
	@SuppressWarnings({ "unchecked" })
	public List<DropDownModel> getAllDocumentReport(DataTableRequest request) {
		logger.info("Method in Dao: getAllDocumentReport starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		String values = GenerateParameter.getSearchParam(request);
		System.out.println("@@@@@######"+values);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "AllDocumentReport").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0], m[1]);
					dropDownModel.add(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllDocumentReport ends");
		System.out.println("getAllDocumentReport"+dropDownModel);
		return dropDownModel;
	}

	/*
	 * for all concession details view
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllDraftNo(String param1, String param2, String param3) {

		logger.info("Method in Dao: getAllDraftNo starts");

		List<DropDownModel> draftList = new ArrayList<DropDownModel>();
		String values = "SET @p_param1='" + param1 + "',@p_param2='" + param2 + "',@p_param3='" + param3 + "';";
		System.out.println(values);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getAllDraftNo").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel concession = new DropDownModel(m[0], m[1]);
					draftList.add(concession);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAllDraftNo ends");

		System.out.println(draftList);
		return draftList;
	}

	public ResponseEntity<JsonResponse<Object>> sendFinalObservation(List<AuditObservationModel> obs) {
		logger.info("Method : sendFinalObservation ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String values = GenerateAuditQuestionParam.getIRSParam(obs);
			// String value = "SET @p_quesId=" + obs.getQuesId() + ",@p_severity=" +
			// obs.getSeverity() + ",@p_obs='"+obs.getObservation()+"';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "giveFinalObs").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(data);
					resp.setBody(dropDownModel);
				}

			}
			List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
			if (obs.get(0).getPersonCc() != null && obs.get(0).getPersonCc() != "") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", values).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x1) {

						DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel1.add(data1);
						resp.setSecondBody(dropDownModel1);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : sendFinalObservation ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for get approveAccept
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> revertBack(List<RequisitionViewModel> obj) {
		logger.info("Method in Dao: sendStatuRequestRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;

		if (obj.get(0).getComment() == null || obj.get(0).getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}

		if (validity)

			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();

				String value = GenerateRequestRequisitionDocumentParameter.addDocument(obj);
				System.out.println(value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "revertBack").setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {

						DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
					}

				}
				if (obj.get(0).getPersonCc() != null && obj.get(0).getPersonCc() != "") {
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "emailCc").setParameter("actionValue", value).getResultList();
					if (!x.isEmpty()) {
						for (Object[] m : x1) {

							DropDownModel data1 = new DropDownModel(m[0].toString(), m[1]);
							dropDownModel1.add(data1);
							resp.setSecondBody(dropDownModel1);
						}

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

		// resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: revertBack ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<List<RequisitionViewModel>>> getReplyAutocomplete(String id, String reqId) {

		logger.info("Method : getReplyAutocomplete starts");

		List<RequisitionViewModel> reply = new ArrayList<RequisitionViewModel>();
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		resp.setMessage("");

		try {
		String value = "SET @p_id='" + id + "', @p_reqId='" + reqId + "';";

		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
		.setParameter("actionType", "getReplyAutocom").setParameter("actionValue", value).getResultList();

		if (!x.isEmpty()) {
		for (Object[] m : x) {
		RequisitionViewModel replyList = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6]);
		reply.add(replyList);

		}
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		resp.setBody(reply);
		ResponseEntity<JsonResponse<List<RequisitionViewModel>>> response = new ResponseEntity<JsonResponse<List<RequisitionViewModel>>>(
		resp, HttpStatus.CREATED);

		logger.info("Method : getReplyAutocomplete ends");

		return response;
		}

	public ResponseEntity<JsonResponse<Object>> saveForwardss(RequisitionViewModel obj) {
		logger.info("Method : saveForwardss starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {

			String value = "SET @p_id1='" + obj.getInitiatedId() + "',@p_summery1='" + obj.getComment() + "';";
			System.out.println("ytytytytyty" + value);

			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "saveForward")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : saveForwardss ends");
		return response;
	}
	/*
	 * Reminder
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> getReminderDetails() {
		logger.info("Method in Dao: sendResponseRequisition starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();

		try {
			List<RequisitionViewModel> dropDownModel = new ArrayList<RequisitionViewModel>();

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "reminderDetails").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				/*
				 * Object date = null; if (m[3] != null) { date =
				 * DateFormatter.returnStringDateTime(m[3]); }
				 */

				RequisitionViewModel data = new RequisitionViewModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7]);
				dropDownModel.add(data);
				resp.setBody(dropDownModel);
			}
			/*
			 * RequisitionViewModel data = new RequisitionViewModel("AKM", "HEAD",
			 * "mishraashishkumar41@gmail.com", null); dropDownModel.add(data);
			 * resp.setBody(dropDownModel);
			 */

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

		logger.info("Method in Dao: sendResponseRequisition ends");
		System.out.println("resp "+resp);
		return resp;
	}

	/*
	 * Priority DropDown
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList() {

		logger.info("Method in Dao: getPriorityList starts");

		List<DropDownModel> priorityType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getPriorList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				priorityType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getPriorityList ends");

		return priorityType;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOnlyDraft(String id) {
		logger.info("Method : getOnlyDraft starts");
		
		List<DropDownModel> ques1 = new ArrayList<DropDownModel>();
		String value = "SET @p_id='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getOnlyDraft").setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				ques1.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getOnlyDraft ends");
		System.out.println("getOnlyDraft "+ques1);
		return ques1;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOnlyPara(String id) {
		logger.info("Method : getOnlyPara starts");
		
		List<DropDownModel> ques = new ArrayList<DropDownModel>();
		String value = "SET @p_id='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getOnlyPara").setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				ques.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getOnlyPara ends");
		System.out.println(ques);
		return ques;
	}
	
	public ResponseEntity<JsonResponse<Object>> getReminderDetailsupdate(Integer reqId, Integer auditId) {
		
		logger.info("Method in Dao: getReminderDetailsupdate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		
		try {
			String value = "SET @p_reqId='" + reqId + "',@p_auditId='" + auditId + "';";
			System.out.println("bikash "+value);

			em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter("actionType", "updatetable")
					.setParameter("actionValue", value).execute();
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
		
		logger.info("Method : getReminderDetailsupdate ends");
		System.out.println("bikash 123 ");
		//System.out.println("requisitionViewModel" + requisitionViewModel);
		return response;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> getallDocument(String prevauditid) {
		
		logger.info("Method in Dao: getallDocument starts");
		//System.out.println("bikash 123 "+prevauditid);
		//JsonResponse<Object>
		
		String value = "SET @p_id='" + prevauditid + "';";
		System.out.println("bikash 123 "+value);
		
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();

		try {
			//List<RequisitionViewModel> dropDownModel = new ArrayList<RequisitionViewModel>();

			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "allpdflists").setParameter("actionValue", value).getResultList();
			//System.out.println("bikash 123456789  "+x);
			/*
			 * String prevtid=""; for (Object[] m : x) {
			 * System.out.println(Arrays.toString(m)); //prevtid = m[0].toString(); }
			 * System.out.println(prevtid);
			 */
			StringBuffer sbf1 =new StringBuffer("");
			for (int i=0; i<x.size(); i++){
				   System.out.println("Element "+i+x.get(i));
				   sbf1.append(x.get(i));
				}
			//String firstName = x.get(0).toString();
			//System.out.println("firstName "+sbf1);
			
			
			String value1 = "SET @p_previd='" + sbf1 + "';";
			System.out.println("bikash 1231 "+value1);
			
			List<Object[]> x1 = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "allpdflistsdata").setParameter("actionValue", value1).getResultList();
			
			
			
			/*
			 * String prevtid = x.toString();
			 * 
			 * System.out.println(prevtid);
			 */
			
			for (Object[] m : x1) {

				System.out.println(Arrays.toString(m));
				
				RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4]);
				//String[] commaSeparatedArr = dropDownModel.getPersonCcId().split(",");
				// dropDownModel.setPersonToId(Arrays.stream(commaSeparatedArr).collect(Collectors.toList()));
				
				requisitionViewModel.add(dropDownModel);
			}
			
			
			resp.setBody(requisitionViewModel);
			 
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
		
		
		
		logger.info("Method : getallDocument ends");
		System.out.println("resp "+resp);
		return resp;
	}


	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReqorev(String reqid) {
		logger.info("Method : getReqorev starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_id='" + reqid + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getprevid").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					summery.add(dropDownModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(summery);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getReqorev ends");

		return response;
	}
	/*
	 * draft Section by Deepak
	 */
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveDraft(List<RequisitionViewModel> obj) {
		logger.info("Method in Dao: saveDraft starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;

		if (obj.get(0).getComment() == null || obj.get(0).getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}

		if (validity)

			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
System.out.println(obj);
				String value = GenerateRequestRequisitionDocumentParameter.addDraft(obj);
				System.out.println("PARAMS : "+value);
				
				em.createNamedStoredProcedureQuery("statutaryRoutines").setParameter(
						  "actionType", "saveDraft") .setParameter("actionValue",value).execute();
						  
		} catch (Exception e) { 
			e.printStackTrace();
			try { 
				String[] err = serverDao.errorProcedureCall(e); resp.setCode(err[0]);
						  resp.setMessage(err[1]); 
				} catch (Exception e1) { 
					e1.printStackTrace(); 
					} 
			} 
						  
	ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);				 
	return response;
	}
	/*
	 * draft LIst
	 */
	public ResponseEntity<JsonResponse<List<DraftListModel>>> getDraftLIst(String id, String userId, String status) {

		logger.info("Method : getDraftLIst starts");

		List<DraftListModel> reply = new ArrayList<DraftListModel>();
		JsonResponse<List<DraftListModel>> resp = new JsonResponse<List<DraftListModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_id='" + id + "', @p_reqId='" + userId + "', @p_status='" + status + "';";
System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getDraftLIst").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DraftListModel replyList = new DraftListModel(m[0].toString(), m[1],m[2], m[3]);
					reply.add(replyList);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("draft list"+reply);
		resp.setBody(reply);
		ResponseEntity<JsonResponse<List<DraftListModel>>> response = new ResponseEntity<JsonResponse<List<DraftListModel>>>(
		resp, HttpStatus.CREATED);

		logger.info("Method : getReplyAutocomplete ends");
		System.out.println("draft list"+response);
		return response;
		}
	
	/*
	 * Dao for draft Message
	 */
@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<DraftListModel>> getDraftComment(String id) {
	logger.info("Method : getDraftMessage starts");
	List<DraftListModel> form = new ArrayList<DraftListModel>();

	try {
		String values = "SET @p_id=" + id + ";";
		System.out.println("draft Param: "+values);
		List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
				.setParameter("actionType", "draftMessage").setParameter("actionValue", values).getResultList();
		if (!x.isEmpty()) {
			for (Object[] m : x) {
				DraftListModel sectionMaster = new DraftListModel(m[0],m[1],m[2],m[3]);
				form.add(sectionMaster);
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	JsonResponse<DraftListModel> servicemaster = new JsonResponse<DraftListModel>();
	servicemaster.setBody(form.get(0));

	ResponseEntity<JsonResponse<DraftListModel>> response = new ResponseEntity<JsonResponse<DraftListModel>>(
			servicemaster, HttpStatus.CREATED);
	logger.info("Method : getDraftMessage ends");
	return response;
}
		/*
		 * 
		 * Dao Draft Autocomplete
		 */
		public ResponseEntity<JsonResponse<List<DraftModel>>> draftAutocomplete(String id) {

			logger.info("Method : getReplyAutocomplete starts");

			List<DraftModel> reply = new ArrayList<DraftModel>();
			
			JsonResponse<List<DraftModel>> resp = new JsonResponse<List<DraftModel>>();
			resp.setMessage("");
			/*
			 * for document list
			 * 
			 */
			
			List<DropDownModel> fordoc = new ArrayList<DropDownModel>();
			try {
				String value = "SET @p_id='" + id + "';";

				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "getDraftDocumentList").setParameter("actionValue", value)
						.getResultList();

				if (!x.isEmpty()) {
					for (Object[] m : x) {
						DropDownModel replyList = new DropDownModel(m[0], m[1], m[2].toString());
						//reply.get(0).add(replyList);
						fordoc.add(replyList);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			System.out.println("Draft Document"+fordoc);
			/*
			 * for toperson list
			 * 
			 */	
			List<DropDownModel> forTo = new ArrayList<DropDownModel>();
			try {
				String value = "SET @p_id='" + id + "';";
				
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
				.setParameter("actionType", "getToPerson").setParameter("actionValue", value)
				.getResultList();
				
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						DropDownModel replyList = new DropDownModel(m[0], m[1]);
						forTo.add(replyList);
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Draft To"+forTo);
			
			/*
			 * for Ccperson list
			 * 
			 */List<DropDownModel> forCc = new ArrayList<DropDownModel>();
				
			try {
				String value = "SET @p_id='" + id + "';";
				
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
				.setParameter("actionType", "getCcPerson").setParameter("actionValue", value)
				.getResultList();
				
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						DropDownModel replyList = new DropDownModel(m[0], m[1]);
						forCc.add(replyList);
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Draft CC"+forCc);

			List<DraftModel> x = new ArrayList<DraftModel>();
			
			DraftModel obj = new DraftModel(fordoc,forTo,forCc);

			obj.setDocuments(fordoc);
			obj.setPersonTo(forTo);
			obj.setPersonCc(forCc);
			
			
			x.add(obj);
			
			resp.setBody(x);
			System.out.println("Entire body"+resp);
			ResponseEntity<JsonResponse<List<DraftModel>>> response = new ResponseEntity<JsonResponse<List<DraftModel>>>(
					resp, HttpStatus.CREATED);

			logger.info("Method : getReplyAutocomplete ends");

			return response;
		}
				
}
