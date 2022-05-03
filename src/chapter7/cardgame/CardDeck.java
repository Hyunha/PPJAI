package chapter7.cardgame;

public class CardDeck {
	
	
	private Card[] deck = 
			new Card[Card.KINDS_OF_SUIT * Card.SIZE_OF_ONE_SUIT];
	
	private int card_count = 0;
	
	public CardDeck() {
		createDeck();
	}
	
	private void createDeck() {
		createSuit(Card.CLUBS);
		createSuit(Card.DIAMONDS);
		createSuit(Card.HEARTS);
		createSuit(Card.SPADES);
	}
	
	private void createSuit(String suit) {
		for (int i = 1; i <= Card.SIZE_OF_ONE_SUIT; i = i + 1) {
			deck[card_count] = new Card(suit, i);
			card_count = card_count + 1;
		}
	}
	
	Card newCard() {
		if (!moreCard()) {
			createDeck();
		}
		int index = (int)(Math.random() * card_count);
		Card draw = deck[index];
		for (int i = index + 1; i < card_count; i = i + 1) {
			deck[i - 1] = deck[i];
		}
		card_count = card_count - 1;
		return draw;
	}
	
	boolean moreCard() {
		return !(deck == null || deck.length == 0);
	}
}
