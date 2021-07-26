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
import nirmalya.aatithya.restmodule.audit.model.AuditPartyMasterModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditPartyParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AuditPartyMasterDao {

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(AuditPartyMasterDao.class);

	// Add AuditParty Master
	public ResponseEntity<JsonResponse<Object>> addAuditParty(AuditPartyMasterModel auditParty) {
		logger.info("Method : addAuditParty DAo starts");

		Boolean valid = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		if (auditParty.getAuditPartyFirstName() == null || auditParty.getAuditPartyFirstName() == "") {
			resp.setMessage("Audit Party First Name can't be Empty");
			valid = false;
		}
		if (auditParty.getAuditPartyLastName() == null || auditParty.getAuditPartyLastName() == "") {
			resp.setMessage("Audit Party Last Name can't be Empty");
			valid = false;
		}
		if (auditParty.getAuditPartyDesc() == null || auditParty.getAuditPartyDesc() == "") {
			resp.setMessage("Description can't be Empty");
			valid = false;
		}
		if (auditParty.getAuditPartyActive() == null) {
			resp.setMessage("Status can't be left empty");
			valid = false;
		}
		if (valid) {
			String values = GenerateAuditPartyParameter.addStructParam(auditParty);


			if (auditParty.getAuditPartyId() != null && auditParty.getAuditPartyId() != "") {
				em.createNamedStoredProcedureQuery("masterAuditPartyRoutines")
						.setParameter("actionType", "modifyAuditParty").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("masterAuditPartyRoutines")
						.setParameter("actionType", "addAuditParty").setParameter("actionValue", values).execute();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addAuditParty Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AuditPartyMasterModel>>> getAuditParty(DataTableRequest request) {
		logger.info("Method : getAuditParty Dao starts");

		List<AuditPartyMasterModel> auditParty = new ArrayList<AuditPartyMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterAuditPartyRoutines")
					.setParameter("actionType", "viewAuditParty").setParameter("actionValue", values).getResultList();
			int i=1;
			for (Object[] m : x) {
				m[6]=i;
				AuditPartyMasterModel audit = new AuditPartyMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				auditParty.add(audit);
				i++;
			}

			if (x.size() > 0) {

				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AuditPartyMasterModel>> resp = new JsonResponse<List<AuditPartyMasterModel>>();
		resp.setBody(auditParty);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AuditPartyMasterModel>>> response = new ResponseEntity<JsonResponse<List<AuditPartyMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAuditParty Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AuditPartyMasterModel>> viewAuditModelView(String id) {
		logger.info("Method : viewAuditModelView Dao starts");
		List<AuditPartyMasterModel> form = new ArrayList<AuditPartyMasterModel>();

		try {
			String values = "SET @p_auditId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterAuditPartyRoutines")
					.setParameter("actionType", "auditModelView").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					
					AuditPartyMasterModel audit = new AuditPartyMasterModel(m[0], m[1], m[2], m[3], null, null, null);
					form.add(audit);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<AuditPartyMasterModel> auditParty = new JsonResponse<AuditPartyMasterModel>();
		auditParty.setBody(form.get(0));

		ResponseEntity<JsonResponse<AuditPartyMasterModel>> response = new ResponseEntity<JsonResponse<AuditPartyMasterModel>>(
				auditParty, HttpStatus.CREATED);
		logger.info("Method : viewAuditModelView Dao ends");
		return response;
	}

	// DELETE AUDIT PARTY
	public ResponseEntity<JsonResponse<Object>> deleteAudit(String id) {
		logger.info("Method : deleteAudit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = "SET @p_auditId='" + id + "';";
			em.createNamedStoredProcedureQuery("masterAuditPartyRoutines").setParameter("actionType", "deleteAudit")
					.setParameter("actionValue", values).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);

				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteAudit Dao ends");
		return response;
	}

	// EDIT AUDIT PARTY
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AuditPartyMasterModel>> getAuditById(String id) {
		logger.info("Method : getAuditById starts");

		List<AuditPartyMasterModel> auditParty = new ArrayList<AuditPartyMasterModel>();
		JsonResponse<AuditPartyMasterModel> resp = new JsonResponse<AuditPartyMasterModel>();

		try {

			String value = "SET @p_auditId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterAuditPartyRoutines")
					.setParameter("actionType", "editAudit").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				AuditPartyMasterModel audit = new AuditPartyMasterModel(m[0], m[1], m[2], m[3], null, null, null);
				auditParty.add(audit);
			}

			resp.setBody(auditParty.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AuditPartyMasterModel>> response = new ResponseEntity<JsonResponse<AuditPartyMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAuditById ends");
		return response;
	}

}
