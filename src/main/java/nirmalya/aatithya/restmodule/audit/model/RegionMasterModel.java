package nirmalya.aatithya.restmodule.audit.model;

public class RegionMasterModel {

	private String department;
	private String regionId;
	private String description;
	private String CreatedBy;
	private String regionName;
	private Boolean status;
	

	public RegionMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegionMasterModel(Object department, Object regionId, Object description, Object CreatedBy,
			Object regionName, Object status) {
		super();

		this.department = (String) department;
		this.regionId = (String) regionId;
		this.regionName = (String) regionName;
		this.description = (String) description;
		this.status = (Boolean) status;
		this.CreatedBy = (String) CreatedBy;
		
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	

}
