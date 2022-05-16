package chapter8.object;

public class Main {

	public static void main(String[] args) {
		
		Pair p = new Pair("abc", 7);
		
		Object item1 = p.get1st();
		System.out.println((String)item1 + (String)item1);
		
		Object item2 = p.get2nd();
		System.out.println((int)item2 + 2);
		
	}
}



