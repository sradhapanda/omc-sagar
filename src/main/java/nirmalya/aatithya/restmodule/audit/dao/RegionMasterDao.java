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

import nirmalya.aatithya.restmodule.audit.model.RegionMasterModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterDepartmentParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository

public class RegionMasterDao {
	Logger logger = LoggerFactory.getLogger(RegionMasterDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * DAO - Get Department For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentNameDiv() {
		logger.info("Method : getDepartmentNameDiv starts");

		List<DropDownModel> departmentNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterRegionRoutines")
					.setParameter("actionType", "getRegion").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentNameDiv ends");
		return departmentNameList;

	}

	/**
	 * DAO - Add/Modify Region Master
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addRegionMaster(RegionMasterModel region) {
		logger.info("Method : addRegionMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (region.getDepartment() == null || region.getDepartment() == "") {
			resp.setMessage("Department Name Required");
			validity = false;
		}
		if (region.getRegionName() == null || region.getRegionName() == "") {
			resp.setMessage("Region Name Required");
			validity = false;
		}
		if (region.getDescription() == null || region.getDescription() == "") {
			resp.setMessage("Description Name Required");
			validity = false;

		}

		if (validity)
			try {

				String values = GenerateMasterDepartmentParameter.getAddDepartmentParam(region);
				if (region.getRegionId() != null && region.getRegionId() != "") {
					em.createNamedStoredProcedureQuery("masterRegionRoutines")
							.setParameter("actionType", "modifyRegion").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("masterRegionRoutines").setParameter("actionType", "addRegion")
							.setParameter("actionValue", values).execute();
				}
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

		logger.info("Method : addRegionMaster ends");
		return response;
	}

	/**
	 * DAO - Get Region Details
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RegionMasterModel>>> getRegionDetails(DataTableRequest request) {
		logger.info("Method : getRegionDetails Starts");

		List<RegionMasterModel> region = new ArrayList<RegionMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterRegionRoutines")
					.setParameter("actionType", "viewRegionDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				RegionMasterModel regionMasterModel = new RegionMasterModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				region.add(regionMasterModel);
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

		JsonResponse<List<RegionMasterModel>> resp = new JsonResponse<List<RegionMasterModel>>();
		resp.setBody(region);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RegionMasterModel>>> response = new ResponseEntity<JsonResponse<List<RegionMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRegionDetails ends");
		return response;
	}

	/**
	 * DAO - Get Region For Edit View
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RegionMasterModel>> getRegionByIds(String id) {
		logger.info("Method : getRegionByIds starts");

		List<RegionMasterModel> regionMaster = new ArrayList<RegionMasterModel>();
		JsonResponse<RegionMasterModel> resp = new JsonResponse<RegionMasterModel>();

		try {

			String value = "SET @p_regionId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterRegionRoutines")
					.setParameter("actionType", "viewEditRegion")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				RegionMasterModel region = new RegionMasterModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				regionMaster.add(region);
			}

			resp.setBody(regionMaster.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RegionMasterModel>> response = new ResponseEntity<JsonResponse<RegionMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRegionByIds ends");
		return response;
	}

	/**
	 * DAO - Delete Region
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteRegionById(String id, String createdBy) {
		logger.info("Method : deleteRegionById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_regionId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("masterRegionRoutines").setParameter("actionType", "deleteRegion")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteRegionById ends");
		return response;
	}
}
