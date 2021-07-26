package nirmalya.aatithya.restmodule.audit.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.audit.model.AuditDashboardModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditNotificationModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AuditDashboardDao {
	Logger logger = LoggerFactory.getLogger(AuditDashboardDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardData(String userId) {

		logger.info("Method : getDashboardData starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "'";
		
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDashboardData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(m[0], m[1], m[2], null, null,null,null,null  ,null,null,null,null,null,null,null,null,null,null,null,null,null, null, null, null, null);
				dashboardList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardData ends");

		return dashboardList;
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardTransCoordinator(String userId,String financialYear) {

		logger.info("Method : getDashboardTransCoordinator starts");

		List<AuditDashboardModel> dashboardTransList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "',@p_financialYear='" + financialYear + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDashboardTransCrd").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(null,m[0].toString(), null, null, null, null,m[1].toString(),m[2].toString(),null,null,null,null,null,null,null,null,null,null, null, null, null, null, null, null, null);
					dashboardTransList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardTransCoordinator ends");
		return dashboardTransList;
	}

	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardCoordinator(String userId,String financialYear) {

		logger.info("Method : getDashboardCoordinator starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "',@p_financialYear='" + financialYear + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDashboardCrd").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				AuditDashboardModel dashboard = new AuditDashboardModel(null,m[0].toString(), null, null, null, null,m[1].toString(),m[2].toString(),null,null,null,null,null,null,null,null,null,null, null, null, null, null, null, null, null);
				dashboardList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardCoordinator ends");
		return dashboardList;
	}
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardMonthlyData(String userId) {

		logger.info("Method : getDashboardMonthlyData starts");

		List<AuditDashboardModel> dashboardMonthlyList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "'";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDashboardMonthly").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(null, null, null, null, null,null,null,null,null,null,null,null,null,m[0].toString(),m[1].toString(),null,null,null,null,null,null, null, null, null, null);
				dashboardMonthlyList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardCoordinator ends");

		return dashboardMonthlyList;
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardAuditor(String userId) {

		logger.info("Method : getDashboardAuditor starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {

			String value = "SET @p_userId = '" + userId + "'";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDashboardAuditor").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(m[0], m[1], m[2], m[3], m[4],null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null, null, null, null, null);
				dashboardList.add(dashboard);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardAuditor ends");

		return dashboardList;
	}

	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardAuditee(String userId,String financialYear) {

		logger.info("Method : getDashboardAuditee starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId  + "',@p_financialYear='" + financialYear + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDashboardAuditee").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(m[0], m[1], m[2], m[3], m[4],null,null,null,null,null,null,null,null,null,null,m[5],m[6],m[7],m[8],null,null, null, null, null, null);
				dashboardList.add(dashboard);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardAuditee ends");

		return dashboardList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getYearList() {
		logger.info("Method : RESTMODULE getYearList  starts");

		List<DropDownModel> yearList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "yearList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				yearList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE getAuditorName  ends");
	
		return yearList;
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getAuditNoDash() {
		logger.info("Method : getAuditNoDash  starts");
		
		List<AuditDashboardModel> AuditNoDash = new ArrayList<AuditDashboardModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getAuditNoDash").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				// m[1] = Integer.valueOf(((BigInteger)m[1]).toString());
				 /*m[0] = Integer.valueOf(((BigInteger)m[0]).toString());
				
				 m[2] = Integer.valueOf(((BigInteger)m[2]).toString());
				 m[3] = Integer.valueOf(((BigInteger)m[3]).toString());*/
				AuditDashboardModel dropDownModel = new AuditDashboardModel(m[0].toString(), m[1].toString(), m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				AuditNoDash.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getAuditNoDash  ends");
		System.out.println("AuditNoDash"+AuditNoDash);
		return AuditNoDash;
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardBarFromPieCoordinator(String userId,String label,String financialYear,String auditType) {

		logger.info("Method : getDashboardBarFromPieCoordinator starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			if(auditType.equals("misc")) {
				String value = "SET @p_userId = '" + userId + "',@p_label='" + label + "',@p_financialYear='" + financialYear + "',@auditType='"+auditType+"';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
						.setParameter("actionType", "getMiscAuditData").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					AuditDashboardModel dashboard = new AuditDashboardModel(null, m[0], null, null, null,null,m[1],m[2],null,null,null,null,null,null,null,null,null,null,null,null,m[3], null, null, null, null);
					dashboard.setAuditId((String) m[4]);
					dashboard.setDepartment((String) m[5]);
					dashboard.setAuditType((String)m[6]);
					dashboardList.add(dashboard);
				}
			}else {
				String value = "SET @p_userId = '" + userId + "',@p_label='" + label + "',@p_financialYear='" + financialYear + "',@auditType='"+auditType+"';";
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
						.setParameter("actionType", "getDeptTransCrd").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					/*m[0] = Integer.valueOf(((BigInteger)m[0]).toString());
					m[1] = Integer.valueOf(((BigInteger)m[1]).toString());
					m[2] = Integer.valueOf(((BigInteger)m[2]).toString());*/
					AuditDashboardModel dashboard = new AuditDashboardModel(null, m[0].toString(), null, null, null,null,m[1].toString(),m[2].toString(),null,null,null,null,null,null,null,null,null,null,null,null,m[3].toString(), null, null, null, null);
					dashboard.setAuditId((String) m[4]);
					dashboard.setDepartment((String) m[5]);
					dashboard.setAuditType((String)m[6]);
					dashboardList.add(dashboard);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardBarFromPieCoordinator ends");
		return dashboardList;
	}
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardBarFromPieTransCoordinator(String userId,String label,String financialYear,String auditType) {

		logger.info("Method : getDashboardBarFromPieTransCoordinator starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "',@p_label='" + label + "',@p_financialYear='" + financialYear + "',@p_auditType='"+auditType+"';";
	
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDcPieToTraBar").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,m[0],m[1], null, null, null, null);
				dashboardList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDashboardBarFromPieTransCoordinator ends");
		
		return dashboardList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardBarFromBarCoordinator(String userId,String label,String financialYear) {

		logger.info("Method : getDashboardBarFromBarCoordinator starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "',@p_label='" + label + "',@p_financialYear='" + financialYear + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDscBarToBar").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,m[0],m[1], null, null, null, null);
				dashboardList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardBarFromBarCoordinator ends");
		
		return dashboardList;
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardAuditeeBarFromPieCoordinator(String userId,String label,String financialYear) {

		logger.info("Method : getDashboardAuditeeBarFromPieCoordinator starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "',@p_label='" + label + "',@p_financialYear='" + financialYear + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDsbSecHPieToBar").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,m[0],m[1], null, null, null, null);
				dashboardList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardAuditeeBarFromPieCoordinator ends");
		
		return dashboardList;
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardTransAuditee(String userId,String financialYear) {

		logger.info("Method : getDashboardTransAuditee starts");

		List<AuditDashboardModel> dashboardTransList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "',@p_financialYear='" + financialYear + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getDsbTransAuditee").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(m[0], m[1], m[2], m[3], m[4],null,null,null,null,null,null,null,null,null,null,m[5],m[6],m[7],m[8],null,null, null, null, null, null);
				dashboardTransList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardTransAuditee ends");
		
		return dashboardTransList;
	}
	@SuppressWarnings("unchecked")
	public List<AuditDashboardModel> getDashboardAuditeeTransBarFromPieCoordinator(String userId,String label,String financialYear) {

		logger.info("Method : getDashboardAuditeeTransBarFromPieCoordinator starts");

		List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

		try {
			String value = "SET @p_userId = '" + userId + "',@p_label='" + label + "',@p_financialYear='" + financialYear + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getTransSecHPieToBar").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,m[0],m[1], null, null, null, null);
				dashboardList.add(dashboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDashboardAuditeeBarFromPieCoordinator ends");
		
		return dashboardList;
	}
	@SuppressWarnings({ "unchecked", "unused" })
	public List<DropDownModel> getTodaysCaseCount(@RequestParam String userId) {
		logger.info("Method : RESTMODULE getTodaysCase  starts");
		String value = "SET @p_userId = '" + userId + "';";
		List<DropDownModel> res = new ArrayList<DropDownModel>();

		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getTodaysCase").setParameter("actionValue", value)
					.getResultList();
			for(Object[] m:x) {
				//BigInteger i = (BigInteger) m[0];
				DropDownModel dp = new DropDownModel(m[0].toString(),m[1]);
				res.add(dp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE getTodaysCase  ends");
		return res;
	}
public JsonResponse<Integer> getPendingCaseCount() {
		
		logger.info("Method : RESTMODULE getPendingCaseCount  ends");

		JsonResponse<Integer> res = new JsonResponse<Integer>();

		try {
			
			@SuppressWarnings("unchecked")
			List<Object> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getPendingCaseCount").setParameter("actionValue", "")
					.getResultList();
			for(Object m:x) {
				res.setBody(Integer.parseInt(m.toString()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : RESTMODULE getPendingCaseCount  ends");
	
		return res;
	
	}
public List<AuditDashboardModel> getSuplAuditDashData(String userId,String financialYear) {

	logger.info("Method : getSuplAuditDashData starts");

	List<AuditDashboardModel> dashboardTransList = new ArrayList<AuditDashboardModel>();

	try {
		String value = "SET @p_userId = '" + userId + "',@p_financialYear='" + financialYear + "';";
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType", "getSuplAuditDashData").setParameter("actionValue", value).getResultList();

		for (Object[] m : x) {
			AuditDashboardModel dashboard = new AuditDashboardModel(null,m[0].toString(), null, null, null, null,m[1].toString(),m[2].toString(),null,null,null,null,null,null,null,null,null,null, null, null, null, null, null, null, null);
			dashboardTransList.add(dashboard);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	logger.info("Method : getSuplAuditDashData ends");
	return dashboardTransList;
}

public List<DropDownModel> getMonthlyInitData(String financialYear) {
	
	logger.info("Method : getMonthlyInitData ends");
	
	List<DropDownModel> result = new ArrayList<DropDownModel>();

	try {
		String value = "SET @p_financialYear='" + financialYear + "';";
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType", "getInitData").setParameter("actionValue", value).getResultList();

		for (Object[] m : x) {
			BigInteger i = (BigInteger)m[1];
			String val = i.toString();
			DropDownModel data = new DropDownModel(i.toString(), val);
			result.add(data);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
	logger.info("Method : getMonthlyInitData ends");
	return result;
}

public List<DropDownModel> getMonthlyClosedData(String financialYear) {
	logger.info("Method : getMonthlyClosedData ends");
	
	List<DropDownModel> result = new ArrayList<DropDownModel>();
	try {
		String value = "SET @p_financialYear='" + financialYear + "';";
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType", "getMonthlyClosedData").setParameter("actionValue", value).getResultList();

		for (Object[] m : x) {
			/*BigInteger i = (BigInteger)m[1];
			String val = i.toString();*/
			DropDownModel data = new DropDownModel(m[0].toString(), m[1]);
			result.add(data);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	logger.info("Method : getMonthlyClosedData ends");
	return null;
}
@SuppressWarnings({ "unchecked" })
public List<DropDownModel> getTodaysCaseById(String id) {
	logger.info("Method : RESTMODULE getTodaysCase  starts");

	List<DropDownModel> res = new ArrayList<DropDownModel>();
	String value = "SET @p_id='" + id + "';";
	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType", "todayCaseById").setParameter("actionValue",value)
				.getResultList();
		for(Object[] m:x) {
			
			DropDownModel dp = new DropDownModel(m[0].toString(),m[1]);
			res.add(dp);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	logger.info("Method : RESTMODULE getTodaysCase  ends");
	return res;
}

public JsonResponse<Integer> getPendingCaseById(String id) {
	logger.info("Method : RESTMODULE getPendingCaseCount  ends");
	JsonResponse<Integer> res = new JsonResponse<Integer>();
	String value = "SET @p_id='" + id + "';";
	try {
		
		@SuppressWarnings("unchecked")
		List<Object> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType", "pendingCaseById").setParameter("actionValue", value)
				.getResultList();
		for(Object m:x) {
			res.setBody(Integer.parseInt(m.toString()));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	logger.info("Method : RESTMODULE getPendingCaseCount  ends");
	return res;

}
public List<DropDownModel> getAuditTypes(){
	
	List<DropDownModel> result = new ArrayList<DropDownModel>();
	
	try {
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType","getAuditTypes").setParameter("actionValue","").getResultList();
		for(Object[] m : x) {
			DropDownModel dm = new DropDownModel(m[0].toString(),m[1].toString());
			result.add(dm);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return result;
}
public List<DropDownModel> getAuditTypeCagPie(){
	
	List<DropDownModel> result = new ArrayList<DropDownModel>();
	
	try {
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType","auditTypeCagPie").setParameter("actionValue","").getResultList();
		for(Object[] m : x) {
			DropDownModel dm = new DropDownModel(m[0].toString(),m[1].toString());
			result.add(dm);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return result;
}

@SuppressWarnings("unchecked")
public List<DropDownModel> getRepliedData(String financialYear) {
	
	List<DropDownModel> result = new ArrayList<DropDownModel>();
	
	try {
		String value = "SET @finYear = '"+financialYear+"';";
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType","getRepliedData").setParameter("actionValue",value).getResultList();
		for(Object[] m : x) {
			DropDownModel dm = new DropDownModel(m[0].toString(),m[1].toString());
			result.add(dm);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return result;
}
public List<DropDownModel> getPendingData(String financialYear) {
	List<DropDownModel> result = new ArrayList<DropDownModel>();
	
	try {
		String value = "SET @finYear = '"+financialYear+"';";
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType","getPendingData").setParameter("actionValue",value).getResultList();
		for(Object[] m : x) {
			DropDownModel dm = new DropDownModel(m[0].toString(),m[1].toString());
			result.add(dm);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return result;
}
/*
 * get pie data
 */

public List<AuditDashboardModel> getPieData(String financialYear,String type,String auditType,String userId, String auditor) {
	logger.info("Method : RESTMODULE:DAO getPieData  starts");
	List<AuditDashboardModel> result = new ArrayList<AuditDashboardModel>();
	
	try {
		String value = "SET @financialYear = '"+financialYear+"',@p_type='"+type+"',@p_auditType='"+auditType+"',@p_auditor='"+auditor+"',@p_userId='"+userId+"';";
		System.out.println("value "+value);
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType","getPieData").setParameter("actionValue",value).getResultList();
		if(!x.isEmpty()) {
			for(Object[] m : x ) {
				
//			if(m[3] != null) {
//				BigInteger d = (BigInteger) m[3];
//				int i = d.intValue();
//				m[3] = i;
//			}
				
			AuditDashboardModel dm = new AuditDashboardModel(m[0], null, null, m[1].toString(), m[3].toString(),null,null,null,null,null,
					null,null,null,null,null, m[2].toString(), null, null, null, null, null, null, null, null, null);
			//dm.setReplied(m[2].toString());
			result.add(dm);
		
	}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("@@@"+result);
	logger.info("Method : RESTMODULE:DAO getPieData  ends");
	return result;
}
/*
 * getPieToBarData
 */

public List<AuditDashboardModel> getPieToBarData(String financialYear,String type,String label) {
	logger.info("Method : RESTMODULE:DAO getPieToBarData  starts");
	List<AuditDashboardModel> result = new ArrayList<AuditDashboardModel>();
	
	try {
		String value = "SET @financialYear = '"+financialYear+"',@p_type='"+type+"',@p_label='"+label+"';";
		System.out.println(value);
		@SuppressWarnings("unchecked")
		List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
				.setParameter("actionType","getPieToBarData").setParameter("actionValue",value).getResultList();
		for(Object[] m : x ) {
			AuditDashboardModel dm = new AuditDashboardModel(null, null, null, m[1].toString(), m[3].toString(),null,null,null,null,null,
					null,null,null,null,null,m[2].toString(), null, null, null, null, null, null, null, null, null);
			dm.setAuditType((String) m[0]);
			dm.setReplied(m[2].toString());
			result.add(dm);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("@@@"+result);
	logger.info("Method : RESTMODULE:DAO getPieToBarData  ends");
	return result;
}
@SuppressWarnings("unchecked")
public List<AuditDashboardModel> getTableData(String userId,String label,String financialYear,String auditType) {

	logger.info("Method : getTableData starts");

	List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();

	try {
			String value = "SET @p_userId = '" + userId + "',@p_label='" + label + "',@financialYear='" + financialYear + "',@auditType='"+auditType+"';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
					.setParameter("actionType", "getTableData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AuditDashboardModel dashboard = new AuditDashboardModel(m[0], null, null, m[5].toString(), m[7].toString(),null,null,null,null,null,
						null,null,null,null,null,m[5].toString(), null, null, null, null, m[4].toString(), null, null, null, null);					
				dashboard.setAuditId((String) m[1]);
				dashboard.setDepartment((String) m[2]);
				dashboard.setAuditType((String)m[3]);
				dashboard.setReplied(m[6].toString());
				dashboardList.add(dashboard);
			}

	} catch (Exception e) {
		e.printStackTrace();
	}

	logger.info("Method : getTableData ends");
	System.out.println(dashboardList);
	return dashboardList;
}
@SuppressWarnings("unchecked")
public List<AuditDashboardModel> getModalData(String financialYear, String type, String status, String auditId,
		String section, String department,String label,String userId) {
	logger.info("Method : getModalData starts");
	
	List<AuditDashboardModel> dashboardList = new ArrayList<AuditDashboardModel>();
	
	try {
			String value = "SET @auditId = '" + auditId + "',@p_status='" + status + "',@financialYear='" + financialYear + "',@p_section='"+section+"',@p_department='"+department+"',@p_label='"+label+"',@p_userId='"+userId+"';";
			System.out.println(value);
			if(label.equals("REQ")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
						.setParameter("actionType", "getModalDataReq").setParameter("actionValue", value).getResultList();
				if(!x.isEmpty()) {
				for (Object[] m : x) {
					AuditDashboardModel dashboard = new AuditDashboardModel();					
					dashboard.setAuditId((String) m[0]);
					System.out.println("audit"+dashboard.getAuditId());
					dashboard.setReqNo(((BigInteger)m[1]).toString());
					System.out.println("req"+dashboard.getReqNo());
					if(m[2]!=null) {
					dashboard.setRaisedBy(m[2].toString());
					}
					if(m[3]!=null) {
					dashboard.setDate((String)DateFormatter.returnStringDate(m[3]));
					}
					if(m[4]!=null) {
					dashboard.setRaisedTo(m[4].toString());
					}
					dashboardList.add(dashboard);
				}
				}
			}
			if(label.equals("OBS")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
						.setParameter("actionType", "getModalDataObs").setParameter("actionValue", value).getResultList();
				if(!x.isEmpty()) {
				for (Object[] m : x) {
					AuditDashboardModel dashboard = new AuditDashboardModel();					
					dashboard.setAuditId((String) m[0]);
					System.out.println(dashboard.getAuditId());
					dashboard.setReqNo(m[1].toString());
					System.out.println(dashboard.getReqNo());
					dashboard.setRaisedBy((String)m[2]);
					dashboard.setDate((String)DateFormatter.returnStringDate(m[3]));
					dashboard.setRaisedTo((String)m[4]);
					dashboardList.add(dashboard);
				}
			}
			}
			if(label.equals("POM")) {
				System.out.println("sdsxfcgvhbj");
				List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
						.setParameter("actionType", "getModalDPom").setParameter("actionValue", value).getResultList();
				if(!x.isEmpty()) {
				for (Object[] m : x) {
					AuditDashboardModel dashboard = new AuditDashboardModel();					
					dashboard.setAuditId((String) m[0]);
					dashboard.setReqNo(m[1].toString());
					dashboard.setRaisedBy((String)m[2]);
					dashboard.setDate((String)DateFormatter.returnStringDate(m[3]));
					dashboard.setRaisedTo((String)m[4]);
					dashboardList.add(dashboard);
					System.out.println("esrdfghb"+dashboard.getReqNo());
				}
			}
			}
			

	} catch (Exception e) {
		e.printStackTrace();
	}

	logger.info("Method : getModalData ends");
	System.out.println(dashboardList);
	return dashboardList;
}


}
