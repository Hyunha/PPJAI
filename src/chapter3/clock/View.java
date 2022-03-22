package chapter3.clock;

import java.time.LocalTime;

import javax.swing.JOptionPane;

public class View {
	void show(LocalTime t) {
		System.out.println("지금 시각:" + t);
	}

	void showSwing(LocalTime t) {
		JOptionPane.showMessageDialog(null, "지금 시각:" + t);
	}
}
