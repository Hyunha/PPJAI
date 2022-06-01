package test;

import java.io.*;
import java.util.StringTokenizer;

public class PayrollReader {

	private static String filename = "list.txt";
	private FileReader reader;
	private BufferedReader infile;
	
	private String name;
	private int hours;
	private int payrate;

	public PayrollReader() {
		try {
			reader = new FileReader(filename);
			infile = new BufferedReader(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("급여 명단을 찾을 수 없습니다.");
		}
	}

	public boolean getNextRecord() {
		try {
			if (infile.ready()) {
				String s = infile.readLine();
				if (s.equals("!")) {
					return false;
				}
				StringTokenizer t = new StringTokenizer(s, ",");
				name = t.nextToken();
				hours = Integer.parseInt(t.nextToken());
				payrate = Integer.parseInt(t.nextToken());
				return true;
			}
		} catch (NumberFormatException | IOException e) {
			return false;
		}
		return false;
	}

	public String nameOf() {
		return "";
	}

	public int hoursOf() {
		return 0;
	}

	public int payrateOf() {
		return 0;
	}

	public void close() {
		try {
			infile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
