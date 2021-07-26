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

import nirmalya.aatithya.restmodule.audit.dao.RestAddAuditPartyNewDao;
import nirmalya.aatithya.restmodule.audit.model.OrganizationAuditorsRestModel;
import nirmalya.aatithya.restmodule.audit.model.OrganizationRestModel;
import nirmalya.aatithya.restmodule.audit.model.RestAddAuditPartyNewMoldel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "employee")

public class RestAddAduitPartyNewController {
	@Autowired
	RestAddAuditPartyNewDao restAuditPartynewDao;
	Logger logger = LoggerFactory.getLogger(RestAddAduitPartyNewController.class);
	/**
	 * Post Mapping to Add new Guest Details
	 *
	 */
	
	@RequestMapping(value = "/restAddRegion", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewGuest(@RequestBody RestAddAuditPartyNewMoldel guestAddAudit) {
		logger.info("Method : restAddNewGuest starts");
		logger.info("Method : restAddNewGuest endss");
		return restAuditPartynewDao.addNewAuditRegion(guestAddAudit);
	}
	/*
	 * 
	 * Get mapping for get Organization Name
	 * 
	 * 
	 */
	/*
	 * @RequestMapping(value = "rest-get-organizationName-New", method = {
	 * RequestMethod.GET }) public List<DropDownModel> getOrgName() {
	 * logger.info("Method :  getOrgName starts");
	 * logger.info("Method :  getOrgName endss"); return
	 * restAuditPartynewDao.getOrgName(); }
	 */

	@RequestMapping(value = "get-region-list-Name-New", method = { RequestMethod.GET })
	public List<DropDownModel> getRegionName() {
		logger.info("Method : getRegionName starts");
		logger.info("Method : getRegionName ends");
		return restAuditPartynewDao.getRegionName();
	}
	
	/*
	 * 
	 * PostMapping for add get country name
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-countryName-New", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryName() {
		logger.info("Method : getCountryName starts");
		logger.info("Method : getCountryName ends");
		return restAuditPartynewDao.getCountryName();
	}
	/*
	 * 
	 * Get mapping for get State name
	 * 
	 */
	@RequestMapping(value = "rest-get-stateName-New", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(@RequestParam String id) {
		logger.info("Method : getStateName starts");
		logger.info("Method : getStateName ends");
		return restAuditPartynewDao.getStateName(id);
	}
	/*
	 * 
	 * Get mapping for get District name
	 * 
	 */
	@RequestMapping(value = "rest-get-districtName-New", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictName(@RequestParam String id) {
		logger.info("Method : getDistrictName starts");
		logger.info("Method : getDistrictName ends");
		return restAuditPartynewDao.getDistrictName(id);
	}
	
	@RequestMapping(value = "/getAuditParty-New", method = {RequestMethod.POST})
	ResponseEntity<JsonResponse<List<RestAddAuditPartyNewMoldel>>> getAuditParty(@RequestBody DataTableRequest request)
	{
		logger.info("Method : getAuditParty strats");
		
		
		logger.info("Method : getAuditParty ends");
		System.out.println(request);
		return restAuditPartynewDao.getAuditParty(request);
	}
	/*
	 * 
	 * Get mapping for edit Guest Detail
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-org-auditor-details-New", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestAddAuditPartyNewMoldel>> editOrgAuditorsById(@RequestParam String id) {
		logger.info("Method : editOrgAuditorsById starts");
		logger.info("Method : editOrgAuditorsById ends");
		return restAuditPartynewDao.editAuditorsById(id);
	}
	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-disName-New", method = { RequestMethod.GET })
	public List<DropDownModel> getDistNameList(@RequestParam String id) {
		logger.info("Method :  getDistNameList starts");
		logger.info("Method :  getDistNameList endss");
		return restAuditPartynewDao.getDistNameList(id);
	}
	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-st-name-New", method = { RequestMethod.GET })
	public List<DropDownModel> getStateNameList(@RequestParam String id) {
		logger.info("Method :  getStateNameList starts");
		logger.info("Method :  getStateNameList endss");
		return restAuditPartynewDao.getStateNameList(id);
	}

	
}
