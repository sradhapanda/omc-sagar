package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestFolderMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestFolderMasterModel;



@RestController
@RequestMapping(value = "audit")

public class RestFolderMasterController {
	Logger logger = LoggerFactory.getLogger(RestFolderMasterController.class);

	@Autowired
	RestFolderMasterDao folderMasterDao;

	

	/**
	 * Rest Controller - Add Folder Master 
	 *
	 */
	@RequestMapping(value = "/restAddFolder", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddRegion(@RequestBody RestFolderMasterModel folder) {
		logger.info("Method : restAddRegion starts");

		logger.info("Method : restAddRegion ends");
		return folderMasterDao.addFolderMaster(folder);
	}
	/**
	 * returns folder list for drop down model
	 *
	 */
	@RequestMapping(value = "/getAllFolder", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestFolderMasterModel>>> getAllfolder(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllfolder starts");
		logger.info("Method : getAllfolder endss");
		return folderMasterDao.getAllfolder(request);
	}
	
	/**
	 * delete particular Service
	 *
	 */
	@RequestMapping(value = "/deleteFolderById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFolder(@RequestParam String id,@RequestParam String createdBy) {

		logger.info("Method : deleteFolder starts");

		logger.info("Method : deleteFolder end");

		return folderMasterDao.deleteFolder(id,createdBy);
	}
	@RequestMapping(value = "/getFolderById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestFolderMasterModel>> viewFolderModal(@RequestParam("id") String id) {
		logger.info("Method : viewFolderModal starts");
		logger.info("Method : viewFolderModal ends");
		return folderMasterDao.viewFolderModal(id);
	}
}
