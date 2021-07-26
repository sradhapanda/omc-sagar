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
import nirmalya.aatithya.restmodule.audit.dao.AuditPartyMasterDao;
import nirmalya.aatithya.restmodule.audit.model.AuditPartyMasterModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "master/")
public class AuditPartyMasterRestController {

	@Autowired
	AuditPartyMasterDao auditPartyDao;
	
	Logger logger = LoggerFactory.getLogger(AuditPartyMasterRestController.class);
	
	@RequestMapping(value = "/restAddAuditparty", method = {RequestMethod.POST})
	ResponseEntity<JsonResponse<Object>> restAddStruct(@RequestBody AuditPartyMasterModel auditParty){
		
		logger.info("Method : restAddStruct strats");
		
		logger.info("Method : restAddStruct ends");
		
		return auditPartyDao.addAuditParty(auditParty);
	}
	
	@RequestMapping(value = "/getAuditParty", method = {RequestMethod.POST})
	ResponseEntity<JsonResponse<List<AuditPartyMasterModel>>> getAuditParty(@RequestBody DataTableRequest request)
	{
		logger.info("Method : getAuditParty strats");
		
		
		logger.info("Method : getAuditParty ends");
		
		return auditPartyDao.getAuditParty(request);
	}
	
	@RequestMapping(value = "/viewAuditModelView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AuditPartyMasterModel>> viewAuditModelView(@RequestParam("id") String id) {
		logger.info("Method : viewAuditModelView Rest starts");
		logger.info("Method : viewAuditModelView Rest ends");
		return auditPartyDao.viewAuditModelView(id);
	}
	
	@RequestMapping(value = "/deleteAudit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAudit(@RequestParam("id") String id) {
		logger.info("Method : deleteAudit Rest starts");
		logger.info("Method : deleteAudit Rest ends");
		return auditPartyDao.deleteAudit(id);
	}
	
	@RequestMapping(value = "/getAuditById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AuditPartyMasterModel>> getAuditById(@RequestParam String id) {
		logger.info("Method : getAuditById starts");

		logger.info("Method :getAuditById ends");
		return auditPartyDao.getAuditById(id);
	}
	
}
