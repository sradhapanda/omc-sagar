package nirmalya.aatithya.restmodule.audit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.audit.dao.AuditReportUpdateDateDao;
import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditReportUpdateDateModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "audit/")
public class RestAuditReportUpdateDateController {
	Logger logger = LoggerFactory.getLogger(RestAuditReportUpdateDateController.class);
	
	@Autowired
	AuditReportUpdateDateDao AuditReportUpdateDateDao;
	
	/*
	 * Rest-get report ids
	 */
	@GetMapping("getReportIds")
	public List<DropDownModel> getReportIds(@RequestParam("id")String id){
		logger.info("rest-get all report ids starts");
		
		logger.info("rest-get all report ids ends");
		
		return  AuditReportUpdateDateDao.getReportIds(id);
	}
	/*
	 * Rest-get report ids
	 */
	@GetMapping("getDescription")
	public List<DropDownModel> getDescription(){
		logger.info("getDescription starts");
		
		logger.info("getDescription ends");
		
		return  AuditReportUpdateDateDao.getDescription();
	}
	
	/*
	 * Rest-get report ids
	 */
	@PostMapping("update-date-forReport")
	public ResponseEntity<JsonResponse<Object>> updateDate(@RequestBody List<RestAuditReportUpdateDateModel> data){
		logger.info("rest- updateDate starts");
		
		logger.info("rest-  updateDate ends");
		
		return  AuditReportUpdateDateDao.updateDate(data);
	}
	
	/*
	 * for All Report Dates
	 */
	@PostMapping("getAllReportDates")
	public ResponseEntity<JsonResponse<List<RestAuditReportUpdateDateModel>>> getAllReportDates(@RequestBody DataTableRequest request){
		logger.info("Method : getAllReportDates starts");
		
		logger.info("Method : getAllReportDates ends");
		return AuditReportUpdateDateDao.getAllReportDates(request);
	}
	

	/*
	 * for  Report Dates ById
	 */
	@GetMapping("getUpdatedDateById")
	public List<RestAuditReportUpdateDateModel> getUpdatedDateById(@RequestParam String id){
		logger.info("Method : getUpdatedDateById starts");
		
		logger.info("Method : getUpdatedDateById ends");
		
		return AuditReportUpdateDateDao.getUpdatedDateById(id);
	}
	
	/*
	 * for Updated Reports 
	 */
	@PostMapping("getUpdatedReport")
	public ResponseEntity<JsonResponse<List<AuditMasterModel>>> getUpdatedReports(@RequestBody DataTableRequest request){
		logger.info("Method : getAllReportDates starts");
		
		logger.info("Method : getAllReportDates ends");
		return AuditReportUpdateDateDao.getUpdatedReports(request);
	}
}
