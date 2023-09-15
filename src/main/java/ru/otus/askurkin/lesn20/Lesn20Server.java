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

	public void start() throws IOException {

		socket = serverSocket.accept();
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		System.out.println("Connect");
		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String buff = reader.readLine();
			System.out.println(buff);

			String res = "";
			if (buff.equals("operation")) {
				res = "+ - * /";
			}
			if (buff.trim().length() > 0) {
				res = Lesn20Server.process(buff);
			}
			System.out.println(buff + " = " + res);

			if (res.trim().length() > 0) {
				out.writeBytes(res + "\n");
				out.flush();
				System.out.println("Push");
			}
		}
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

	@Override
	public void close() throws Exception {
		in.close();
		out.close();
		serverSocket.close();
	}
}
