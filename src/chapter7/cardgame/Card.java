package chapter7.cardgame;

public class Card {
	public static final String SPADES = "spades";
	public static final String HEARTS = "hearts";
	public static final String DIAMONDS = "diamonds";
	public static final String CLUBS = "clubs";
	
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public static final int KINDS_OF_SUIT = 4;
	public static final int SIZE_OF_ONE_SUIT = 13;
	
	private String suit;
	private int rank;
	
	public Card(String s, int r) {
		suit = s;
		rank = r;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getRank() {
		return rank;
	}
 }
