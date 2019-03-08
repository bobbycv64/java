package cv64.jsp.beans;

public class GeneralBean {

	public GeneralBean() {}

	public void display() {
		System.out.println("GeneralBean.toString()");

		System.out.println(backgroundColor + "," + serverIP);
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public String getServerIP() {
		return serverIP;
	}

	public static final String backgroundColor = "lightblue";
//	public static final String serverIP ="http://127.0.0.1:8080";
	public static final String serverIP ="http://www.netvn-usa.com";
}
