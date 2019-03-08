package cv64.jsp.utilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cv64.jsp.exception.ExceptionHandler;

public class ServletUtilities {

	public static final String DOCTYPE =
	    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">";

	public static String headWithTitle(String title) {
		return(DOCTYPE + "\n" + "<HTML>\n" + "<HEAD><TITLE>" +
		    title + "</TITLE></HEAD>\n");
	}

	public static int getIntParameter(HttpServletRequest request,
	    String paramName, int defaultValue) {

		String paramString = request.getParameter(paramName);
		int paramValue;

		try {
			paramValue = Integer.parseInt(paramString);
		} catch(NumberFormatException exception) {
			new ExceptionHandler(exception, "ServletUtlities.getIntParameter");
			paramValue = defaultValue;
		}

		return(paramValue);
	}

	public static String getCookieValue(Cookie[] cookies, String cookieName,
	    String defaultValue) {

		for(int i=0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookieName.equals(cookie.getName()))
				return(cookie.getValue());
		}

		return(defaultValue);
	}

	public static Cookie getCookie(Cookie[] cookies, String cookieName) {

		for(int i=0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookieName.equals(cookie.getName()))
				return(cookie);
		}

		return(null);
	}

	public static String filter(String input) {

		StringBuffer filtered = new StringBuffer(input.length());
		char c;

		for(int i=0; i < input.length(); i++) {
			c = input.charAt(i);

			if (c == '<') {
				filtered.append("&lt;");
			} else if (c == '>') {
				filtered.append("&gt;");
			} else if (c == '"') {
				filtered.append("&quot;");
			} else if (c == '&') {
				filtered.append("&amp;");
			} else {
				filtered.append(c);
			}
		}

		return(filtered.toString());
	}
}
