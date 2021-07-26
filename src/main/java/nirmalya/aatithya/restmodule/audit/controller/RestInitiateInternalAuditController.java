
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

import nirmalya.aatithya.restmodule.audit.dao.InitiateInternalAuditDao;
import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "audit/")
public class RestInitiateInternalAuditController {
	
	Logger logger = LoggerFactory.getLogger(RestInitiateInternalAuditController.class);

	@Autowired
	InitiateInternalAuditDao initiateInternalAuditDao;
	
	@RequestMapping(value="getInternalAuditType" , method={RequestMethod.GET})
	public List<DropDownModel> getInternalAuditType() {
		logger.info("Method : getInternalAuditType starts");
		logger.info("Method : getInternalAuditType ends");
		return initiateInternalAuditDao.getInternalAuditType();
	}
	
	@RequestMapping(value="getRegion" , method={RequestMethod.GET})
	public List<DropDownModel> getRegion() {
		logger.info("Method : getRegion starts");
		
		logger.info("Method : getRegion ends");
		return initiateInternalAuditDao.getRegion();
	}
	
	@RequestMapping(value = "getInternalAuditor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInternalAuditor(@RequestParam("region") String region) {
		logger.info("Method : getInternalAuditor starts");

		logger.info("Method : getInternalAuditor ends");
		return initiateInternalAuditDao.getInternalAuditor(region);
	}
	
	@RequestMapping(value = "getRegionalManager", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRegionalManager(@RequestParam("auditor") String id) {
		logger.info("Method : getRegionalManager starts");
		
		logger.info("Method : getRegionalManager ends");
		return initiateInternalAuditDao.getRegionalManager(id);
	}
	@RequestMapping(value = "getConcernFinance", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getConcernFinance(@RequestParam("region")  String id) {
		logger.info("Method : getConcernFinance starts");
		
		logger.info("Method : getConcernFinance ends");
		return initiateInternalAuditDao.getConcernFinance(id);
	}

	@RequestMapping(value = "getQuarter", method = { RequestMethod.GET })
	public List<DropDownModel>getQuarter() {
		logger.info("Method : getQuarter starts");

		logger.info("Method : getQuarter ends");
		return initiateInternalAuditDao.getQuarter();
	}
	@RequestMapping(value = "getFolderName", method = { RequestMethod.GET })
	public List<DropDownModel>getFolderName() {
		logger.info("Method : getFolderName starts");

		logger.info("Method : getFolderName ends");
		return initiateInternalAuditDao.getFolderName();
	}
	
	@RequestMapping(value="initiate-internal-audit" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> initiateAudit(@RequestBody  AuditInitiateModel audit) {
		logger.info("Method : initiateAudit for rest controller starts");
		
		logger.info("Method : initiateAudit for rest controller ends");
		return initiateInternalAuditDao.initiateAudit(audit);
	}
	
	// ********** AUTO_COMPLETE folder type ************/
	@RequestMapping(value = "getFolderNameListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getFolderListByAutoSearch1(@RequestParam String id) {
	logger.info("Method : getFolderListByAutoSearch1 starts");
	logger.info("Method : getFolderListByAutoSearch1 ends");
	return initiateInternalAuditDao.getFolderByAutoSearch(id);
	}

}
