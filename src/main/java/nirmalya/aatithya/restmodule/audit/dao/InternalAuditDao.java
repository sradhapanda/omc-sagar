
package nirmalya.aatithya.restmodule.audit.dao;

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
import org.springframework.web.bind.annotation.RequestBody;

import nirmalya.aatithya.restmodule.audit.model.AuditCommentsModel;
import nirmalya.aatithya.restmodule.audit.model.AuditComplianceModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.InternalRequisitionViewModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterPdfModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.PersonListModel;
import nirmalya.aatithya.restmodule.audit.model.PersonModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditQuestionParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditorParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InternalAuditDao {

	Logger logger = LoggerFactory.getLogger(InternalAuditDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	

	/*
	 * for all audit master
	 */
	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditMasterModel>>> getAllInternalAudit(DataTableRequest request) {

		logger.info("Method in Dao: getAllInternalAudit starts");

		List<AuditMasterModel> auditInitiateModelList = new ArrayList<AuditMasterModel>();

		if (request.getParam3() != null && request.getParam3() != "") {
			request.setParam3(DateFormatter.getStringDate(request.getParam3()));
		}
		if (request.getParam4() != null && request.getParam4() != "") {
			request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "getAllInternalAudit").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object toDate = null;
					Object fromDate = null;
					if(m[10]!=null) {
					
					
					fromDate = DateFormatter.returnStringDate(m[10]);
					}
					if(m[11]!=null) {
					
					toDate = DateFormatter.returnStringDate(m[11]);
					}
					AuditMasterModel auditInitiateModel = new AuditMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], fromDate, toDate, m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							null, m[20], m[21], m[22], m[23],m[24],m[25],m[26],m[27],m[28],m[29], m[30], null, null, null, null, null, null, null, null, null, null, null, null,null);
					auditInitiateModelList.add(auditInitiateModel);

				}

//				if (x.get(0).length > 31) {
//					BigInteger t = (BigInteger) x.get(0)[31];
//					total = Integer.parseInt((t.toString()));
//				}
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

		logger.info("Method in Dao: getAllInternalAudit ends");
		return response;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> fowardedStatuReq(String id, String createdBy) {

		logger.info("Method in Dao: fowardedStatuReq starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "fowardedReq")
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

		logger.info("Method in Dao: fowardedStatuReq ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<AuditObservationModel> getInternQuestionList(Integer id, String deptId, String sectionId,
			String userId) {
		logger.info("Method : getInternQuestionList starts");

		List<AuditObservationModel> ques = new ArrayList<AuditObservationModel>();
		String value = "SET @p_id=" + id + ", @p_dept='" + deptId + "', @p_section='" + sectionId + "',@userId='"
				+ userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "getStatuQuestionList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				AuditObservationModel dropDownModel = new AuditObservationModel(m[0], null, null, null, m[1], m[2],
						m[3], null, m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
						m[17], m[18], m[19],m[20],null,null, null, null, null, null, null, null, null, null,null, null, null);
				ques.add(dropDownModel);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String data="";
		for(int i=0;i<ques.size();i++) {
		String	comment=ques.get(i).getObservation();
		if(comment !=null) {
		data=comment.substring(0, 25);
			ques.get(i).setRegion(data);
		}
		}
		logger.info("Method : getInternQuestionList ends");
		return ques;
	}

	/*
	 * for add other service price
	 */
/*	public ResponseEntity<JsonResponse<Object>> restAddInternQuestion(
			List<AuditObservationModel> auditObservationModel) {

		logger.info("Method in restAddInternQuestion starts");

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
				String values = GenerateAuditQuestionParam.getQuestionParam(auditObservationModel);
				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "addQuestion")
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

		logger.info("Method in restAddInternQuestion ends");

		return response;
	}
*/
	/*public ResponseEntity<JsonResponse<Object>> approveObsInStatutaryAudit(List<AuditObservationModel> observation) {
		logger.info("Method : approveObsInTransAudit starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AuditObservationModel l : observation) {
			if (l.getQuesId() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Question Required");
				break;
			}
		}

		if (validity) {
			try {
				String values = GenerateObservationParameter.approveObservationParam(observation);

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "apprObsStaAudit")
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
		logger.info("Method : approveObsInTransAudit ends");
		return response;
	}*/

/*	public ResponseEntity<JsonResponse<Object>> forwardStatutaryToApprove(List<AuditObservationModel> observation) {
		logger.info("Method : forwardStatutaryToApprove starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AuditObservationModel l : observation) {
			if (l.getQuesId() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Question Required");
				break;
			} else if (l.getObsType() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Observation Type Required");
				break;
			} else if (l.getSeverity() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Severity Required");
				break;
			}
		}

		if (validity) {
			try {
				String values = GenerateObservationParameter.forwardToApproveObservationParam(observation);

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardStatToApprv")
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
		logger.info("Method : forwardStatutaryToApprove ends");
		return response;
	}*/

/*	public ResponseEntity<JsonResponse<Object>> addInternObservation(List<AuditObservationModel> observation) {
		logger.info("Method : addInternObservation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AuditObservationModel l : observation) {
			if (l.getObservation() == null || l.getObservation() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Observation Required");
				break;
			} else if (l.getObsType() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Observation Type Required");
				break;
			}
		}

		if (validity) {
			try {
				String values = GenerateObservationParameter.addObservationParam(observation);

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
						.setParameter("actionType", "addInternObservation").setParameter("actionValue", values)
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
		logger.info("Method : addInternObservation ends");
		return response;
	}*/

	/*
	 * for all audit master
	 */
	public ResponseEntity<JsonResponse<Object>> forwardInternObs(RequisitionViewModel obj) {

		logger.info("Method in Dao: forwardInternObs starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" + obj.getCreatedby() + "',@p_comment='"+obj.getComment()+"';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardInternObs")
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

		logger.info("Method in Dao: forwardInternObs ends");
		return response;
	}

/*	public ResponseEntity<JsonResponse<Object>> auditeeStatuCommentSave(List<AuditComplianceModel> index) {
		logger.info("Method : auditeeStatuCommentSave starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		
		 * if (index.getQuesId() == null) { resp.setMessage("Question Id Required");
		 * validity = false; } else if (index.getAuditId() == null) {
		 * resp.setMessage("Audit Id Required"); validity = false; } else if
		 * (index.getComment() == null || index.getComment() == "") {
		 * resp.setMessage("Comment Required"); validity = false; } else if
		 * (index.getCreatedBy() == null || index.getCreatedBy() == "") {
		 * resp.setMessage("Created By Required"); validity = false; }
		 

		if (validity)
			try {

				String values = GenerateAuditeeParameter.addDocument(index);

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "statuAuditeeSave")
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

		logger.info("Method : auditeeStatuCommentSave ends");
		return response;
	}*/

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditComplianceModel>>> getStatuViewCommentList(Integer id, String userId) {
		logger.info("Method : getStatuViewCommentList starts");

		List<AuditComplianceModel> parkingLot = new ArrayList<AuditComplianceModel>();
		JsonResponse<List<AuditComplianceModel>> resp = new JsonResponse<List<AuditComplianceModel>>();
		try {

			String value = "SET @p_auditId=" + id + ",@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "ComplianceForReport").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[4] != null) {
						date = DateFormatter.returnStringDateTime(m[4]);
					}

					AuditComplianceModel parking = new AuditComplianceModel(m[0], null, m[1], m[2], m[3], null, null,
							null, null, date,m[5],null,null, null, null);
					parkingLot.add(parking);
				}
			}
			resp.setBody(parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AuditComplianceModel>>> response = new ResponseEntity<JsonResponse<List<AuditComplianceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getStatuViewCommentList ends");
		return response;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RequisitionViewModel>> getInternReqDocument(String id, String userId) {
		logger.info("Method in Dao: getInternReqDocument starts");
		JsonResponse<List<RequisitionViewModel>> resp = new JsonResponse<List<RequisitionViewModel>>();
		List<RequisitionViewModel> requisitionViewModel = new ArrayList<RequisitionViewModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_id='" + id + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "viewReqDocument").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDateTime(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							m[6], m[7], m[8], null, null, null, null, null, null, null, null, null, null, null, null);
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

		logger.info("Method : getInternReqDocument ends");
		return resp;
	}

	/*
	 * for get approveAccept
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendStatuRequestRequisition(InternalRequisitionViewModel obj) {
		logger.info("Method in Dao: sendStatuRequestRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		if (obj.getComment() == null || obj.getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}
		if (validity)
			try {

				try {
					String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" + obj.getCreatedby()
							+ "',@p_document='" + obj.getDocument() + "',@p_comment='" + obj.getComment() + "';";
					em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
							.setParameter("actionType", "requestRequisition").setParameter("actionValue", value)
							.execute();

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

		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendStatuRequestRequisition ends");
		return resp;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sendStatuResponseRequisition(RequisitionViewModel obj) {
		logger.info("Method in Dao: sendResponseRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		if (obj.getComment() == null || obj.getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}
		if (validity)

			try {
				String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" + obj.getCreatedby()
						+ "',@p_document='" + obj.getDocument() + "',@p_comment='" + obj.getComment() + "';";

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
						.setParameter("actionType", "responseRequisition").setParameter("actionValue", value).execute();
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "pdfQuestionList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				AuditObservationModel parking = new AuditObservationModel(m[0], null, null, null, m[1], null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null,null,null,null, null, null, null, null, null, null, null, null,null, null, null);
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

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStatuApprovalStage(Integer id, String userId) {
		logger.info("Method : getStatuApprovalStage starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		String value = "SET @p_id=" + id + ", @p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "getApprovalStage").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				dept.add(dropDownModel);
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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
	public ResponseEntity<JsonResponse<Object>> forwardInternReply(String id, String createdBy) {

		logger.info("Method in Dao: forwardInternReply starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardStatuReply")
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

		logger.info("Method in Dao: forwardInternReply ends");
		return response;
	}



	/*
	 * for all audit master
	 */
	public ResponseEntity<JsonResponse<Object>> forwardInternToCo(String id, String createdBy) {

		logger.info("Method in Dao: forwardInternToCo starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardInternToCo")
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

		logger.info("Method in Dao: forwardInternToCo ends");
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

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "auditorSave")
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
	public ResponseEntity<JsonResponse<Object>> cordinatorforwardToAuditor(AuditComplianceModel obj ) {

		logger.info("Method in Dao: cordinatorforwardToAuditor starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" + obj.getCreatedBy() + "',@p_comment='"+obj.getComment()+"';";
						em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
								.setParameter("actionType", "forwardToAuditor").setParameter("actionValue", value)
								.execute();

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
	public ResponseEntity<JsonResponse<Object>> forwardToCrn(AuditComplianceModel obj) {

		logger.info("Method in Dao: forwardToCrn starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + obj.getAuditId() + "',@p_comment='"+obj.getComment()+"',@p_createdBy='" + obj.getCreatedBy() + "';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardToCrn")
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

		logger.info("Method in Dao: forwardToCrn ends");
		return response;
	}

	/*
	 * for get send Response to Requisition
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reqInternForwardBysec(RequisitionViewModel obj) {
		logger.info("Method in Dao: reqInternForwardBysec starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		if (obj.getComment() == null || obj.getComment() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}
		if (validity)

			try {
				String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" + obj.getCreatedby()
						+ "',@p_document='" + obj.getDocument() + "',@p_comment='" + obj.getComment() + "';";
				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "reqInternForwardBysec")
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
		logger.info("Method in Dao: reqInternForwardBysec ends");

		return resp;
	}

	/*
	 * for fowardedReq
	 */
	public ResponseEntity<JsonResponse<Object>> rejectReq(RequisitionViewModel obj) {

		logger.info("Method in Dao: rejectReq starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" + obj.getCreatedby() + "',@p_comment='" + obj.getComment() + "';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "rejectReq")
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

		logger.info("Method in Dao: rejectReq ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveRequisitionComment(RequisitionViewModel summery) {
		logger.info("Method : saveRequisitionComment starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {
			Integer id = summery.getAuditId();
			String summery1 = summery.getComment();
			String value = "SET @p_summery='" + summery1 + "',@p_id='" + id + "'";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "saveRequisitionComment")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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

	public ResponseEntity<JsonResponse<Object>> saveResponse(RequisitionViewModel obj) {
		logger.info("Method : saveResponse starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {

			String value = "SET @p_id='" + obj.getAuditId() + "',@p_summery='" + obj.getComment() + "';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "saveResponse")
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

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSecComment(String queId) {
		logger.info("Method : getSecComment starts");
		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_quesId='" + queId + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "saveObsComment")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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


	public ResponseEntity<JsonResponse<List<DropDownModel>>> getConAudiComment(String queId) {
		logger.info("Method : getConAudiComment starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {
			String value = "SET @p_quesId='" + queId + "';";
			;
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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



	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectResponse(RequisitionViewModel obj) {
		logger.info("Method : rejectResponse starts");
		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {

			@SuppressWarnings("unchecked")

			String value = "SET @p_id='" + obj.getAuditId() + "',@p_comment='" + obj.getComment() + "',@p_createdBy='"
					+ obj.getCreatedby() + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "rejectResponse").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : rejectResponse ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<PersonListModel> getPersonList() {
		logger.info("Method : getPersonList starts");
		List<PersonListModel> dept = new ArrayList<PersonListModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "getPersonList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				PersonListModel dropDownModel = new PersonListModel(m[0], m[1], m[2]);
				dept.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPersonList ends");
		return dept;
	}

	/*
	 * for all audit master
	 */
	public ResponseEntity<JsonResponse<Object>> forwardToPerson(AuditComplianceModel obj) {

		logger.info("Method in Dao: forwardToPerson starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + obj.getAuditId() + "',@p_createdBy='" + obj.getCreatedBy() + "',@p_comment='"+obj.getComment()+"';";
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardToPerson")
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

		logger.info("Method in Dao: forwardToPerson ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectObsBySec(String id, String comment,
			String createdBy) {
		logger.info("Method : rejectObsBySec starts");

		List<DropDownModel> summery = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setMessage("");

		try {

			@SuppressWarnings("unchecked")

			String value = "SET @p_id='" + id + "',@p_comment='" + comment + "',@p_createdBy='" + createdBy + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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

	public ResponseEntity<JsonResponse<Object>> rejectObsByCoordinator(RequisitionViewModel obj ) {
		logger.info("Method : rejectObsByCoordinator starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity) {

		try {

			String value = "SET @p_id='" + obj.getAuditId() + "',@p_comment='" + obj.getComment() + "',@p_createdBy='" + obj.getCreatedby() + "';";
			
			 em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
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

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "addViewRequest")
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

				em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "addViewRequest")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "EditviewReqDocument").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDateTime(m[5]);
					}
					RequisitionViewModel dropDownModel = new RequisitionViewModel(m[0], m[1], m[2], m[3], m[4], date,
							m[6], null, null, null, null, null, null, null, null, null, null, null, null, null, null);
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
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardToAuditor")
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

			@SuppressWarnings("unchecked")

			String value = "SET @p_id='" + obj.getAuditId() + "',@p_comment='" + obj.getComment() + "',@p_createdBy='"
					+ obj.getCreatedBy() + "';";
			// @SuppressWarnings("unchecked")
			em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "rejectObs")
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
	public ResponseEntity<JsonResponse<List<PersonModel>>>getPersonList(String id) {

		logger.info("Method in Dao: getPersonList starts");
		JsonResponse<List<PersonModel>>resp = new JsonResponse<List<PersonModel>>();
		List<PersonModel> dept = new ArrayList<PersonModel>();
		try {

			String value = "SET @p_id='" + id + "';";
			List<Object[]> x=em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "personList")
					.setParameter("actionValue", value).getResultList();

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
		ResponseEntity<JsonResponse<List<PersonModel>>> response = new ResponseEntity<JsonResponse<List<PersonModel>>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: getPersonList ends");
		return response;
	}
	/*
	 * for all audit master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> coordinatorInternforward(@RequestBody AuditComplianceModel obj ) {

		logger.info("Method in Dao: coordinatorInternforward starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
						///String value = GenerateAuditMasterParameter.forwardAudit(obj);
						em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
								.setParameter("actionType", "coordinatorInternforward").setParameter("actionValue", "")
								.execute();

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

		logger.info("Method in Dao: coordinatorInternforward ends");
		return response;
	}
	/*
	 * for get Person List
	 */
	@SuppressWarnings("unchecked")
	public  List<DropDownModel>getforwardInternPersonList(String id) {

		logger.info("Method in Dao: getforwardInternPersonList starts");
		
		List<DropDownModel> forwardPersonList = new ArrayList<DropDownModel>();
		try {

			String value = "SET @p_id='" + id + "';";
			List<Object[]> x=em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "forwardPersonList")
					.setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					forwardPersonList.add(dropDownModel);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		logger.info("Method in Dao: getforwardInternPersonList ends");
		return forwardPersonList;
	}
	/*
	 * for get Person List
	 */
	@SuppressWarnings("unchecked")
	public  List<DropDownModel>frowardPersonCCList(String id) {
		logger.info("Method in Dao: frowardPersonCCList starts");		
		List<DropDownModel> frowardPersonCCList = new ArrayList<DropDownModel>();
		try {

			String value = "SET @p_id='" + id + "';";			
			List<Object[]> x=em.createNamedStoredProcedureQuery("internalAuditMasterRoutines").setParameter("actionType", "frowardPersonCCList")
					.setParameter("actionValue", value).getResultList();

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
	@SuppressWarnings("unchecked")
	public List<AuditObservationModel> getInternQuestionListForApprove(Integer id) {
		logger.info("Method : getInternQuestionListForApprove starts");
		
		List<AuditObservationModel> ques = new ArrayList<AuditObservationModel>();
		String value = "SET @p_id=" + id + ";";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "getQuestionListForApprv")
					.setParameter("actionValue", value)
					.getResultList();
			
			for(Object[] m : x) {
				AuditObservationModel dropDownModel = new AuditObservationModel(m[0],null,null,null,m[1],m[2],m[3],null,m[4],m[5],m[6],m[7],m[8],m[9],null,null,null,null,null,null,null,null,null,null,null, null, null,  null, null, null, null, null, null, null, null,null, null, null);
				ques.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInternQuestionListForApprove ends");
		return ques;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditComplianceModel>>> forwardDetails(Integer id, String userId) {
		logger.info("Method : forwardDetails starts");

		List<AuditComplianceModel> parkingLot = new ArrayList<AuditComplianceModel>();
		JsonResponse<List<AuditComplianceModel>> resp = new JsonResponse<List<AuditComplianceModel>>();
		try {

			String value = "SET @p_auditId=" + id + ",@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "forwardDetails").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[4] != null) {
						date = DateFormatter.returnStringDateTime(m[4]);
					}

					AuditComplianceModel parking = new AuditComplianceModel(m[0], m[1],  m[2],null, m[3], null, null,
							null, null, date,null,null,null, null, null);
					parkingLot.add(parking);
				}
			}

			resp.setBody(parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AuditComplianceModel>>> response = new ResponseEntity<JsonResponse<List<AuditComplianceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : forwardDetails ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditComplianceModel>>> forwardCommentDetails(Integer id, String userId) {
		logger.info("Method : forwardCommentDetails starts");

		List<AuditComplianceModel> parkingLot = new ArrayList<AuditComplianceModel>();
		JsonResponse<List<AuditComplianceModel>> resp = new JsonResponse<List<AuditComplianceModel>>();
		try {

			String value = "SET @p_auditId=" + id + ",@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("internalAuditMasterRoutines")
					.setParameter("actionType", "forwardCommentDetails").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[4] != null) {
						date = DateFormatter.returnStringDateTime(m[4]);
					}

					AuditComplianceModel parking = new AuditComplianceModel(m[0], m[1],  m[2],null, m[3], null, null,
							null, null, date,null,null,null, null, null);
					parkingLot.add(parking);
				}
			}

			resp.setBody(parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AuditComplianceModel>>> response = new ResponseEntity<JsonResponse<List<AuditComplianceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : forwardCommentDetails ends");
		return response;
	}

	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditComplianceModel>>> getCommentList(Integer id, String userId) {
		logger.info("Method : getStatuViewCommentList starts");

		List<AuditComplianceModel> parkingLot = new ArrayList<AuditComplianceModel>();
		JsonResponse<List<AuditComplianceModel>> resp = new JsonResponse<List<AuditComplianceModel>>();
		try {

			String value = "SET @p_quesId=" + id + ",@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("statutaryRoutines")
					.setParameter("actionType", "ComplianceForReport").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[4] != null) {
						date = DateFormatter.returnStringDateTime(m[4]);
					}

					AuditComplianceModel parking = new AuditComplianceModel(m[0], null, m[1], m[2], m[3], null, null,
							null, null, date,m[5],null,null, null, null);
					parkingLot.add(parking);
				}
			}
			resp.setBody(parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AuditComplianceModel>>> response = new ResponseEntity<JsonResponse<List<AuditComplianceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getStatuViewCommentList ends");
		
		return response;
	}


}
