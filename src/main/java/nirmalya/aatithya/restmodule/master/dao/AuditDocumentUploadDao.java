package nirmalya.aatithya.restmodule.master.dao;

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

import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditQuestionParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditUploadDocumentParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.AuditUploadDocumentReportModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AuditDocumentUploadDao {
	Logger logger = LoggerFactory.getLogger(AuditDocumentUploadDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	public ResponseEntity<JsonResponse<Object>> restAddAuditDocument(
			List<AuditUploadDocumentReportModel> auditUploadDocumentReportModel) {

		logger.info("Method in restAddAuditDocument starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AuditUploadDocumentReportModel a : auditUploadDocumentReportModel) {
			if (a.getYear() == null || a.getYear() == "") {
				resp.setMessage("Year Can not beleft Blank.");
			}

		}
		if (validity)
			try {
				String values = GenerateAuditUploadDocumentParameter.getUploadAuditDociumentParam(auditUploadDocumentReportModel);
				em.createNamedStoredProcedureQuery("auditUploadDocumentRoutine").setParameter("actionType", "addAuditUpDoc")
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

		logger.info("Method in restAddAuditDocument ends");

		return response;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditType() {
		logger.info("Method : getAuditType starts");

		List<DropDownModel> auditType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditUploadDocumentRoutine")
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
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditUploadDocumentReportModel>>> getAllUploadDocument(DataTableRequest request) {

		logger.info("Method in Dao: getAllUploadDocument starts");

		List<AuditUploadDocumentReportModel> auditUploadDocumentList = new ArrayList<AuditUploadDocumentReportModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditUploadDocumentRoutine")
					.setParameter("actionType", "viewUploadDocAudit").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					//Object date = null;
					//date = DateFormatter.returnStringDate(m[4]);
					AuditUploadDocumentReportModel auditUploadDocumentReportModel = new AuditUploadDocumentReportModel(m[0], m[1], m[2], m[3], m[4]);
					auditUploadDocumentList.add(auditUploadDocumentReportModel);

				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditUploadDocumentReportModel>> resp = new JsonResponse<List<AuditUploadDocumentReportModel>>();
		resp.setBody(auditUploadDocumentList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditUploadDocumentReportModel>>> response = new ResponseEntity<JsonResponse<List<AuditUploadDocumentReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllUploadDocument ends");
		System.out.println(response);
		return response;
	}

}
