package cv64.jsp.beans;

public class General {

	public General() {}

	public void display() {
		System.out.println("General.toString()");

		System.out.println(companyName + host + servletPort + url);
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getHost() {
		return host;
	}

	public String getServletPort() {
		return servletPort;
	}

	public String getURL() {
		return url;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setServletPort(String servletPort) {
		this.servletPort = servletPort;
	}

	public void setURL(String url) {
		this.url = url;
	}

	private String companyName;
	private String host;
	private String servletPort;
	private String url;
}
