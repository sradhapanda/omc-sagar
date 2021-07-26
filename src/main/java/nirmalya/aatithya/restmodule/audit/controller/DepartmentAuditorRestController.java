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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.audit.dao.DepartmentAuditorDao;
import nirmalya.aatithya.restmodule.audit.model.DepartmentAuditorModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "master")
public class DepartmentAuditorRestController {

	Logger logger = LoggerFactory.getLogger(DepartmentAuditorRestController.class);
	@Autowired
	DepartmentAuditorDao departmentAuditorDao;

	@RequestMapping(value = "getSectionByDepartmentAudit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSectionByDepartmentAudit(
			@RequestParam String department) {
		logger.info("Method :  getSectionByDepartmentAudit starts");

		logger.info("Method :  getSectionByDepartmentAudit ends");
		return departmentAuditorDao.getSectionByDepartmentAudit(department);
	}

	@RequestMapping(value = "get-concernAuditee-Name", method = { RequestMethod.GET })
	public List<DropDownModel> concernAuditee() {
		logger.info("Method : concernAuditee starts");
		logger.info("Method : concernAuditee ends");
		return departmentAuditorDao.concernAuditee();
	}

	@RequestMapping(value = "get-auditee-list-Name", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditeeName() {
		logger.info("Method : getAuditeeName starts");
		logger.info("Method : getAuditeeName ends");
		return departmentAuditorDao.getAuditeeName();
	}

	@RequestMapping(value = "get-dep-head-list-Name", method = { RequestMethod.GET })
	public List<DropDownModel> getDepHeadList() {
		logger.info("Method : getDepHeadList starts");
		logger.info("Method : getDepHeadList ends");
		return departmentAuditorDao.getDepHeadList();
	}

	@RequestMapping(value = "get-section-list-Name", method = { RequestMethod.GET })
	public List<DropDownModel> getSectionList() {
		logger.info("Method : getSectionList starts");
		logger.info("Method : getSectionList ends");
		return departmentAuditorDao.getSectionList();
	}

	@RequestMapping(value = "/addDepartment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDepartmentAuditor(@RequestBody DepartmentAuditorModel form) {
		logger.info("Method : addDepartmentAuditor starts");

		logger.info("Method : addDepartmentAuditor end");

		return departmentAuditorDao.addDepartmentAuditor(form);

	}

	@RequestMapping(value = "/getAllDepartmentAuditor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DepartmentAuditorModel>>> getAllDepartmentAuditor(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllDepartmentAuditor starts");
		logger.info("Method : getAllDepartmentAuditor endss");
		return departmentAuditorDao.getAllDepartmentAuditor(request);
	}

	@RequestMapping(value = "/viewDepAuditorEdit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DepartmentAuditorModel>> viewDepAuditorEdit(@RequestParam("id") String id,
			@RequestParam("secId") String secId) {
		logger.info("Method : viewSectionModal starts");
		logger.info("Method : viewSectionModal ends");
		return departmentAuditorDao.viewDepAuditorEdit(id, secId);
	}

	
	@RequestMapping(value = "/getSectionByDepartmentAuditEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getSectionByDepartmentAuditEdit(@RequestParam String department) {
		logger.info("Method : getSectionByDepartmentAuditEdit starts");

		logger.info("Method : getSectionByDepartmentAuditEdit end");
		return departmentAuditorDao.getSectionByDepartmentAuditEdit(department);
		
	}
	@RequestMapping(value = "/viewDepAuditorModelView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DepartmentAuditorModel>> viewDepAuditorModelView(@RequestParam("id") String id,
			@RequestParam("secId") String secId) {
		logger.info("Method : viewDepAuditorModelView starts");
		logger.info("Method : viewDepAuditorModelView ends");
		return departmentAuditorDao.viewDepAuditorModelView(id, secId);
	}
	@RequestMapping(value = "/deleteDeptAuditor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDeptAuditor(@RequestParam String id,@RequestParam String secId) {

		logger.info("Method : deleteDeptAuditor starts");

		logger.info("Method : deleteDeptAuditor end");

		return departmentAuditorDao.deleteDeptAuditor(id,secId);
	}
	
	@RequestMapping(value = "get-auditor-list-Name", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditList() {
		logger.info("Method : getSectionList starts");
		//System.out.println("hiii");
		logger.info("Method : getSectionList ends");
		return departmentAuditorDao.getAuditList();
	}
}
