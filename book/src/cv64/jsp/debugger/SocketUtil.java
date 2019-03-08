package cv64.jsp.debugger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketUtil {

	public static BufferedReader getReader(Socket socket) throws IOException {
		return(new BufferedReader(new InputStreamReader(socket.getInputStream())));
	}

	public static PrintWriter getWriter(Socket socket) throws IOException {
		return(new PrintWriter(socket.getOutputStream(), true));
	}
}

