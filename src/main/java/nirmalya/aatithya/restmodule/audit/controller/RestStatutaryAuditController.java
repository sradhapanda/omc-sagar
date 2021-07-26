/**
 * 
 */
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
import nirmalya.aatithya.restmodule.audit.dao.RestStatutaryAuditDao;
import nirmalya.aatithya.restmodule.audit.model.AuditCommentsModel;
import nirmalya.aatithya.restmodule.audit.model.AuditComplianceModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterModel;
import nirmalya.aatithya.restmodule.audit.model.AuditMasterPdfModel;
import nirmalya.aatithya.restmodule.audit.model.AuditObservationModel;
import nirmalya.aatithya.restmodule.audit.model.DraftListModel;
import nirmalya.aatithya.restmodule.audit.model.DraftModel;
import nirmalya.aatithya.restmodule.audit.model.PersonListModel;
import nirmalya.aatithya.restmodule.audit.model.PersonModel;
import nirmalya.aatithya.restmodule.audit.model.RequisitionViewModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuidtReportModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "audit/")
public class RestStatutaryAuditController {
	Logger logger = LoggerFactory.getLogger(RestStatutaryAuditController.class);

	@Autowired
	RestStatutaryAuditDao restStatutaryAuditDao;

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "getAllStatutaryAudit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AuditMasterModel>>> getAllStatutaryAudit(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllStatutaryAudit starts");

		logger.info("Method : getAllStatutaryAudit ends");

		return restStatutaryAuditDao.getAllStatutaryAudit(request);
	}

	@RequestMapping(value = "/getStatuCommentsList", method = { RequestMethod.GET })
	public List<AuditCommentsModel> getCommentsList(@RequestParam Integer id) {
		logger.info("Method : getCommentsList starts");

		logger.info("Method : getCommentsList ends");
		return restStatutaryAuditDao.getStatuCommentsList(id);
	}

	/**
	 * Rest Controller - sendRequestRequisition reqForwardBysec
	 *
	 */
	@RequestMapping(value = "/sendStatuResponseRequisition", method = { RequestMethod.POST })
	public JsonResponse<Object> sendStatuResponseRequisition(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : sendStatuResponseRequisition starts");

		logger.info("Method : sendStatuResponseRequisition ends");
		return restStatutaryAuditDao.sendStatuResponseRequisition(obj);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "fowardedStatuReq", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> fowardedStatuReq(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : fowardedStatuReq starts");

		logger.info("Method : fowardedStatuReq ends");

		return restStatutaryAuditDao.fowardedStatuReq(obj);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardPom", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> forwardPom(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardPom starts");

		logger.info("Method : forwardPom ends");

		return restStatutaryAuditDao.fowardedStatuPom(obj);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardIRS", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> forwardIRS(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardIRS starts");

		logger.info("Method : forwardIRS ends");

		return restStatutaryAuditDao.forwardIRS(obj);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardPara", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> forwardPara(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardPara starts");

		logger.info("Method : forwardPara ends");

		return restStatutaryAuditDao.forwardPara(obj);
	}

	/**
	 * Rest Controller - sendRequestRequisition
	 *
	 */
	@RequestMapping(value = "/sendStatuRequestRequisition", method = {
			RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> sendTransRequestRequisition(
			@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : sendStatuRequestRequisition starts");

		logger.info("Method : sendStatuRequestRequisition ends");
		return restStatutaryAuditDao.sendStatuRequestRequisition(obj);
	}

	@RequestMapping(value = "/getStatuReqDocument", method = { RequestMethod.GET })
	public List<RequisitionViewModel> getStatuReqDocument(@RequestParam("id") String id,
			@RequestParam("userId") String userId) {
		logger.info("Method : getStatuReqDocument starts");

		logger.info("Method : getStatuReqDocument ends");
		return restStatutaryAuditDao.getStatuReqDocument(id, userId);
	}

	@RequestMapping(value = "/getStatuQuestionList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getStatuQuestionList(@RequestParam("id") Integer id,
			@RequestParam("deptId") String deptId,

			@RequestParam("sectionId") String sectionId, @RequestParam("userId") String userId) {
		logger.info("Method : getStatuQuestionList starts");

		logger.info("Method : getStatuQuestionList ends");
		return restStatutaryAuditDao.getStatuQuestionList(id, deptId, sectionId, userId);
	}

	@RequestMapping(value = "/getReqDocList", method = { RequestMethod.GET })
	public List<DropDownModel> getReqDocList(@RequestParam("id") String id, @RequestParam("userId") String userId) {
		logger.info("Method : getReqDocList starts");

		logger.info("Method : getReqDocList ends");
		return restStatutaryAuditDao.getReqDocList(id, userId);
	}

	@RequestMapping(value = "getOnlyQuestions", method = { RequestMethod.GET })
	public List<DropDownModel> getOnlyQuestions(@RequestParam("id") String id) {
		logger.info("Method : getOnlyQuestions starts");

		logger.info("Method : getOnlyQuestions ends");
		return restStatutaryAuditDao.getOnlyQuestions(id);
	}

	@RequestMapping(value = "getOnlyIRS", method = { RequestMethod.GET })
	public List<DropDownModel> getOnlyIRS(@RequestParam("id") String id) {
		logger.info("Method : getOnlyIRS starts");

		logger.info("Method : getOnlyIRS ends");
		return restStatutaryAuditDao.getOnlyIRS(id);
	}
	
	@RequestMapping(value = "getOnlyDraft", method = { RequestMethod.GET })
	public List<DropDownModel> getOnlyDraft(@RequestParam("id") String id) {
		logger.info("Method : getOnlyIRS starts");
		
		logger.info("Method : getOnlyIRS ends");
		return restStatutaryAuditDao.getOnlyDraft(id);
	}
	@RequestMapping(value = "getOnlyPara", method = { RequestMethod.GET })
	public List<DropDownModel> getOnlyPara(@RequestParam("id") String id) {
		logger.info("Method : getOnlyIRS starts");
		
		logger.info("Method : getOnlyIRS ends");
		return restStatutaryAuditDao.getOnlyPara(id);
	}
	

	@RequestMapping(value = "getDeviationQuestionList", method = { RequestMethod.GET })
	public List<AuditObservationModel> getDeviationQuestionList(@RequestParam Integer id, @RequestParam String deptId,
			@RequestParam String sectionId, @RequestParam("userId") String userId) {
		logger.info("Method : getDeviationQuestionList starts");

		logger.info("Method : getDeviationQuestionList ends");
		return restStatutaryAuditDao.getDeviationQuestionList(id, deptId, sectionId, userId);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardStatuObs", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> forwardStatuObs(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardStatuObs starts");

		logger.info("Method : forwardStatuObs ends");

		return restStatutaryAuditDao.forwardStatuObs(obj);
	}

	/*
	 * forward To Co-ordinator
	 */
	@RequestMapping(value = "forwardToCo", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> forwardToCo(@RequestParam("id") String id,
			@RequestParam("createdBy") String createdBy) {
		logger.info("Method : forwardToCo starts");

		logger.info("Method : forwardToCo ends");

		return restStatutaryAuditDao.forwardToCo(id, createdBy);
	}

	/*
	 * for Add audit question
	 */
	@RequestMapping(value = "restAddStatuQuestion", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddStatuQuestion(
			@RequestBody List<AuditObservationModel> auditObservationModel) {
		logger.info("Method in rest: restAddStatuQuestion starts");

		logger.info("Method in rest: restAddStatuQuestion ends");
		return restStatutaryAuditDao.restAddStatuQuestion(auditObservationModel);
	}

	/*
	 * for Add audit question
	 */
	@RequestMapping(value = "restAddStatuIrs", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddStatuIrs(
			@RequestBody List<AuditObservationModel> auditObservationModel) {
		logger.info("Method in rest: restAddStatuIrs starts");

		logger.info("Method in rest: restAddStatuIrs ends");
		return restStatutaryAuditDao.restAddStatuIrs(auditObservationModel);
	}

	/*
	 * for Add audit question
	 */
	@RequestMapping(value = "restAddStatuPara", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddStatuPara(
			@RequestBody List<AuditObservationModel> auditObservationModel) {
		logger.info("Method in rest: restAddStatuPara starts");

		logger.info("Method in rest: restAddStatuPara ends");
		return restStatutaryAuditDao.restAddStatuPara(auditObservationModel);
	}
	@RequestMapping(value = "restAddnewPara", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddnewPara(
			@RequestBody List<AuditObservationModel> auditObservationModel) {
		logger.info("Method in rest: restAddnewPara starts");
		
		logger.info("Method in rest: restAddnewPara ends");
		return restStatutaryAuditDao.restAddnewPara(auditObservationModel);
	}
	
	@RequestMapping(value = "restforPara", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restforPara(

			@RequestBody List<AuditObservationModel> auditObservationModel) {
		logger.info("Method in rest: restforPara starts");

		logger.info("Method in rest: restforPara ends");
		return restStatutaryAuditDao.restforPara(auditObservationModel);
	}

	@RequestMapping(value = "/getStatuViewCommentList", method = { RequestMethod.GET })
	public List<AuditComplianceModel> getStatuViewCommentList(@RequestParam("id") Integer id,
			@RequestParam("userId") String userId) {
		logger.info("Method : getStatuViewCommentList starts");

		logger.info("Method : getStatuViewCommentList ends");
		return restStatutaryAuditDao.getStatuViewCommentList(id, userId);
	}

	@RequestMapping(value = "/pdfStatuQuestionList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AuditObservationModel>>> pdfQuestionList(@RequestParam("id") Integer id) {
		logger.info("Method : pdfQuestionList starts");

		logger.info("Method : pdfQuestionList ends");
		return restStatutaryAuditDao.pdfStatuQuestionList(id);
	}

	@RequestMapping(value = "approveObsInStatuAudit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> approveObsInTransAudit(
			@RequestBody List<RequisitionViewModel> observation) {
		logger.info("Method : approveObsInStatuAudit for rest controller starts");

		logger.info("Method : approveObsInStatuAudit for rest controller ends");
		return restStatutaryAuditDao.approveObsInStatuAudit(observation);
	}

	@RequestMapping(value = "/getStatuApprovalStage", method = { RequestMethod.GET })
	public List<DropDownModel> getStatuApprovalStage(@RequestParam Integer id, @RequestParam String userId) {
		logger.info("Method : getStatuApprovalStage starts");

		logger.info("Method : getStatuApprovalStage ends");
		return restStatutaryAuditDao.getStatuApprovalStage(id, userId);
	}

	@RequestMapping(value = "/getAllStatuAuditDetailsByAuditId", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AuditMasterPdfModel>>> getAllStatuAuditDetailsByAuditId(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllStatuAuditDetailsByAuditId starts");

		logger.info("Method : getAllStatuAuditDetailsByAuditId ends");
		return restStatutaryAuditDao.getAllStatuAuditDetailsByAuditId(request);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardStatuReply", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> forwardStatuReply(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardStatuReply starts");

		logger.info("Method : forwardStatuReply ends");

		return restStatutaryAuditDao.forwardStatuReply(obj);
	}

	@RequestMapping(value = "/concernAudicomment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> concernAudicomment(@RequestBody List<RequisitionViewModel> index) {
		logger.info("Method : concernAudicomment starts");

		logger.info("Method : concernAudicomment ends");
		return restStatutaryAuditDao.concernAudicomment(index);
	}

	@RequestMapping(value = "/auditorCommentSave", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> auditorCommentSave(@RequestBody AuditComplianceModel index) {
		logger.info("Method : auditorCommentSave starts");

		logger.info("Method : auditorCommentSave ends");
		return restStatutaryAuditDao.auditorCommentSave(index);
	}

	/*
	 * for coordinator forward
	 */
	@RequestMapping(value = "/coordinatorforward", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> coordinatorforward(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : coordinatorforward starts");

		logger.info("Method : coordinatorforward ends");

		return restStatutaryAuditDao.coordinatorforward(obj);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardToCrn", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> forwardToCrn(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardToCrn starts");

		logger.info("Method : forwardToCrn ends");

		return restStatutaryAuditDao.forwardToCrn(obj);
	}

	/**
	 * Rest Controller - sendRequestRequisition
	 *
	 */
	@RequestMapping(value = "/reqForwardBysec", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> reqForwardBysec(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : reqForwardBysec starts");

		logger.info("Method : reqForwardBysec ends");
		return restStatutaryAuditDao.reqForwardBysec(obj);
	}

	/*
	 * for rejectReq
	 */
	@RequestMapping(value = "rejectReq", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> rejectReq(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : rejectReq starts");

		logger.info("Method : rejectReq ends");

		return restStatutaryAuditDao.rejectReq(obj);
	}

	/*
	 * for saveRequisitionComment
	 */
	@RequestMapping(value = "saveRequisitionComment", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> saveRequisitionComment(@RequestBody RequisitionViewModel obj) {
		logger.info("Method : saveRequisitionComment starts");

		logger.info("Method : saveRequisitionComment ends");
		return restStatutaryAuditDao.saveRequisitionComment(obj);
	}

	/*
	 * for getRequisitionComment
	 */
	@RequestMapping(value = "getRequisitionComment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionComment(@RequestParam("id") String id) {
		logger.info("Method : getRequisitionComment starts");

		logger.info("Method : getRequisitionComment ends");
		return restStatutaryAuditDao.getRequisitionComment(id);
	}

	/*
	 * for getRequisitionComment
	 */
	@RequestMapping(value = "getReqResponse", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReqResponse(@RequestParam("id") String id) {
		logger.info("Method : getReqResponse starts");

		logger.info("Method : getReqResponse ends");
		return restStatutaryAuditDao.getReqResponse(id);
	}

	/*
	 * for saveResponse
	 */
	@RequestMapping(value = "saveResponse", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> saveResponse(@RequestBody RequisitionViewModel obj) {
		logger.info("Method : saveResponse starts");

		logger.info("Method : saveResponse ends");
		return restStatutaryAuditDao.saveResponse(obj);
	}

	@RequestMapping(value = "getSecComment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSecComment(@RequestParam("queId") String queId) {
		logger.info("Method : getSecComment starts");

		logger.info("Method : getSecComment ends");
		return restStatutaryAuditDao.getSecComment(queId);
	}

	/*
	 * for saveSummery
	 */
	@RequestMapping(value = "saveObsComment", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> saveObsComment(@RequestBody AuditComplianceModel index) {
		logger.info("Method : saveObsComment starts");

		logger.info("Method : saveObsComment ends");
		return restStatutaryAuditDao.saveObsComment(index);
	}

	/*
	 * for saveSummery
	 */
	@RequestMapping(value = "getObsComment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getObsComment(@RequestParam("queId") String queId) {
		logger.info("Method : getObsComment starts");

		logger.info("Method : getObsComment ends");
		return restStatutaryAuditDao.getObsComment(queId);
	}

	@RequestMapping(value = "getConAudiComment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getConAudiComment(@RequestParam("queId") String queId) {
		logger.info("Method : getConAudiComment starts");

		logger.info("Method : getConAudiComment ends");
		return restStatutaryAuditDao.getConAudiComment(queId);
	}

	@RequestMapping(value = "/auditeeStatuCommentconsernsave", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> auditeeStatuCommentconsernsave(
			@RequestBody List<RequisitionViewModel> index) {
		logger.info("Method : auditeeStatuCommentconsernsave starts");

		logger.info("Method : auditeeStatuCommentconsernsave ends");
		return restStatutaryAuditDao.auditeeStatuCommentconsernsave(index);
	}

	/*
	 * for rejectResponse
	 */
	@RequestMapping(value = "rejectResponse", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectResponse(
			@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : rejectResponse starts");

		logger.info("Method : rejectResponse ends");
		return restStatutaryAuditDao.rejectResponse(obj);
	}

	@RequestMapping(value = "getPersonList", method = { RequestMethod.GET })
	public List<PersonListModel> getPersonList() {
		logger.info("Method : getPersonList starts");

		logger.info("Method : getPersonList ends");
		return restStatutaryAuditDao.getPersonList();
	}

	/*
	 * f forward To Person
	 */
	@RequestMapping(value = "forwardToPerson", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> forwardToPerson(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardToPerson starts");

		logger.info("Method : forwardToPerson ends");

		return restStatutaryAuditDao.forwardToPerson(obj);
	}

	/*
	 * for rejectObsBySec
	 */
	@RequestMapping(value = "rejectObsBySec", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectObsBySec(@RequestBody AuditComplianceModel obj) {
		logger.info("Method : rejectObsBySec starts");

		logger.info("Method : rejectObsBySec ends");
		return restStatutaryAuditDao.rejectObsBySec(obj);
	}

	/*
	 * for rejectObsByCoordinator
	 */
	@RequestMapping(value = "rejectObsByCoordinator", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> rejectObsByCoordinator(@RequestBody RequisitionViewModel obj) {
		logger.info("Method : rejectObsByCoordinator starts");

		logger.info("Method : rejectObsByCoordinator ends");
		return restStatutaryAuditDao.rejectObsByCoordinator(obj);
	}
	/*
	 * // My View request
	 * 
	 * @RequestMapping(value = "addDocument", method = { RequestMethod.POST })
	 * public ResponseEntity<JsonResponse<Object>> addDocument(@RequestBody
	 * List<RequisitionViewModel> request) {
	 * logger.info("Method : addDocument for rest controller starts");
	 * System.out.println(request);
	 * logger.info("Method : addDocument for rest controller ends"); return
	 * restStatutaryAuditDao.addDocument(request); }
	 */

	// My View request
	@RequestMapping(value = "addDocument", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDocument(@RequestBody List<RequisitionViewModel> request) {
		logger.info("Method : addDocument for rest controller starts");

		logger.info("Method : addDocument for rest controller ends");
		return restStatutaryAuditDao.addDocuments(request);
	}

	/********************************
	 * EDIT RESPONSE
	 *****************************************/
	@RequestMapping(value = "/editStatuReqDocument", method = { RequestMethod.GET })
	public JsonResponse<List<RequisitionViewModel>> viewStatuReqDocument(@RequestParam("id") String id,
			@RequestParam("userId") String userId) {
		logger.info("Method : editStatuReqDocument starts");

		logger.info("Method : editStatuReqDocument ends");
		return restStatutaryAuditDao.editStatuReqDocument(id, userId);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardToAuditorDirect", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> forwardToAuditorDirect(@RequestParam("id") String id,
			@RequestParam("createdBy") String createdBy) {
		logger.info("Method : forwardToAuditorDirect starts");

		logger.info("Method : forwardToAuditorDirect ends");

		return restStatutaryAuditDao.forwardToAuditorDirect(id, createdBy);
	}

	/*
	 * for rejectObsBySec
	 */
	@RequestMapping(value = "rejectObs", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> rejectObs(@RequestBody AuditComplianceModel obj) {
		logger.info("Method : rejectObs starts");

		logger.info("Method : rejectObs ends");
		return restStatutaryAuditDao.rejectObs(obj);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "personList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PersonModel>>> getPersonList(@RequestParam("id") String id) {
		logger.info("Method : getPersonList starts");

		logger.info("Method : getPersonList ends");

		return restStatutaryAuditDao.getPersonList(id);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "getSectionHeadName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PersonModel>>> getSectionHeadName() {
		logger.info("Method : getSectionHeadName starts");

		logger.info("Method : getSectionHeadName ends");

		return restStatutaryAuditDao.getSectionHeadName();
	}

	/*
	 * for coordinator forward
	 */
	@RequestMapping(value = "cordinatorforwardToAuditor", method = {
			RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> cordinatorforwardToAuditor(
			@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : cordinatorforwardToAuditor starts");

		logger.info("Method : cordinatorforwardToAuditor ends");

		return restStatutaryAuditDao.cordinatorforwardToAuditor(obj);
	}

	@RequestMapping(value = "getforwardPersonList", method = { RequestMethod.GET })
	public List<DropDownModel> getforwardPersonList(@RequestParam("id") String id) {
		logger.info("Method : getforwardPersonList starts");

		logger.info("Method : getforwardPersonList ends");
		return restStatutaryAuditDao.getforwardPersonList(id);
	}

	@RequestMapping(value = "getfrowardPersonCCList", method = { RequestMethod.GET })
	public List<DropDownModel> frowardPersonCCList(@RequestParam("id") String id) {
		logger.info("Method : frowardPersonCCList starts");

		logger.info("Method : frowardPersonCCList ends");
		return restStatutaryAuditDao.frowardPersonCCList(id);
	}

	// multiple document
	@RequestMapping(value = "/getStatuMulDocument", method = { RequestMethod.GET })
	public JsonResponse<List<RequisitionViewModel>> getStatuMulDocument(@RequestParam("id") String id) {
		logger.info("Method : getStatuMulDocument starts");

		logger.info("Method : getStatuMulDocument ends");
		return restStatutaryAuditDao.getStatuMulDocument(id);
	}

	// multiple document
	@RequestMapping(value = "/getConcernAuditees", method = { RequestMethod.GET })
	public List<DropDownModel> getConcernAuditees() {
		logger.info("Method : getConcernAuditees starts");

		logger.info("Method : getConcernAuditees ends");
		return restStatutaryAuditDao.getConcernAuditees();
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "getAllStatutaryAuditList", method = { RequestMethod.GET })
	public List<AuditMasterModel> getAllStatutaryAuditList(@RequestParam("id") String id,
			@RequestParam("sectionId") String sectionId, @RequestParam("userId") String userId) {
		logger.info("Method : getAllStatutaryAuditList starts");

		logger.info("Method : getAllStatutaryAuditList ends");

		return restStatutaryAuditDao.getAllStatutaryAuditList(id, sectionId, userId);
	}

	/*
	 * get audit note by id
	 */
	@RequestMapping(value = "getCoForwardDetails", method = { RequestMethod.GET })
	public List<RequisitionViewModel> getCoForwardDetails(@RequestParam String id) {
		logger.info("Method : getCoForwardDetails starts");

		logger.info("Method : getCoForwardDetails ends");

		return restStatutaryAuditDao.getCoForwardDetails(id);
	}

	@RequestMapping(value = "/getForDocList", method = { RequestMethod.GET })
	public List<DropDownModel> getForDocList(@RequestParam("id") String id) {
		logger.info("Method : getForDocList starts");

		logger.info("Method : getForDocList ends");
		return restStatutaryAuditDao.getForDocList(id);
	}

	@RequestMapping(value = "/getCoObsForwardDetails", method = { RequestMethod.GET })
	public List<RequisitionViewModel> getCoObsForwardDetails(@RequestParam("id") String id,
			@RequestParam("userId") String userId) {
		logger.info("Method : getCoObsForwardDetails starts");

		logger.info("Method : getCoObsForwardDetails ends");
		return restStatutaryAuditDao.getCoObsForwardDetails(id, userId);
	}

	@RequestMapping(value = "/getObsReportDetails", method = { RequestMethod.GET })
	public List<RequisitionViewModel> getObsReportDetails(@RequestParam("id") String id) {
		logger.info("Method : getObsReportDetails starts");

		logger.info("Method : getObsReportDetails ends");
		return restStatutaryAuditDao.getObsReportDetails(id);
	}

	@RequestMapping(value = "/getObsForDocList", method = { RequestMethod.GET })
	public List<DropDownModel> getObsForDocList(@RequestParam("id") String id) {
		logger.info("Method : getObsForDocList starts");

		logger.info("Method : getObsForDocList ends");
		return restStatutaryAuditDao.getObsForDocList(id);
	}

	@RequestMapping(value = "/getComplianceDocList", method = { RequestMethod.GET })
	public List<DropDownModel> getComplianceDocList(@RequestParam("id") String id) {
		logger.info("Method : getComplianceDocList starts");

		logger.info("Method : getComplianceDocList ends");
		return restStatutaryAuditDao.getComplianceDocList(id);
	}

	@RequestMapping(value = "/getAuditNoteDocList", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditNoteDocList(@RequestParam("id") String id) {
		logger.info("Method : getAuditNoteDocList starts");

		logger.info("Method : getAuditNoteDocList ends");
		return restStatutaryAuditDao.getAuditNoteDocList(id);
	}

	/*
	 * for All Initiated Audits
	 */
	@RequestMapping(value = "forwardRemark", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> forwardRemark(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : forwardRemark starts");

		logger.info("Method : forwardRemark ends");

		return restStatutaryAuditDao.forwardRemark(obj);
	}

	@RequestMapping(value = "/getAllAuditReport", method = { RequestMethod.GET })
	public List<RestAuidtReportModel> getAllAuditReport(@RequestParam("id") String id) {
		logger.info("Method : getAllAuditReport starts");

		logger.info("Method : getAllAuditReport ends");
		return restStatutaryAuditDao.getAllAuditReport(id);
	}

	@RequestMapping(value = "/getAllAuditReportDtl", method = { RequestMethod.POST })
	public List<RestAuidtReportModel> getAllAuditReportDtl(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllAuditReportDtl starts");

		logger.info("Method : getAllAuditReportDtl ends");
		return restStatutaryAuditDao.getAllAuditReportDtl(request);
	}

	@RequestMapping(value = "/getAllDocumentReport", method = { RequestMethod.POST })
	public List<DropDownModel> getAllDocumentReport(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllDocumentReport starts");

		logger.info("Method : getAllDocumentReport ends");
		return restStatutaryAuditDao.getAllDocumentReport(request);
	}

	/*
	 * for All
	 */
	@RequestMapping(value = "/getAllDraftNo", method = { RequestMethod.GET })
	public List<DropDownModel> getAllDraftNo(@RequestParam("id") String param1, @RequestParam("id2") String param2,
			@RequestParam("id3") String param3) {
		logger.info("Method : getAllDraftNo starts");

		logger.info("Method : getAllDraftNo ends");

		return restStatutaryAuditDao.getAllDraftNo(param1, param2, param3);
	}

	@RequestMapping(value = "/sendFinalObservation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> sendFinalObservation(@RequestBody List<AuditObservationModel> obs) {
		logger.info("Method : sendFinalObservation starts");

		logger.info("Method : sendFinalObservation ends");

		return restStatutaryAuditDao.sendFinalObservation(obs);
	}

	/**
	 * Rest Controller - sendRequestRequisition
	 *
	 */
	@RequestMapping(value = "/revertBack", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> revertBack(@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : revertBack starts");

		logger.info("Method : revertBack ends");
		return restStatutaryAuditDao.revertBack(obj);
	}

	/*
	 * Replay auto Complete
	 */
	@RequestMapping(value = "getReplyAutocomplete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RequisitionViewModel>>> getReplyAutocomplete(@RequestParam("id") String id,
			@RequestParam("reqId") String reqId) {
		logger.info("Method : getReplyAutocomplete starts");

		logger.info("Method : getReplyAutocomplete ends");
		return restStatutaryAuditDao.getReplyAutocomplete(id, reqId);
	}

	/*
	 * for saveForward
	 */
	@RequestMapping(value = "saveForward", method = { RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> saveForwards(@RequestBody RequisitionViewModel obj) {
		logger.info("Method : saveForward starts");

		logger.info("Method : saveForward ends");
		return restStatutaryAuditDao.saveForwardss(obj);
	}
	/*
	 * Reminder Rest
	 * 
	 */

	@RequestMapping(value = "/getReminderDetails", method = { RequestMethod.GET })
	public JsonResponse<List<RequisitionViewModel>> getReminderDetails() {
		logger.info("Method : getReminderDetails starts");

		logger.info("Method : getReminderDetails ends");
		return restStatutaryAuditDao.getReminderDetails();
	}

	/*
	 * Priority DropDown
	 */
	@RequestMapping(value = "getPriorityList", method = { RequestMethod.GET })
	public List<DropDownModel> getPriorityList() {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");

		return restStatutaryAuditDao.getPriorityList();
	}
	@RequestMapping(value = "/getReminderDetailsupdate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getReminderDetailsupdate(@RequestParam("reqId") Integer reqId,
			@RequestParam("auditId") Integer auditId) {
		logger.info("Method : getReminderDetailsupdate starts");

		logger.info("Method : getReminderDetailsupdate ends");
		return restStatutaryAuditDao.getReminderDetailsupdate(reqId, auditId);
	}
	
	@RequestMapping(value = "/viewAllDocument", method = { RequestMethod.GET }, produces = "application/json")
	public JsonResponse<List<RequisitionViewModel>> viewAllDocument(@RequestParam("prevauditid") String prevauditid) {
		logger.info("Method : viewAllDocument starts");

		logger.info("Method : viewAllDocument ends");

		return restStatutaryAuditDao.getallDocument(prevauditid);
	}
	
	@RequestMapping(value = "getReqorev", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReqorev(@RequestParam("reqid") String reqid) {
		logger.info("Method : getReqorev starts");

		logger.info("Method : getReqorev ends");
		return restStatutaryAuditDao.getReqorev(reqid);
	}
	
	/*
	 * Draft Section by Deepak
	 */
	
	@RequestMapping(value = "/saveDraft", method = {
			RequestMethod.POST }, produces = "application/json")
	public ResponseEntity<JsonResponse<Object>> saveDraft(
			@RequestBody List<RequisitionViewModel> obj) {
		logger.info("Method : saveDraft starts");

		logger.info("Method : saveDraft ends");
		return restStatutaryAuditDao.saveDraft(obj);
	}
	/*
	 * draft LIst
	 */
	@RequestMapping(value = "getDraftLIst", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DraftListModel>>> getDraftLIst(@RequestParam("id") String id,
			@RequestParam("userId") String userId, @RequestParam String status) {
		logger.info("Method : getDraftLIst starts");

		logger.info("Method : getDraftLIst ends");
		return restStatutaryAuditDao.getDraftLIst(id, userId, status);
	}
	/*
	 * for DraftComment
	 */
	@RequestMapping(value = "getDraftComment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DraftListModel>> getDraftComment(
			@RequestParam("id") String id) {
		logger.info("Method : getRequisitionComment starts");

		logger.info("Method : getRequisitionComment ends");
		return restStatutaryAuditDao.getDraftComment(id);
	}
	/*
	 * draft Auto complete
	 */
	
	@RequestMapping(value = "draftAutocomplete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DraftModel>>> draftAutocomplete(@RequestParam("id") String id
			) {
		logger.info("Method : draftAutocomplete starts");

		logger.info("Method : draftAutocomplete ends");
		return restStatutaryAuditDao.draftAutocomplete(id);
	}

}
