package chapter5;

public class DanglingElse {

	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		if (b1)
		if (b2)
		System.out.println("AAA");
		else
		System.out.println("BBB");
	}

}
