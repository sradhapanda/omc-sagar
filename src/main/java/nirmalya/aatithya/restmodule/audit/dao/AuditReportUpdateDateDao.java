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
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditReportUpdateDateModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditDraftDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AuditReportUpdateDateDao {
	Logger logger = LoggerFactory.getLogger(AuditReportUpdateDateDao.class);
	
	@Autowired
	EntityManager em;
	
	@Autowired
	ServerDao serverDao;
	
	
	/*
	 * Dao-get all report ids
	 */
	public List<DropDownModel> getReportIds(String id){
		logger.info("Dao-get all report ids starts");
		
		List<DropDownModel> reportIds = new ArrayList<DropDownModel>();
		String value = "SET @p_initiateId='"+id+"';";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditReportUpdateDateRutines")
			.setParameter("actionType","getReportIds").setParameter("actionValue", value).getResultList();
			for(Object[] m : x) {
				DropDownModel dm = new DropDownModel(m[0],m[1]);
				reportIds.add(dm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Dao-get all report ids ends");
		return reportIds;
	}
	/*
	 * Dao-get all report ids
	 */
	public List<DropDownModel> getDescription(){
		logger.info("Dao-get all report ids starts");
		
		List<DropDownModel> reportIds = new ArrayList<DropDownModel>();
		
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditReportUpdateDateRutines")
			.setParameter("actionType","getDescription").setParameter("actionValue", "").getResultList();
			for(Object[] m : x) {
				DropDownModel dm = new DropDownModel(m[0],m[1]);
				reportIds.add(dm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Dao-get all report ids ends");
		return reportIds;
	}

	public ResponseEntity<JsonResponse<Object>> updateDate(List<RestAuditReportUpdateDateModel> data) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;

		if (data.get(0).getDate() == null || data.get(0).getDate() == "") {
			resp.setMessage("Comment Required");
			validity = false;
		}
		
		if (validity)
				try {
					
					if(data.get(0).getIsEdit()!=null ) {
						String value = GenerateAuditDraftDetailsParameter.getUpdateDateParams(data);
						em.createNamedStoredProcedureQuery("auditReportUpdateDateRutines").setParameter("actionType", "updateReportDate")
						.setParameter("actionValue", value).execute();
					}else {
						String value = GenerateAuditDraftDetailsParameter.getUpdateDateParams(data);
						em.createNamedStoredProcedureQuery("auditReportUpdateDateRutines").setParameter("actionType", "saveReportDate")
						.setParameter("actionValue", value).execute();
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

		return response;
	}

	
	/*
	 * for all report dates
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAuditReportUpdateDateModel>>> getAllReportDates(
			DataTableRequest request) {
		logger.info("Method in Dao: getAllReportDates starts");

		List<RestAuditReportUpdateDateModel> reportDatelList = new ArrayList<RestAuditReportUpdateDateModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditReportUpdateDateRutines")
					.setParameter("actionType", "getAllReportDates").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object date = null;
					//date = DateFormatter.returnStringDate(m[4]);
					RestAuditReportUpdateDateModel model = new RestAuditReportUpdateDateModel(m[1],m[2],null,m[4],m[5],m[3],null,null,null,null,null);
					reportDatelList.add(model);

				}

				/*if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAuditReportUpdateDateModel>> resp = new JsonResponse<List<RestAuditReportUpdateDateModel>>();
		resp.setBody(reportDatelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestAuditReportUpdateDateModel>>> response = new ResponseEntity<JsonResponse<List<RestAuditReportUpdateDateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllReportDates ends");
	
		return response;
	}

	/*
	 * Dao-get report updatedDate by id
	 */
	public List<RestAuditReportUpdateDateModel> getUpdatedDateById(String id) {
		
		logger.info("Method in Dao: getUpdatedDateById ends");
		
		String values = "SET @p_reportId='"+id+"';";
		List<RestAuditReportUpdateDateModel> reportDatelList = new ArrayList<RestAuditReportUpdateDateModel>();

		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditReportUpdateDateRutines")
					.setParameter("actionType", "getReportDateById").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if(m[8]!=null) {
					date = DateFormatter.returnStringDate(m[8]);
					}
					Object date1 = null;
					if(m[9]!=null) {
						date1 = DateFormatter.returnStringDate(m[9]);
					}
					RestAuditReportUpdateDateModel model = new RestAuditReportUpdateDateModel(m[0],m[1],m[2],m[3],m[4],m[5],null,m[6],m[7],date,date1);
					reportDatelList.add(model);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getUpdatedDateById ends");
		return reportDatelList;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public ResponseEntity<JsonResponse<List<AuditMasterModel>>> getUpdatedReports(DataTableRequest request) {
		
		logger.info("Method in Dao: getUpdatedReports starts");

		List<AuditMasterModel> reportDatelList = new ArrayList<AuditMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditReportUpdateDateRutines")
					.setParameter("actionType", "getUpdatedReports").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object date = null;
					date = DateFormatter.returnStringDate(m[5]);
					AuditMasterModel model = new AuditMasterModel(null,m[2],m[3],null,null,null,null,null,m[0],null,null,null,
							null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,date,null,null,
							true,null,null,null,null,null,null,null,null,null,null, m[4], null,null);
					reportDatelList.add(model);

				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AuditMasterModel>> resp = new JsonResponse<List<AuditMasterModel>>();
		resp.setBody(reportDatelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditMasterModel>>> response = new ResponseEntity<JsonResponse<List<AuditMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getUpdatedReports ends");
	

		return response;
	}

}
