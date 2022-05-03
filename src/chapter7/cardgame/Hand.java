package chapter7.cardgame;

public class Hand {
	private Card[] hand;
	int number_of_cards;
	
	public Hand(int max) {
		hand = new Card[max];
	}
	
	public void showHand() {
		if (number_of_cards == 0) {
			System.out.println("카드가 없습니다.");
		} else {
			for (int i = 0; i < number_of_cards; i = i + 1) {
				Card card = hand[i];
				System.out.println("#" + (i + 1) + " " +
						card.getSuit() + " " + card.getRank()
						);
			}
		}
	}
	
	public boolean receiveCard(Card c) {
		if (number_of_cards < hand.length) {
			hand[number_of_cards] = c;
			number_of_cards = number_of_cards + 1;
			return true;
		}
		return false;
	}
	
	public Card removeCard() {
		if (number_of_cards > 0) {
			int index = (int)(Math.random() * number_of_cards);
			Card draw = hand[index];
			for (int i = index + 1; i < number_of_cards; i = i + 1) {
				hand[i - 1] = hand[i];
			}
			number_of_cards = number_of_cards - 1;
			return draw;
		}
		return null;
	}
}
