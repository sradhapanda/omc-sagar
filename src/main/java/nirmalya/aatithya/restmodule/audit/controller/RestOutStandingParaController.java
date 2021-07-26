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
	import nirmalya.aatithya.restmodule.audit.dao.RestOutStandingDao;
	import nirmalya.aatithya.restmodule.audit.model.OutStandingParaModel;
	import nirmalya.aatithya.restmodule.audit.model.RegionMasterModel;
	import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
	import nirmalya.aatithya.restmodule.common.utils.JsonResponse;



	@RestController
	@RequestMapping(value = "audit")

	public class RestOutStandingParaController {
		Logger logger = LoggerFactory.getLogger(RestOutStandingParaController.class);

		@Autowired
		RestOutStandingDao restOutStandingDao;


		/**
		 * Rest Controller - Add Region Master 
		 *
		 */
		@RequestMapping(value = "/restAddOutStandingPara", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> restAddOutStandingPara(@RequestBody OutStandingParaModel region) {
			logger.info("Method : restAddOutStandingPara starts");

			logger.info("Method : restAddOutStandingPara ends");
			return restOutStandingDao.restAddOutStandingPara(region);
		}
		
		/**
		 * Rest Controller - Get Region Details
		 *
		 */
		@RequestMapping(value = "/getOutStandingParas", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<OutStandingParaModel>>> getOutStandingParas(
				@RequestBody DataTableRequest request) {
			logger.info("Method : getOutStandingParas starts");

			logger.info("Method : getOutStandingParas ends");
			return restOutStandingDao.getOutStandingParas(request);
		}

		

		
	}
