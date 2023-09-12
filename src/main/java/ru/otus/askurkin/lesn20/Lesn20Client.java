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
	private DataInputStream in;
	private DataOutputStream out;

	public Lesn20Client(String srv, int port) throws IOException {
		socket = new Socket(srv, port);
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}

	@Override
	public void close() throws Exception {
		in.close();
		out.close();
	}

	public void push(String str) throws IOException, InterruptedException {
		out.writeBytes(str);
		out.flush();
		Thread.sleep(5000);
	}

	public String pull() {
		String result;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			result = reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
