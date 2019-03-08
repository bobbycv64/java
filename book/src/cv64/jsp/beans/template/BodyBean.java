package cv64.jsp.beans.template;

public class BodyBean extends TemplateBean {

	public BodyBean() {}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public String getDescription() {
		return description;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String backgroundColor;
	private String description;
}
