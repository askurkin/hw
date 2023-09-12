package ru.otus.askurkin.lesn20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Lesn20Server implements AutoCloseable {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;

	public Lesn20Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public String readRequest() throws IOException {
		socket = serverSocket.accept();
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		String result = "";
		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String str = reader.readLine();
			if (str == null || str.trim().length() == 0) {
				break;
			}
			result = result.concat(str);
		}
		return result;
	}

	public static String process(String str) {
		String[] prc = str.split(" ");

		if (prc[1].equals("+")) {
			return String.valueOf(Integer.parseInt(prc[0]) + Integer.parseInt(prc[2]));
		} else if (prc[1].equals("-")) {
			return String.valueOf(Integer.parseInt(prc[0]) - Integer.parseInt(prc[2]));
		} else if (prc[1].equals("/")) {
			return String.valueOf(Integer.parseInt(prc[0]) / Integer.parseInt(prc[2]));
		} else if (prc[1].equals("*")) {
			return String.valueOf(Integer.parseInt(prc[0]) * Integer.parseInt(prc[2]));
		}

		return null;
	}

	public void push(String str) throws IOException {
		out.writeBytes(str);
		out.flush();
	}

	@Override
	public void close() throws Exception {
		serverSocket.close();
	}
}
