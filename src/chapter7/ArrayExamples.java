package chapter7;

public class ArrayExamples {

	static void printArray(String name, int[] r) {
		System.out.println("| " + name + " | ");
		for (int i = 0; i < r.length - 1; i++) {
			if (r[i] < 10) {
				System.out.print("------");
			} else if (r[i] < 100) {
				System.out.print("-----");
			} else {
				System.out.print("----");
			}
		}
		System.out.println();
		System.out.print("|");
		for (int i = 0; i < r.length; i++) {
			if (i < 10) {
				System.out.print("   ");
			} else if (i < 100) {
				System.out.print("  ");
			} else {
				System.out.print(" ");
			}
			System.out.print(i + "|");			
		}
		System.out.println();
		for (int i = 0; i < r.length - 1; i++) {
			if (r[i] < 10) {
				System.out.print("------");
			} else if (r[i] < 100) {
				System.out.print("-----");
			} else {
				System.out.print("----");
			}
		}
		System.out.println();
		System.out.print("|");
		for (int i = 0; i < r.length; i++) {
			if (r[i] < 10) {
				System.out.print("   ");
			} else if (r[i] < 100) {
				System.out.print("  ");
			} else {
				System.out.print(" ");
			}
			System.out.print(r[i] + "|");			
		}
		
		System.out.println();
		for (int i = 0; i < r.length - 1; i++) {
			if (r[i] < 10) {
				System.out.print("------");
			} else if (r[i] < 100) {
				System.out.print("-----");
			} else {
				System.out.print("----");
			}
		}
		System.out.println();
	}
	
	static void simple() {
		int[] r = new int[6];
		System.out.println("int[] r = new int[6];");
		printArray("r", r);
		r[1] = 7;
		System.out.println("r[1] = 7;");
		printArray("r", r);
		r[3] = r[1] + 2;
		System.out.println("r[3] = r[1] + 2;");
		printArray("r", r);
		int[] s = r;
		System.out.println("int[] s = r;");
		printArray("s", s);
		s[5] = 5;
		System.out.println("s[5] = 5;");
		printArray("r", r);
		printArray("s", s);
	}
	
	static void createAndFilled() {
		int[] r = new int[12];
		r[0] = 1;
		r[1] = 1;
		for (int i = 2; i < r.length; i = i + 1) {
			r[i] = r[i-1] + r[i-2];
		}
		printArray("r", r);
	}
	
	public static void main(String[] args) {
		simple();
//		createAndFilled();
	}

}
