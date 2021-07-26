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

import nirmalya.aatithya.restmodule.audit.model.RestAddAuditPartyNewMoldel;
import nirmalya.aatithya.restmodule.audit.model.OrganizationRestModel;
import nirmalya.aatithya.restmodule.audit.model.RestAddAuditPartyNewMoldel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAddAuditNewParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateOrganizationParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAddAuditPartyNewDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;
	Logger logger = LoggerFactory.getLogger(RestAddAuditPartyNewDao.class);

	/**
	 * DAO Function to Add/edit New Detail
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addNewAuditRegion(RestAddAuditPartyNewMoldel guestAddAudit) {
		logger.info("Method : addNewAuditRegion starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (guestAddAudit.gettAduitNewName() == null || guestAddAudit.gettAduitNewName() == "") {
			resp.setMessage("Region Name required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewFName() == null || guestAddAudit.gettAduitNewFName() == "") {
			resp.setMessage("First Name required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewLName() == null || guestAddAudit.gettAduitNewLName() == "") {
			resp.setMessage("Last Name required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewMobile() == null || guestAddAudit.gettAduitNewMobile() == "") {
			resp.setMessage("Mobile No Required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewEmail() == null || guestAddAudit.gettAduitNewEmail() == "") {
			resp.setMessage("Email Id Required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewCountry() == null || guestAddAudit.gettAduitNewCountry() == "") {
			resp.setMessage("Country Name id Required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewState() == null || guestAddAudit.gettAduitNewState() == "") {
			resp.setMessage("State Name is Required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewDist() == null || guestAddAudit.gettAduitNewDist() == "") {
			resp.setMessage("Dist Name is Required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewAddress() == null || guestAddAudit.gettAduitNewAddress() == "") {
			resp.setMessage("Address is Required");
			validity = false;
		} else if (guestAddAudit.gettAduitNewPINno() == null || guestAddAudit.gettAduitNewPINno() == "") {
			resp.setMessage("Pin is Required");
			validity = false;
		} /*
			 * else if (guestAddAudit.gettPassword() == null || guestAddAudit.gettPassword()
			 * == "") { resp.setMessage("Enter Password"); validity = false; }
			 */

		/*
		 * else if (guestAddAudit.getDesignation() == null ||
		 * guestAddAudit.getDesignation() == "") {
		 * resp.setMessage("Designation is Required"); validity = false; }
		 */

		if (validity) {
			try {

				String values = GenerateAddAuditNewParameter.addAuditNewParam(guestAddAudit);

				if (guestAddAudit.gettAduitNewId() == null || guestAddAudit.gettAduitNewId() == "") {
					em.createNamedStoredProcedureQuery("addAuditRegionMaster").setParameter("actionType", "addAuditRegion").setParameter("actionValue", values).execute();
				} 
					  else { em.createNamedStoredProcedureQuery("addAuditRegionMaster").setParameter("actionType", "modifyOrgDetail").setParameter("actionValue",
					  values) .execute(); }
					 

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
		logger.info("Method : addNewGuest ends");

		return response;
	}

	/**
	 * DAO Function to view particular District name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictName(String id) {
		logger.info("Method : getDistrictName starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "getDistrictName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				districtList.add(dropDownModel);
			}

			resp.setBody(districtList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDistrictName ends");
		return response;
	}

	/*
	 * DAO Function to view State Name in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryName() {
		logger.info("Method : getCountryName starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "getCountryName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCountryName ends");
		return countryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistNameList(String id) {
		logger.info("Method : getDistNameList starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_tOrgState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "getDistrictName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				districtList.add(dropDownModel);
			}
			resp.setBody(districtList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);

		logger.info("Method : getDistNameList ends");
		return districtList;
	}

	/*
	 * DAO Function to view Country Name in dropDown
	 *
	 */

	/**
	 * DAO Function to view particular District name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(String id) {

		logger.info("Method : getStateName starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "getStateName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getStateName ends");
		return response;
	}

	/**
	 * DAO Function to get District Name List for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateNameList(String id) {
		logger.info("Method : getStateNameList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		String value = "SET @p_tGuestCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "getStateName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStateNameList ends");
		return stateList;
	}

	/*
	 * DAO Function to view Organization Name in dropDown
	 * 
	 */
	/*
	 * @SuppressWarnings("unchecked") public List<DropDownModel> getOrgName() {
	 * logger.info("Method : getOrgName starts"); List<DropDownModel> orgList = new
	 * ArrayList<DropDownModel>(); try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("addAuditRegionMaster")
	 * .setParameter("actionType",
	 * "getOrganizationName").setParameter("actionValue", "").getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); orgList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * logger.info("Method : getOrgName ends"); return orgList; }
	 */
	/*
	 * DAO Function to view Region Name in dropDown
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRegionName() {
		logger.info("Method : getRegionName  starts");

		List<DropDownModel> regionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "regionList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				regionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRegionName  ends");

		return regionList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAddAuditPartyNewMoldel>>> getAuditParty(DataTableRequest request) {
		logger.info("Method : getAuditParty Dao starts");

		List<RestAddAuditPartyNewMoldel> auditParty = new ArrayList<RestAddAuditPartyNewMoldel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "viewOrgAuditor").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				RestAddAuditPartyNewMoldel audit = new RestAddAuditPartyNewMoldel(m[0], m[1], m[2],null, m[3], m[4], m[5],
						m[6], m[7], m[8],null, m[9], m[10], null, null, null, null, null);
				auditParty.add(audit);
			}

			/*
			 * if (x.size() > 0) {
			 * 
			 * if (x.get(0).length > 6) { BigInteger t = (BigInteger) x.get(0)[12];
			 * 
			 * total = Integer.parseInt((t.toString())); }
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestAddAuditPartyNewMoldel>> resp = new JsonResponse<List<RestAddAuditPartyNewMoldel>>();
		resp.setBody(auditParty);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestAddAuditPartyNewMoldel>>> response = new ResponseEntity<JsonResponse<List<RestAddAuditPartyNewMoldel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAuditParty Dao ends");
		return response;
	}
	/**
	 * DAO Function to edit Guest Details
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestAddAuditPartyNewMoldel>> editAuditorsById(String id) {

		logger.info("Method : editDetailsById starts");
		List<RestAddAuditPartyNewMoldel> form = new ArrayList<RestAddAuditPartyNewMoldel>();
		try {
			String value = "SET @p_Region='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("addAuditRegionMaster")
					.setParameter("actionType", "editOrgDetail").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAddAuditPartyNewMoldel guestmater = new RestAddAuditPartyNewMoldel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9],null, m[10],  null, null, null, null,null,null);
				form.add(guestmater);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(form);
		JsonResponse<RestAddAuditPartyNewMoldel> resp = new JsonResponse<RestAddAuditPartyNewMoldel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestAddAuditPartyNewMoldel>> response = new ResponseEntity<JsonResponse<RestAddAuditPartyNewMoldel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editDetailsById ends");
		System.out.println(response);
		return response;
		
	}

}