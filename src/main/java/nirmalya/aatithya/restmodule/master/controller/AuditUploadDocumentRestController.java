package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.audit.model.AuditInitiateModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.AuditDocumentUploadDao;
import nirmalya.aatithya.restmodule.master.model.AuditUploadDocumentReportModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "master")
public class AuditUploadDocumentRestController {
	Logger logger = LoggerFactory.getLogger(AuditUploadDocumentRestController.class);
	@Autowired
	AuditDocumentUploadDao auditDocumentUploadDao;
	
	
	@RequestMapping(value = "restAddAuditDocument", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddAuditDocument(
			@RequestBody List<AuditUploadDocumentReportModel> auditUploadDocumentReportModel) {
		logger.info("Method in rest: restAddAuditDocument starts");

		logger.info("Method in rest: restAddAuditDocument ends");
		return auditDocumentUploadDao.restAddAuditDocument(auditUploadDocumentReportModel);
	}
	
	@RequestMapping(value="getAuditType" , method={RequestMethod.GET})
	public List<DropDownModel> getAuditType() {
		logger.info("Method : getAuditType starts");

		logger.info("Method : getAuditType ends");
		return auditDocumentUploadDao.getAuditType();
	}
	@RequestMapping(value="getAllUploadDocument" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AuditUploadDocumentReportModel>>> getAllUploadDocument(@RequestBody DataTableRequest request){
		logger.info("Method : getAllUploadDocument starts");
		
		logger.info("Method : getAllUploadDocument ends");
		return auditDocumentUploadDao.getAllUploadDocument(request);
	}
}
