
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

import nirmalya.aatithya.restmodule.audit.model.AuditDetailModel;
import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditInitiateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InitiateInternalAuditDao {

	Logger logger = LoggerFactory.getLogger(InitiateInternalAuditDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * DAO - Get Audit Type For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInternalAuditType() {
		logger.info("Method : getInternalAuditType starts");

		List<DropDownModel> auditType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "getAuditType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getInternalAuditType ends");
		return auditType;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRegion() {
		logger.info("Method : getRegion starts");
		
		List<DropDownModel> auditType = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "getRegion").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditType.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getRegion ends");
		return auditType;
	}
	
	/*
	 * for all audit initiated
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInternalAuditor(String region) {

		logger.info("Method in Dao: getInternalAuditor starts");

		List<DropDownModel> auditInitiateModelList = new ArrayList<DropDownModel>();
		
		String value = "SET @p_region='" + region + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "auditorName").setParameter("actionValue", value)
					.getResultList();
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
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getInternalAuditor ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> initiateAudit(AuditInitiateModel auditInitiate) {
		logger.info("Method : initiateAuditDao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (auditInitiate.getAuditType() == null || auditInitiate.getAuditType() == "") {
			resp.setMessage("Audit Type Required");
			validity = false;
		} /*
			 * else if (auditInitiate.getRegion()== null || auditInitiate.getRegion() == "")
			 * { resp.setMessage("Region Required"); validity = false; } else if
			 * (auditInitiate.getAuditor() == null || auditInitiate.getRegionalManager() ==
			 * "") { resp.setMessage("Auditor Required"); validity = false; } else if
			 * (auditInitiate.getRegionalManager() == null || auditInitiate.getAuditor() ==
			 * "") { resp.setMessage("Regional Manager Required"); validity = false; } else
			 * if (auditInitiate.getConcernedFinance() == null ||
			 * auditInitiate.getConcernedFinance() == "") {
			 * resp.setMessage("Concerned Finance Required"); validity = false; }else if
			 * (auditInitiate.getQuarter() == null || auditInitiate.getQuarter() == "") {
			 * resp.setMessage("Quarter Required"); validity = false; }
			 */else if (auditInitiate.getInitiatedDate() == null || auditInitiate.getInitiatedDate() == "") {
			resp.setMessage("Initiated Date Required");
			validity = false;
		}else if (auditInitiate.getFinancialYear()== null || auditInitiate.getFinancialYear() == "") {
			resp.setMessage("Financial Year Required");
			validity = false;
		} else if (auditInitiate.getSummary() == null || auditInitiate.getSummary() == "") {
			resp.setMessage("Summary Required");
			validity = false;
		}
			
		if (validity)
			try {
				String values = GenerateAuditInitiateParameter.initiateInternalAudit(auditInitiate);

				if (auditInitiate.getAuditInitiate() != null && auditInitiate.getAuditInitiate() != "") {
					em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
							.setParameter("actionType", "modifyAudit").setParameter("actionValue", values).execute();
					resp.setCode("Data Saved Successfully");
				} else {
					em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
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
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
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
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "viewInitiatedAudit").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object date = null;
					date = DateFormatter.returnStringDate(m[4]);
					AuditInitiateModel auditInitiateModel = new AuditInitiateModel(m[0], m[1], m[2], m[3], date, m[5],
							m[6], m[7], null, m[8], m[9],null,null,null,null,null,m[10], null, null, null, null, null, null, null, null, null, null, null, null);
					auditInitiateModelList.add(auditInitiateModel);

				}

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}
			}
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
	 * for  Regional Manager
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRegionalManager(String id) {

		logger.info("Method in Dao: getRegionalManager starts");

		List<DropDownModel> auditInitiateModelList = new ArrayList<DropDownModel>();
		
		String value = "SET @p_region='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "regionalManager").setParameter("actionValue", value)
					.getResultList();
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
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getRegionalManager ends");
		return response;
	}
	/*
	 * for  Regional Manager
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getConcernFinance(String id) {

		logger.info("Method in Dao: getConcernFinance starts");

		List<DropDownModel> auditInitiateModelList = new ArrayList<DropDownModel>();
		
		String value = "SET @p_region='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "getConcernFinance").setParameter("actionValue", value)
					.getResultList();
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
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getConcernFinance ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveSummery(String summery) {
		logger.info("Method : saveSummery starts");

		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		
			try {

				String value = "SET @p_summery='" + summery + "';";
				em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
				.setParameter("actionType", "saveSummery").setParameter("actionValue", value)
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
				List<Object[]> x =	em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
				.setParameter("actionType", "getSummery").setParameter("actionValue", "")
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
		ResponseEntity<JsonResponse<List<DropDownModel>> >response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getSummery ends");
		return response;
	}
	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendDetails(AuditInitiateModel obj) {
		logger.info("Method in Dao: sendDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		if (obj.getSummary() == null || obj.getSummary()== "") {
			resp.setMessage("Comment Required");
			validity = false;
		} 
		if (validity)
			
				
				try {
					String value = "SET @p_id='" + obj.getAuditInitiate() + "',@p_createdBy='" + obj.getCreatedBy() + "',@p_document='" + obj.getDocument()
							+ "',@p_comment='" + obj.getSummary() + "';";
					em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines").setParameter("actionType", "sendDetails")
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
		logger.info("Method in Dao: sendDetails ends");

		return resp;
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
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
			em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines").setParameter("actionType", "saveNotes")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines").setParameter("actionType", "getNotes")
					.setParameter("actionValue", value).getResultList();
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
	public List<DropDownModel> getQuarter() {

		logger.info("Method in Dao: getQuarter starts");

		List<DropDownModel> auditInitiateModelList = new ArrayList<DropDownModel>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "getQuarter").setParameter("actionValue", "")
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					
					DropDownModel auditInitiateModel = new DropDownModel(m[0], m[1]);
					auditInitiateModelList.add(auditInitiateModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		logger.info("Method in Dao: getQuarter ends");
		return auditInitiateModelList;
	}
	/*
	 * for all audit initiated
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFolderName() {

		logger.info("Method in Dao: getFolderName starts");

		List<DropDownModel> auditInitiateModelList = new ArrayList<DropDownModel>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
					.setParameter("actionType", "getFolderName").setParameter("actionValue", "")
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					
					DropDownModel auditInitiateModel = new DropDownModel(m[0], m[1]);
					auditInitiateModelList.add(auditInitiateModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		logger.info("Method in Dao: getFolderName ends");
		return auditInitiateModelList;
	}
	/**
	*Folder auto search
	*
	*/
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getFolderByAutoSearch(String id) {
	logger.info("Method : getFolderByAutoSearch Dao starts");

	List<DropDownModel> folderList = new ArrayList<DropDownModel>();
	JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
	System.out.println("%%%$$%%"+id);
	try {

	String value = "SET @p_FName='" + id + "';";
	System.out.println("@@@@@@"+value);
	List<Object[]> x = em.createNamedStoredProcedureQuery("InitiateInternalAuditRoutines")
	.setParameter("actionType", "getFoldersList1").setParameter("actionValue", value).getResultList();

	for (Object[] m : x) {
	DropDownModel dropDownModel1 = new DropDownModel(m[0], m[1]);
	folderList.add(dropDownModel1);
	System.out.println("***&&&****"+folderList);
	}

	resp.setBody(folderList);

	} catch (Exception e) {
	e.printStackTrace();
	}

	ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
	resp, HttpStatus.CREATED);

	logger.info("Method : getFolderByAutoSearch Dao ends");
	return response;
	}
}