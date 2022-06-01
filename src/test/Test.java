package test;

import java.io.*;

import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) {
		int n = readInt();
		String answer = "100 나누기 " + Integer.toString(n) + " = " + 
		(100 / n);
		JOptionPane.showMessageDialog(null, answer);
	}

	private static int readInt() {
		String input = JOptionPane.showInputDialog("정수를 주세요. 100에서 나누어 드립니다.");
		int n = Integer.parseInt(input.trim());
		return n;
	}
}
