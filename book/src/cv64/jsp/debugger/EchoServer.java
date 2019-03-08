package cv64.jsp.debugger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class EchoServer extends NetworkServer {

	public EchoServer(int port, int maxConnections) {

		super(port, maxConnections);
		listen();
	}

	private int contentLength(String[] inputs) {

		String input;

		for (int i=0; i < inputs.length; i++) {

			if (inputs[i].length() == 0) break;

			input = inputs[i].toUpperCase();

			if (input.startsWith("CONTENT-LENGTH"))
				return(getLength(input));
		}

		return(0);
	}

	private int getLength(String length) {

		StringTokenizer tok = new StringTokenizer(length);
		tok.nextToken();
		return(Integer.parseInt(tok.nextToken()));
	}

	public void handleConnection(Socket server) throws IOException {

			System.out.println(serverName_ + ": got connection from " +
			    server.getInetAddress().getHostName());

			BufferedReader in = SocketUtil.getReader(server);
			PrintWriter out = SocketUtil.getWriter(server);
			String[] inputLines = new String[maxRequestLines_];

			int i;
			for (i=0; i < maxRequestLines_; i++) {

				inputLines[i] = in.readLine();

				if (inputLines[i] == null) // Client closed connection
				break;

				if (inputLines[i].length() == 0) { // Blank line

				if (usingPost(inputLines)) {
					readPostData(inputLines, i, in);
					i = i + 2;
				}
				break;
			}
		}

		printHeader(out);

		for (int j=0; j < i; j++) {
			out.println(inputLines[j]);
		}

		printTrailer(out);
		server.close();
	}

	private void printHeader(PrintWriter out) {

		out.println("HTTP/1.0 200 OK\r\n" +
		    "Server: " + serverName_ + "\r\n" +
		    "Content-Type: text/html\r\n\r\n" +
		    "<!DOCTYPE HTML PUBLIC " +
		    "\"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" +
		    "<HTML>\n" + "<HEAD>\n" +
		    "  <TITLE>" + serverName_ + " Results</TITLE>\n" +
		    "</HEAD>\n\n" +
		    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		    "<H1 ALIGN=\"CENTER\">" + serverName_ +
		    " Results</H1>\n" +
		    "Here is the request line and request headers\n" +
		    "sent by your browser:\n" +
		    "<PRE>");
	}

	private void printTrailer(PrintWriter out) {

		out.println("</PRE>\n" + "</BODY>\n" + "</HTML>\n");
	}

	private void readPostData(String[] inputs, int i, BufferedReader in)
	    throws IOException {

		int contentLength = contentLength(inputs);
		char[] postData = new char[contentLength];
		in.read(postData, 0, contentLength);
		inputs[++i] = new String(postData, 0, contentLength);
	}

	private boolean usingPost(String[] inputs) {

		return(inputs[0].toUpperCase().startsWith("POST"));
	}

	public static void main(String[] args) {

		int port = 8080;

		if (args.length > 0) {

		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException exception) {}
		}

		new EchoServer(port, 0);
	}

	protected int maxRequestLines_ = 50;
	protected String serverName_ = "EchoServer";
}
