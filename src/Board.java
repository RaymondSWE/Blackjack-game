
import java.util.ArrayList;

public class Board {

	private final Deck deck;
	private final ArrayList<Card> playerCards;
	private final ArrayList<Card> dealerCards;
	private final Player player;
	private final Dealer dealer;
	private int deckIndex;

	public Board(String playerName, int playerBalance) {
		deck = new Deck();
		playerCards = new ArrayList<>();
		dealerCards = new ArrayList<>();
		deckIndex = 0;
		player = new Player(playerName, playerBalance);
		dealer = new Dealer();
		deck.shuffleDeck();
	}

	public void playerHit() {
		playerCards.add(deck.getPlayerCards(deckIndex));
		player.setScore(deck.getPlayerCards(deckIndex++).getValue() + player.getScore());
	}

	public void dealerHit() {
		dealerCards.add(deck.getPlayerCards(deckIndex));
		dealer.setScore(deck.getPlayerCards(deckIndex++).getValue() + dealer.getScore());
	}

	public void dealCards() {
		for (int i = 0; i < 2; i++) {
			dealerHit();
			playerHit();
		}
	}

	public ArrayList<Card> getCurrentPlayerCards() {
		return playerCards;
	}

	public ArrayList<Card> getCurrentDealerCards() {
		return dealerCards;
	}

	public void resetBoard() {
		dealerCards.clear();
		playerCards.clear();
		deckIndex = 0;
		player.setScore(0);
		dealer.setScore(0);
		deck.shuffleDeck();
	}

	public void setDeckIndex(int deckIndex) {
		this.deckIndex = deckIndex;
	}

	public Player getPlayer() {
		return player;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public Deck getDeck() {
		return deck;
	}
}