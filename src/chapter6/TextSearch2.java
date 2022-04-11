package chapter6;

public class TextSearch2 {
	
	/* findChar - 문자열에서 가장 먼저 나타나는 문자를 검색 
	 * @param c - 검색할 문자 
	 * @param s - 검색 대상 문자열 
	 * @return - s에서 가장 먼저 나타나는 문자 c의 인덱스;  없으면 -1 */
	public int findChar(char c, String s) {
		int index = 0;
		for (index = 0; index < s.length() && s.charAt(index) != c; index++)
			// loop invariant: s[0], .., s[index-1]은 모두 c가 아님
			;
		if (index == s.length())
			index = -1;
		return index;
	}
	
	public static void main(String[] args) {
		TextSearch2 text_search = new TextSearch2();
		System.out.println(text_search.findChar('a', "Hanyang"));
		System.out.println(text_search.findChar('e', "Hanyang"));
	}
}

