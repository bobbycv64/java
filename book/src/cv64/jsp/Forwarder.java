package cv64.jsp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cv64.jsp.exception.ExceptionHandler;

public class Forwarder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(true);

			goToPage(request.getParameter("pageReference") + ".jsp",
			    request, response);

		} catch(Exception exception) {
			new ExceptionHandler(exception, "Forwarder.doPut()");
		}
	}

	protected void goToPage(String url, HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher =
		    getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	public void init(ServletConfig config, HttpServletRequest request)
	    throws ServletException {

		super.init(config);
	}
}
