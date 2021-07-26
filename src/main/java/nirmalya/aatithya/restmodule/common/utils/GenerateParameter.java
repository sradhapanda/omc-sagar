/**Defines SQL SET Parameters */
package nirmalya.aatithya.restmodule.common.utils;
import java.util.Random;


/**
 * @author NirmalyaLabs
 *
 */
public class GenerateParameter {

	/**
	 * returns parameter set for error class
	 **/
	public static String getSqlErrorParam(Integer code, String state, String message, String type) {

		String parameterString = "SET ";
		message = message.replace("'", "");
		String[] x = message.split(";");
		parameterString = parameterString + "@p_code='" + code + "',";
		parameterString = parameterString + "@p_state='" + state + "',";
		parameterString = parameterString + "@p_message='" + x[0] + "',";
		parameterString = parameterString + "@p_dbName='" + type + "';";

		return parameterString;
	}

	/**
	 * returns parameter set for DataTableRequest class
	 **/
	public static String getSearchParam(DataTableRequest request) {

		String s = "";

		if (request.getStart() != null) {
			s = s + "@p_start=" + request.getStart() + ",";
		}

		if (request.getLength() != null) {
			s = s + "@p_length=" + request.getLength() + ",";
		}

		if (request.getSearch() != null) {
			s = s + "@p_search='" + request.getSearch() + "',";
		}

		if (request.getParam1() != null) {
			s = s + "@p_param1='" + request.getParam1() + "',";
		}

		if (request.getParam2() != null) {
			s = s + "@p_param2='" + request.getParam2() + "',";
		}

		if (request.getParam3() != null) {
			s = s + "@p_param3='" + request.getParam3() + "',";
		}

		if (request.getParam4() != null) {
			s = s + "@p_param4='" + request.getParam4() + "',";
		}
		
		if (request.getParam5() != null) {
			s = s + "@p_param5='" + request.getParam5() + "',";
		}
		if (request.getParam6() != null) {
			s = s + "@p_param6='" + request.getParam6() + "',";
		}
		if (request.getParam7() != null) {
			s = s + "@p_param7='" + request.getParam7() + "',";
		}
		if (request.getParam8() != null) {
			s = s + "@P_USERROLE='" + request.getParam8() + "',";
		}
		
		if (request.getUserId() != null) {
			s = s + "@p_userid='" + request.getUserId() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("param  : " + s);

		return s;
	}

	/**
	 * returns parameter set for PropertyModel class
	 **/
//	public static String addPropertyParam(PropertyModel prop) {
//
//		String s = "";
//		if (prop.getpTypeName() != null || prop.getpTypeName() != "") {
//			s = s + "@p_pTypeName='" + prop.getpTypeName() + "',";
//		}
//		if (prop.getPropertyCategory() != null || prop.getPropertyCategory() != "") {
//			s = s + "@p_propertyCategory='" + prop.getPropertyCategory() + "',";
//		}
//		if (prop.getpTypeActive() != null) {
//			s = s + "@p_pTypeActive=" + prop.getpTypeActive() + ",";
//		}
//		if (prop.getpTypeDescription() != null || prop.getpTypeDescription() != "") {
//			s = s + "@p_pTypeDescription='" + prop.getpTypeDescription() + "',";
//		}
//
//		if (prop.getPropertyType() != null) {
//			s = s + "@p_propertyType='" + prop.getPropertyType() + "',";
//		}
//
//		if (s != "") {
//			s = s.substring(0, s.length() - 1);
//
//			s = "SET " + s + ";";
//		}
//
//		System.out.println("Paramerized Query 2= " + s);
//
//		return s;
//
//	}
//
//	public static String getAmenityParam(AmenityForm form) {
//
//		String s = "";
//		Random rand = new Random();
//
//		// Generate random integers in range 0 to 999
//		int rand_int1 = rand.nextInt(100);
//
//		if (!form.getAmenitiesId().contentEquals("0")) {
//			s = s + "@amenities='" + form.getAmenitiesId() + "',";
//		} else {
//			s = s + "@amenities='" + "ame3222" + "',";
//		}
//
//		s = s + "@propertyCategory='" + form.getPropertyCategoryId() + "',";
//		s = s + "@smntsName='" + form.getAmntsName() + "',";
//		s = s + "@amntsDescription='" + form.getAmntsDescription() + "',";
//		s = s + "@amntsActive=" + form.getAmntsActive() + ",";
//		
//
//		if (s != "") {
//			s = s.substring(0, s.length() - 1);
//
//			s = "SET " + s + ";";
//		}
//		
//		return s;
//	}	
}
