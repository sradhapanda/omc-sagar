package nirmalya.aatithya.restmodule.audit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.audit.dao.AuditDashboardDao;
import nirmalya.aatithya.restmodule.audit.model.AuditDashboardModel;
import nirmalya.aatithya.restmodule.audit.model.AuditDetailModel;
import nirmalya.aatithya.restmodule.audit.model.RestAuditNotificationModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
@RestController
@RequestMapping("audit/")
public class AuditDashboardRestController {
	Logger logger = LoggerFactory.getLogger(AuditDashboardRestController.class);
	
	@Autowired
	AuditDashboardDao auditDashboardDao;
/**
 * 
 * @param userId
 * @return
 */
	@RequestMapping(value = "getDashboardData", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardData( @RequestParam String userId) {

		logger.info("Method : getDashboardData starts");
		logger.info("Method : getDashboardData ends");

		return auditDashboardDao.getDashboardData(userId);
	}
	
	@RequestMapping(value = "getDashboardCoordinator", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardCoordinator( @RequestParam String userId,@RequestParam String financialYear) {

		logger.info("Method : getDashboardCoordinator starts");
		logger.info("Method : getDashboardCoordinator ends"); 

		return auditDashboardDao.getDashboardCoordinator(userId,financialYear);
	}
	
	@RequestMapping(value = "getDashboardTransCoordinator", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardTransCoordinator( @RequestParam String userId,@RequestParam String financialYear) {

		logger.info("Method : getDashboardTransCoordinator starts");
		logger.info("Method : getDashboardTransCoordinator ends"); 

		return auditDashboardDao.getDashboardTransCoordinator(userId,financialYear);
	}
	@RequestMapping(value = "getDashboardMonthlyData", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardMonthlyData( @RequestParam String userId) {

		logger.info("Method : getDashboardMonthlyData starts");
		logger.info("Method : getDashboardMonthlyData ends"); 

		return auditDashboardDao.getDashboardMonthlyData(userId);
	}
	
	@RequestMapping(value = "getDashboardAuditor", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardAuditor( @RequestParam String userId) {

		logger.info("Method : getDashboardAuditor starts");
		logger.info("Method : getDashboardAuditor ends"); 

		return auditDashboardDao.getDashboardAuditor(userId);
	}
	
	@RequestMapping(value = "getDashboardAuditee", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardAuditee( @RequestParam String userId,@RequestParam String financialYear) {

		logger.info("Method : getDashboardAuditee starts");
		logger.info("Method : getDashboardAuditee ends"); 

		return auditDashboardDao.getDashboardAuditee(userId,financialYear);
	}
	
	
	@RequestMapping(value = "getYearList", method = { RequestMethod.GET })
	public List<DropDownModel> getYearList() {
		logger.info("Method : getYearList starts");
		logger.info("Method : getYearList ends");
		return auditDashboardDao.getYearList();
	}
	@RequestMapping(value = "getAuditNoDash", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getAuditNoDash() {
		logger.info("Method : getAuditNoDash starts");
		logger.info("Method : getAuditNoDash ends");
		return auditDashboardDao.getAuditNoDash();
	}
	
	
	@RequestMapping(value = "getDashboardBarFromPieCoordinator", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardBarFromPieCoordinator( @RequestParam String userId,@RequestParam String label,
			@RequestParam String financialYear,@RequestParam String auditType) {

		logger.info("Method : getDashboardBarFromPieCoordinator starts");
		logger.info("Method : getDashboardBarFromPieCoordinator ends"); 
		

		return auditDashboardDao.getDashboardBarFromPieCoordinator(userId,label,financialYear,auditType);
	}
	@RequestMapping(value = "getDashboardBarFromPieTransCoordinator", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardBarFromPieTransCoordinator( @RequestParam String userId,@RequestParam String label,
			@RequestParam String financialYear,@RequestParam String type) {

		logger.info("Method : getDashboardBarFromPieTransCoordinator starts");
		logger.info("Method : getDashboardBarFromPieTransCoordinator ends"); 

		return auditDashboardDao.getDashboardBarFromPieTransCoordinator(userId,label,financialYear,type);
	}
	@RequestMapping(value = "getDashboardBarFromBarCoordinator", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardBarFromBarCoordinator( @RequestParam String userId,@RequestParam String label,@RequestParam String financialYear) {

		logger.info("Method : getDashboardBarFromBarCoordinator starts");
		logger.info("Method : getDashboardBarFromBarCoordinator ends"); 
		

		return auditDashboardDao.getDashboardBarFromBarCoordinator(userId,label,financialYear);
	}
	
	
	@RequestMapping(value = "getDashboardAuditeeBarFromPieCoordinator", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardAuditeeBarFromPieCoordinator( @RequestParam String userId,@RequestParam String label,@RequestParam String financialYear) {

		logger.info("Method : getDashboardAuditeeBarFromPieCoordinator starts");
		logger.info("Method : getDashboardAuditeeBarFromPieCoordinator ends"); 
		

		return auditDashboardDao.getDashboardAuditeeBarFromPieCoordinator(userId,label,financialYear);
	}
	
	@RequestMapping(value = "getDashboardTransAuditee", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardTransAuditee( @RequestParam String userId,@RequestParam String financialYear) {

		logger.info("Method : getDashboardTransAuditee starts");
		logger.info("Method : getDashboardTransAuditee ends"); 

		return auditDashboardDao.getDashboardTransAuditee(userId,financialYear);
	}
	
	@RequestMapping(value = "getDashboardAuditeeTransBarFromPieCoordinator", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getDashboardAuditeeTransBarFromPieCoordinator( @RequestParam String userId,@RequestParam String label,@RequestParam String financialYear) {

		logger.info("Method : getDashboardAuditeeTransBarFromPieCoordinator starts");
		logger.info("Method : getDashboardAuditeeTransBarFromPieCoordinator ends"); 
		

		return auditDashboardDao.getDashboardAuditeeTransBarFromPieCoordinator(userId,label,financialYear);
	}
	@RequestMapping(value = "getTodaysCase", method = { RequestMethod.GET })
	public List<DropDownModel> getTodaysCaseCount(@RequestParam("id") String userid ) {

		logger.info("Method : getTodaysCase-count starts");
		logger.info("Method : getTodaysCase-count ends"); 

		return auditDashboardDao.getTodaysCaseCount(userid);
	}
	@RequestMapping(value = "getPendingCase", method = { RequestMethod.GET })
	public JsonResponse<Integer> getPendingCase( ) {

		logger.info("Method : getTodagetPendingCaseysCase-count starts");
		logger.info("Method : getPendingCase-count ends"); 

		return auditDashboardDao.getPendingCaseCount();
	}
	@RequestMapping(value = "getSuplAuditDashData", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getSuplAuditDashData( @RequestParam String userId,@RequestParam String financialYear) {

		logger.info("Method : getSuplAuditDashData starts");
		logger.info("Method : getSuplAuditDashData ends"); 

		return auditDashboardDao.getSuplAuditDashData(userId,financialYear);
	}
	@RequestMapping(value = "getMonthlyInitData", method = { RequestMethod.GET })
	public List<DropDownModel> getMonthlyInitData(@RequestParam String financialYear) {

		logger.info("Method : getMonthlyInitData starts");
		logger.info("Method : getMonthlyInitData ends"); 

		return auditDashboardDao.getMonthlyInitData(financialYear);
	}
	@RequestMapping(value = "getMonthlyClosedData", method = { RequestMethod.GET })
	public List<DropDownModel> getMonthlyClosedData(@RequestParam String financialYear) {

		logger.info("Method : getMonthlyClosedData starts");
		logger.info("Method : getMonthlyClosedData ends"); 

		return auditDashboardDao.getMonthlyClosedData(financialYear);
	}
	@RequestMapping(value = "getTodaysCaseById", method = { RequestMethod.GET })
	public List<DropDownModel> getTodaysCaseById(@RequestParam("id") String id ) {

		logger.info("Method : getTodaysCaseById-count starts");
		logger.info("Method : getTodaysCaseById-count ends"); 

		return auditDashboardDao.getTodaysCaseById(id);
	}
	@RequestMapping(value = "getPendingCaseById", method = { RequestMethod.GET })
	public JsonResponse<Integer> getPendingCase(@RequestParam("id") String id ) {

		logger.info("Method : getPendingCaseById starts");
		logger.info("Method : getPendingCaseById ends"); 

		return auditDashboardDao.getPendingCaseById(id);
	}
	@RequestMapping(value = "getAuditTypes", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditTypes() {

		logger.info("Method : getAuditTypes starts");
		logger.info("Method : getAuditTypes ends"); 

		return auditDashboardDao.getAuditTypes();
	}
	
	@RequestMapping(value = "getAuditTypeCagPie", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditTypeCagPie() {
		
		logger.info("Method : getAuditTypeCagPie starts");
		logger.info("Method : getAuditTypeCagPie ends"); 
		
		return auditDashboardDao.getAuditTypeCagPie();
	}
	
	@RequestMapping(value = "getRepliedData", method = { RequestMethod.GET })
	public List<DropDownModel> getRepliedData(@RequestParam String financialYear) {

		logger.info("Method : getRepliedData starts");
		logger.info("Method : getRepliedData ends"); 

		return auditDashboardDao.getRepliedData(financialYear);
	}
	
	@RequestMapping(value = "getPendingData", method = { RequestMethod.GET })
	public List<DropDownModel> getPendingData(@RequestParam String financialYear) {

		logger.info("Method : getpendingData starts");
		logger.info("Method : getpendingData ends"); 

		return auditDashboardDao.getPendingData(financialYear);
	}
	@RequestMapping(value = "getPieData", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getPieData(@RequestParam String financialYear,@RequestParam String type,@RequestParam String auditType,@RequestParam String userId,
			@RequestParam String auditor) {

		logger.info("Method : getPieData starts");
		logger.info("Method : getPieData ends"); 

		return auditDashboardDao.getPieData(financialYear,type,auditType,userId,auditor);
	}
	
	@RequestMapping(value = "getPieToBarData", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getPieToBarData(@RequestParam String financialYear,@RequestParam String type,@RequestParam String label) {

		logger.info("Method : getPieToBarData starts");
		logger.info("Method : getPieToBarData ends"); 

		return auditDashboardDao.getPieToBarData(financialYear,type,label);
	}
	
	@RequestMapping(value = "getTableData", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getTableData( @RequestParam String userId,@RequestParam String label,@RequestParam String financialYear
			,@RequestParam String auditType) {

		logger.info("Method : getTableData starts");
		logger.info("Method : getTableData ends"); 
		

		return auditDashboardDao.getTableData(userId,label,financialYear,auditType);
	}
	
	@RequestMapping(value = "getModalData", method = { RequestMethod.GET })
	public List<AuditDashboardModel> getModalData(@RequestParam("financialYear") String financialYear ,@RequestParam("type") String type ,
			@RequestParam("status") String status ,@RequestParam("auditId") String auditId ,
			@RequestParam("section") String section ,@RequestParam("department") String department,@RequestParam("label") String label,@RequestParam("userId") String userId  ) {

		logger.info("Method : getModalData starts");
		logger.info("Method : getModalData ends"); 
		

		return auditDashboardDao.getModalData(financialYear,type,status,auditId,section,department,label,userId);
	}
	
	
	
}
