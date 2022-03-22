package chapter2;

public class BooleanDemo {
	public static void main(String[] args) {
		boolean b = false;
		b = (b && true) || false;
		System.out.println(!b);
	}
}
