/**
 * Repository for user handling related call
**/
package nirmalya.aatithya.restmodule.user.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.audit.model.RestAuditNotificationModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.User;


/**
 * @author Nirmalya Labs
 *
 */
@Repository
@Component
public class UserLoginDao {
	
	Logger logger = LoggerFactory.getLogger(UserLoginDao.class);

	@Autowired
	EntityManager em;
	
	@Autowired
	ServerDao serverDao;
	
	
	/**
	 * function to return user by name 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<User>> getUserByUsername(String username) {
		logger.info("Method : getUserByUsername starts");
		
		JsonResponse<User> jsonResponse = new JsonResponse<User>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");
		
		List<User> userArray = new ArrayList<User>();
		List<String> userRole = new ArrayList<String>();
		
		try {
			
			String value = "SET @p_userName='"+username +"';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
				.setParameter("actionType", "getByName")
				.setParameter("actionValue", value)
				.getResultList();
			
			
			for(Object[] m :x) {
				String role = (String)m[6];
				System.out.println("user details "+Arrays.toString(m));
				
				if(role != null && role.length() >0 ){
					String[] roles = role.split(",");
					userRole = Arrays.asList(roles);
				}
				
				User user = new User(m[0],m[1],m[2],m[3],m[4],m[10],m[11],null,null,null,null,m[5],null,null,userRole,m[7],m[8],m[9],m[12],m[13]);
				userArray.add(user);
			}
			
			if(userArray.size() >0) {
				jsonResponse.setBody(userArray.get(0));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		if(jsonResponse.getBody()==null) {
			jsonResponse.setMessage("User Id Or Password Not Found");
			}
		
		ResponseEntity<JsonResponse<User>> response = new ResponseEntity<JsonResponse<User>>(jsonResponse,HttpStatus.OK);

		logger.info("Method : getUserByUsername ends");
		System.out.println(response);
		return response;
		
	}
	
	/**
	 * function to register user 
	 *
	 */
	public ResponseEntity<JsonResponse<String>> registerUser(User user) {
		logger.info("Method : registerUser starts");
		
		JsonResponse<String> jsonResponse = new JsonResponse<String>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");
		
		
		try {
			String value = GenerateUserParameter.getUserParam(user);
			
			em.createNamedStoredProcedureQuery("userRoutines")
				.setParameter("actionType", "getByName")
				.setParameter("actionValue", value)
				.execute();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				String[] err = serverDao.errorProcedureCall(e);
				
				jsonResponse.setCode(err[0]);
				jsonResponse.setMessage(err[1]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		
		ResponseEntity<JsonResponse<String>> response = new ResponseEntity<JsonResponse<String>>(jsonResponse,HttpStatus.OK);
		logger.info("Method : registerUser ends");
		
		return response;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getemail(String emailid) {
		logger.info("Method : getemail starts");
		
		String value = "SET @p_email='" + emailid + "';";
		
		//System.out.println("value "+value);
		
		List<DropDownModel> mail = new ArrayList<DropDownModel>();
		
		Object email = null;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
					.setParameter("actionType", "getmail").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				if (m[1].toString().contentEquals("success")) {
					//System.out.println("Valid Mail");
					
					//System.out.println(m[0].toString());
					
					if (m[1] != null) {
						email = (""+emailid);
					}
					DropDownModel dropDownModel1 = new DropDownModel(m[0], email);
					mail.add(dropDownModel1);
				}
				else
				{
					//System.out.println("Invalid Mail");
				}
				//mail.add(dropDownModel);
				//System.out.println(mail);
			}
			//String email
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getemail ends");
		return mail ;
	}
	
	public ResponseEntity<JsonResponse<Object>> forgetpassword(String email,String otp, String password ) {
		logger.info("Method : changePassword starts");
		
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
		
			String values = "SET @p_email='" + email + "', @p_otp='"+ otp +"', @p_pass='"+ password +"';";
			System.out.println("values "+values);
				
			em.createNamedStoredProcedureQuery("userRoutines")
				.setParameter("actionType", "forgetPassword")
				.setParameter("actionValue", values)
				.execute();
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
		logger.info("Method : changePassword ends");
		return response;
	}
	
	@Scheduled(cron = "0 */10 * * * *")
	public void deleteOtp() {
		logger.info("Method : deleteOtp starts");
		try {
			em.createNamedStoredProcedureQuery("userRoutines")
				.setParameter("actionType", "deleteOtp")
				.setParameter("actionValue", "")
				.execute();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		logger.info("Method : deleteOtp ends");
	}

	@SuppressWarnings("unchecked")
public JsonResponse<List<RestAuditNotificationModel>> getNotification(String id) {
	
	logger.info("Method : getNotification starts");
	
	JsonResponse<List<RestAuditNotificationModel>> res = new JsonResponse<List<RestAuditNotificationModel>>();
	List<RestAuditNotificationModel> notifyList = new ArrayList<RestAuditNotificationModel>();
	
	String value = "SET @p_roleId='" + id + "';";
	
	System.out.println("value123  "+value);
	
	List<Object[]> x = em.createNamedStoredProcedureQuery("auditDashboard")
			.setParameter("actionType", "getNotification").setParameter("actionValue", value).getResultList();
	
	for(Object[] m : x) {
		RestAuditNotificationModel notify = new RestAuditNotificationModel(m[0],m[1],m[2]);
		notifyList.add(notify);
	}
	
	res.setBody(notifyList);
	
	logger.info("Method : getNotification ends");
	
	return res;
}	
	
}
