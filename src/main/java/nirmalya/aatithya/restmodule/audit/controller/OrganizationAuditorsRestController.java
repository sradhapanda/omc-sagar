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

import nirmalya.aatithya.restmodule.audit.dao.RestOrganizationAuditorsDao;
import nirmalya.aatithya.restmodule.audit.model.OrganizationAuditorsRestModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "audit")
public class OrganizationAuditorsRestController {

	@Autowired
	RestOrganizationAuditorsDao restOrganizationAuditorsDao;

	Logger logger = LoggerFactory.getLogger(OrganizationAuditorsRestController.class);

	/**
	 * Post Mapping to Add new Auditor Details
	 *
	 */
	@RequestMapping(value = "/restAddOrganizationAuditor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewAuditors(
			@RequestBody OrganizationAuditorsRestModel orgAuditors) {
		logger.info("Method : restAddNewAuditors starts");
		logger.info("Method : restAddNewAuditors endss");
		return restOrganizationAuditorsDao.addNewAuditors(orgAuditors);
	}
	
	/*
	 * 
	 * Get mapping for get Organization Name
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-organizationName", method = { RequestMethod.GET })
	public List<DropDownModel> getOrgName() {
		logger.info("Method :  getOrgName starts");
		logger.info("Method :  getOrgName endss");
		return restOrganizationAuditorsDao.getOrgName();
	}
	
	/*
	 * 
	 * Get mapping for get UserType
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-userType", method = { RequestMethod.GET })
	public List<DropDownModel> getUserType() {
		logger.info("Method :  getUserType starts");
		logger.info("Method :  getUserType endss");
		return restOrganizationAuditorsDao.getUserType();
	}
	
	/*
	 * 
	 * PostMapping for add get country name
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-countyName", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryName() {
		logger.info("Method : getCountryName starts");
		logger.info("Method : getCountryName ends");
		return restOrganizationAuditorsDao.getCountryName();
	}
	

	/*
	 * 
	 * Get mapping for get State name
	 * 
	 */
	@RequestMapping(value = "rest-get-stName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(@RequestParam String id) {
		logger.info("Method : getStateName starts");
		logger.info("Method : getStateName ends");
		return restOrganizationAuditorsDao.getStateName(id);
	}

	/*
	 * 
	 * Get mapping for get District name
	 * 
	 */
	@RequestMapping(value = "rest-get-distrName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictName(@RequestParam String id) {
		logger.info("Method : getDistrictName starts");
		logger.info("Method : getDistrictName ends");
		return restOrganizationAuditorsDao.getDistrictName(id);
	}

	/**
	 * returns all Guest Details
	 *
	 */
	@RequestMapping(value = "/getOrgAuditorsDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<OrganizationAuditorsRestModel>>> getAllOrgAuditors(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllOrgAuditors starts");
		logger.info("Method : getAllOrgAuditors endss");
		return restOrganizationAuditorsDao.getAllOrgAuditors(request);
	}

	/**
	 * delete particular Guest Details in model
	 *
	 */
	@RequestMapping(value = "/deleteOrgAuditorsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteOrgAuditors(@RequestParam String id,
			@RequestParam String createdBy) {

		logger.info("Method : deleteOrgAuditors starts");

		logger.info("Method : deleteOrgAuditors end");

		return restOrganizationAuditorsDao.deleteOrgAuditors(id, createdBy);
	}

	/**
	 * returns particular Guest Detail to view
	 *
	 */
	@RequestMapping(value = "/getOrgAuditorsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>> viewOrgAuditors(@RequestParam String id) {
		logger.info("Method : viewOrgAuditors starts");
		logger.info("Method : viewOrgAuditors ends");
		return restOrganizationAuditorsDao.viewOrgAuditors(id);
	}

	/*
	 * 
	 * Get mapping for edit Guest Detail
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-org-auditor-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<OrganizationAuditorsRestModel>> editOrgAuditorsById(@RequestParam String id) {
		logger.info("Method : editOrgAuditorsById starts");
		logger.info("Method : editOrgAuditorsById ends");
		return restOrganizationAuditorsDao.editOrgAuditorsById(id);
	}

	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-disName", method = { RequestMethod.GET })
	public List<DropDownModel> getDistNameList(@RequestParam String id) {
		logger.info("Method :  getDistNameList starts");
		logger.info("Method :  getDistNameList endss");
		return restOrganizationAuditorsDao.getDistNameList(id);
	}

	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-st-name", method = { RequestMethod.GET })
	public List<DropDownModel> getStateNameList(@RequestParam String id) {
		logger.info("Method :  getStateNameList starts");
		logger.info("Method :  getStateNameList endss");
		return restOrganizationAuditorsDao.getStateNameList(id);
	}
	
	

}
