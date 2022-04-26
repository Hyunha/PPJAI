package midterm.glassbead;

import javax.swing.JOptionPane;

public class Registrar {
	boolean chooseEven() {
		String s = JOptionPane.showInputDialog("홀? 짝?").trim();
		while (!("짝".equals(s) || "홀".equals(s))) {
			s = JOptionPane.showInputDialog("홀? 짝?").trim();
		}
		return "짝".equals(s);
	}
	
	int chooseForAttack(int max) {
		String s = JOptionPane.showInputDialog("몇개를 걸까요? (최대 " + max + "개)");
		int value = Integer.parseInt(s);
		while (value > max || value <= 0) {
			s = JOptionPane.showInputDialog("몇개를 걸까요? (최대 " + max + "개)");
			value = Integer.parseInt(s);
		}
		return value;
	}
	
	int chooseForGuard(int max) {
		String s = JOptionPane.showInputDialog("몇개를 집을까요? (최대 " + max + "개)");
		int value = Integer.parseInt(s);
		while (value > max || value < 0) {
			s = JOptionPane.showInputDialog("몇개를 집을까요? (최대 " + max + "개)");
			value = Integer.parseInt(s);
		}
		return value;
	}
}
