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

import nirmalya.aatithya.restmodule.audit.dao.RegionMasterDao;
import nirmalya.aatithya.restmodule.audit.model.RegionMasterModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;



@RestController
@RequestMapping(value = "audit")

public class RegionMasterRestController {
	Logger logger = LoggerFactory.getLogger(RegionMasterRestController.class);

	@Autowired
	RegionMasterDao regionMasterDao;

	/**
	 * Rest Controller - Get Department For Drop Down
	 *
	 */
	@RequestMapping(value = "dropDownDepartmentDiv", method = { RequestMethod.GET })
	public List<DropDownModel> dropDownDepartmentDiv() {
		logger.info("Method : dropDownDepartmentDiv starts");

		logger.info("Method : dropDownDepartmentDiv ends");
		return regionMasterDao.getDepartmentNameDiv();
	}

	/**
	 * Rest Controller - Add Region Master 
	 *
	 */
	@RequestMapping(value = "/restAddRegion", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddRegion(@RequestBody RegionMasterModel region) {
		logger.info("Method : restAddRegion starts");

		logger.info("Method : restAddRegion ends");
		return regionMasterDao.addRegionMaster(region);
	}
	
	/**
	 * Rest Controller - Get Region Details
	 *
	 */
	@RequestMapping(value = "/getRegion", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RegionMasterModel>>> getRegion(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getRegion starts");

		logger.info("Method : getRegion ends");
		return regionMasterDao.getRegionDetails(request);
	}

	/**
	 * Rest Controller - Get Region Details For Edit
	 *
	 */
	@RequestMapping(value = "/getRegionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RegionMasterModel>> getRegionById(@RequestParam String id) {
		logger.info("Method : getRegionById starts");

		logger.info("Method : getRegionById ends");
		return regionMasterDao.getRegionByIds(id);
	}

	/**
	 * Rest Controller - Delete Region
	 *
	 */
	@RequestMapping(value = "/deleteRegionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRegionById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteRegionById starts");

		logger.info("Method : deleteRegionById ends");
		return regionMasterDao.deleteRegionById(id, createdBy);
	}
}
