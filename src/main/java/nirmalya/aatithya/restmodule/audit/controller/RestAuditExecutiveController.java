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

import nirmalya.aatithya.restmodule.audit.dao.RestAuditExecutiveDao;
import nirmalya.aatithya.restmodule.audit.model.RestAuditExecutiveModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 

@RestController
@RequestMapping("audit")
public class RestAuditExecutiveController {
	Logger logger = LoggerFactory.getLogger(RestAuditExecutiveController.class);
	
	@Autowired
	RestAuditExecutiveDao auditExecutiveDao;
	
		/*
		 * Finance year dropdown
		 */
			
	  @RequestMapping(value = "getFinanceYearDropdown", method = {
	  RequestMethod.GET }) public List<DropDownModel> getFinanceYear() {
	  logger.info("Method : getFinanceYear starts");
	  
	  logger.info("Method : getFinanceYear ends"); return
	  auditExecutiveDao.getFinanceYear(); }
	  	/*
		 * Department drop down
		 */
	  @RequestMapping(value = "getDepartmentDropdown", method = {
	  RequestMethod.GET }) public List<DropDownModel> getDepartment() {
	  logger.info("Method : dropDown getDepartment starts");
	  
	  logger.info("Method : dropDown getDepartment ends"); return
	  auditExecutiveDao.getDepartment(); }
	 	/*
		 * Audit Type Drop down
		 */
	@RequestMapping(value = "getAuditTypeDropdown", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditType() {
		logger.info("Method : getAuditType starts");

		logger.info("Method : getAuditType ends");
		return auditExecutiveDao.getAuditType();
	}
	
	@RequestMapping(value = "restAddAuditExecutive", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddAuditExecutive(
			@RequestBody List<RestAuditExecutiveModel> auditExecutiveModel) {
		logger.info("Method in rest: restAddAuditExecutive starts");

		logger.info("Method in rest: restAddAuditExecutive ends");

		return auditExecutiveDao.restAddAuditExecutive(auditExecutiveModel);
	}
	@RequestMapping(value="getExecutiveDtls" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<RestAuditExecutiveModel>>> getExecutiveDtls(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getExecutiveDtls starts");
		
		logger.info("Method : getExecutiveDtls ends");
		
		return auditExecutiveDao.getExecutiveDtls(request);
	}
	@RequestMapping(value = "getExecutiveDtlsList", method = { RequestMethod.GET })
	public List<RestAuditExecutiveModel> getExecutiveDtls(@RequestParam("id") String id) {
		logger.info("Method : getExecutiveDtls starts");

		logger.info("Method : getExecutiveDtls ends");
		return auditExecutiveDao.getExecutiveDtlsList(id);
	}
	
	@RequestMapping(value = "getExecutiveDtlsListCheck", method = { RequestMethod.GET })
	public List<RestAuditExecutiveModel> getExecutiveDtlsListCheck(@RequestParam("id") String id) {
		logger.info("Method : getExecutiveDtlsListCheck starts");
		
		logger.info("Method : getExecutiveDtlsListCheck ends");
		return auditExecutiveDao.getExecutiveDtlsListCheck(id);
	}
	
}
