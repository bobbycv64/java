package cv64.jsp.beans.template;

public class TemplateBean {

	public TemplateBean() {}

	public String getBackgroundColor() {
		return background;
	}

	public int getHeight() {
		return height;
	}

	public String getServerIP() {
		return serverIP;
	}

	public int getWidth() {
		return width;
	}

	public static final String background = "lightblue";
	public static final String serverIP ="http://127.0.0.1:8080";
	public static final int height = 480;
	public static final int width = 640;
}
