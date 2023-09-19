package ru.otus.askurkin.lesn20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Lesn20Client implements AutoCloseable {
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;

	public Lesn20Client(String srv, int port) throws IOException {
		socket = new Socket(srv, port);
		out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	}

	@Override
	public void close() throws Exception {
		in.close();
		out.close();
		socket.close();
	}

	public void push(String str) throws IOException {
		out.writeBytes(str + "\n");
		out.flush();
	}

	public String pull() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = reader.readLine();
		return line;
	}
}
