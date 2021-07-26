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

import nirmalya.aatithya.restmodule.audit.dao.AuditInitiateDao;
import nirmalya.aatithya.restmodule.audit.model.AuditAdditionalInfoModel;
import nirmalya.aatithya.restmodule.audit.model.AuditDetailModel;
import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.AuditNoteModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditMeetingModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "audit/")
public class AuditInitaiteRestController {

	Logger logger = LoggerFactory.getLogger(AuditInitaiteRestController.class);

	@Autowired
	AuditInitiateDao auditInitiateDao;

	/**
	 * Rest Controller - Get Audit Type For Drop Down  x
	 *
	 */
	@RequestMapping(value = "getAuditType", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditType() {
		logger.info("Method : getAuditType starts");

		logger.info("Method : getAuditType ends");
		return auditInitiateDao.getAuditType();
	}  
	/**
	 * Rest Controller - Get Audit Type For Drop Down  
	 *
	 */
	@RequestMapping(value = "getSupplementaryTypeDashboard", method = { RequestMethod.GET })
	public List<DropDownModel> getSupplementaryTypeDashboard() {
		logger.info("Method : getSupplementaryTypeDashboard starts");
		
		logger.info("Method : getSupplementaryTypeDashboard ends");
		return auditInitiateDao.getSupplementaryTypeDashboard();
	}  
	
	
	
	
	/**
	 * Rest Controller - Get Audit Type For Drop Down
	 *
	 */
	@RequestMapping(value = "getAuditTypeDashboard", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditTypeDashboard() {
		logger.info("Method : getAuditTypeDashboard starts");
		
		logger.info("Method : getAuditTypeDashboard ends");
		return auditInitiateDao.getAuditTypeDashboard();
	}
	
	/**
	 * Rest Controller - Get Audit Type For Drop Down
	 *
	 */
	@RequestMapping(value = "getAuditTypePie", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditTypePie() {
		logger.info("Method : getAuditTypePie starts");
		
		logger.info("Method : getAuditTypePie ends");
		return auditInitiateDao.getAuditTypePie();
	}
	/**
	 * Rest Controller - Get Audit Type For Drop Down getAuditNosByType
	 *
	 */
	@RequestMapping(value = "getAuditNos", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditNos() {
		logger.info("Method : getAuditNos starts");
		
		logger.info("Method : getAuditNos ends");
		return auditInitiateDao.getAuditNos();
	}
	/**
	 * Rest Controller - Get Audit Type For Drop Down 
	 *
	 */
	@RequestMapping(value = "getAuditNosByType", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditNosByType(@RequestParam("id") String auditType) {
		logger.info("Method : getAuditNosByType starts");
		
		logger.info("Method : getAuditNosByType ends");
		return auditInitiateDao.getAuditNosByType(auditType);
	}
	/**
	 * Rest Controller - Get Audit Type For Drop Down
	 *
	 */
	@RequestMapping(value = "getFinancialYear", method = { RequestMethod.GET })
	public List<DropDownModel> getFinancialYear() {
		logger.info("Method : getFinancialYear starts");
		
		logger.info("Method : getFinancialYear ends");
		return auditInitiateDao.getFinancialYear();
	}
	/**
	 * Rest Controller - Get Audit Type For Drop Down
	 *
	 */
	@RequestMapping(value = "getDepartmentListSerach", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentListSerach() {
		logger.info("Method : getDepartmentListSerach starts");
		
		logger.info("Method : getDepartmentListSerach ends");
		return auditInitiateDao.getDepartmentListSerach();
	}

	@RequestMapping(value = "getOrganizationId", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationId() {
		logger.info("Method : getOrganizationId starts");

		logger.info("Method : getOrganizationId ends");
		return auditInitiateDao.getOrganizationId();
	}

	/**
	 * Rest Controller - Initiate Audit
	 *
	 */
	@RequestMapping(value = "/initiate-audit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<Object>>> restInitiateAudit(
			@RequestBody List<AuditInitiateModel> auditInitiate) {
		logger.info("Method : restInitiateAudit starts");

		logger.info("Method : restInitiateAudit ends");
		return auditInitiateDao.initiateAuditDao(auditInitiate);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "getAllInitiatedAudits", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getAllInitiatedAudits(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllInitiatedAudits starts");

		logger.info("Method : getAllInitiatedAudits ends");
		return auditInitiateDao.getAllInitiatedAudits(request);
	}

	/**
	 * Rest Controller - approveAccept
	 *
	 */
	@RequestMapping(value = "/approveAccept", method = { RequestMethod.GET })
	public JsonResponse<Object> approveAccept(@RequestParam("id") String id,
			@RequestParam("createdBy") String createdBy) {
		logger.info("Method : approveAccept starts");

		logger.info("Method : approveAccept ends");
		return auditInitiateDao.approveAccept(id, createdBy);
	}

	@RequestMapping(value = "getAuditor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getAuditor(
			@RequestParam("organization") String organization) {
		logger.info("Method : getAuditor starts");

		logger.info("Method : getAuditor ends");
		return auditInitiateDao.getAuditor(organization);
	}

	@RequestMapping(value = "getDesignation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getDesignation(
			@RequestParam("auditor") String auditor) {
		logger.info("Method : getDesignation starts");

		logger.info("Method : getDesignation ends");
		return auditInitiateDao.getDesignation(auditor);
	}

	/*
	 * for saveSummery
	 */
	@RequestMapping(value = "saveSummery", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveSummery(@RequestBody String summery) {
		logger.info("Method : saveSummery starts");

		logger.info("Method : saveSummery ends");
		return auditInitiateDao.saveSummery(summery);
	}

	/*
	 * for getSummery
	 */
	@RequestMapping(value = "getSummery", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSummery() {
		logger.info("Method : getSummery starts");

		logger.info("Method : getSummery ends");
		return auditInitiateDao.getSummery();
	}

	/**
	 * Rest Controller - sendRequestRequisition
	 *
	 */
	@RequestMapping(value = "/sendDetails", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> sendDetails(@RequestBody List<AuditInitiateModel> obj) {
		logger.info("Method : sendDetails starts");
		//System.out.println(obj);
		logger.info("Method : sendDetails ends");
		return auditInitiateDao.sendDetails(obj);
	}

	@RequestMapping(value = "/viewDetails", method = { RequestMethod.GET })
	public JsonResponse<List<AuditDetailModel>> viewDetails(@RequestParam("id") String id) {
		logger.info("Method : viewDetails starts");

		logger.info("Method : viewDetails ends");
		return auditInitiateDao.viewDetails(id);
	}

	/*
	 * for saveNotes
	 */
	@RequestMapping(value = "saveNotes", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> saveNotes(@RequestBody AuditInitiateModel obj) {
		logger.info("Method : saveNotes starts");

		logger.info("Method : saveNotes ends");
		return auditInitiateDao.saveNotes(obj);
	}
	/*
	 * for saveNotes
	 */
	@RequestMapping(value = "viewNotification", method = { RequestMethod.GET }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> viewNotification(@RequestParam("id")String id,@RequestParam("type")String type,@RequestParam("userId")String userId) {
		logger.info("Method : viewNotification starts");
		
		logger.info("Method : viewNotification ends");
		return auditInitiateDao.viewNotification(id,type,userId);
	}

	/*
	 * for saveSummery
	 */
	@RequestMapping(value = "getNotes", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<DropDownModel>> getNotes(@RequestBody String id) {
		logger.info("Method : getNotes starts");

		logger.info("Method : getNotes ends");
		return auditInitiateDao.getNotes(id);
	}

	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AuditInitiateModel>>> getOrganization(
			@RequestParam("auditType") String auditType) {
		logger.info("Method : getOrganization starts");

		logger.info("Method : getOrganization ends");
		return auditInitiateDao.getOrganization(auditType);
	}

	/*
	 * for Edit
	 */
	@RequestMapping(value = "getinitiateAuditById", method = { RequestMethod.GET })
	public List<AuditMasterModel> getinitiateAuditById(@RequestParam String id) {
		logger.info("Method : getinitiateAuditById starts");

		logger.info("Method : getinitiateAuditById ends");

		return auditInitiateDao.getinitiateAuditById(id);
	}
	
	/*
	 * for Edit
	 */
	@RequestMapping(value = "getMeetSectionList", method = { RequestMethod.GET })
	public List<DropDownModel> getSectionList(@RequestParam String id) {
		logger.info("Method : getSectionList starts");
		
		logger.info("Method : getSectionList ends");
		
		return auditInitiateDao.getSectionList(id);
	}

	/*
	 * getAudits
	 */
	@RequestMapping(value = "getAudits", method = { RequestMethod.GET })
	public List<AuditInitiateModel> getAudits(@RequestParam String id) {
		logger.info("Method : getAudits starts");

		logger.info("Method : getAudits ends");

		return auditInitiateDao.getAudits(id);
	}

	/*
	 * for Edit
	 */
	@RequestMapping(value = "getAdditionalInformation", method = { RequestMethod.GET })
	public List<AuditAdditionalInfoModel> getAdditionalInformation(@RequestParam String id) {
		logger.info("Method : getAdditionalInformation starts");

		logger.info("Method : getAdditionalInformation ends");

		return auditInitiateDao.getAdditionalInformation(id);
	}

	/*
	 * get docs
	 */
	@RequestMapping(value = "getinitiateAuditDocsById", method = { RequestMethod.GET })
	public List<AuditAdditionalInfoModel> getinitiateAuditDocsById(@RequestParam String id) {
		logger.info("Method : getinitiateAuditDocsById starts");

		logger.info("Method : getinitiateAuditDocsById ends");

		return auditInitiateDao.getinitiateAuditDocsById(id);
	}

	/*
	 * get audit note by id getCoForwardDetails
	 */
	@RequestMapping(value = "getAuditNoteById", method = { RequestMethod.GET })
	public List<AuditNoteModel> getAuditNoteById(@RequestParam String id) {
		logger.info("Method : getAuditNoteById starts");

		logger.info("Method : getAuditNoteById ends");

		return auditInitiateDao.getAuditNoteById(id);
	}
	/*
	 * get audit note by id getCoForwardDetails
	 */
	@RequestMapping(value = "getAuditorQuestionList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getAuditorQuestionList(@RequestParam String id) {
		logger.info("Method : getAuditorQuestionList starts");
		
		logger.info("Method : getAuditorQuestionList ends");
		
		return auditInitiateDao.getAuditorQuestionList(id);
	}
	/*
	 * get audit note by id getCoForwardDetails
	 */
	@RequestMapping(value = "getAuditorIRSList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getAuditorIRSList(@RequestParam String id) {
		logger.info("Method : getAuditorIRSList starts");
		
		logger.info("Method : getAuditorIRSList ends");
		
		return auditInitiateDao.getAuditorIRSList(id);
	}
	/*
	 * get audit note by id getCoForwardDetails
	 */
	@RequestMapping(value = "getAuditorDraftParaList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getAuditorDraftParaList(@RequestParam String id) {
		logger.info("Method : getAuditorDraftParaList starts");
		
		logger.info("Method : getAuditorDraftParaList ends");
		
		return auditInitiateDao.getAuditorDraftParaList(id);
	}
	@RequestMapping(value = "getAuditorParaList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getAuditorParaList(@RequestParam String id) {
		logger.info("Method : getAuditorParaList starts");
		
		logger.info("Method : getAuditorParaList ends");
		
		return auditInitiateDao.getAuditorParaList(id);
	}
	@RequestMapping(value = "getAuditorCocoList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getAuditorCocoList(@RequestParam String id) {
		logger.info("Method : getAuditorCocoList starts");
		
		logger.info("Method : getAuditorCocoList ends");
		
		return auditInitiateDao.getAuditorCocoList(id);
	}
	/*
	 * get audit note by id getMeetingDetails
	 */
	@RequestMapping(value = "getMeetingDetails", method = { RequestMethod.GET })
	public List<RestAuditMeetingModel> getMeetingDetails(@RequestParam String id,@RequestParam("auditType") String auditType) {
		logger.info("Method : getMeetingDetails starts");

		logger.info("Method : getMeetingDetails ends");

		return auditInitiateDao.getMeetingDetails(id,auditType);
	}
	
	/*
	* get questions
	*/
	@RequestMapping(value = "/getQuestionList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getQuestionList(@RequestParam("userid") String id,@RequestParam("auditId") String auditid,
			@RequestParam("department") String department,@RequestParam("section") String section) {
	logger.info("Method : getQuestionList starts");

	logger.info("Method : getQuestionList ends");

	return auditInitiateDao.getQuestionList(id,auditid,department,section);
	}
	/*
	 * get AuditReport Dtl
	 */
	@RequestMapping(value = "/getAuditReportDtl", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditReportDtl(@RequestParam("auditId") String auditid) {
		logger.info("Method : getAuditReportDtl starts");
		
		logger.info("Method : getAuditReportDtl ends");
		
		return auditInitiateDao.getAuditReportDtl(auditid);
	}
	/*
	 * get AuditReport Dtl
	 */
	@RequestMapping(value = "/getReplyOfManagement", method = { RequestMethod.GET })
	public List<DropDownModel> getReplyOfManagement(@RequestParam("auditId") String auditid) {
		logger.info("Method : getReplyOfManagement starts");
		
		logger.info("Method : getReplyOfManagement ends");
		
		return auditInitiateDao.getReplyOfManagement(auditid);
	}
	/*
	 * get AuditReport Dtl
	 */
	@RequestMapping(value = "/getAuditFinalObservation", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditFinalObservation(@RequestParam("auditId") String auditid) {
		logger.info("Method : getAuditFinalObservation starts");
		
		logger.info("Method : getAuditFinalObservation ends");
		
		return auditInitiateDao.getAuditFinalObservation(auditid);
	}

	/*
	 * get AuditDocs By id
	 */
	@RequestMapping(value = "getAuditDocs", method = { RequestMethod.GET })
	public List<AuditAdditionalInfoModel> getAuditDocs(@RequestParam("id") String id) {
		logger.info("Method : getAuditDocs starts");

		logger.info("Method : getAuditDocs ends");

		return auditInitiateDao.getAuditDocs(id);
	}
	/**
	 * Rest Controller - sendRequestRequisition
	 *
	 */
	@RequestMapping(value = "/meetingDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> meetingDetails(@RequestBody List<RestAuditMeetingModel> obj) {
		logger.info("Method : meetingDetails starts");
		logger.info("Method : meetingDetails ends");
		return auditInitiateDao.meetingDetails(obj);
	}
	
	@PostMapping(value = "/meetingDetailsAfterAttend")
	public ResponseEntity<JsonResponse<Object>> meetingDetailsAfterAttend(@RequestBody List<RestAuditMeetingModel> obj) {
		logger.info("Method : meetingDetailsAfterAttend starts");
		logger.info("Method : meetingDetailsAfterAttend ends");
		return auditInitiateDao.meetingDetailsAfterAttend(obj);
	}
	
	@GetMapping(value = "/modalMeetingDetailsAfterAttend")
	public ResponseEntity<JsonResponse<List<RestAuditMeetingModel>>> modalMeetingDetailsAfterAttend(@RequestParam Integer id) {
		logger.info("Method : modalMeetingDetailsAfterAttend starts");
		logger.info("Method : modalMeetingDetailsAfterAttend ends");
		return auditInitiateDao.modalMeetingDetailsAfterAttend(id);
	}
	
	/*
	 * get AuditDocs By id
	 */
	@RequestMapping(value = "getMeetingDetailsDoc", method = { RequestMethod.GET })
	public List<DropDownModel> getMeetingDetailsDoc(@RequestParam("id") String id) {
		logger.info("Method : getMeetingDetailsDoc starts");

		logger.info("Method : getMeetingDetailsDoc ends");

		return auditInitiateDao.getMeetingDetailsDoc(id);
	}
	/*
	 * get AuditDocs By id
	 */
	@RequestMapping(value = "getAuditNoteByIdDoc", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditNoteByIdDoc(@RequestParam("id") String id) {
		logger.info("Method : getAuditNoteByIdDoc starts");
		
		logger.info("Method : getAuditNoteByIdDoc ends");
		
		return auditInitiateDao.getAuditNoteByIdDoc(id);
	}
	
	@RequestMapping(value = "documentAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> documentAutoSearch(
			@RequestParam("id") String id) {
		logger.info("Method : documentAutoSearch starts");

		logger.info("Method : documentAutoSearch ends");
		return auditInitiateDao.documentAutoSearch(id);
	}
	/**
	 * Rest Controller - Initiate Audit
	 *
	 */
	@RequestMapping(value = "/delete-audit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>>deleteAudit(@RequestParam("id") String id,@RequestParam("createdBy") String createdBy) {
		logger.info("Method : deleteAudit starts");

		logger.info("Method : deleteAudit ends");
		return auditInitiateDao.deleteAudit(id,createdBy);
	}
	
	
	@RequestMapping(value = "uploadDocument", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDocument(@RequestBody List<RequisitionViewModel> request) {
		logger.info("Method : uploadDocument for rest controller starts");
		
		logger.info("Method : uploadDocument for rest controller ends");
		return auditInitiateDao.uploadDocument(request);
	}
	
	
	@RequestMapping(value = "getDeptHeadList", method = { RequestMethod.GET })
	public List<DropDownModel> getDeptHeadList(@RequestParam String id) {
	logger.info("Method : getDeptHeadList starts");

	logger.info("Method : getDeptHeadList ends");
	return auditInitiateDao.getDeptHeadList(id);
	}
	
	
	@RequestMapping(value = "getSelectedDeptHeadList", method = { RequestMethod.GET })
	public List<DropDownModel> getSelectedDeptHeadList(@RequestParam String id) {
		logger.info("Method : getSelectedDeptHeadList starts");
		
		logger.info("Method : getSelectedDeptHeadList ends");
		return auditInitiateDao.getSelectedDeptHeadList(id);
	}
	
	@RequestMapping(value = "getCCList", method = { RequestMethod.GET })
	public List<DropDownModel> getCCList(@RequestParam String id) {
		logger.info("Method : getCCList starts");
		
		logger.info("Method : getCCList ends");
		return auditInitiateDao.getCCList(id);
	}
	@RequestMapping(value = "/postEmailPassword", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> postEmailPassword(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("host") String host) {
		logger.info("Method : postEmailPassword starts");

		logger.info("Method : postEmailPassword ends");
		return auditInitiateDao.postEmailPassword(id,password,host);
	}
	@RequestMapping(value = "/getAuditNameListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditNameList(@RequestParam("id") String id,@RequestParam("auditTypeId") String auditTypeId) {
		logger.info("Method : getItemNameListByAutoSearch starts");
		logger.info("Method : getItemNameListByAutoSearch ends");
		return auditInitiateDao.getAuditNameListByAutoSearch(id,auditTypeId);
	}
	/*
	 * get audit note by id getMeetingDetails
	 */
	@RequestMapping(value = "getMeetingDetailsEachAudit", method = { RequestMethod.GET })
	public List<RestAuditMeetingModel> getMeetingDetailsEachAudit(@RequestParam String id) {
		logger.info("Method : getMeetingDetailsEachAudit starts");

		logger.info("Method : getMeetingDetailsEachAudit ends");

		return auditInitiateDao.getMeetingDetailsEachAudit(id);
	}
	
}
