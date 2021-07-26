package nirmalya.aatithya.restmodule.master.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestMailModel;

@Repository
public class RestMailDao {
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(RestMailDao.class);
	public ResponseEntity<JsonResponse<Object>> emailStatus(String id) {
		logger.info("Method : emailStatus starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		

		if (validity)
			try {

				String value = "SET @p_mail='" + id + "';";
				System.out.println("rgsegrtv"+value);
				//System.out.println("sdfsdv "+mail.getFolder());
					em.createNamedStoredProcedureQuery("masterFolderRoutines")
							.setParameter("actionType", "modifyEmailStatus").setParameter("actionValue", value).execute();
				
				
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

		logger.info("Method : emailStatus ends");
		return response;
	}

}
