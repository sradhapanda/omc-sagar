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

import nirmalya.aatithya.restmodule.audit.model.AuditAdditionalInfoModel;
import nirmalya.aatithya.restmodule.audit.model.AuditDetailModel;
import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.AuditNoteModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.PersonListModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditMeetingModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditMeetingParameter;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditInitiateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateRequestRequisitionDocumentParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AuditInitiateDao {

	Logger logger = LoggerFactory.getLogger(AuditInitiateDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditType() {
		logger.info("Method : getAuditType starts");

		List<DropDownModel> auditType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getAuditType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditType ends");
		return auditType;
	}
	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSupplementaryTypeDashboard() {
		logger.info("Method : getSupplementaryTypeDashboard starts");
		
		List<DropDownModel> auditType = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "supplType").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getSupplementaryTypeDashboard ends");
		return auditType;
	}
	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditTypeDashboard() {
		logger.info("Method : getAuditTypeDashboard starts");
		
		List<DropDownModel> auditType = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "auditTypeDashBoard").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getAuditTypeDashboard ends");
		return auditType;
	}
	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditTypePie() {
		logger.info("Method : getAuditTypePie starts");
		
		List<DropDownModel> auditType = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getAuditTypePie").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getAuditTypePie ends");
		return auditType;
	}
	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditNos() {
		logger.info("Method : getAuditNos starts");

		List<DropDownModel> auditType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getAuditNos").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditNos ends");
		return auditType;
	}
	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditNosByType(String id) {
		logger.info("Method : getAuditNosByType starts");

		List<DropDownModel> auditType = new ArrayList<DropDownModel>();
		String value = "SET @p_id='" + id + "';";
System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "auditNoByType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditNosByType ends");
		System.out.println(auditType);
		return auditType;
	}
	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFinancialYear() {
		logger.info("Method : getFinancialYear starts");

		List<DropDownModel> financialYear = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getFinancialYear").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				financialYear.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFinancialYear ends");
		return financialYear;
	}
	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentListSerach() {
		logger.info("Method : getDepartmentListSerach starts");

		List<DropDownModel> financialYear = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "deptList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				financialYear.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentListSerach ends");
		return financialYear;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganizationId() {
		logger.info("Method : getOrganizationId starts");

		List<DropDownModel> auditType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getOrganizationId").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOrganizationId ends");
		return auditType;
	}

	public ResponseEntity<JsonResponse<List<Object>>> initiateAuditDao(List<AuditInitiateModel> auditInitiate) {
		logger.info("Method : initiateAuditDao starts");

		Boolean validity = true;
		JsonResponse<List<Object>> resp = new JsonResponse<List<Object>>();
		resp.setMessage("");
		resp.setCode("");
		for (AuditInitiateModel l : auditInitiate)
			if (l.getAuditType() == null || l.getAuditType() == "") {
				resp.setMessage("Audit Type Required");
				validity = false;
			} else if (l.getFinancialYear() == null || l.getFinancialYear() == "") {
				resp.setMessage("Financial Year Required");
				validity = false;
			} else if (l.getInitiatedBy() == null || l.getInitiatedBy() == "") {
				resp.setMessage("Initiated By Required");
				validity = false;
			} else if (l.getInitiatedDate() == null || l.getInitiatedDate() == "") {
				resp.setMessage("Initiated Date Required");
				validity = false;
			} else if (l.getSummary() == null || l.getSummary() == "") {
				resp.setMessage("Summary Required");
				validity = false;
			} /*
				 * else if (auditInitiate.getDocument() == null || auditInitiate.getDocument()
				 * == "") { resp.setMessage("Document Required"); validity = false; }
				 */

		if (validity)
			try {

				String values = GenerateAuditInitiateParameter.initiateAudit(auditInitiate);

				if (auditInitiate.get(0).getAuditInitiate() != null && auditInitiate.get(0).getAuditInitiate() != "") {
					em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "modifyAudit").setParameter("actionValue", values).execute();
					resp.setCode("Data Saved Successfully");
				} else {
					em.createNamedStoredProcedureQuery("auditInitiateRoutines")
							.setParameter("actionType", "initiateAudit").setParameter("actionValue", values).execute();
					resp.setCode("Data Saved Successfully");
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

		ResponseEntity<JsonResponse<List<Object>>> response = new ResponseEntity<JsonResponse<List<Object>>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : initiateAuditDao ends");
		return response;
	}

	/*
	 * for all audit initiated
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getAllInitiatedAudits(DataTableRequest request) {

		logger.info("Method in Dao: getAllInitiatedAudits starts");

		List<AuditInitiateModel> auditInitiateModelList = new ArrayList<AuditInitiateModel>();
		//System.out.println("request"+request);
		String values = GenerateParameter.getSearchParam(request);
		
		Integer total = 0;
		if (request.getParam5() != null && request.getParam5() != "") {
			request.setParam5(DateFormatter.getStringDate(request.getParam5()));
		}
		if (request.getParam6() != null && request.getParam6() != "") {
			request.setParam6(DateFormatter.getStringDate(request.getParam6()));
		}
		try {
			
			/*if (request.getParam3() != null && request.getParam3() != "" ) {
				
				System.out.println("param 3");
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
						.setParameter("actionType", "viewInitiatedAudit").setParameter("actionValue", values)
						.getResultList();

				if (!x.isEmpty()) {
					for (Object[] m : x) {

						Object date = null;
						if (m[4] != null) {
							date = DateFormatter.returnStringDate(m[4]);
						}
						Object val = null;
						if (m[11] != null) {
							val = m[11].toString();
						} // m[11] =
						//Integer.valueOf(((BigInteger) m[11]).toString()); // m[12] =
						//Integer.valueOf(((BigInteger) m[12]).toString());
						AuditInitiateModel auditInitiateModel = new AuditInitiateModel(m[0], m[1], m[2], m[3], date,
								m[5], m[6], m[7], null, m[8], m[9], null, null, null, null, null, m[10], null, null,
								null, null, null, null, val, m[12], m[13].toString(), m[14], null, null);
						auditInitiateModelList.add(auditInitiateModel);

					}

					
					if (x.get(0).length > 16) {
						BigInteger t = (BigInteger) x.get(0)[16];

						total = Integer.parseInt((t.toString()));
					}
					 
				}
				 
			}
			else {*/
			System.out.println("bikash testing "+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "viewInitiatedAudit").setParameter("actionValue", values)
					.getResultList();
			
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object date = null;
					if(m[4]!=null) {
					date = DateFormatter.returnStringDate(m[4]);
					}
					Object val=null;
					if(m[11]!=null) {
					val=m[11].toString();	
					}
					// m[11] = Integer.valueOf(((BigInteger)m[11]).toString());
				//	 m[12] = Integer.valueOf(((BigInteger)m[12]).toString());
					AuditInitiateModel auditInitiateModel = new AuditInitiateModel(m[0], m[1], m[2], m[3], date, m[5],
							m[6], m[7], null, m[8], m[9], null, null, null, null, null, m[10], null, null, null, null,
							null, null,val,m[12], m[13].toString(),m[14],null, 	null);
					auditInitiateModelList.add(auditInitiateModel);

				}

				if (x.get(0).length > 16) {
					BigInteger t = (BigInteger) x.get(0)[16];

					total = Integer.parseInt((t.toString()));
				}
			}
			//}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditInitiateModel>> resp = new JsonResponse<List<AuditInitiateModel>>();
		resp.setBody(auditInitiateModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditInitiateModel>>> response = new ResponseEntity<JsonResponse<List<AuditInitiateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllInitiatedAudits ends");
		return response;
	}

	/*
	 * for get approveAccept
	 */
	public JsonResponse<Object> approveAccept(String id, String createdBy) {
		logger.info("Method in Dao: approveAccept starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_audit='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "accept")
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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: approveAccept ends");

		return resp;
	}

	/*
	 * for all audit initiated
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getAuditor(String id) {

		logger.info("Method in Dao: getAuditor starts");

		List<AuditInitiateModel> auditInitiateModelList = new ArrayList<AuditInitiateModel>();

		String value = "SET @p_organization='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "auditorName").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					AuditInitiateModel auditInitiateModel = new AuditInitiateModel(m[0], m[1], m[2], null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null);
					auditInitiateModelList.add(auditInitiateModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditInitiateModel>> resp = new JsonResponse<List<AuditInitiateModel>>();
		resp.setBody(auditInitiateModelList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditInitiateModel>>> response = new ResponseEntity<JsonResponse<List<AuditInitiateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAuditor ends");

		return response;
	}

	/*
	 * for all audit initiated
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getDesignation(String id) {

		logger.info("Method in Dao: getDesignation starts");

		List<AuditInitiateModel> auditInitiateModelList = new ArrayList<AuditInitiateModel>();

		String value = "SET @p_auditor='" + id + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "designationName").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					AuditInitiateModel auditInitiateModel = new AuditInitiateModel(m[0], m[1], m[2], null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null);
					auditInitiateModelList.add(auditInitiateModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditInitiateModel>> resp = new JsonResponse<List<AuditInitiateModel>>();
		resp.setBody(auditInitiateModelList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditInitiateModel>>> response = new ResponseEntity<JsonResponse<List<AuditInitiateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getDesignation ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveSummery(String summery) {
		logger.info("Method : saveSummery starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {

			String value = "SET @p_summery='" + summery + "';";
			em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "saveSummery")
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
		logger.info("Method : saveSummery ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSummery() {
		logger.info("Method : getSummery starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getSummery").setParameter("actionValue", "").getResultList();

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

		logger.info("Method : getSummery ends");
		return response;
	}

	/*
	 * for get send Response to Requisition
	 */
	// ###################### NOTE ###########
	public ResponseEntity<JsonResponse<Object>> sendDetails(List<AuditInitiateModel> obj) {
		logger.info("Method in Dao: sendDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		if (obj.get(0).getSummary() == null || obj.get(0).getSummary() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}
		if (validity)

			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				String value = GenerateAuditDetailsParameter.addDocument(obj);

				@SuppressWarnings("unchecked")
				List<Object[]> x=em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "sendDetails")
						.setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {

						DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
					}

				}
				List<DropDownModel> dropDownModel1 = new ArrayList<DropDownModel>();
				if(obj.get(0).getPersonCc()!=null && obj.get(0).getPersonCc()!="") {
				@SuppressWarnings("unchecked")
				List<Object[]> x1=em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "emailCc").setParameter("actionValue", value)
						.getResultList();
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
		logger.info("Method in Dao: sendDetails ends");
System.out.println(response);
		return response;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<AuditDetailModel>> viewDetails(String id) {
		logger.info("Method in Dao: viewDetails starts");
		JsonResponse<List<AuditDetailModel>> resp = new JsonResponse<List<AuditDetailModel>>();
		List<AuditDetailModel> requisitionViewModel = new ArrayList<AuditDetailModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "viewDetails").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDateTime(m[5]);
					}
					AuditDetailModel dropDownModel = new AuditDetailModel(m[0], m[1], m[2], m[3], m[4], date);
					requisitionViewModel.add(dropDownModel);
				}
				resp.setBody(requisitionViewModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AuditDetailModel>>> response = new ResponseEntity<JsonResponse<List<AuditDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewDetails ends");

		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> saveNotes(AuditInitiateModel obj) {
		logger.info("Method : saveNotes starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {

			String value = "SET @p_id='" + obj.getAuditInitiate() + "',@p_summery='" + obj.getSummary() + "';";

			em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "saveNotes")
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

		logger.info("Method : saveNotes ends");
		System.out.println(response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> viewNotification(String id,String type,String userId) {
		logger.info("Method : viewNotification starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		
		try {
			
			String value = "SET @p_id='" +id+ "',@p_type='"+type+"',@p_userId='"+userId+"';";
			System.out.println(value);
			em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "viewNotification")
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
		
		logger.info("Method : viewNotification ends");
		System.out.println(response);
		return response;
	}

	public ResponseEntity<JsonResponse<DropDownModel>> getNotes(String id) {
		logger.info("Method : getNotes starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		resp.setMessage("");

		try {

			String value = "SET @p_id='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getNotes").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel dropDown = new DropDownModel(m[0].toString(), m[1]);
					dropDownModel.add(dropDown);
				}
				resp.setBody(dropDownModel.get(0));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getNotes ends");

		return response;
	}

	/*
	 * for all audit initiated
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getOrganization(String id) {

		logger.info("Method in Dao: getOrganization starts");

		List<AuditInitiateModel> auditInitiateModelList = new ArrayList<AuditInitiateModel>();

		String value = "SET @p_organization='" + id + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getOrganizationName").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					AuditInitiateModel auditInitiateModel = new AuditInitiateModel(m[0], m[1], m[2], null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null);
					auditInitiateModelList.add(auditInitiateModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditInitiateModel>> resp = new JsonResponse<List<AuditInitiateModel>>();
		resp.setBody(auditInitiateModelList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditInitiateModel>>> response = new ResponseEntity<JsonResponse<List<AuditInitiateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getOrganization ends");

		return response;
	}

	/*
	 * for edit
	 */
	@SuppressWarnings("unchecked")
	public List<AuditMasterModel> getinitiateAuditById(String id) {

		logger.info("Method in Dao: getinitiateAuditById ends");

		List<AuditMasterModel> auditmstr = new ArrayList<AuditMasterModel>();

		try {

			String value = "SET @P_auditId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "editAuditmstr").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				 Object fromDate = null;

				if (m[10] != null) {
					fromDate = DateFormatter.returnStringDate(m[10]);
				}
				Object toDate = null;
				if (m[11] != null) {
					toDate = DateFormatter.returnStringDate(m[11]);
				}

				Object submissionDate = null;
				/*
				 * if (m[17] != null) { submissionDate = DateFormatter.returnStringDate(m[17]);
				 * }
				 */

				Object iniDate = null;
				if (m[12] != null) {
					iniDate = DateFormatter.returnStringDateTime(m[12]);
				}

				AuditMasterModel adt = new AuditMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
						fromDate, toDate, null, null, null, null, null, null, null, null, null, null, null, null, null,
						m[20], null, m[21], iniDate, null, null, m[13], m[14], m[15], m[16], m[17], m[18], m[19], null,
						null, null, null, m[22],m[23],null);
				auditmstr.add(adt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getinitiateAuditById ends");
		System.out.println("edit"+auditmstr);
		return auditmstr;
	}

	/*
	 * for edit
	 */
	@SuppressWarnings("unchecked")
	public List<AuditAdditionalInfoModel> getAdditionalInformation(String id) {

		logger.info("Method in Dao: getAdditionalInformation ends");

		List<AuditAdditionalInfoModel> auditmstr = new ArrayList<AuditAdditionalInfoModel>();

		try {

			String value = "SET @P_auditId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "addInfo").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				AuditAdditionalInfoModel adt = new AuditAdditionalInfoModel(m[0], m[1], m[2]);
				auditmstr.add(adt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAdditionalInformation ends");

		return auditmstr;
	}

	/*
	 * get docs
	 */
	public List<AuditAdditionalInfoModel> getinitiateAuditDocsById(String id) {

		logger.info("Method in Dao: getinitiateAuditDocsById ends");

		List<AuditAdditionalInfoModel> docs = new ArrayList<AuditAdditionalInfoModel>();

		try {

			String value = "SET @P_auditId='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getadditionalDtls").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				AuditAdditionalInfoModel doc = new AuditAdditionalInfoModel(m[0], m[1], m[2]);
				docs.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getinitiateAuditDocsById ends");

		return docs;

	}

	/*
	 *
	 * get Audit Note By id dao
	 */
	public List<AuditNoteModel> getAuditNoteById(String id) {

		logger.info("Method in Dao: getAuditNoteById ends");

		List<AuditNoteModel> auditNote = new ArrayList<AuditNoteModel>();

		try {

			String value = "SET @P_auditId='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getAuditNoteById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				String Date = "";
				if (m[2] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[2]);
				}
				AuditNoteModel note = new AuditNoteModel(m[0].toString(), m[1], Date, null, m[3], m[4], m[5], m[6],m[7],m[8],m[9].toString());
				auditNote.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAuditNoteById ends");
System.out.println(auditNote);
		return auditNote;

	}
	/*
	 *
	 * get Audit Note By id dao
	 */
	public List<AuditObservationModel> getAuditorQuestionList(String id) {
		
		logger.info("Method in Dao: getAuditorQuestionList ends");
		
		List<AuditObservationModel> auditorQuestionList = new ArrayList<AuditObservationModel>();
		
		try {
			
			String value = "SET @P_auditId='" + id + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
			.setParameter("actionType", "auditorQuestionList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				String Date = "";
				if (m[9] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[9]);
				}
				AuditObservationModel note = new AuditObservationModel( null,m[10].toString(), null, null, null,null, null, null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Date, m[0].toString(),m[1], m[2], m[3],m[4], m[5], m[6], m[7], m[8]);
				auditorQuestionList.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAuditorQuestionList ends");
		System.out.println(auditorQuestionList);
		return auditorQuestionList;
		
	}
	/*
	 *
	 * get Audit Note By id dao
	 */
	public List<AuditObservationModel> getAuditorIRSList(String id) {
		
		logger.info("Method in Dao: getAuditorIRSList ends");
		
		List<AuditObservationModel> getAuditorIRSList = new ArrayList<AuditObservationModel>();
		
		try {
			
			String value = "SET @P_auditId='" + id + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
			.setParameter("actionType", "auditorIRSList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				String Date = "";
				if (m[9] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[9]);
				}
				AuditObservationModel note = new AuditObservationModel(null, m[10].toString(), null, null, null,null, null, null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Date, m[0].toString(),m[1], m[2], m[3],m[4], m[5], m[6], m[7], m[8]);
				getAuditorIRSList.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAuditorIRSList ends");
		System.out.println(getAuditorIRSList);
		return getAuditorIRSList;
		
	}
	
	public List<AuditObservationModel> getAuditorParaList(String id) {
		
		logger.info("Method in Dao: getAuditorParaList ends");
		
		List<AuditObservationModel> getAuditorParaList = new ArrayList<AuditObservationModel>();
		
		try {
			
			String value = "SET @P_auditId='" + id + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
			.setParameter("actionType", "auditorDraftList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				String Date = "";
				if (m[9] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[9]);
				}
				AuditObservationModel note = new AuditObservationModel(null, m[10].toString(), null, null, null,null, null, null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Date, m[0].toString(),m[1], m[2], m[3],m[4], m[5], m[6], m[7], m[8]);
				getAuditorParaList.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAuditorParaList ends");
		System.out.println("getAuditorParaList "+getAuditorParaList);
		return getAuditorParaList;
		
	}
	
	public List<AuditObservationModel> getAuditorCocoList(String id) {
		
		logger.info("Method in Dao: getAuditorCocoList ends");
		
		List<AuditObservationModel> getAuditorCocoList = new ArrayList<AuditObservationModel>();
		//System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		
		try {
			
			String value = "SET @P_auditId='" + id + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
			.setParameter("actionType", "auditorCocoList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				String Date = "";
				if (m[9] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[9]);
				}
				AuditObservationModel note = new AuditObservationModel(null, m[10].toString(), null, null, null,null, null, null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Date, m[0].toString(),m[1], m[2], m[3],m[4], m[5], m[6], m[7], m[8]);
				getAuditorCocoList.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAuditorCocoList ends");
		System.out.println("getAuditorParaList "+getAuditorCocoList);
		return getAuditorCocoList;
		
	}
	/*
	 *
	 * get Audit Note By id dao
	 */
	public List<AuditObservationModel> getAuditorDraftParaList(String id) {
		
		logger.info("Method in Dao: getAuditorDraftParaList ends");
		
		List<AuditObservationModel> getAuditorDraftList = new ArrayList<AuditObservationModel>();
		
		try {
			
			String value = "SET @P_auditId='" + id + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
			.setParameter("actionType", "auditorParaList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				String Date = "";
				if (m[9] != null) {
					Date = (String) DateFormatter.returnStringDateTime(m[9]);
				}
				AuditObservationModel note = new AuditObservationModel(null,  m[10].toString(), null, null, null,null, null, null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Date, m[0].toString(),m[1], m[2], m[3],m[4], m[5], m[6], m[7], m[8]);
				getAuditorDraftList.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAuditorDraftParaList ends");
		System.out.println("getAuditorDraftList "+getAuditorDraftList);
		return getAuditorDraftList;
		
	}

	public List<AuditObservationModel> getQuestionList(String userid, String initiate) {
		logger.info("Method in Dao: getQuestionList ends");

		List<AuditObservationModel> questions = new ArrayList<AuditObservationModel>();

		try {

			@SuppressWarnings("unchecked")
			String value = "SET @p_userId='" + userid + "',@p_initiateId='" + initiate + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getStatuQuestionList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				String DateString = "";
				String Date = "";
				String Time = "";
				if (m[22] != null) {

					DateString = (String) DateFormatter.returnStringDateTime(m[22]);
				}

				AuditObservationModel q = new AuditObservationModel(m[0], m[23], m[24], null, m[1], m[2], m[3], null,
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19], m[20], null, null, null, DateString, null, null, null, null, null, null,null, null, null);
				questions.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getQuestionList ends");

		return questions;

	}

	public List<AuditAdditionalInfoModel> getAuditDocs(String id) {

		logger.info("Method in Dao: getAuditDocs ends");

		List<AuditAdditionalInfoModel> docs = new ArrayList<AuditAdditionalInfoModel>();

		try {

			String value = "SET @P_auditId='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getAuditDocs").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				AuditAdditionalInfoModel doc = new AuditAdditionalInfoModel(m[0], m[1], m[2]);
				docs.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAuditDocs ends");

		return docs;
	}

	public List<AuditObservationModel> getQuestionList(String userid, String auditid, String department,
			String section) {
		logger.info("Method in Dao: getQuestionList ends");

		List<AuditObservationModel> questions = new ArrayList<AuditObservationModel>();

		try {

			String value = "SET @p_id=" + auditid + ", @p_dept='" + department + "', @p_section='" + section
					+ "',@userId='" + userid + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "getStatuQuestionList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				String DateString = "";
				String Date = "";
				String Time = "";
				if (m[24] != null) {

					DateString = (String) DateFormatter.returnStringDateTime(m[24]);
				}

				/*
				 * AuditObservationModel q = new AuditObservationModel(m[0], null, m[24], null,
				 * m[1], m[2], m[3], null, m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11],
				 * m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], null, null,
				 */
				AuditObservationModel q = new AuditObservationModel(m[0], m[1], m[2], null, m[3], m[4], m[5], null,
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], m[22], null, m[27], m[23], DateString, null, m[26], m[25], null, m[28], m[29],m[30], null, null);

				questions.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getQuestionList ends");

		return questions;

	}
	public List<DropDownModel> getAuditReportDtl( String auditid) {
		logger.info("Method in Dao: getAuditReportDtl ends");

		List<DropDownModel> questions = new ArrayList<DropDownModel>();

		try {

			String value = "SET @p_id='" + auditid + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "getAuditReportDtl").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				
				
				DropDownModel q = new DropDownModel(m[0].toString(), m[1].toString());

				questions.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAuditReportDtl ends");
	System.out.println(questions);
		return questions;

	}
	public List<DropDownModel> getReplyOfManagement( String auditid) {
		logger.info("Method in Dao: getReplyOfManagement ends");
		
		List<DropDownModel> questions = new ArrayList<DropDownModel>();
		
		try {
			
			String value = "SET @p_id='" + auditid + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
			.setParameter("actionType", "getReplyOfManagement").setParameter("actionValue", value)
			.getResultList();
			for (Object[] m : x) {
				
				
				DropDownModel q = new DropDownModel(m[0].toString(), m[1].toString());
				
				questions.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getReplyOfManagement ends");
		System.out.println(questions);
		return questions;
		
	}
	public List<DropDownModel> getAuditFinalObservation( String auditid) {
		logger.info("Method in Dao: getAuditFinalObservation ends");
		
		List<DropDownModel> questions = new ArrayList<DropDownModel>();
		
		try {
			
			String value = "SET @p_id='" + auditid + "';";
			System.out.println(value);
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
			.setParameter("actionType", "getFinalObservation").setParameter("actionValue", value)
			.getResultList();
			for (Object[] m : x) {
				
				
				DropDownModel q = new DropDownModel(m[0].toString(), m[1].toString());
				
				questions.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAuditFinalObservation ends");
		System.out.println(questions);
		return questions;
		
	}
	/*
	 * for edit
	 */
	@SuppressWarnings("unchecked")
	public List<AuditInitiateModel> getAudits(String id) {

		logger.info("Method in Dao: getAudits ends");

		List<AuditInitiateModel> auditmstr = new ArrayList<AuditInitiateModel>();

		try {

			String value = "SET @P_initId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getAudit").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				if (m[1] == null) {
					m[1] = "";
				}

				AuditInitiateModel adt = new AuditInitiateModel(null, m[0], m[1], m[2], m[3], null, null, null, null,
						null, m[5], null, null, null, null, null, null, null, null, null, null, null, m[4], null, null,
						null, null, null, null);
				auditmstr.add(adt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getAudits ends");
		return auditmstr;
	}
	

	/*
	 * for edit
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSectionList(String id) {

		logger.info("Method in Dao: getSectionList ends");

		List<DropDownModel> auditmstr = new ArrayList<DropDownModel>();

		try {

			String value = "SET @p_dept='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getSectionList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel adt = new DropDownModel(m[0], m[1]);
				auditmstr.add(adt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getSectionList ends");
		return auditmstr;
	}
	/*
	 * meeting Details
	 */
	
	public ResponseEntity<JsonResponse<Object>> meetingDetails(List<RestAuditMeetingModel> obj) {
		logger.info("Method in Dao: meetingDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		
		if (validity)

			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				String value = GenerateAuditMeetingParameter.addMeeting(obj);
				
				System.out.println("value meeting "+value);
				
				@SuppressWarnings("unchecked")
				List<Object[]> x=	em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "meetingDetails")
						.setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {

						DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
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

		//resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: meetingDetails ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> meetingDetailsAfterAttend(List<RestAuditMeetingModel> obj) {
		logger.info("Method in Dao: meetingDetailsAfterAttend starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		
		if (validity)
			
			try {
				List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
				String value = GenerateAuditMeetingParameter.addMeeting(obj);
				
				System.out.println("value meeting "+value);
				
				@SuppressWarnings("unchecked")
				List<Object[]> x=	em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "meetingDetailsAftAttend")
				.setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						
						DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
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
		
		//resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		
		logger.info("Method in Dao: meetingDetailsAfterAttend ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<List<RestAuditMeetingModel>>> modalMeetingDetailsAfterAttend(Integer obj) {
		logger.info("Method in Dao: modalMeetingDetailsAfterAttend starts");
		
		JsonResponse<List<RestAuditMeetingModel>> resp = new JsonResponse<List<RestAuditMeetingModel>>();
		
			
			try {
				List<RestAuditMeetingModel> dropDownModel = new ArrayList<RestAuditMeetingModel>();
				String value = "SET @P_MeetingId="+obj+";";
				
				System.out.println("value meeting "+value);
				
				@SuppressWarnings("unchecked")
				List<Object[]> x=	em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "modalMeetingDtlsAftAttnd")
				.setParameter("actionValue", value).getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {
						Object date = null;
						if(m[1] != null) {
							date = DateFormatter.returnStringDate(m[1]);
						}
						
						RestAuditMeetingModel data = new RestAuditMeetingModel(m[0],null,null,date,m[2],m[3],null,null,m[4],m[5],m[6],
								m[7],null,null,m[8],m[9]);
						dropDownModel.add(data);
						resp.setBody(dropDownModel);
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
		
		//resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestAuditMeetingModel>>> response = new ResponseEntity<JsonResponse<List<RestAuditMeetingModel>>>(resp, responseHeaders,
				HttpStatus.CREATED);
		
		logger.info("Method in Dao: modalMeetingDetailsAfterAttend ends");
		return response;
	}
	/*
	 *
	 * get Meeting Details Dao
	 */
	public List<RestAuditMeetingModel> getMeetingDetails(String id,String auditType) {

		logger.info("Method in Dao: getMeetingDetails ends");

		List<RestAuditMeetingModel> auditNote = new ArrayList<RestAuditMeetingModel>();

		try {

			String value = "SET @p_auditInitId='" + id + "';";
			if(id.equals("1")) {
				String value1 = "SET @p_auditInitId='" + id + "',@p_auditType='"+auditType+"';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "1stmeetingDetails").setParameter("actionValue", value1).getResultList();
			for (Object[] m : x) {
				String Date = "";
				
				if (m[3] != null) {
					Date = (String) DateFormatter.returnStringDate(m[3]);
					
				}
				RestAuditMeetingModel note = new RestAuditMeetingModel(m[0], m[1], m[2], Date, m[4], m[5], m[6], null,m[7], m[8], null, null, null, null, m[9], null);
				auditNote.add(note);
			}
			}
			else {
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "getMeetingDetails").setParameter("actionValue", value).getResultList();
				
				for (Object[] m : x) {
					String Date = "";
					
					if (m[3] != null) {
						Date = (String) DateFormatter.returnStringDate(m[3]);
						
					}
					RestAuditMeetingModel note = new RestAuditMeetingModel(m[0], m[1], m[2], Date, m[4], m[5], m[6], null,m[7], m[8], null, null, m[9], null, null, null);
					auditNote.add(note);
				}
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getMeetingDetails ends");
		return auditNote;

	}
	public List<DropDownModel> getMeetingDetailsDoc(String id) {

		logger.info("Method in Dao: getMeetingDetailsDoc ends");

		List<DropDownModel> docs = new ArrayList<DropDownModel>();

		try {

			String value = "SET @P_id='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "meetingDetailsDoc").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel doc = new DropDownModel(m[0], m[1]);
				docs.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getMeetingDetailsDoc ends");
		return docs;
	}
	public List<DropDownModel> getAuditNoteByIdDoc(String id) {

		logger.info("Method in Dao: getAuditNoteByIdDoc ends");

		List<DropDownModel> docs = new ArrayList<DropDownModel>();

		try {

			String value = "SET @P_id='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "auditNoteDoc").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel doc = new DropDownModel(m[0], m[1]);
				docs.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAuditNoteByIdDoc ends");
		return docs;
	}
	/*
	 * for all audit initiated
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> documentAutoSearch(String id) {

		logger.info("Method in Dao: documentAutoSearch starts");

		List<DropDownModel> auditInitiateModelList = new ArrayList<DropDownModel>();

		String value = "SET @p_doc='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getDocumentName").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel auditInitiateModel = new DropDownModel(m[0], null);
					auditInitiateModelList.add(auditInitiateModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(auditInitiateModelList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: documentAutoSearch ends");
		return response;
	}
	/*
	 * DAO Function to delete Item of inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteAudit(String id, String createdBy) {
		logger.info("Method : deleteAudit starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_audit='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "deleteAudit").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteAudit ends");
		return response;
	}
	// Edit Response################
			public ResponseEntity<JsonResponse<Object>> uploadDocument(List<RequisitionViewModel> request) {
				logger.info("Method : uploadDocument starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");

				if (validity) {
					try {
						String values = "";
					
							values = GenerateRequestRequisitionDocumentParameter.addDocumentUpload(request);
						
//System.out.println(values);
						em.createNamedStoredProcedureQuery("auditInitiateRoutines").setParameter("actionType", "uploadDocument")
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
				logger.info("Method : uploadDocument ends");
				return response;
			}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeptHeadList(String id) {
		logger.info("Method : getSelectedDeptHeadList starts");

		List<DropDownModel> depHeadList = new ArrayList<DropDownModel>();
		String value = "SET @p_dept= \"(" + id + ")\";";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "getDeptHeadList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				depHeadList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSelectedDeptHeadList ends");
		return depHeadList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSelectedDeptHeadList(String id) {
		logger.info("Method : getSelectedDeptHeadList starts");
		
		List<DropDownModel> depHeadList = new ArrayList<DropDownModel>();
		//String value = "SET @p_dept= \"(" + id + ")\";";
		String value = "SET @p_audit='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "selDeptHeadList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				depHeadList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getSelectedDeptHeadList ends");
		return depHeadList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCCList(String id) {
		logger.info("Method : getCCList starts");
		
		List<DropDownModel> depHeadList = new ArrayList<DropDownModel>();
		//String value = "SET @p_dept= \"(" + id + ")\";";
		String value = "SET @p_audit='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditMasterRoutines")
					.setParameter("actionType", "selCCList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				depHeadList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getCCList ends");
		return depHeadList;
	}
	public ResponseEntity<JsonResponse<Object>> postEmailPassword(String id, String password,String host) {
		logger.info("Method : postEmailPassword starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_user='" + id + "', @p_pass='"+ password +"',@p_host='"+host+"';";
			System.out.println(values);
			em.createNamedStoredProcedureQuery("auditMasterRoutines")
				.setParameter("actionType", "setEmailPassword")
				.setParameter("actionValue", values)
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
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : postEmailPassword ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditNameListByAutoSearch(String id,String  auditTypeId) {
		logger.info("Method : getAuditNameListByAutoSearch Dao starts");
		
		List<DropDownModel> auditNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			
			String value = "SET @p_param1='" + id + "',@p_param2='"+ auditTypeId +"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
					.setParameter("actionType", "getAuditNameList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], null);
				auditNameList.add(dropDownModel);
			}

			resp.setBody(auditNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAuditNameListByAutoSearch Dao ends");
		
		return response;
	}
	/*
	 *
	 * get Meeting Details Dao
	 */
	public List<RestAuditMeetingModel> getMeetingDetailsEachAudit(String id) {

		logger.info("Method in Dao: getMeetingDetails ends");

		List<RestAuditMeetingModel> getMeetingDetailsEachAudit = new ArrayList<RestAuditMeetingModel>();

		try {

			String value = "SET @p_auditInitId='" + id + "';";
			
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("auditInitiateRoutines")
						.setParameter("actionType", "getMeetingDetails").setParameter("actionValue", value).getResultList();
				
				for (Object[] m : x) {
					String Date = "";
					
					if (m[3] != null) {
						Date = (String) DateFormatter.returnStringDate(m[3]);
						
					}
					RestAuditMeetingModel note = new RestAuditMeetingModel(m[0], m[1], m[2], Date, m[4], m[5], m[6], null,m[7], m[8], null, null, m[9], null, null, null);
					getMeetingDetailsEachAudit.add(note);
				}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getMeetingDetailsEachAudit ends");
		System.out.println(getMeetingDetailsEachAudit);
		return getMeetingDetailsEachAudit;

	}
}
