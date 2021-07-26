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

import nirmalya.aatithya.restmodule.audit.model.OrganizationAuditorsRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateOrganizationAuditorsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestOrganizationAuditorsDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestOrganizationAuditorsDao.class);

	/**
	 * DAO Function to Add/edit New Detail
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addNewAuditors(OrganizationAuditorsRestModel guestMaster) {
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
				String values = GenerateOrganizationAuditorsParameter.addOrganizationAuditorsParam(guestMaster);

				if (guestMaster.gettOrgId() == null || guestMaster.gettOrgId() == "") {
					em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
							.setParameter("actionType", "addOrgAuditors").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
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

	public ResponseEntity<JsonResponse<List<OrganizationAuditorsRestModel>>> getAllOrgAuditors(DataTableRequest request) {
		logger.info("Method : getAllGuestDeatils starts");

		List<OrganizationAuditorsRestModel> form = new ArrayList<OrganizationAuditorsRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
					.setParameter("actionType", "viewOrgAuditor").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
			for (Object[] m : x) {
				OrganizationAuditorsRestModel properties = new OrganizationAuditorsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], null, null,m[17]);
				form.add(properties);
			}
			
			if (x.get(0).length >18) {
				BigInteger t = (BigInteger) x.get(0)[18];

				total = Integer.parseInt((t.toString()));
			}

			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<OrganizationAuditorsRestModel>> resp = new JsonResponse<List<OrganizationAuditorsRestModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<OrganizationAuditorsRestModel>>> response = new ResponseEntity<JsonResponse<List<OrganizationAuditorsRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllGuestDeatils ends");
		return response;
	}

	/**
	 * DAO Function to delete particular Guest Details in model
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteOrgAuditors(String id, String createdBy) {
		logger.info("Method : deleteGuestDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_OrgId='" + id + "',@p_CreatedBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("organizationAuditorsMaster").setParameter("actionType", "deleteGuestDetail")
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
	public ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>> viewOrgAuditors(String id) {
		logger.info("Method : getGuestListModal starts");
		List<OrganizationAuditorsRestModel> form = new ArrayList<OrganizationAuditorsRestModel>();
		try {
			String value = "SET @p_OrgId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
					.setParameter("actionType", "viewInModel").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				OrganizationAuditorsRestModel guestMaster = new OrganizationAuditorsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9],m[10], m[11], null, m[13], m[14], m[15], m[16],null, null,m[17]);
				form.add(guestMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<OrganizationAuditorsRestModel> resp = new JsonResponse<OrganizationAuditorsRestModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>> response = new ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getGuestListModal ends");
		return response;
	}

	/**
	 * DAO Function to edit Guest Details
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>> editOrgAuditorsById(String id) {

		logger.info("Method : editDetailsById starts");
		List<OrganizationAuditorsRestModel> form = new ArrayList<OrganizationAuditorsRestModel>();
		try {
			String value = "SET @p_OrgId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
					.setParameter("actionType", "editOrgDetail").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				OrganizationAuditorsRestModel guestMaster = new OrganizationAuditorsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10],m[11], null, null, m[14], m[15], null, m[17], null,m[18]);
				form.add(guestMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<OrganizationAuditorsRestModel> resp = new JsonResponse<OrganizationAuditorsRestModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>> response = new ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>>(
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
		String value = "SET @p_tGuestState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
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

		String value = "SET @p_OrgCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
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
		String value = "SET @p_OrgCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
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
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrgName() {
		logger.info("Method : getOrgName starts");
		List<DropDownModel> orgList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
					.setParameter("actionType", "getOrganizationName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				orgList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getOrgName ends");
		return orgList;
	}
	
	/*
	 * DAO Function to view Organization Name in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserType() {
		logger.info("Method : getUserType starts");
		List<DropDownModel> UserType = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationAuditorsMaster")
					.setParameter("actionType", "getUserType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getUserType ends");
		return UserType;
	}



}

