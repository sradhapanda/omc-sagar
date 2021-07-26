package nirmalya.aatithya.restmodule.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.audit.model.RestAuditNotificationModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.dao.UserLoginDao;
import nirmalya.aatithya.restmodule.user.model.User;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value="user/")
public class UserLoginController {

	Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	UserLoginDao userLoginDao;
	
	
	/**
	 * Function to check connection
	 *
	 */
	@RequestMapping(value="welcome" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<String>> welcome() {
		logger.info("Method : welcome starts");
		
		JsonResponse<String> jsonResponse = new JsonResponse<String>();
		jsonResponse.setBody("Available");
		
		ResponseEntity<JsonResponse<String>> response = new ResponseEntity<JsonResponse<String>>(jsonResponse,HttpStatus.ACCEPTED);
		logger.info("Method : welcome ends");
		return response;
	}
	
	/**
	 * Function to get user by name
	 *
	 */
	@RequestMapping(value="getUserByUsername" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<User>> getUserByUsername(@RequestParam String username) {
		logger.info("Method : getUserByUsername starts");
		
		logger.info("Method : getUserByUsername ends");
		return userLoginDao.getUserByUsername(username);
	}
	
	/**
	 * Function to register user
	 *
	 */
	@RequestMapping(value="registerUser" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<String>> registerUser(@RequestBody User user) {
		logger.info("Method : registerUser starts");
		
		logger.info("Method : registerUser ends");
		return userLoginDao.registerUser(user);
	}
	
	@RequestMapping(value="getemail" , method={RequestMethod.GET})
	public List<DropDownModel> getemail(@RequestParam String emailid) {
		logger.info("Method : getUserByUsername starts");
		
		logger.info("Method : getUserByUsername ends");
		return userLoginDao.getemail(emailid);
	}
	@RequestMapping(value = "forgetpassword", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changePassword(@RequestParam String email, @RequestParam String otp , @RequestParam String password) {
		logger.info("Method : forgetpassword starts");

		logger.info("Method : forgetpassword ends");
		return userLoginDao.forgetpassword(email,otp,password);
	}
	
	@RequestMapping(value = "getNotification", method = { RequestMethod.GET })
	public JsonResponse<List<RestAuditNotificationModel>> getNotification(@RequestParam("roleId") String id) {
		logger.info("Method : getNotification starts");

		logger.info("Method : getNotification ends");
		return userLoginDao.getNotification(id);
	}
	
}
