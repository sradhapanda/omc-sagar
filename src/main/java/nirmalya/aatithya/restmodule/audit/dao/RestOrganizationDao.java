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

import nirmalya.aatithya.restmodule.audit.model.OrganizationRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateOrganizationParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestOrganizationDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestOrganizationDao.class);

	/**
	 * DAO Function to Add/edit New Detail
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addNewGuest(OrganizationRestModel guestMaster) {
		logger.info("Method : addNewGuest starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (guestMaster.gettOrgName() == null || guestMaster.gettOrgName() == "") {
			resp.setMessage("Organization Name required");
			validity = false;
		} else if (guestMaster.gettOrgMobile() == null || guestMaster.gettOrgMobile() == "") {
			resp.setMessage("Mobile no. required");
			validity = false;
		} else if (guestMaster.gettOrgPINno() == null || guestMaster.gettOrgPINno() == "") {
			resp.setMessage("Pin required");
			validity = false;
		} else if (guestMaster.gettOrgAddress() == null || guestMaster.gettOrgAddress() == "") {
			resp.setMessage("Address required");
			validity = false;
		} else if (guestMaster.gettOrgCountry() == null || guestMaster.gettOrgCountry() == "") {
			resp.setMessage("Country required");
			validity = false;
		} else if (guestMaster.gettOrgState() == null || guestMaster.gettOrgState() == "") {
			resp.setMessage("State required");
			validity = false;
		} else if (guestMaster.gettOrgDist() == null || guestMaster.gettOrgDist() == "") {
			resp.setMessage("District required");
			validity = false;
		} else if (guestMaster.gettCreatedBy() == null || guestMaster.gettCreatedBy() == "") {
			resp.setMessage("");
			validity = false;
		} else if (guestMaster.gettStatus() == null) {
			resp.setMessage("Status required");
			validity = false;
		}

		if (validity) {
			try {
				String values = GenerateOrganizationParameter.addOrganizationParam(guestMaster);

				if (guestMaster.gettOrg() == null || guestMaster.gettOrg() == "") {
					em.createNamedStoredProcedureQuery("organizationMaster")
							.setParameter("actionType", "addNewOrganization").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("organizationMaster")
							.setParameter("actionType", "modifyOrgDetail").setParameter("actionValue", values)
							.execute();
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
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

	/**
	 * DAO Function to View all Guest details
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<OrganizationRestModel>>> getAllGuestDeatils(DataTableRequest request) {
		logger.info("Method : getAllGuestDeatils starts");

		List<OrganizationRestModel> form = new ArrayList<OrganizationRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
					.setParameter("actionType", "viewOrgDetailsList").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
			for (Object[] m : x) {
				OrganizationRestModel properties = new OrganizationRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], null, null);
				form.add(properties);
			}
			if (x.get(0).length >10) {
				BigInteger t = (BigInteger) x.get(0)[10];

				total = Integer.parseInt((t.toString()));
			}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<OrganizationRestModel>> resp = new JsonResponse<List<OrganizationRestModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<OrganizationRestModel>>> response = new ResponseEntity<JsonResponse<List<OrganizationRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllGuestDeatils ends");
		return response;
	}

	/**
	 * DAO Function to delete particular Guest Details in model
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteGuestDetails(String id, String createdBy) {
		logger.info("Method : deleteGuestDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_Org='" + id + "',@p_CreatedBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("organizationMaster").setParameter("actionType", "deleteGuestDetail")
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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteGuestDetails end");
		return response;
	}

	/**
	 * DAO Function to view particular Guest Detail in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<OrganizationRestModel>> viewGuestDetails(String id) {
		logger.info("Method : getGuestListModal starts");
		List<OrganizationRestModel> form = new ArrayList<OrganizationRestModel>();
		try {
			String value = "SET @p_Org='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
					.setParameter("actionType", "viewDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				OrganizationRestModel guestMaster = new OrganizationRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], null, null);
				form.add(guestMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<OrganizationRestModel> resp = new JsonResponse<OrganizationRestModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<OrganizationRestModel>> response = new ResponseEntity<JsonResponse<OrganizationRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getGuestListModal ends");
		return response;
	}

	/**
	 * DAO Function to edit Guest Details
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<OrganizationRestModel>> editDetailsById(String id) {

		logger.info("Method : editDetailsById starts");
		List<OrganizationRestModel> form = new ArrayList<OrganizationRestModel>();
		try {
			String value = "SET @p_Org='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
					.setParameter("actionType", "editOrgDetail").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				OrganizationRestModel guestMaster = new OrganizationRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], null);
				form.add(guestMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<OrganizationRestModel> resp = new JsonResponse<OrganizationRestModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<OrganizationRestModel>> response = new ResponseEntity<JsonResponse<OrganizationRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editDetailsById ends");
		return response;
	}

	/**
	 * DAO Function to get District Name List for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistNameList(String id) {
		logger.info("Method : getDistNameList starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		String value = "SET @p_tOrgState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
					.setParameter("actionType", "getDistrictName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				districtList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDistNameList ends");
		return districtList;
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationMaster")
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

	
}
