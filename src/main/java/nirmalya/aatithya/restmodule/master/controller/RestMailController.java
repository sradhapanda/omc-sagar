package nirmalya.aatithya.restmodule.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestMailDao;
import nirmalya.aatithya.restmodule.master.model.RestMailModel;

@RestController
@RequestMapping(value = "master")
public class RestMailController {
	Logger logger = LoggerFactory.getLogger(RestMailController.class);

	@Autowired
	RestMailDao restMailDao;
	/**
	 * Rest Controller - for mail status
	 *
	 */
	@RequestMapping(value = "restMailStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restMailStatus(@RequestParam String id) {
		logger.info("Method : restMailStatus starts");

		logger.info("Method : restMailStatus ends");
		return restMailDao.emailStatus(id );
	}
}
