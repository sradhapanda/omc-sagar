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
import nirmalya.aatithya.restmodule.audit.dao.RestSectionDao;
import nirmalya.aatithya.restmodule.audit.model.RestSectionMasterModel;


/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "master")
public class RestSectionMasterController {
	@Autowired
	RestSectionDao sectionDao;

	Logger logger = LoggerFactory.getLogger(RestSectionMasterController.class);

	/**
	 * Post Mapping to Add new section
	 *
	 */
	@RequestMapping(value = "/addSection", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addSection(@RequestBody RestSectionMasterModel sectionMasterModel) {
		logger.info("Method : addSection starts");
		logger.info("Method : addSection endss");
		return sectionDao.addSection(sectionMasterModel);
	}
	
	/**
	 * returns department list for drop down model
	 *
	 */
	@RequestMapping(value = "/get-department-list-Name", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");

		logger.info("Method : getDepartmentList end");
		return sectionDao.getDepartmentList();
	}
	/**
	 * returns section list for drop down model
	 *
	 */
	@RequestMapping(value = "/getAllSection", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestSectionMasterModel>>> getAllSection(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllSection starts");
		logger.info("Method : getAllSection endss");
		return sectionDao.getAllSection(request);
	}
	
	@RequestMapping(value = "/viewSectionModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSectionMasterModel>> viewSectionModal(@RequestParam("id") String id) {
		logger.info("Method : viewSectionModal starts");
		logger.info("Method : viewSectionModal ends");
		return sectionDao.viewSectionModal(id);
	}
	@RequestMapping(value = "/viewSectionModelView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSectionMasterModel>> viewSectionModelView(@RequestParam("id") String id) {
		logger.info("Method : viewSectionModelView starts");
		logger.info("Method : viewSectionModelView ends");
		return sectionDao.viewSectionModelView(id);
	}
	
	/**
	 * delete particular Service
	 *
	 */
	@RequestMapping(value = "/deleteSection", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSection(@RequestParam String id,@RequestParam String createdBy) {

		logger.info("Method : deleteSection starts");

		logger.info("Method : deleteSection end");

		return sectionDao.deleteSection(id,createdBy);
	}
}
