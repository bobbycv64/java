package cv64.jsp.debugger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;

public class NetworkServer {

	public NetworkServer(int port, int maxConnections) {

		setPort(port_);
		setMaxConnections(maxConnections_);
	}

	public int getMaxConnections() {
		return(maxConnections_);
	}

	public int getPort() {
		return(port_);
	}

	protected void handleConnection(Socket server) throws IOException {

		BufferedReader in = SocketUtil.getReader(server);
		PrintWriter out = SocketUtil.getWriter(server);
		System.out.println("Generic Network Server: got connection from " +
		    server.getInetAddress().getHostName() + "\n" +
		    "with first line '" + in.readLine() + "'");

		out.println("Generic Network Server");
		server.close();
	}

	public void listen() {

		int i=0;

		try {
			ServerSocket listener = new ServerSocket(port_);
			Socket server;

			while((i++ < maxConnections_) || (maxConnections_ == 0)) {
				server = listener.accept();
				handleConnection(server);
			}

		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
			ioe.printStackTrace();
		}
	}

	public void setMaxConnections(int maxConnections) {
		maxConnections_ = maxConnections;
	}

	protected void setPort(int port) {
		port_ = port;
	}

	private int maxConnections_;
	private int port_;
}
