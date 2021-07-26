package nirmalya.aatithya.restmodule.audit.model;

public class PersonModel {
	private String value;
	private String label;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public PersonModel(Object value, Object label) {
		super();
		this.value = (String)value;
		this.label = (String)label;
	}
	public PersonModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
