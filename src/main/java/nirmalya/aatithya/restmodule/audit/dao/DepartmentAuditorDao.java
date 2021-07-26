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
import nirmalya.aatithya.restmodule.common.utils.GenerateDepartmentAuditorParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.audit.model.DepartmentAuditorModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class DepartmentAuditorDao {
	Logger logger = LoggerFactory.getLogger(DepartmentAuditorDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepHeadList() {
		logger.info("Method : getDepHeadList  starts");

		List<DropDownModel> depHeadList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "depHeadList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				depHeadList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE getAuditorName  ends");

		return depHeadList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSectionList() {
		logger.info("Method : sectionList  starts");

		List<DropDownModel> sectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "sectionList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				sectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE sectionList  ends");

		return sectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSectionByDepartmentAudit(String department) {
		logger.info("Method : getSectionByDepartmentAudit starts");

		List<DropDownModel> sectionList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_depId='" + department + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "getSecByDep").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				sectionList.add(dropDownModel);
			}

			resp.setBody(sectionList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method :  getSectionByDepartmentAudit ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSectionByDepartmentAuditEdit(String id) {
		logger.info("Method : getSectionByDepartmentAuditEdit starts");
		List<DropDownModel> sectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_depId='" + id + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines").setParameter("actionType", "getSecByDep")
					.setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				sectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCourseName end");
		
		return sectionList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> concernAuditee() {
		logger.info("Method : RESTMODULE concernAuditee  starts");

		List<DropDownModel> auditorList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "auditorList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE concernAuditee  ends");

		return auditorList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditeeName() {
		logger.info("Method : RESTMODULE getAuditeeName  starts");

		List<DropDownModel> auditeeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "auditeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE getAuditorName  ends");

		return auditeeList;
	}
	public ResponseEntity<JsonResponse<Object>> addDepartmentAuditor(DepartmentAuditorModel form) {
		logger.info("Method :addDepartmentAuditor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getDepartmentId() == null || form.getDepartmentId() == "") {
			resp.setMessage("Department Name Required");
			validity = false;
		} else if (form.getSection() == null || form.getSection() == "") {
			resp.setMessage("Section Name Required");
			validity = false;
		} else if (form.getAuditor() == null || form.getAuditor() == "") {
			resp.setMessage("Auditee Required");
			validity = false;
		}  else if (form.getDepartmentHead() == null || form.getDepartmentHead() == "") {
			resp.setMessage("Section Head Required");
			validity = false;
		
		} else if (form.getStatus() == null) {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateDepartmentAuditorParameter.addDepartmentAuditorParam(form);
				if (form.getIsEdit() != "") {
					em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
							.setParameter("actionType", "modifyDepAuditor")
							.setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
							.setParameter("actionType", "addDepAuditor")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addDepartmentAuditor end");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DepartmentAuditorModel>>> getAllDepartmentAuditor(DataTableRequest request) {
		logger.info("Method : getAllDepartmentAuditor starts");
		List<DepartmentAuditorModel> form = new ArrayList<DepartmentAuditorModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "viewDepAuditor").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DepartmentAuditorModel depAuditor = new DepartmentAuditorModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],null);
				form.add(depAuditor);
			}

			if (x.get(0).length > 8) {
				BigInteger t = (BigInteger) x.get(0)[8];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<DepartmentAuditorModel>> resp = new JsonResponse<List<DepartmentAuditorModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<DepartmentAuditorModel>>> response = new ResponseEntity<JsonResponse<List<DepartmentAuditorModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllDepartmentAuditor ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DepartmentAuditorModel>> viewDepAuditorEdit(String id,String secId) {
		logger.info("Method : viewDepAuditorEdit starts");
		List<DepartmentAuditorModel> form = new ArrayList<DepartmentAuditorModel>();

		try {
			String values = "SET @p_depId='" + id + "',@p_secId='" + secId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "depAuditModeEdit").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DepartmentAuditorModel depAuditor = new DepartmentAuditorModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],"2");
					form.add(depAuditor);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<DepartmentAuditorModel> depAuditor = new JsonResponse<DepartmentAuditorModel>();
		depAuditor.setBody(form.get(0));

		ResponseEntity<JsonResponse<DepartmentAuditorModel>> response = new ResponseEntity<JsonResponse<DepartmentAuditorModel>>(
				depAuditor, HttpStatus.CREATED);
		logger.info("Method : viewDepAuditorEdit ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DepartmentAuditorModel>> viewDepAuditorModelView(String id,String secId) {
		logger.info("Method : viewDepAuditorModelView starts");
		List<DepartmentAuditorModel> form = new ArrayList<DepartmentAuditorModel>();

		try {
			String values = "SET @p_depId='" + id + "',@p_secId='" + secId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "depAuditModelView").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DepartmentAuditorModel depAuditor = new DepartmentAuditorModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],"2");
					form.add(depAuditor);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<DepartmentAuditorModel> depAuditor = new JsonResponse<DepartmentAuditorModel>();
		depAuditor.setBody(form.get(0));

		ResponseEntity<JsonResponse<DepartmentAuditorModel>> response = new ResponseEntity<JsonResponse<DepartmentAuditorModel>>(
				depAuditor, HttpStatus.CREATED);
		logger.info("Method : viewDepAuditorEdit ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deleteDeptAuditor(String id,String secId) {
		logger.info("Method : deleteDeptAuditor starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_depId='" + id + "',@p_secId='" + secId +"';";
			em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
			.setParameter("actionType", "deleteDepAuditor")
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

		logger.info("Method : deleteDeptAuditor end");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditList() {
		logger.info("Method : Concern Auditee in Dao  starts");
		
		List<DropDownModel> sectionList = new ArrayList<DropDownModel>();
		//System.out.println("hiii");
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentAuditorRoutines")
					.setParameter("actionType", "concernList").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				sectionList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("hii"+sectionList);
		logger.info("Method : Concern Auditee in Dao   ends");
		
		return sectionList;
	}

}
