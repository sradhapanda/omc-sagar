package nirmalya.aatithya.restmodule.audit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nirmalya.aatithya.restmodule.audit.dao.RestAuditHistoryDao;
import nirmalya.aatithya.restmodule.audit.model.AuditHistoryRestModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Controller
@RequestMapping(value = "audit/")
public class AuditHistoryRestController {
	@Autowired
	RestAuditHistoryDao restAuditHistoryDao;

	Logger logger = LoggerFactory.getLogger(AuditHistoryRestController.class);

	/*
	 * for All Service
	 */
	@RequestMapping(value = "getAuditHistoryDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>> getsubgroupDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAuditHistoryDetails starts");

		logger.info("Method : getAuditHistoryDetails ends");

		return restAuditHistoryDao.getAuditHistoryDetails(request);
	}
	
	/**
	 *  REPORT
	 *
	 */
	@RequestMapping(value = "getAuditHitpdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AuditHistoryRestModel>>> restGetBedReport(@RequestBody DataTableRequest request) {
		logger.info("Method : getAuditHitpdf starts");

		logger.info("Method : getAuditHitpdf ends");
		return restAuditHistoryDao.getAuditHitpdf(request);

	}

}
