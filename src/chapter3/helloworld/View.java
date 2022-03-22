package chapter3.helloworld;

import javax.swing.JOptionPane;

public class View {
	public void show(String message) {
		System.out.println(message);
	}

	public void showSwing(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
