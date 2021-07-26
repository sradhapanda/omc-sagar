package nirmalya.aatithya.restmodule.audit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.audit.dao.RegionAuditPartyMasterDao;
import nirmalya.aatithya.restmodule.audit.model.RegionAuditPartyMasterModel;

@RestController
@RequestMapping(value = "audit/")
public class RegionAuditPartyMasterRestController {

	Logger logger = LoggerFactory.getLogger(RegionAuditPartyMasterRestController.class);
	@Autowired
	RegionAuditPartyMasterDao regionMasterDao;


	@RequestMapping(value = "/getAuditParty", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RegionAuditPartyMasterModel>>> getAuditParty(
			@RequestBody DataTableRequest tableRequest) {
		logger.info("Method : getAuditParty starts");

		logger.info("Method : getAuditParty ends");

		return regionMasterDao.getAuditPartyDetails(tableRequest);
	}
}
