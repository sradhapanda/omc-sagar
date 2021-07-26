package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestFolderMasterModel;

public class GenerateFolderMasterParameter {
	public static String addFolderParam(RestFolderMasterModel folder) {
		String s = "";

		if (folder.getFolder() != null && folder.getFolder() != "") {
			s = s + "@p_folder='" + folder.getFolder() + "',";
		}
		if (folder.getFolderName() != null && folder.getFolderName() != "") {
			s = s + "@p_folderName='" + folder.getFolderName() + "',";
		}

		if (folder.getDescription() != null && folder.getDescription() != "") {
			s = s + "@p_folderDescription='" + folder.getDescription() + "',";
		}
		if (folder.getCreatedBy() != null && folder.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + folder.getCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
