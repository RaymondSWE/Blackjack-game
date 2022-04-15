
import java.util.ArrayList;

public class Board {
	private Deck mDeck = new Deck();
	private ArrayList<Card> mPlayerCards = new ArrayList<Card>();
	private ArrayList<Card> mDealerCards = new ArrayList<Card>();
	private Player mPlayer;
	private int mCardIndex = 0;
	private Dealer mDealer = new Dealer();

	public Board(String name, int balance) {
		mDeck.shuffleDeck();
		mPlayer = new Player(name, balance);
	}

	private void increaseCardIndex(int value) {
		mCardIndex += value;
		if (mCardIndex == 51) {
			mDeck.shuffleDeck();
			mCardIndex = 0;
		}

	}

	public void playerHit() {
		mPlayerCards.add(mDeck.getPlayerCards(mCardIndex));
		int playerScore = mPlayerCards.get(mCardIndex).getValue();
		mPlayer.setScore(playerScore);
		increaseCardIndex(1);
	}

	public void dealerHit() {
		int dealerScore = 0;
		mDealerCards.add(mDeck.getPlayerCards(mCardIndex));
		dealerScore = mDealerCards.get(mCardIndex).getValue();
		mDealer.setScore(dealerScore);
		increaseCardIndex(1);

	}

	public void dealCards() {
		for (int i = 0; i < 2; i++) {
			mDealerCards.add(mDeck.getPlayerCards(mCardIndex));
			increaseCardIndex(1);

		}

		for (int i = 0; i < 2; i++) {
			increaseCardIndex(1);
			mPlayerCards.add(mDeck.getPlayerCards(mCardIndex));
			mPlayer.setScore(mPlayerCards.get(i).getValue());
		}
		//we increase the card index again to make sure that when a hit is done that we don't give out the same card.
		increaseCardIndex(1);

	}

	public void setBalance(int balance) {
		mPlayer.setBalance(balance);
	}
	
	public int getBalance() {
		return mPlayer.getBalance();
	}

	public boolean isEmptyBalance() {
		if (mPlayer.getBalance() == 0)
			return true;
		else
			return false;
	}

	public int getPlayerScore() {
		return mPlayer.getScore();

	}

	public int getDealerScore() {
		return mDealer.getScore();
	}

	public void increaseBalance(int bet) {
		int balance = mPlayer.getBalance();
		balance += bet;
		mPlayer.setBalance(balance);

	}

	public void decreaseBalance(int bet) {
		int balance = mPlayer.getBalance();
		balance -= bet;
		mPlayer.setBalance(balance);

	}

	public ArrayList<Card> getCurrentPlayerCards() {
		return mPlayerCards;
	}

	public ArrayList<Card> getCurrentDealerCards() {
		return mDealerCards;
	}

	public void clearGameCards() {
		mDealerCards.clear();
		mPlayerCards.clear();
		mCardIndex = 0;
		mDeck.shuffleDeck();

	}
}