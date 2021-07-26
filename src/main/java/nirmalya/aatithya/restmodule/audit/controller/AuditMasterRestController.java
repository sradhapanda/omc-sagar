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

import nirmalya.aatithya.restmodule.audit.dao.AuditMasterDao;
import nirmalya.aatithya.restmodule.audit.model.AuditCommentsModel;
import nirmalya.aatithya.restmodule.audit.model.AuditComplianceModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterPdfModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "audit/")
public class AuditMasterRestController {
	
	Logger logger = LoggerFactory.getLogger(AuditMasterRestController.class);

	@Autowired
	AuditMasterDao auditMasterDao;
	
	@RequestMapping(value="getAuditTypeByAuditName" , method={RequestMethod.GET})
	public List<DropDownModel> getAuditTypeByAuditName(@RequestParam String id) {
		logger.info("Method : getAuditTypeByAuditName starts");

		logger.info("Method : getAuditTypeByAuditName ends");
		return auditMasterDao.getAuditTypeByAuditName(id);
	}
	
	@RequestMapping(value="getDeptList" , method={RequestMethod.GET})
	public List<DropDownModel> getDeptList() {
		logger.info("Method : getDeptList starts");
		
		logger.info("Method : getDeptList ends");
		return auditMasterDao.getDeptList();
	}
	
	@RequestMapping(value="getSectionList" , method={RequestMethod.GET})
	public List<DropDownModel> getSectionList(@RequestParam("id") String id) {
		logger.info("Method : getSectionList starts");
		
		logger.info("Method : getSectionList ends");
		return auditMasterDao.getSectionList(id);
	}
	
	
	@RequestMapping(value="getDepartmentHeadList" , method={RequestMethod.GET})
	public List<DropDownModel> getDepartmentHeadList(@RequestParam("id") String id) {
		logger.info("Method : getDepartmentHeadList starts");
		
		logger.info("Method : getDepartmentHeadList ends");
		return auditMasterDao.getDepartmentHeadList(id);
	}
	
	@RequestMapping(value="getConcernAuditList" , method={RequestMethod.GET})
	public List<DropDownModel> getConcernAuditList(@RequestParam("id") String id) {
		logger.info("Method : getConcernAuditList starts");
		
		logger.info("Method : getConcernAuditList ends");
		return auditMasterDao.getConcernAuditList(id);
	}
	
	/*@RequestMapping(value="getSelectedConcernAuditList" , method={RequestMethod.GET})
	public List<DropDownModel> getSelectedConcernAuditList(@RequestParam("id") String id) {
		logger.info("Method : getSelectedConcernAuditList starts");
		
		logger.info("Method : getSelectedConcernAuditList ends");
		return auditMasterDao.getSelectedConcernAuditList(id);
	}*/
	@RequestMapping(value="getSelectedDeptList" , method={RequestMethod.GET})
	public List<DropDownModel> getSelectedDeptList(@RequestParam("id") String id) {
		logger.info("Method : getSelectedDeptList starts");
		
		logger.info("Method : getSelectedDeptList ends");
		return auditMasterDao.getSelectedDeptList(id);
	}
	/*@RequestMapping(value="getSelectedSubCoordList" , method={RequestMethod.GET})
	public List<DropDownModel> getSelectedSubCoordList(@RequestParam("id") String id) {
		logger.info("Method : getSelectedSubCoordList starts");
		
		logger.info("Method : getSelectedSubCoordList ends");
		return auditMasterDao.getSelectedSubCoordList(id);
	}*/
	
	@RequestMapping(value = "/getSectionListByDept", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSectionListByDept(@RequestParam String id) {
		logger.info("Method : getSectionListByDept starts");

		logger.info("Method : getSectionListByDept ends");
		return auditMasterDao.getSectionListByDept(id);
	}
	
	@RequestMapping(value = "/getDeptHeadListByDept", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptHeadListByDept(@RequestParam String id) {
		logger.info("Method : getDeptHeadListByDept starts");
		
		logger.info("Method : getDeptHeadListByDept ends");
		return auditMasterDao.getDeptHeadListByDept(id);
	}
	@RequestMapping(value = "/getAuditeeListByDept", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditeeListByDept(@RequestParam String id) {
		logger.info("Method : getAuditeeListByDept starts");
		
		logger.info("Method : getAuditeeListByDept ends");
		return auditMasterDao.getAuditeeListByDept(id);
	}

	@RequestMapping(value = "/getAuditorListByOrg", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditorListByOrg(@RequestParam String id) {
		logger.info("Method : getAuditorListByOrg starts");

		logger.info("Method : getAuditorListByOrg ends");
		return auditMasterDao.getAuditorListByOrg(id);
	}
	
	@RequestMapping(value="addNewAudit" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> addNewAudit(@RequestBody  List<AuditMasterModel> audit) {
		logger.info("Method : addNewAudit for rest controller starts");
		
		logger.info("Method : addNewAudit for rest controller ends");
		return auditMasterDao.addNewAudit(audit);
	}
	@RequestMapping(value="getSubCoordList" , method={RequestMethod.GET})
	public List<DropDownModel> getSubCoordList() {
		logger.info("Method : getSubCoordList starts");
		
		logger.info("Method : getSubCoordList ends");
		return auditMasterDao.getSubCoordList();
	}

	/**
	 * Rest Controller - Initiate Audit
	 *
	 */
	@RequestMapping(value = "/getAuditOrganization", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditOrganization(@RequestParam("audit") String audit) {
		logger.info("Method : getAuditOrganization starts");

		logger.info("Method : getAuditOrganization ends");
		return auditMasterDao.getAuditOrganization(audit);
	}


	

}
