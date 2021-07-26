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

import nirmalya.aatithya.restmodule.audit.model.AuditHistoryRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class RestAuditHistoryDao {
	Logger logger = LoggerFactory.getLogger(RestAuditHistoryDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	/*
	 * for all concession details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>> getAuditHistoryDetails(DataTableRequest request) {

		logger.info("Method in Dao: getAuditHistoryDetails starts");

		List<AuditHistoryRestModel> historyList = new ArrayList<AuditHistoryRestModel>();
	
		Integer total = 0;
		String values = GenerateParameter.getSearchParam(request);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditHistoryRoutine")
					.setParameter("actionType", "viewhistoryList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					
					Object date = null;

					if (m[3] != null) {
						date = DateFormatter.returnStringDateTime(m[3]);
					}
					AuditHistoryRestModel hist = new AuditHistoryRestModel(m[0], m[1].toString(), m[2], date,m[4]);
					historyList.add(hist);

				}

				if (x.get(0).length >5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditHistoryRestModel>> resp = new JsonResponse<List<AuditHistoryRestModel>>();
		resp.setBody(historyList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>> response = new ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAuditHistoryDetails ends");
		return response;
	}
	/**
	 * DAO REPORT
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>> getAuditHitpdf(DataTableRequest request) {
		logger.info("Method : DAO getIpdReport starts");

		List<AuditHistoryRestModel> pdfList = new ArrayList<AuditHistoryRestModel>();
		JsonResponse<List<AuditHistoryRestModel>> resp = new JsonResponse<List<AuditHistoryRestModel>>();
		
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);

			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);

			request.setParam2(tDate);
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditHistoryRoutine").setParameter("actionType", "viewhistorypdf")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object date = null;

				if (m[2] != null) {
					date = DateFormatter.returnStringDate(m[2]);
				}
				AuditHistoryRestModel hist = new AuditHistoryRestModel(m[0], m[1], date, m[3], m[4]);
				pdfList.add(hist);

			}
				
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		resp.setBody(pdfList);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>> response = new ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getIpdReport ends");
		return response;
	}

}
