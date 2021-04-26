package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Conection {
	
	private Socket server;
	private int port = 24211;
	private String host = "localhost";
	private DataInputStream input;
	private DataOutputStream output;
	
	public Conection() {
		try {
			server = new Socket(host, port);
			input = new DataInputStream(server.getInputStream());
			output = new DataOutputStream(server.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String receiveUTF() throws IOException {
		return input.readUTF();
	}
	
	public void sendUTF(String info) throws IOException {
		output.writeUTF(info);
	}
	
	public boolean receiveBoolean() {
		return true;
	}
	
	public void sendBoolean(boolean info) {
		
	}
	
	public void closeConection() throws IOException {
		server.close();
	}
}
