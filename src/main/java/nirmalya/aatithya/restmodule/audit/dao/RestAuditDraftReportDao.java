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

import nirmalya.aatithya.restmodule.audit.model.AuditAttachmentNewModel;
import nirmalya.aatithya.restmodule.audit.model.AuditDraftReportModelNew;
import nirmalya.aatithya.restmodule.audit.model.RestAuditDraftReportModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditReportAdditionalInfoModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditReportBasicsQualifyModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditDraftDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAuditDraftReportParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAuditDraftReportDao {

	Logger logger = LoggerFactory.getLogger(RestAuditDraftReportDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/*
	 * DropDown for AuditReportType
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditReportType() {
		logger.info("Method : getAuditReportType starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getAuditReportType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditReportType ends");
		return dept;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getempList() {
		logger.info("Method : getempList starts");
		
		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getempList").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getempList ends");
		return dept;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getrefNoList() {
		logger.info("Method : getrefNoList starts");
		
		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getrefNoList").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getrefNoList ends");
		return dept;
	}

	/*
	 * DropDown for getReportCategoryList
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReportCtgList() {
		logger.info("Method : getAuditReportType starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getReportCtgList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditReportType ends");
		return dept;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRefListByAudiType(String id) {

		logger.info("Method : getRefListByAudiType starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_audit='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getAuditRefList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

			resp.setBody(dept);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getRefListByAudiType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addNewAuditReport(List<RestAuditDraftReportModel> audit) {
		logger.info("Method : addNewAuditReport starts");

		Boolean validity = true;
	
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		resp.setMessage("");
		resp.setCode("");
		
		if (validity) {
			try {
				for (RestAuditDraftReportModel l : audit) {
					String values = GenerateAuditDraftReportParameter.addAuditReportParam(l);
					em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
							.setParameter("actionType", "addAuditReport").setParameter("actionValue", values).execute();
					
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
		resp.setCode("Data Saved Successfully");
			
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		

		logger.info("Method : addNewAuditReport ends");
		return response;
	}
	
	/*
	 * for all concession details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>> getdraftDetails(DataTableRequest request) {

		logger.info("Method in Dao: getdraftDetails starts");

		List<RestAuditDraftReportModel> draftList = new ArrayList<RestAuditDraftReportModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "viewauditdraftList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if(m[2]!=null) {
					date = DateFormatter.returnStringDate(m[2]);
					}
					
					RestAuditDraftReportModel concession = new RestAuditDraftReportModel(m[0], m[1], null,date,m[4],m[5],null, null, 
							null, null, null, null, null, null, null, null, null, null, null, null, null,null, null,null,null,null,null,null, null);
					draftList.add(concession);

				}

				if (x.get(0).length >6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestAuditDraftReportModel>> resp = new JsonResponse<List<RestAuditDraftReportModel>>();
		resp.setBody(draftList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>> response = new ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getdraftDetails ends");
		

		return response;
	}
	
	/*
	 * for draft details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestAuditDraftReportModel>>detailsReportById(String id) {

		logger.info("Method in Dao: detailsReportById ends");

		List<RestAuditDraftReportModel> draftDtls = new ArrayList<RestAuditDraftReportModel>();
		List<RestAuditReportAdditionalInfoModel> additionalInfo = null;
		try {
			String value = "SET @P_draftId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "viewReportDetails").setParameter("actionValue", value).getResultList();
			
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if(m[3]!=null) {
					date = DateFormatter.returnStringDate(m[3]);
					}
					Object date1 = null;
					if(m[10]!=null) {
						date1 = DateFormatter.returnStringDate(m[10]);
					}
					
					RestAuditDraftReportModel concession = new RestAuditDraftReportModel(m[0], m[1], m[2],date,m[4],m[5], null,m[6], m[7], m[8], m[9], date1,
							m[11], m[12], null, null, null, null, null, null, null,null, null,null,null, null, null, null, null);
					try {
						List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
								.setParameter("actionType", "additionalInfoDtls").setParameter("actionValue", value).getResultList();
					
						if(x1.isEmpty()) {
							RestAuditReportAdditionalInfoModel addiInfo = new RestAuditReportAdditionalInfoModel();
							 
						}
						
					}catch(Exception ex) {
						
					}
					concession.setAdditionalInfo(additionalInfo);
					draftDtls.add(concession);
					 

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<RestAuditDraftReportModel> resp = new JsonResponse<RestAuditDraftReportModel>();
		resp.setBody(draftDtls.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestAuditDraftReportModel>> response = new ResponseEntity<JsonResponse<RestAuditDraftReportModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: detailsReportById ends");
		
		return response;
	}
	

	
	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings({ "unchecked"})
	public ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>> getdraftReportById(String id) {

		logger.info("Method : getdraftReportById starts");

		List<RestAuditDraftReportModel> draftDtls = new ArrayList<RestAuditDraftReportModel>();
		JsonResponse<List<RestAuditDraftReportModel>> resp = new JsonResponse<List<RestAuditDraftReportModel>>();
		List<RestAuditReportAdditionalInfoModel> additionalInfo = new ArrayList<RestAuditReportAdditionalInfoModel>();
		List<RestAuditReportBasicsQualifyModel> basicsInfo = new ArrayList<RestAuditReportBasicsQualifyModel>();

		try {

			String value = "SET @P_initId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "viewReportDetails").setParameter("actionValue", value).getResultList();
			RestAuditDraftReportModel concession = new RestAuditDraftReportModel();
			for (Object[] m : x) {
				Object date = null;
				if(m[3]!=null) {
				date = DateFormatter.returnStringDate(m[3]);
				}
				Object date1 = null;
				if(m[10]!=null) {
					date1 = DateFormatter.returnStringDate(m[10]);
				}
				
				List<String> to = new ArrayList<String>();
				if(m[14]!=null) {
				String[] data = m[14].toString().split(",");
				for (String p : data) {
					to.add(p);
				}
				}
				
				List<String> cc = new ArrayList<String>();
				String[] data1=null;
				if(m[15]!=null) {
					data1 = m[15].toString().split(",");
				}
				if(data1!=null) {
				for (String c : data1) {
					cc.add(c);
				}
				}
				
				concession = new RestAuditDraftReportModel(m[0], m[1], m[2],date,m[4],m[5],m[6],m[7], m[8], m[9],
						date1, m[11], m[12], m[13], null, null, null, null, null, null, null,null, null,to,cc,null,null,null, null);
				
				draftDtls.add(concession);

			}
			try {
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
						.setParameter("actionType", "addiDetails").setParameter("actionValue", value).getResultList();
				if(!x1.isEmpty()) {
					for (Object[] m1 : x1) {
						RestAuditReportAdditionalInfoModel addiInfo = new RestAuditReportAdditionalInfoModel(m1[0], m1[1], m1[2],null);
						additionalInfo.add(addiInfo);
					}
				}
				List<Object[]> x2 = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
						.setParameter("actionType", "basicsDetails").setParameter("actionValue", value).getResultList();
				
				if(!x2.isEmpty()) {
					for (Object[] m2 : x2) {
					RestAuditReportBasicsQualifyModel basInfo = new RestAuditReportBasicsQualifyModel(m2[0],m2[1],m2[2]);
					basicsInfo.add(basInfo);
					}
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			if(additionalInfo.size()>0) {
			draftDtls.get(0).setAdditionalInfo(additionalInfo);
			}
			if(basicsInfo.size()>0) {
			draftDtls.get(0).setBasicOfQualify(basicsInfo);
			}
			resp.setBody(draftDtls);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>> response = new ResponseEntity<JsonResponse<List<RestAuditDraftReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getdraftReportById ends");
		return response;
	}
	
	/*
	 * for get send Response to Requisition
	 */
	//###################### NOTE ###########
	public ResponseEntity<JsonResponse<Object>> sendDetails(List<RestAuditDraftReportModel> obj) {
		logger.info("Method in Dao: sendDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Boolean validity = true;
		/*
		 * if (obj.get(0).getComment() == null || obj.get(0).getComment()== "") {
		 * resp.setMessage("Comment Required"); validity = false; }
		 */
		if (validity)
				try {
					String value = GenerateAuditDraftDetailsParameter.addDocument(obj);
					em.createNamedStoredProcedureQuery("auditDraftReportRoutines").setParameter("actionType", "sendDetails")
							.setParameter("actionValue", value).execute();
				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
				
			
		resp.setCode("Data Saved Successfully");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method in Dao: sendDetails ends");

		return response;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public  List<RestAuditDraftReportModel> getdraftCommentById(String id) {
		logger.info("Method in Dao: getdraftCommentById start");
		
		List<RestAuditDraftReportModel> comments = new ArrayList<RestAuditDraftReportModel>(); 
		String value = "set @p_draftId='"+id+"';";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines").setParameter("actionType", "getComments")
			.setParameter("actionValue", value).getResultList();
			
			List<RestAuditReportAdditionalInfoModel> files = new ArrayList<RestAuditReportAdditionalInfoModel>();
			try {
				List<Object[]> docs = em.createNamedStoredProcedureQuery("auditDraftReportRoutines").setParameter("actionType", "getCommentDocs")
						.setParameter("actionValue", value).getResultList();
				for(Object[] s:docs) {
					RestAuditReportAdditionalInfoModel d = new RestAuditReportAdditionalInfoModel(s[2],s[1],null,s[0]);
					files.add(d);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			for(Object[] m: x) {
				String DateString = "";
				if(m[1]!=null) {
					DateFormatter format = new DateFormatter();
					DateString = (String) format.returnStringDateTime(m[1]);
				}
				List<RestAuditReportAdditionalInfoModel> flist = new ArrayList<RestAuditReportAdditionalInfoModel>();
				for(RestAuditReportAdditionalInfoModel fl: files) {
					if(fl.getCommentId() == m[6]) {
						flist.add(fl);
					}
				}
				
				RestAuditDraftReportModel c = new RestAuditDraftReportModel(m[0],null,null,DateString,null,null,null,m[2],null,null,null,null,null,null,null,
						null,null,null,null,null,flist,null,null,null,null,m[3],m[4],m[5],m[6]);
				comments.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getdraftCommentById ends");
		return comments;
	}
	/*
	 * for edit audit draft report new
	 */
	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<AuditDraftReportModelNew>> getdraftReporteditByIdNew(String id) {

		logger.info("Method : getdraftReporteditByIdNew starts");

		List<AuditDraftReportModelNew> draftDtls = new ArrayList<AuditDraftReportModelNew>();
		JsonResponse<AuditDraftReportModelNew> resp = new JsonResponse<AuditDraftReportModelNew>();
		List<RestAuditReportAdditionalInfoModel> additionalInfo = new ArrayList<RestAuditReportAdditionalInfoModel>();
		List<AuditAttachmentNewModel> attachmentList = new ArrayList<AuditAttachmentNewModel>();
		List<RestAuditReportBasicsQualifyModel> basicsInfo = new ArrayList<RestAuditReportBasicsQualifyModel>();

		try {

			String value = "SET @P_draftId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getAuditReportById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[3] != null) {
					date = DateFormatter.returnStringDate(m[3]);
				}

				List<String> to = new ArrayList<String>();
				String[] data = m[8].toString().split(",");
				for (String p : data) {
					to.add(p);
				}

				List<String> cc = new ArrayList<String>();
				String[] data1 = m[9].toString().split(",");
				for (String c : data1) {
					cc.add(c);
				}

				AuditDraftReportModelNew concession = new AuditDraftReportModelNew(m[0], m[1], m[2], date, m[4], m[5],
						m[6], m[7]);

				try {
					List<Object[]> x3 = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
							.setParameter("actionType", "attachmentDetails").setParameter("actionValue", value)
							.getResultList();
					if (!x3.isEmpty()) {

						for (Object[] m3 : x3) {
							Object date1 = null;
							if (m3[2] != null) {
								date1 = DateFormatter.returnStringDate(m3[2]);
							}
							AuditAttachmentNewModel addiInfo = new AuditAttachmentNewModel(m3[0], m3[1], date1, m3[3],
									m3[4], m3[5]);
							attachmentList.add(addiInfo);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
							.setParameter("actionType", "addiDetails").setParameter("actionValue", value)
							.getResultList();
					if (!x1.isEmpty()) {
						for (Object[] m1 : x1) {
							RestAuditReportAdditionalInfoModel addiInfo = new RestAuditReportAdditionalInfoModel(m1[0],
									m1[1], m1[2], null);
							additionalInfo.add(addiInfo);
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				try {
					List<Object[]> x2 = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
							.setParameter("actionType", "basicsDetails").setParameter("actionValue", value)
							.getResultList();

					if (!x2.isEmpty()) {
						for (Object[] m2 : x2) {
							RestAuditReportBasicsQualifyModel basInfo = new RestAuditReportBasicsQualifyModel(m2[0],
									m2[1], m2[2]);
							basicsInfo.add(basInfo);
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				concession.setPersonCC(cc);
				concession.setPersonTo(to);
				concession.setAuditAttachmentNewModelList(attachmentList);
				concession.setBasicOfQualifyList(basicsInfo);
				concession.setAdditionalInfoList(additionalInfo);
				draftDtls.add(concession);

			}

			resp.setBody(draftDtls.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AuditDraftReportModelNew>> response = new ResponseEntity<JsonResponse<AuditDraftReportModelNew>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getdraftReporteditByIdNew ends");

		return response;
	}
	/*
	 * DropDown for Audit Initiated  id AuditReportType
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditInitiatedIdByAuditType(String id) {
		logger.info("Method : getAuditInitiatedIdByAuditType starts");

		List<DropDownModel> auditList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_audit='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getAuditRefList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAuditInitiatedIdByAuditType ends");
		return auditList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getccAndToempList() {
		logger.info("Method : getccAndToempList starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDraftReportRoutines")
					.setParameter("actionType", "getccAndToempList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getccAndToempList ends");
		return dept;
	}

}
