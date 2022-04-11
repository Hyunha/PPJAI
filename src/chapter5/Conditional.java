package chapter5;

import javax.swing.JOptionPane;

public class Conditional {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("나이를 알려주세요.");
		int age = Integer.parseInt(input);
		if (age < 19) {
			System.out.println(age + "세는 미성년입니다.");
		}else {
			System.out.println(age + "세는 성년입니다.");
		}
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("역수를 계산해 드립니다."));
		if (n == 0) {
			System.out.println("0의 역수는 없습니다.");
		} else {
			System.out.println(n + "의 역수는 " + 1.0/n + "입니다.");
		}
	}
}
