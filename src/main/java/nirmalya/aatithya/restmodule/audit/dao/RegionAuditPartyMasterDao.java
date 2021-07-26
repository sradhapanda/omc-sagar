package nirmalya.aatithya.restmodule.audit.dao;

import org.springframework.stereotype.Repository;
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

import nirmalya.aatithya.restmodule.audit.model.RegionAuditPartyMasterModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class RegionAuditPartyMasterDao {
	Logger logger = LoggerFactory.getLogger(RegionAuditPartyMasterDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	
	
	
	
	/*
	 * for all assignSkill details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RegionAuditPartyMasterModel>>> getAuditPartyDetails(DataTableRequest tableRequest) {

		logger.info("Method in Dao: getAuditPartyDetails starts");

		List<RegionAuditPartyMasterModel> auditList = new ArrayList<RegionAuditPartyMasterModel>();
		String values = GenerateParameter.getSearchParam(tableRequest);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterRegionAuditParty")
					.setParameter("actionType", "getAuditDepnd").setParameter("actionValue",values )
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					RegionAuditPartyMasterModel audit = new RegionAuditPartyMasterModel(m[0],m[1],m[2],m[3],null,m[4],null, null);
					auditList.add(audit);
				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RegionAuditPartyMasterModel>> resp = new JsonResponse<List<RegionAuditPartyMasterModel>>();
		resp.setBody(auditList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RegionAuditPartyMasterModel>>> response = new ResponseEntity<JsonResponse<List<RegionAuditPartyMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAuditPartyDetails ends");
      
		return response;
	}

}
