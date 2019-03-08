package cv64.jsp.beans.template;

public class FooterBean extends TemplateBean {

	public FooterBean() {}

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
