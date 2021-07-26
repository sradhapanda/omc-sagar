package nirmalya.aatithya.restmodule.master.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.audit.dao.RegionMasterDao;
import nirmalya.aatithya.restmodule.audit.model.RestSectionMasterModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateFolderMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterDepartmentParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSectionMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestFolderMasterModel;
@Repository
public class RestFolderMasterDao {
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(RestFolderMasterDao.class);

	/**
	 * DAO - Add/Modify Region Master
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addFolderMaster(RestFolderMasterModel folder) {
		logger.info("Method : addFolderMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		/*
		 * if (region.getFolder() == null || region.getDepartment() == "") {
		 * resp.setMessage("Department Name Required"); validity = false; } if
		 * (region.getRegionName() == null || region.getRegionName() == "") {
		 * resp.setMessage("Region Name Required"); validity = false; } if
		 * (region.getDescription() == null || region.getDescription() == "") {
		 * resp.setMessage("Description Name Required"); validity = false;
		 * 
		 * }
		 */

		if (validity)
			try {

				String values = GenerateFolderMasterParameter.addFolderParam(folder);
				System.out.println(values);
				System.out.println("sdfsdv "+folder.getFolder());
				if (folder.getFolder() != null && folder.getFolder() != "") {
					em.createNamedStoredProcedureQuery("masterFolderRoutines")
							.setParameter("actionType", "modifyFolder").setParameter("actionValue", values).execute();
				}
				else{
					em.createNamedStoredProcedureQuery("masterFolderRoutines").setParameter("actionType", "addfolder").setParameter("actionValue", values).execute();
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

		logger.info("Method : addFolderMaster ends");
		return response;
	}
	/**
	 * DAO Function to View all folder
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestFolderMasterModel>>> getAllfolder(DataTableRequest request) {
		logger.info("Method : getAllfolder starts");
		List<RestFolderMasterModel> form = new ArrayList<RestFolderMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterFolderRoutines")
					.setParameter("actionType", "viewFolder").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				System.out.println();
				System.out.println(Arrays.toString(m));
				
				RestFolderMasterModel restFolder = new RestFolderMasterModel( m[0], m[1],m[2],null);
				form.add(restFolder);
			}
System.out.println(form);
			if (x.get(0).length > 3) {
				BigInteger t = (BigInteger) x.get(0)[3];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestFolderMasterModel>> resp = new JsonResponse<List<RestFolderMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestFolderMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestFolderMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllfolder ends");

		return response;
	}

	/**
	 * DAO Function to delete particular service
	 *
	 */

public ResponseEntity<JsonResponse<Object>> deleteFolder(String id, String createdBy) {
		logger.info("Method : deleteFolder starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_sectionId='" + id + "';";

			em.createNamedStoredProcedureQuery("masterFolderRoutines")
			.setParameter("actionType", "deleteFolder")
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

		logger.info("Method : deleteFolder end");
		return response;
	}

/**
 * DAO Function to view particular HouseKeeping task to edit/view
 *
 */
@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<RestFolderMasterModel>> viewFolderModal(String id) {
	logger.info("Method : viewFolderModal starts");
	List<RestFolderMasterModel> form = new ArrayList<RestFolderMasterModel>();

	try {
		String values = "SET @p_sectionId='" + id + "';";
		System.out.println(values);
		List<Object[]> x = em.createNamedStoredProcedureQuery("masterFolderRoutines")
				.setParameter("actionType", "FolderModel").setParameter("actionValue", values).getResultList();
		if (!x.isEmpty()) {
			for (Object[] m : x) {
				RestFolderMasterModel sectionMaster = new RestFolderMasterModel(m[0], m[1], m[2], null);
				form.add(sectionMaster);
			}
		}
		System.out.println(form);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	JsonResponse<RestFolderMasterModel> servicemaster = new JsonResponse<RestFolderMasterModel>();
	servicemaster.setBody(form.get(0));

	ResponseEntity<JsonResponse<RestFolderMasterModel>> response = new ResponseEntity<JsonResponse<RestFolderMasterModel>>(
			servicemaster, HttpStatus.CREATED);
	logger.info("Method : viewFolderModal ends");
	return response;
}
}
