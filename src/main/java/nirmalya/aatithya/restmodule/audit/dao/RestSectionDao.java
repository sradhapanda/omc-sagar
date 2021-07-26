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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSectionMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.audit.model.RestSectionMasterModel;




@Repository
public class RestSectionDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;
	Logger logger = LoggerFactory.getLogger(RestSectionDao.class);

	/*
	 * DAO Function to Add/edit New HouseKeeping Task
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addSection(RestSectionMasterModel sectionMasterModel) {

		logger.info("Method : addSection starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (sectionMasterModel.getSectionName() == null || sectionMasterModel.getSectionName() == "") {
			resp.setMessage("Section Name required");
			validity = false;
		} else if (sectionMasterModel.getDepartment() == null || sectionMasterModel.getDepartment() == "") {
			resp.setMessage("Department required");
			validity = false;
		} else if (sectionMasterModel.getSectionStatus() == null) {
			resp.setMessage("Status required");
			validity = false;
		} else if (sectionMasterModel.getCreatedBy() == null || sectionMasterModel.getCreatedBy() == "") {
			resp.setMessage(" required");
			validity = false;
		}

		if (validity) {
			try {
				String values = GenerateSectionMasterParameter.addSectionParam(sectionMasterModel);

				if (sectionMasterModel.getSection() == null || sectionMasterModel.getSection() == "") {
					em.createNamedStoredProcedureQuery("sectionRoutines").setParameter("actionType", "addSection")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("sectionRoutines").setParameter("actionType", "modifySection")
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addSection ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");
		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("sectionRoutines")
					.setParameter("actionType", "departmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDepartmentList end");
		return departmentList;
	}
	/**
	 * DAO Function to View all Service
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSectionMasterModel>>> getAllSection(DataTableRequest request) {
		logger.info("Method : getAllSection starts");
		List<RestSectionMasterModel> form = new ArrayList<RestSectionMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("sectionRoutines")
					.setParameter("actionType", "viewSection").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestSectionMasterModel restSection = new RestSectionMasterModel(m[0], m[1], m[2], m[3]);
				form.add(restSection);
			}

			if (x.get(0).length > 4) {
				BigInteger t = (BigInteger) x.get(0)[4];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestSectionMasterModel>> resp = new JsonResponse<List<RestSectionMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestSectionMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestSectionMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllSection ends");

		return response;
	}

	/**
	 * DAO Function to view particular HouseKeeping task to edit/view
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSectionMasterModel>> viewSectionModal(String id) {
		logger.info("Method : viewSectionModal starts");
		List<RestSectionMasterModel> form = new ArrayList<RestSectionMasterModel>();

		try {
			String values = "SET @p_sectionId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("sectionRoutines")
					.setParameter("actionType", "sectionModel").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestSectionMasterModel sectionMaster = new RestSectionMasterModel(m[0], m[1], m[2], m[3]);
					form.add(sectionMaster);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestSectionMasterModel> servicemaster = new JsonResponse<RestSectionMasterModel>();
		servicemaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestSectionMasterModel>> response = new ResponseEntity<JsonResponse<RestSectionMasterModel>>(
				servicemaster, HttpStatus.CREATED);
		logger.info("Method : viewSectionModal ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSectionMasterModel>> viewSectionModelView(String id) {
		logger.info("Method : viewSectionModelView starts");
		List<RestSectionMasterModel> form = new ArrayList<RestSectionMasterModel>();

		try {
			String values = "SET @p_sectionId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("sectionRoutines")
					.setParameter("actionType", "modelVwSection").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestSectionMasterModel sectionMaster = new RestSectionMasterModel(m[0], m[1], m[2], m[3]);
					form.add(sectionMaster);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestSectionMasterModel> servicemaster = new JsonResponse<RestSectionMasterModel>();
		servicemaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestSectionMasterModel>> response = new ResponseEntity<JsonResponse<RestSectionMasterModel>>(
				servicemaster, HttpStatus.CREATED);
		logger.info("Method : viewSectionModal ends");
		return response;
	}
	
		/**
		 * DAO Function to delete particular service
		 *
		 */

	public ResponseEntity<JsonResponse<Object>> deleteSection(String id, String createdBy) {
			logger.info("Method : deleteSection starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			try {

				String value = "SET @p_sectionId='" + id + "',@p_createdBy='" + createdBy +"';";

				em.createNamedStoredProcedureQuery("sectionRoutines")
				.setParameter("actionType", "deleteSection")
						.setParameter("actionValue", value).execute();

			}  catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : deleteSection end");
			return response;
		}

}
