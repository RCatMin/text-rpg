package controlManage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOControl {
	public static StringBuilder buffer;
	public static BufferedWriter writer;
	private static BufferedReader reader;

	private IOControl() {
		buffer = new StringBuilder();
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static IOControl instance = new IOControl();

	public static IOControl getInstance() {
		return instance;
	}

	public static void printString(String message) {
		buffer.setLength(0);
		buffer.append(message);
		try {
			writer.append(buffer);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String inputString(String message) {
		buffer.setLength(0);
		buffer.append(message);
		try {
			writer.append(buffer);
			writer.flush();
			String input = reader.readLine();
			return input;
		} catch (Exception e) {
			return "";
		}
	}

}
