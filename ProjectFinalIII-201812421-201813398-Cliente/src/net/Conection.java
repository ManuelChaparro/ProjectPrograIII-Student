package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Conection {

	private static final String FAILED_CONNECTION_TITLE = "Conexion fallida";
	private static final String ERROR_MESSAGE_FAIL_CONNECTION = "No se pudo conectar con el servidor";
	private Socket server;
	private DataInputStream input;
	private DataOutputStream output;
	private int port = 24211;
	private String host = "localhost";

	public Conection() {
		try {
			server = new Socket(host, port);
			input = new DataInputStream(server.getInputStream());
			output = new DataOutputStream(server.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ERROR_MESSAGE_FAIL_CONNECTION, FAILED_CONNECTION_TITLE,
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public String receiveUTF() throws IOException {
		return input.readUTF();
	}

	public void sendUTF(String info) throws IOException {
		output.writeUTF(info);
	}

	public boolean receiveBoolean() throws IOException {
		return input.readBoolean();
	}

	public void sendBoolean(boolean info) throws IOException {
		output.writeBoolean(info);
	}

	public void closeConection() throws IOException {
		server.close();
	}
}
