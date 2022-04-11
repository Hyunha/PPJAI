package chapter6;

public class MultiplicationTable {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			// loop invariant: 구구단의 i-1 단까지 출력했음 
			for (int j = 1; j < 10; j++) {
				// loop invariant: 구구단의 i-1 단까지 출력하고, i단의 j항까지 출력했음 
				System.out.print(i + "x" + j + "=" + (i * j) + " ");
			}
			System.out.println();
		}
	}
}