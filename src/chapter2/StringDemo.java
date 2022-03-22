package chapter2;

public class StringDemo {
	public static void main(String[] args) {
		String slogan = "자유는 공짜가 아니다";
		System.out.println(slogan);
		System.out.println(slogan.length());
		String slogan2 = "   " + slogan + "   ";
		System.out.println(slogan2 + "!");
		System.out.println(slogan2.length());
		String slogan3 = slogan2.trim();
		System.out.println(slogan3 + "!");
		System.out.println(slogan);
		System.out.println(slogan3);
		System.out.println(slogan == slogan3);
		System.out.println(slogan.equals(slogan3));
		System.out.println(slogan.charAt(5));
		System.out.println(slogan.substring(4,6));
		String slogan_E = "Freedom is not free";
		System.out.println(slogan_E.toUpperCase());
		System.out.println(slogan_E.toLowerCase());
		System.out.println(slogan_E.indexOf("o"));
		System.out.println(slogan_E.indexOf("o",6));
		System.out.println("a".compareTo("c"));
		System.out.println("C".compareTo("A"));
	}
}
