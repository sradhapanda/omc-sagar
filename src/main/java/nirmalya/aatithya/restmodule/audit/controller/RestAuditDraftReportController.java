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

import nirmalya.aatithya.restmodule.audit.dao.RestAuditDraftReportDao;
import nirmalya.aatithya.restmodule.audit.model.AuditDraftReportModelNew;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditDraftReportModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "audit/")
public class RestAuditDraftReportController {
	Logger logger = LoggerFactory.getLogger(RestAuditDraftReportController.class);

	@Autowired
	RestAuditDraftReportDao restAuditDraftReportDao;
	
	@RequestMapping(value="getempList" , method={RequestMethod.GET})
	public List<DropDownModel> getempList() {
		logger.info("Method : getempList starts");
		
		logger.info("Method : getempList ends");
		return restAuditDraftReportDao.getempList();
	}
	@RequestMapping(value="getrefNoList" , method={RequestMethod.GET})
	public List<DropDownModel> getrefNoList() {
		logger.info("Method : getrefNoList starts");
		
		logger.info("Method : getrefNoList ends");
		return restAuditDraftReportDao.getrefNoList();
	}
	@RequestMapping(value="getAuditReportType" , method={RequestMethod.GET})
	public List<DropDownModel> getAuditReportType() {
		logger.info("Method : getAuditReportType starts");
		
		logger.info("Method : getAuditReportType ends");
		return restAuditDraftReportDao.getAuditReportType();
	}
	@RequestMapping(value="getReportCtgList" , method={RequestMethod.GET})
	public List<DropDownModel> getReportCtgList() {
		logger.info("Method : getReportCtgList starts");
		
		logger.info("Method : getReportCtgList ends");
		return restAuditDraftReportDao.getReportCtgList();
	}
	
	@RequestMapping(value = "/getRefListByAudiType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRefListByAudiType(@RequestParam String id) {
		logger.info("Method : getRefListByAudiType starts");

		logger.info("Method : getRefListByAudiType ends");
		return restAuditDraftReportDao.getRefListByAudiType(id);
	}

	@RequestMapping(value = "addNewAuditReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addNewAudit(
			@RequestBody List<RestAuditDraftReportModel> audit) {
		logger.info("Method : addNewAuditReport for rest controller starts");

		logger.info("Method : addNewAuditReport for rest controller ends");
		return restAuditDraftReportDao.addNewAuditReport(audit);
	}
	
	/*
	 * for All Report
	 */
	@RequestMapping(value="getauditDraftDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>> getdraftDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getdraftDetails starts");
		
		logger.info("Method : getdraftDetails ends");
		
		return restAuditDraftReportDao.getdraftDetails(request);
	}
	
	/*
	 * for All 
	 */
	@RequestMapping(value="getdraftReportById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<RestAuditDraftReportModel>> detailsReportById(@RequestParam String id) 
	{
		logger.info("Method : detailsReportById starts");
		
		logger.info("Method : detailsReportById ends");
		
		return restAuditDraftReportDao.detailsReportById(id);
	}

	
	/*
	 * for Edit
	 */
	@RequestMapping(value = "getdraftReporteditById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>> getdraftReportById(
			@RequestParam String id) {
		logger.info("Method : getdraftReportById starts");

		logger.info("Method : getdraftReportById ends");
		return restAuditDraftReportDao.getdraftReportById(id);
	}
	
	/**
	 * Rest Controller - sendRequestRequisition
	 *
	 */
	@RequestMapping(value = "/sendDraftDetails", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> sendDetails(@RequestBody List<RestAuditDraftReportModel> obj) {
		logger.info("Method : sendDetails starts");
		System.out.println(obj);
		logger.info("Method : sendDetails ends");
		return restAuditDraftReportDao.sendDetails(obj);
	}
	
	/**
	 * Rest Controller - get Comments Against DraftReport
	 *
	 */
	@RequestMapping(value = "/getdraftCommentById", method = { RequestMethod.GET }, produces = "application/json")
	public List<RestAuditDraftReportModel> getdraftCommentById(@RequestParam String id) {
		logger.info("Method : getdraftCommentById starts");
		
		logger.info("Method : getdraftCommentById ends");
		return restAuditDraftReportDao.getdraftCommentById(id);
	}
	/*
	 * for Edit
	 */
	@RequestMapping(value = "getdraftReporteditByIdNew", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AuditDraftReportModelNew>> getdraftReporteditByIdNew(
			@RequestParam String id) {
		logger.info("Method : getdraftReporteditByIdNew starts");

		logger.info("Method : getdraftReporteditByIdNew ends");
		return restAuditDraftReportDao.getdraftReporteditByIdNew(id);
	}
	/*
	 * for get audit initiated id by audit type
	 */
	@RequestMapping(value = "getAuditInitiatedIdByAuditType", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditInitiatedIdByAuditType(@RequestParam String id) {
		logger.info("Method : getAuditInitiatedIdByAuditType starts");

		logger.info("Method : getAuditInitiatedIdByAuditType ends");
		return restAuditDraftReportDao.getAuditInitiatedIdByAuditType(id);
	}
	@RequestMapping(value = "getccAndToempList", method = { RequestMethod.GET })
	public List<DropDownModel> getccAndToempList() {
	logger.info("Method : getccAndToempList starts");

	logger.info("Method : getccAndToempList ends");
	return restAuditDraftReportDao.getccAndToempList();
	}
}