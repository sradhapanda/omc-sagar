package nirmalya.aatithya.restmodule.audit.dao;

	import java.math.BigInteger;
	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.EntityManager;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.audit.model.OutStandingParaModel;
import nirmalya.aatithya.restmodule.audit.model.RegionMasterModel;
	import nirmalya.aatithya.restmodule.common.ServerDao;
	import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
	import nirmalya.aatithya.restmodule.common.utils.GenerateMasterDepartmentParameter;
	import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
	import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

	@Repository

	public class RestOutStandingDao {
		Logger logger = LoggerFactory.getLogger(RestOutStandingDao.class);

		@Autowired
		ServerDao serverDao;

		@Autowired
		EntityManager em;


		/**
		 * DAO - Add/Modify Region Master
		 *
		 */
		public ResponseEntity<JsonResponse<Object>> restAddOutStandingPara(OutStandingParaModel paras) {
			logger.info("Method : restAddOutStandingPara starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (paras.getYear() == null || paras.getYear() == "") {
				resp.setMessage("Year  Required");
				validity = false;
			}
			if (paras.getIrs() == null ) {
				resp.setMessage("Irs Required");
				validity = false;
			}
			if (paras.getParas() == null ) {
				resp.setMessage("Paras  Required");
				validity = false;

			}
			if (paras.getMoneyValue() == null ) {
				resp.setMessage("Money Value  Required");
				validity = false;
				
			}

			if (validity)
				try {

					String values = GenerateMasterDepartmentParameter.addOutstandingParam(paras);
					
						em.createNamedStoredProcedureQuery("executiveRoutines").setParameter("actionType", "addOutStanPara")
								.setParameter("actionValue", values).execute();
					
				} catch (Exception e) {
					e.printStackTrace();
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
System.out.println(response);
			logger.info("Method : restAddOutStandingPara ends");
			return response;
		}

		/**
		 * DAO - Get Region Details
		 *
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<OutStandingParaModel>>> getOutStandingParas(DataTableRequest request) {
			logger.info("Method : getOutStandingParas Starts");

			List<OutStandingParaModel> region = new ArrayList<OutStandingParaModel>();
			String values = GenerateParameter.getSearchParam(request);
			Integer total = 0;

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("executiveRoutines")
						.setParameter("actionType", "viewOutStandingPara").setParameter("actionValue", values)
						.getResultList();

				for (Object[] m : x) {
					OutStandingParaModel outStandingParaModel = new OutStandingParaModel(m[0], m[1], m[2], m[3], m[4], m[5]);
					region.add(outStandingParaModel);
				}
				if (x.size() > 0) {
					if (x.get(0).length > 6) {
						BigInteger t = (BigInteger) x.get(0)[6];

						total = Integer.parseInt((t.toString()));
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			JsonResponse<List<OutStandingParaModel>> resp = new JsonResponse<List<OutStandingParaModel>>();
			resp.setBody(region);
			resp.setTotal(total);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<OutStandingParaModel>>> response = new ResponseEntity<JsonResponse<List<OutStandingParaModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : getOutStandingParas ends");
			System.out.println(response);
			return response;
		}

	
	}
