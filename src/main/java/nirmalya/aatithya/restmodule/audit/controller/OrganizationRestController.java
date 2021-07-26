package nirmalya.aatithya.restmodule.audit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.audit.dao.RestOrganizationDao;
import nirmalya.aatithya.restmodule.audit.model.OrganizationRestModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "audit")
public class OrganizationRestController {

	@Autowired
	RestOrganizationDao restOrganizationDao;

	Logger logger = LoggerFactory.getLogger(OrganizationRestController.class);

	/**
	 * Post Mapping to Add new Guest Details
	 *
	 */
	@RequestMapping(value = "/restAddOrganization", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewGuest(@RequestBody OrganizationRestModel guestMaster) {
		logger.info("Method : restAddNewGuest starts");
		logger.info("Method : restAddNewGuest endss");
		return restOrganizationDao.addNewGuest(guestMaster);
	}

	

	/*
	 * 
	 * PostMapping for add get country name
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-countryName", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryName() {
		logger.info("Method : getCountryName starts");
		logger.info("Method : getCountryName ends");
		return restOrganizationDao.getCountryName();
	}
	
	/*
	 * 
	 * Get mapping for get State name
	 * 
	 */
	@RequestMapping(value = "rest-get-stateName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(@RequestParam String id) {
		logger.info("Method : getStateName starts");
		logger.info("Method : getStateName ends");
		return restOrganizationDao.getStateName(id);
	}


	/*
	 * 
	 * Get mapping for get District name
	 * 
	 */
	@RequestMapping(value = "rest-get-districtName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictName(@RequestParam String id) {
		logger.info("Method : getDistrictName starts");
		logger.info("Method : getDistrictName ends");
		return restOrganizationDao.getDistrictName(id);
	}

	/**
	 * returns all Guest Details
	 *
	 */
	@RequestMapping(value = "/getOrgDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<OrganizationRestModel>>> getAllGuestDeatils(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllGuestDeatils starts");
		logger.info("Method : getAllGuestDeatils endss");
		return restOrganizationDao.getAllGuestDeatils(request);
	}

	/**
	 * delete particular Guest Details in model
	 *
	 */
	@RequestMapping(value = "/deleteOrgById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGuestDetails(@RequestParam String id,@RequestParam String createdBy) {

		logger.info("Method : deleteGuestDetails starts");

		logger.info("Method : deleteGuestDetails end");

		return restOrganizationDao.deleteGuestDetails(id,createdBy);
	}

	/**
	 * returns particular Guest Detail to view
	 *
	 */
	@RequestMapping(value = "/getOrgById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<OrganizationRestModel>> viewGuestDetails(@RequestParam String id) {
		logger.info("Method : viewGuestDetails starts");
		logger.info("Method : viewGuestDetails ends");
		return restOrganizationDao.viewGuestDetails(id);
	}

	/*
	 * 
	 * Get mapping for edit Guest Detail
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-org-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<OrganizationRestModel>> editDetailsById(@RequestParam String id) {
		logger.info("Method : editDetailsById starts");
		logger.info("Method : editDetailsById ends");
		return restOrganizationDao.editDetailsById(id);
	}

	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-distName", method = { RequestMethod.GET })
	public List<DropDownModel> getDistNameList(@RequestParam String id) {
		logger.info("Method :  getDistNameList starts");
		logger.info("Method :  getDistNameList endss");
		return restOrganizationDao.getDistNameList(id);
	}
	
	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-state-name", method = { RequestMethod.GET })
	public List<DropDownModel> getStateNameList(@RequestParam String id) {
		logger.info("Method :  getStateNameList starts");
		logger.info("Method :  getStateNameList endss");
		return restOrganizationDao.getStateNameList(id);
	}

}

