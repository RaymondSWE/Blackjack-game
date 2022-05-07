import java.util.ArrayList;

public class Board {
    /*
    A board contains a deck of cards, player cards, dealer cards.
    A player and a dealer and the index of card to be drawn from the
    deck.
     */


	private final Deck deck;
	private final ArrayList<Card> playerCards;
	private final ArrayList<Card> dealerCards;
	private final Player player;
	private final Dealer dealer;
	private int deckIndex;
	
    /*
    The board takes the parameter of the player name and his balance
    (At the start of the game). Instances of the class are initialized
    with a new deck, new empty lists of player and dealer cards, 0th
    card to be drawn from the deck. A new player and dealer.
    After that, the deck is shuffled.
     */
	

	public Board(String playerName, int playerBalance) {
		deck = new Deck();
		playerCards = new ArrayList<>();
		dealerCards = new ArrayList<>();
		deckIndex = 0;
		player = new Player(playerName, playerBalance);
		dealer = new Dealer();
		deck.shuffleDeck();
	}
	
    /*
    For a player hit, a card is drawn from the deck and added
    to the player's list of cards. And the player's score is
    updated by adding the value of that card, to the previous score.
    After that the deckIndex is incremented.
    As the increment is postIncrement that is why on line deckIndex++
    the deckIndex is same as before and incremented on the next line.
     */

	public void playerHit() {
		playerCards.add(deck.getPlayerCards(deckIndex)); // deckindex = 0
		player.setScore(deck.getPlayerCards(deckIndex++).getValue() + player.getScore());
        //eg. deckIndex = 1 because of deckIndex++ in the previous line.
        //Post increment means use the value first, then increment it.(deckIndex++)
        //Pre increment means increment the value first, then use it.(++deckIndex)
	}
    /*
    For a dealer hit, a card is drawn from the deck and added
    to the player's list of cards. And the player's score is
    updated by adding the value of that card, to the previous score.
    After that the deckIndex is incremented.
     */

	public void dealerHit() {
		dealerCards.add(deck.getPlayerCards(deckIndex));
		dealer.setScore(deck.getPlayerCards(deckIndex++).getValue() + dealer.getScore());
	}
	
    /*
	To deal the cards, the player and the dealer gets two
	cards. That is done by the loop that runs two times.
     */

	public void dealCards() {
		for (int i = 0; i < 2; i++) {
			dealerHit();
			playerHit();
		}
	}
	// Get player cards
	public ArrayList<Card> getCurrentPlayerCards() {
		return playerCards;
	}
	
	// Get dealer

	public ArrayList<Card> getCurrentDealerCards() {
		return dealerCards;
	}
	
    /*
	When resetting the board, the card lists are made empty
	Deck index is returned to 0. Both player and dealer
	scores set to zero and the deck is shuffled again.
     */

	public void resetBoard() {
		dealerCards.clear();
		playerCards.clear();
		deckIndex = 0;
		player.setScore(0);
		dealer.setScore(0);
		deck.shuffleDeck();
	}
	
    /*
	Set the deck index to custom value.
	However this function is not used in the
	project
     */

	public void setDeckIndex(int deckIndex) {
		this.deckIndex = deckIndex;
	}
	// Get the player

	public Player getPlayer() {
		return player;
	}
	// Get the dealer

	public Dealer getDealer() {
		return dealer;
	}
	// Get the deck
	public Deck getDeck() {
		return deck;
	}
}