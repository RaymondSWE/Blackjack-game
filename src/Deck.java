import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

	private ArrayList<Card> mCards = new ArrayList<Card>();
	private String[] mSuit = { "spades", "diamonds", "clubs", "hearts" };
	private String[] mRank = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };
	private int[] mValue = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };

	public Deck() {
		// we create our deck here. The constructor does not expect any input.
		for (int i = 0; i < mSuit.length; i++) {
			for (int j = 0; j < mRank.length; j++) {
				if (mSuit[i].equals("spades"))
					mCards.add(new Card(mRank[j], mSuit[i], mValue[j]));
				else if (mSuit[i].equals("hearts"))
					mCards.add(new Card(mRank[j], mSuit[i], mValue[j]));
				else if (mSuit[i].equals("clubs"))
					mCards.add(new Card(mRank[j], mSuit[i], mValue[j]));
				else if (mSuit[i].equals("diamonds"))
					mCards.add(new Card(mRank[j], mSuit[i], mValue[j]));

			}
		}

	}

	// this function takes no input, returns void and shuffles the deck.
	public void shuffleDeck() {
		Collections.shuffle(mCards);
	}

	// this function returns an array of Card objects containing 3 cards from the
	// deck.
	public Card getPlayerCards(int index) {
		// the size of the array below will be 3 since the player is delt 3 cards.
		Card playerCard = mCards.get(index);
		return playerCard;
	}
}