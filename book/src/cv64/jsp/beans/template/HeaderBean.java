package cv64.jsp.beans.template;

public class HeaderBean extends TemplateBean {

	public HeaderBean() {}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public String getTitle() {
		return title;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String backgroundColor;
	private String title;
}
