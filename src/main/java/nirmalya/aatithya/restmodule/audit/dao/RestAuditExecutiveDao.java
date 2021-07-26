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

import nirmalya.aatithya.restmodule.audit.model.RestAuditExecutiveModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditExecutiveParam;

import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAuditExecutiveDao {
	Logger logger = LoggerFactory.getLogger(RestAuditExecutiveDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFinanceYear() {

		logger.info("Method : getFinanceYear starts");

		List<DropDownModel> auditList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("executiveRoutines")
					.setParameter("actionType", "getFinanceYearList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFinanceYear ends");
		return auditList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartment() {

		logger.info("Method : getDepartment starts");

		List<DropDownModel> auditList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("executiveRoutines")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartment ends");
		return auditList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditType() {

		logger.info("Method : getAuditType starts");

		List<DropDownModel> auditList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("executiveRoutines")
					.setParameter("actionType", "getAuditTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditType ends");
		return auditList;
	}
	public ResponseEntity<JsonResponse<Object>> restAddAuditExecutive(
			List<RestAuditExecutiveModel> auditExecutiveModel) {

		logger.info("Method in Dao: restAddAuditExecutive starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = auditExecutiveModel.get(0).getExecutiveId();

		for (RestAuditExecutiveModel a : auditExecutiveModel) {
			if (a.getFinancialYearId() == null || a.getFinancialYearId() == "") {
				resp.setMessage("Financial Year not Selected");
				validity = false;
			} /*else if (a.getAuditTypeId() == null || a.getAuditTypeId() == "") {
				resp.setMessage(" Audit Type is not Selected");
				validity = false;
			}*/ else if (a.getDepartmentId() == null || a.getDepartmentId() == "") {
				resp.setMessage("department Is not selected");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateAuditExecutiveParam.getAddAuditExecutivParam(auditExecutiveModel);
				if (id != null && id != "") {

					em.createNamedStoredProcedureQuery("executiveRoutines")
							.setParameter("actionType", "modifyEmployeeLang").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("executiveRoutines")
							.setParameter("actionType", "addExecutive").setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: restAddAuditExecutive ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAuditExecutiveModel>>> getExecutiveDtls(DataTableRequest request) {

		logger.info("Method in Dao: getExecutiveDtls starts");

		List<RestAuditExecutiveModel> executiveList = new ArrayList<RestAuditExecutiveModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("executiveRoutines")
					.setParameter("actionType", "getExecutiveSummary").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					RestAuditExecutiveModel restAuditExecutiveModel = new RestAuditExecutiveModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9],null,m[10],null);
					executiveList.add(restAuditExecutiveModel);

				}

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestAuditExecutiveModel>> resp = new JsonResponse<List<RestAuditExecutiveModel>>();
		resp.setBody(executiveList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestAuditExecutiveModel>>> response = new ResponseEntity<JsonResponse<List<RestAuditExecutiveModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getExecutiveDtls ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public List<RestAuditExecutiveModel> getExecutiveDtlsList(String id) {

		logger.info("Method : getExecutiveDtls starts");

		List<RestAuditExecutiveModel> executiveList = new ArrayList<RestAuditExecutiveModel>();
		String value = "SET @P_id='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("executiveRoutines")
					.setParameter("actionType", "ExecutiveDtlsList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAuditExecutiveModel restAuditExecutiveModel = new RestAuditExecutiveModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9],null,m[10],null);
				executiveList.add(restAuditExecutiveModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getExecutiveDtls ends");
		return executiveList;
	}
	@SuppressWarnings("unchecked")
	public List<RestAuditExecutiveModel> getExecutiveDtlsListCheck(String id) {

		logger.info("Method : getExecutiveDtlsListCheck starts");

		List<RestAuditExecutiveModel> executiveList = new ArrayList<RestAuditExecutiveModel>();
		String value = "SET @P_id='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("executiveRoutines")
					.setParameter("actionType", "executiveDtlsListCheck").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAuditExecutiveModel restAuditExecutiveModel = new RestAuditExecutiveModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9],null,m[10],null);
				executiveList.add(restAuditExecutiveModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println(executiveList);
		logger.info("Method : getExecutiveDtlsListCheck ends");
		return executiveList;
	}
}
