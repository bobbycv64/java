package cv64.jsp.beans.template;

public class FrameBean extends TemplateBean {

	public FrameBean() {}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public String[] getButtons() {
		return buttons;
	}

	public boolean getPosition() {
		return position;
	}

	public String getTitle() {
		return title;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setPosition(boolean position) {
		this.position = position;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private static final boolean LEFT = true;
	private static final boolean RIGHT = false;

	private String[] buttons;
	private String backgroundColor;
       private String title;
	private boolean position;
}
